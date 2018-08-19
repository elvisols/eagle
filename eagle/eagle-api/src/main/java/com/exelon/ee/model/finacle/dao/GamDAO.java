/**
 * 
 */
package com.exelon.ee.model.finacle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import com.exelon.ee.enums.AccountDateType;
import com.exelon.ee.model.Parameter;
import com.exelon.ee.model.User;
import com.exelon.ee.model.finacle.GAM;
import com.exelon.ee.qualifier.SystemParameter;
import com.exelon.ee.rs.account.AccountResult;
import com.exelon.ee.rs.account.AccountSearchDTO;
import com.exelon.ee.rs.account.AccountSummaryDTO;
import com.exelon.ee.util.Util;

/**
 * @author ukaegbu
 *
 */
@ApplicationScoped
public class GamDAO {

	@Inject
	private Logger logger;

	@Inject
	private EntityManager em;

	@Inject
	@SystemParameter
	private Parameter parameter;

	@Resource(mappedName = "java:jboss/datasources/eagle")
	private DataSource ds;

	@Resource(mappedName = "java:jboss/datasources/finacle")
	private DataSource finacleDs;
	
	
	public GAM getAccount(String cifId) {
		
		
		return null;
		
	}

	public GAM getAccountFromCba(String cifId) {

		StringBuilder builder = new StringBuilder();

		builder.append(" select  ");
		builder.append("   * ");
		builder.append(" from ");
		builder.append(" tbaadm.gam  g ");
		builder.append(" where g.cif_id = ' ");	builder.append(cifId);builder.append("'  ");

		Connection conn = null;
		ResultSet rst = null;
		Statement stmt = null;
		GAM v = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rst = stmt.executeQuery(builder.toString());

			if (rst.next()) {
				v = new GAM();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != rst)
					rst.close();
				if (null != stmt)
					stmt.close();
				if (null != conn)
					conn.close();
			} catch (SQLException e) {
			}

		}

		return v;
	}
	
	
	public AccountResult getAllAccounts(User user,  Integer start, Integer size ) {
		List<GAM> vl = new ArrayList<GAM>();
		AccountResult ur = new AccountResult();
		StringBuilder builder = new StringBuilder();
		StringBuilder cBuilder = new StringBuilder();
		
		builder.append(getAccountListQuery());
		cBuilder.append(getAccountCountQuery());
		
		builder.append(" where length(t.foracid) = 10 ");
		cBuilder.append(" where length(t.foracid) = 10 ");
		
		
		/*builder.append(" where t.deleted = false ");
		cBuilder.append(" where t.deleted = false ");
		*/
		
		if ("admin".equalsIgnoreCase(user.getRole().getId())) {
			
		} 
		
		builder.append(" order by t.foracid ");
		builder.append(" limit  ");builder.append(size);
		builder.append(" offset  ");builder.append(start);
		
		//logger.info(" the sql is "+builder.toString());
				
		Connection conn = null;
		ResultSet rst = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rst = stmt.executeQuery(builder.toString());
			

			vl = formAccountList(rst);
			ur.setAccounts(vl);
			
			AccountSummaryDTO us = new AccountSummaryDTO();
			if(start == 0) {
				if(null != stmt)stmt.close();
				stmt = conn.createStatement();
				rst = stmt.executeQuery(cBuilder.toString());
				
				if(rst.next()) {
					Long totalSize = rst.getLong("total_size");
					us.setTotalSize(totalSize.intValue());
				}
			}
			ur.setSummary(us);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(null != rst)rst.close();
				if(null != stmt) stmt.close();
				if(null != conn) conn.close();
			}catch(SQLException e) {}
		}


		return ur;
	}

	
	private List<GAM> formAccountList(ResultSet rst) {
		List<GAM> vl = new ArrayList<GAM>();
		
		try {
			while (rst.next()) {
				GAM v = new GAM();
				v.setForacid(rst.getString("foracid"));
				v.setAcid(rst.getString("acid"));
				v.setAcct_crncy_code(rst.getString("acct_crncy_code"));
				v.setAcct_name(rst.getString("acct_name"));
				v.setSol_id(rst.getString("sol_id"));
				v.setCust_id(rst.getString("cust_id"));
				v.setCif_id(rst.getString("cif_id"));
				v.setClr_bal_amt(rst.getBigDecimal("clr_bal_amt"));
				
				
				vl.add(v);
								
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return vl;
	}

	
	private static String GAM_LIST_SQL = null;
	private static String GAM_COUNT_SQL = null;
	
	private  String getAccountListQuery() {
		if(null == GAM_LIST_SQL) {
			StringBuilder builder = new StringBuilder();
			
			builder.append(" select ");
			builder.append(" 	t.foracid ");
			builder.append(" 	, t.clr_bal_amt ");
			builder.append(" 	, t.acid ");
			builder.append(" 	, t.acct_crncy_code ");
			builder.append(" 	, t.sol_id ");
			builder.append(" 	, t.acct_name ");
			builder.append(" 	, t.cif_id ");
			builder.append(" 	, t.cust_id ");
			builder.append(" from finacle.gam  t ");
			
			
			GAM_LIST_SQL = builder.toString();
			
		}
		return GAM_LIST_SQL;
	}
	
	
	private  String getAccountCountQuery() {
		if(null == GAM_COUNT_SQL) {
			StringBuilder builder = new StringBuilder();
			
			builder.append(" select count(1) as total_size   ");
			builder.append(" from finacle.gam  t ");
			//builder.append(" where length(t.foracid) = 10 ");
			
			
			GAM_COUNT_SQL = builder.toString();
			
		}
		return GAM_COUNT_SQL;
	}
	
	
	
	public AccountResult search(User u, Integer start, Integer size, AccountSearchDTO search) {
		StringBuilder builder = new StringBuilder();
		StringBuilder cBuilder = new StringBuilder();
		
		AccountResult tr = new AccountResult();
		User user = em.find(User.class, search.getUserId());
		if (null == user) { // confirm user from the token too
			// strange. return an empty lsist
			return tr;
		}

		Map<String,String> pMap = new HashMap<>();
		
		builder.append(getAccountListQuery());
		cBuilder.append(getAccountCountQuery());
		
		
		String pn = search.getAccountName();
		if(null != pn && pn.length() != 0) {
			StringBuilder b = new StringBuilder();
			b.append(" lower(t.acct_name) like '%");b.append(search.getAccountName().toLowerCase());b.append("%'");
			
			pMap.put("acct_name", b.toString());
			
		}
		
		String an = search.getAccountNumber();
		if(null != an && an.length() != 0) {
			StringBuilder b = new StringBuilder();
			b.append(" t.foracid like '%");b.append(an);b.append("%'");
			
			pMap.put("foracid", b.toString());
			
		}
		
		
		
		/*String cntry = search.getCountry();
		if(null != cntry) {
			StringBuilder b = new StringBuilder();
			b.append(" t.country = '");b.append(search.getCountry());b.append("'");
			pMap.put("country", b.toString());
		}
		*/
		
		
		String st1, ed1;
		st1 = search.getStartDate();
		ed1 = search.getEndDate();
		
		Date st, ed;
		st = Util.parseDate(st1, "yyyy-MM-dd");
		ed = Util.parseDate(ed1, "yyyy-MM-dd");
		
		String dateTypes = search.getDateType();
		
		if (null != st || null != ed) {
			StringBuilder b = new StringBuilder();
			if (null == ed)
				ed = st;
			if (null == st)
				st = ed; // AccountDateType
			
			AccountDateType ts = null;
			try {
				ts = null != dateTypes ? AccountDateType.valueOf(dateTypes) : null;
			} catch (Exception e) {}
			logger.info("The status date is "+ts);
			
			//Predicate condition = null;
			if(null != ts) {
				switch (ts) {
				case OD: // the date the session was approved/accepted
					b.append(" t.acct_opn_date between '");
					b.append(Util.convertDateToString(st, "yyyy-MM-dd"));b.append("' and '");
					b.append(Util.convertDateToString(ed, "yyyy-MM-dd"));b.append("' ");
					break;
				case CD: // the date the session was initiated
					b.append(" t.acct_cls_date between '");
					b.append(Util.convertDateToString(st, "yyyy-MM-dd"));b.append("' and '");
					b.append(Util.convertDateToString(ed, "yyyy-MM-dd"));b.append("' ");
					
					break;

				default:
					b.append(" t.acct_opn_date between '");
					b.append(Util.convertDateToString(st, "yyyy-MM-dd"));b.append("' and '");
					b.append(Util.convertDateToString(ed, "yyyy-MM-dd"));b.append("' ");
					

				}
				pMap.put("date", b.toString());
			}
			

		}
		
		
		
		/*if (!("admin".equalsIgnoreCase(user.getRole().getId()) || "googler".equalsIgnoreCase(user.getRole().getId()))) {
			StringBuilder b = new StringBuilder();
			// restrict further
			if ("partner".equalsIgnoreCase(user.getRole().getId())) {
				// restrict to partner
				AbstractDSPerson ap = user.getPerson();
				b.append(" t.partner =  ");b.append(((PartnerEmployee) ap).getPartner().getId());
			} else if ("trainer".equalsIgnoreCase(user.getRole().getId())) {
				// restrict to partner
				AbstractDSPerson ap = user.getPerson();
				b.append(" t.trainer =  ");b.append(ap.getId());
			}
			pMap.put("restrict", b.toString());
		}*/
		
		if(!pMap.isEmpty()) {
			StringBuilder b = new StringBuilder(); 
			Collection<String> values = pMap.values();
			values.forEach(v -> {
				b.append(" and ");b.append(v);
			});
			
			String t = b.toString();
			// replace the first occurence of and with where
			t = t.replaceFirst("and", "where");
			builder.append(t);
			cBuilder.append(t);
		}
		

		builder.append(" order by t.foracid   ");
		builder.append(" limit  ");builder.append(size);
		builder.append(" offset  ");builder.append(start);
		
		
		/*cBuilder.append(" group by t.partner,p.name ");
		cBuilder.append(" order by t.partner ");*/
		
		logger.info(" the sql is "+builder.toString());
		
		Connection conn = null;
		ResultSet rst = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		List<GAM> vl = new ArrayList<GAM>();
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rst = stmt.executeQuery(builder.toString());

			vl = formAccountList(rst);
			
			//AccountSummaryDTO td = new AccountSummaryDTO();
			AccountSummaryDTO us = new AccountSummaryDTO();
			if(start == 0) {
				if(null != stmt)stmt.close();
				stmt = conn.createStatement();
				rst = stmt.executeQuery(cBuilder.toString());
				
				if(rst.next()) {
					Long totalSize = rst.getLong("total_size");
					us.setTotalSize(totalSize.intValue());
				}
			}
			tr.setSummary(us);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(null != rst)rst.close();
				if(null != stmt) stmt.close();
				if(null != pstmt) pstmt.close();
				if(null != conn) conn.close();
			}catch(SQLException e) {}
			
		}
		
		tr.setAccounts(vl);
		
		return tr;
	}

	

}
