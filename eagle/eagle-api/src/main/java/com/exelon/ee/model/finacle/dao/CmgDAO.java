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

import com.exelon.ee.enums.CustomerDateType;
import com.exelon.ee.model.Parameter;
import com.exelon.ee.model.User;
import com.exelon.ee.model.finacle.CMG;
import com.exelon.ee.model.finacle.GAM;
import com.exelon.ee.qualifier.SystemParameter;
import com.exelon.ee.rs.customer.CustomerResult;
import com.exelon.ee.rs.customer.CustomerSearchDTO;
import com.exelon.ee.rs.customer.CustomerSummaryDTO;
import com.exelon.ee.util.Util;

/**
 * @author ukaegbu
 *
 */
@ApplicationScoped
public class CmgDAO {

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
	
	
	public CMG getCustomer(String cifId) {
		
		
		return null;
		
	}

	public CMG getCustomerFromCba(String cifId) {

		StringBuilder builder = new StringBuilder();

		builder.append(" select  ");
		builder.append("   * ");
		builder.append(" from ");
		builder.append(" tbaadm.cmg  g ");
		builder.append(" where g.cif_id = ' ");	builder.append(cifId);builder.append("'  ");

		Connection conn = null;
		ResultSet rst = null;
		Statement stmt = null;
		CMG v = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rst = stmt.executeQuery(builder.toString());

			if (rst.next()) {
				v = new CMG();

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
	
	
	public CustomerResult getAllCustomers(User user,  Integer start, Integer size ) {
		List<CMG> vl = new ArrayList<CMG>();
		CustomerResult ur = new CustomerResult();
		StringBuilder builder = new StringBuilder();
		StringBuilder cBuilder = new StringBuilder();
		
		builder.append(getCustomerListQuery());
		cBuilder.append(getCustomerCountQuery());
		
		
		/*builder.append(" where t.deleted = false ");
		cBuilder.append(" where t.deleted = false ");
		*/
		
		if ("admin".equalsIgnoreCase(user.getRole().getId())) {
			
		} 
		
		builder.append(" order by t.cif_id ");
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
			

			vl = formCustomerList(rst);
			ur.setCustomers(vl);
			
			CustomerSummaryDTO us = new CustomerSummaryDTO();
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

	
	private List<CMG> formCustomerList(ResultSet rst) {
		List<CMG> vl = new ArrayList<CMG>();
		
		try {
			while (rst.next()) {
				CMG v = new CMG();
				v.setCust_id(rst.getString("cust_id"));
				v.setCif_id(rst.getString("cif_id"));
				v.setCust_name(rst.getString("cust_name"));
				v.setCust_type_code(rst.getString("cust_type_code"));
				v.setAcct_mgr_user_id(rst.getString("acct_mgr_user_id"));
				v.setCust_sector_code(rst.getString("cust_sector_code"));
				
				
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

	
	private static String CMG_LIST_SQL = null;
	private static String CMG_COUNT_SQL = null;
	
	private  String getCustomerListQuery() {
		if(null == CMG_LIST_SQL) {
			StringBuilder builder = new StringBuilder();
			
			builder.append(" select ");
			builder.append(" 	t.cif_id ");
			builder.append(" 	, t.cust_id ");
			builder.append(" 	, t.cust_name ");
			builder.append(" 	, t.acct_mgr_user_id ");
			builder.append(" 	, t.cust_type_code ");
			builder.append(" 	, t.cust_sector_code ");
			
			builder.append(" from finacle.cmg  t ");
			
			CMG_LIST_SQL = builder.toString();
			
		}
		return CMG_LIST_SQL;
	}
	
	
	private  String getCustomerCountQuery() {
		if(null == CMG_COUNT_SQL) {
			StringBuilder builder = new StringBuilder();
			
			builder.append(" select count(1) as total_size   ");
			builder.append(" from finacle.cmg  t ");
			
			
			CMG_COUNT_SQL = builder.toString();
			
		}
		return CMG_COUNT_SQL;
	}
	
	
	public CustomerResult search(User u, Integer start, Integer size, CustomerSearchDTO search) {
		StringBuilder builder = new StringBuilder();
		StringBuilder cBuilder = new StringBuilder();
		
		CustomerResult tr = new CustomerResult();
		User user = em.find(User.class, search.getUserId());
		if (null == user) { // confirm user from the token too
			// strange. return an empty lsist
			return tr;
		}

		Map<String,String> pMap = new HashMap<>();
		
		builder.append(getCustomerListQuery());
		cBuilder.append(getCustomerCountQuery());
		
		
		String pn = search.getCustomerName();
		if(null != pn && pn.length() != 0) {
			StringBuilder b = new StringBuilder();
			b.append(" lower(t.cust_name) like '%");b.append(search.getCustomerName().toLowerCase());b.append("%'");
			
			pMap.put("acct_name", b.toString());
			
		}
		
		
		String cif = search.getCustomerNumber();
		if(null != cif && cif.length() != 0) {
			StringBuilder b = new StringBuilder();
			b.append(" lower(t.cif_id) like '%");b.append(cif.toLowerCase());b.append("%'");
			
			pMap.put("cif_id", b.toString());
			
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
		ed = Util.parseDate(st1, "yyyy-MM-dd");
		
		String dateTypes = search.getDateType();
		
		if (null != st || null != ed) {
			StringBuilder b = new StringBuilder();
			if (null == ed)
				ed = st;
			if (null == st)
				st = ed; // CustomerDateType
			
			CustomerDateType ts = null;
			try {
				ts = null != dateTypes ? CustomerDateType.valueOf(dateTypes) : null;
			} catch (Exception e) {}
			//logger.info("The status date is "+ts);
			
			//Predicate condition = null;
			if(null != ts) {
				switch (ts) {
				case OD: // the date the session was approved/accepted
					b.append(" t.cust_opn_date between '");
					b.append(Util.convertDateToString(st, "yyyy-MM-dd"));b.append("' and '");
					b.append(Util.convertDateToString(ed, "yyyy-MM-dd"));b.append("' ");
					break;
				case CD: // the date the session was initiated
					b.append(" t.cust_opn_date between '");
					b.append(Util.convertDateToString(st, "yyyy-MM-dd"));b.append("' and '");
					b.append(Util.convertDateToString(ed, "yyyy-MM-dd"));b.append("' ");
					
					break;

				default:
					b.append(" t.cust_opn_date between '");
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
		

		builder.append(" order by t.cif_id   ");
		builder.append(" limit  ");builder.append(size);
		builder.append(" offset  ");builder.append(start);
		
		
		/*cBuilder.append(" group by t.partner,p.name ");
		cBuilder.append(" order by t.partner ");*/
		
		logger.info(" the sql is "+builder.toString());
		
		Connection conn = null;
		ResultSet rst = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		List<CMG> vl = new ArrayList<CMG>();
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rst = stmt.executeQuery(builder.toString());

			vl = formCustomerList(rst);
			
			//CustomerSummaryDTO td = new CustomerSummaryDTO();
			CustomerSummaryDTO us = new CustomerSummaryDTO();
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
		
		tr.setCustomers(vl);
		
		return tr;
	}


}
