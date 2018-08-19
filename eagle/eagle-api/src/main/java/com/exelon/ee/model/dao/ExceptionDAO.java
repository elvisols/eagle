/**
 * 
 */
package com.exelon.ee.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import com.exelon.ee.model.AuditException;
import com.exelon.ee.model.User;
import com.exelon.ee.model.finacle.CMG;
import com.exelon.ee.model.finacle.DTD;
import com.exelon.ee.model.finacle.GAM;
import com.exelon.ee.rs.callover.CalloverResult;
import com.exelon.ee.rs.callover.CalloverSummaryDTO;
import com.exelon.ee.rs.exception.ExceptionResponse;
import com.exelon.ee.rs.exception.ExceptionResult;
import com.exelon.ee.rs.exception.ExceptionSummaryDTO;

/**
 * @author ukaegbu
 *
 */
@ApplicationScoped
public class ExceptionDAO extends AbstractDAO{

	@Inject
	private Logger logger;

	@Inject
	private EntityManager em;

	@Resource(mappedName = "java:jboss/datasources/eagle")
	private DataSource ds;

	public List<ExceptionResponse> getDashboard(User user, Integer start, Integer size) {

		StringBuilder builder = new StringBuilder();
		List<ExceptionResponse> vl = new ArrayList<>();

		builder.append(" with txn_by_channel as ( ");
		builder.append(" select ");
		builder.append(" 	c.id ");
		builder.append(" 	, c.name ");
		builder.append(" 	, t.currency ");
		builder.append(" 	, sum(dr_amount) as dr_amount ");
		builder.append(" 	, sum(cr_amount) as cr_amount ");
		builder.append(" 	, sum(txn_count) as txn_count ");
		builder.append(" from core_txn_by_channel t ");
		builder.append(" inner join core_audit_exception c on c.id = t.channel ");
		builder.append(" group by c.id, c.name, t.currency ");
		builder.append(" order by c.name) ");
		builder.append(" select *  ");
		builder.append(" from txn_by_channel ");

		Connection conn = null;
		ResultSet rst = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rst = stmt.executeQuery(builder.toString());

			while (rst.next()) {
				ExceptionResponse v = new ExceptionResponse();
				v.setCrAmount(rst.getBigDecimal("cr_amount"));
				v.setCurrency(rst.getString("currency"));
				v.setDrAmount(rst.getBigDecimal("dr_amount"));
				v.setId(rst.getLong("id"));
				v.setName(rst.getString("name"));
				v.setTxnCount(rst.getLong("txn_count"));

				vl.add(v);
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

		return vl;
	}

	public List<ExceptionResponse> getDashboard(CMG customer, User user, Integer start, Integer size) {

		StringBuilder builder = new StringBuilder();
		List<ExceptionResponse> vl = new ArrayList<>();

		builder.append(" with txn_by_channel as ( ");
		builder.append(" select ");
		builder.append(" 	c.id ");
		builder.append(" 	, c.name ");
		builder.append(" 	, t.currency ");
		builder.append(" 	, sum(dr_amount) as dr_amount ");
		builder.append(" 	, sum(cr_amount) as cr_amount ");
		builder.append(" 	, sum(txn_count) as txn_count ");
		builder.append(" from core_txn_by_channel t ");
		builder.append(" inner join core_audit_exception c on c.id = t.channel ");
		builder.append(" where t.customer = '");builder.append(customer.getCif_id().trim());builder.append("'");
		builder.append(" group by c.id, c.name, t.currency ");
		builder.append(" order by c.name) ");
		builder.append(" select *  ");
		builder.append(" from txn_by_channel ");

		Connection conn = null;
		ResultSet rst = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rst = stmt.executeQuery(builder.toString());

			while (rst.next()) {
				ExceptionResponse v = new ExceptionResponse();
				v.setCrAmount(rst.getBigDecimal("cr_amount"));
				v.setCurrency(rst.getString("currency"));
				v.setDrAmount(rst.getBigDecimal("dr_amount"));
				v.setId(rst.getLong("id"));
				v.setName(rst.getString("name"));
				v.setTxnCount(rst.getLong("txn_count"));

				vl.add(v);
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

		return vl;
	}

	public List<ExceptionResponse> getDashboard(GAM account, User user, Integer start, Integer size) {

		StringBuilder builder = new StringBuilder();
		List<ExceptionResponse> vl = new ArrayList<>();

		builder.append(" with txn_by_channel as ( ");
		builder.append(" select ");
		builder.append(" 	c.id ");
		builder.append(" 	, c.name ");
		builder.append(" 	, t.currency ");
		builder.append(" 	, sum(dr_amount) as dr_amount ");
		builder.append(" 	, sum(cr_amount) as cr_amount ");
		builder.append(" 	, sum(txn_count) as txn_count ");
		builder.append(" from core_txn_by_channel t ");
		builder.append(" inner join core_audit_exception c on c.id = t.channel ");
		builder.append(" where t.account_number = '");builder.append(account.getForacid().trim());builder.append("'");
		builder.append(" group by c.id, c.name, t.currency ");
		builder.append(" order by c.name) ");
		builder.append(" select *  ");
		builder.append(" from txn_by_channel ");

		Connection conn = null;
		ResultSet rst = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rst = stmt.executeQuery(builder.toString());

			while (rst.next()) {
				ExceptionResponse v = new ExceptionResponse();
				v.setCrAmount(rst.getBigDecimal("cr_amount"));
				v.setCurrency(rst.getString("currency"));
				v.setDrAmount(rst.getBigDecimal("dr_amount"));
				v.setId(rst.getLong("id"));
				v.setName(rst.getString("name"));
				v.setTxnCount(rst.getLong("txn_count"));

				vl.add(v);
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

		return vl;
	}

	
	public ExceptionResult getAllExceptions(User user, Integer start, Integer size) {
		List<AuditException> vl = new ArrayList<AuditException>();
		ExceptionResult ur = new ExceptionResult();
		StringBuilder builder = new StringBuilder();
		StringBuilder cBuilder = new StringBuilder();

		builder.append(getExceptionListQuery());
		cBuilder.append(getExceptionCountQuery());

		builder.append(" where t.deleted = false ");
		cBuilder.append(" where t.deleted = false ");

		if ("admin".equalsIgnoreCase(user.getRole().getId())) {

		}

		builder.append(" order by t.id ");
		builder.append(" limit  ");
		builder.append(size);
		builder.append(" offset  ");
		builder.append(start);

		// logger.info(" the sql is "+builder.toString());

		Connection conn = null;
		ResultSet rst = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rst = stmt.executeQuery(builder.toString());

			vl = formExceptionList(rst);
			ur.setExceptions(vl);

			ExceptionSummaryDTO us = new ExceptionSummaryDTO();
			if (start == 0) {
				if (null != stmt)
					stmt.close();
				stmt = conn.createStatement();
				rst = stmt.executeQuery(cBuilder.toString());

				if (rst.next()) {
					Long totalSize = rst.getLong("total_size");
					us.setTotalSize(totalSize.intValue());
				}
			}
			ur.setSummary(us);

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

		return ur;
	}
	
	
	public CalloverResult getExceptionTxns(User user, Exception channel, String currency,  Integer start, Integer size ) {
		List<DTD> vl = new ArrayList<DTD>();
		CalloverResult ur = new CalloverResult();
		StringBuilder builder = new StringBuilder();
		StringBuilder cBuilder = new StringBuilder();
		
		builder.append(getExceptionTxnListQuery());
		cBuilder.append(getExceptionTxnCountQuery());
		
		
		if ("admin".equalsIgnoreCase(user.getRole().getId())) {
			
		} 
		
		builder.append(" order by t.tran_id desc ");
		builder.append(" limit  ");builder.append(size);
		builder.append(" offset  ");builder.append(start);
		
		//logger.info(" the sql is "+builder.toString());
				
		Connection conn = null;
		ResultSet rst = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setString(1, currency);
			
			rst = pstmt.executeQuery();
			

			vl = getDtdFromResultSet(rst);
			ur.setTxns(vl);
			
			CalloverSummaryDTO us = new CalloverSummaryDTO();
			if(start == 0) {
				if(null != pstmt)pstmt.close();
				pstmt = conn.prepareStatement(cBuilder.toString());
				pstmt.setString(1, currency);
				
				rst = pstmt.executeQuery();
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
				if(null != pstmt) pstmt.close();
				if(null != conn) conn.close();
			}catch(SQLException e) {}
		}


		return ur;
	}


	

	private List<AuditException> formExceptionList(ResultSet rst) {
		List<AuditException> vl = new ArrayList<AuditException>();

		try {
			while (rst.next()) {
				AuditException v = new AuditException();
				v.setId(rst.getLong("id"));
				v.setName(rst.getString("name"));
				v.setDescription(rst.getString("description"));
				// v.setThumbnail(rst.getString("profile_image"));

				vl.add(v);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return vl;
	}

	private static String CHANNEL_LIST_SQL = null;
	private static String CHANNEL_COUNT_SQL = null;

	private String getExceptionListQuery() {
		if (null == CHANNEL_LIST_SQL) {
			StringBuilder builder = new StringBuilder();

			builder.append(" select ");
			builder.append(" 	t.id ");
			builder.append(" 	, t.name ");
			builder.append(" 	, t.description ");

			builder.append(" from core_audit_exception t ");

			CHANNEL_LIST_SQL = builder.toString();

		}
		return CHANNEL_LIST_SQL;
	}

	private String getExceptionCountQuery() {
		if (null == CHANNEL_COUNT_SQL) {
			StringBuilder builder = new StringBuilder();

			builder.append(" select count(1) as total_size   ");
			builder.append(" from core_audit_exception t ");

			CHANNEL_COUNT_SQL = builder.toString();

		}
		return CHANNEL_COUNT_SQL;
	}
	
	
	private static String TXN_LIST_SQL = null;
	private static String TXN_COUNT_SQL = null;
	
	
	private  String getExceptionTxnListQuery() {
		if(null == TXN_LIST_SQL) {
			StringBuilder builder = new StringBuilder();
			
			builder.append(" select  ");
			builder.append(" 	g.foracid ");
			builder.append(" 	, g.acct_name ");
			builder.append(" 	, t.* ");
			builder.append(" from finacle.dtd t  ");
			builder.append(" join finacle.gam g on g.acid = t.acid ");
			builder.append(" where t.tran_crncy_code =  ? ");
			
			
			
			TXN_LIST_SQL = builder.toString();
			
		}
		return TXN_LIST_SQL;
	}
	
	
	private  String getExceptionTxnCountQuery() {
		if(null == TXN_COUNT_SQL) {
			StringBuilder builder = new StringBuilder();
			
			builder.append(" select count(1) as total_size   ");
			builder.append(" from finacle.dtd t  ");
			builder.append(" join finacle.gam g on g.acid = t.acid ");
			builder.append(" where t.tran_crncy_code =  ? ");
			
			TXN_COUNT_SQL = builder.toString();
			
		}
		return TXN_COUNT_SQL;
	}

}
