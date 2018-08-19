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
import javax.persistence.Query;
import javax.sql.DataSource;

import com.exelon.ee.model.User;
import com.exelon.ee.model.finacle.CMG;
import com.exelon.ee.model.finacle.DTD;
import com.exelon.ee.model.finacle.TransactionPK;
import com.exelon.ee.rs.callover.CalloverResult;
import com.exelon.ee.rs.callover.CalloverSummary;
import com.exelon.ee.rs.callover.CalloverSummaryDTO;
import com.exelon.ee.rs.channel.ChannelResponse;

/**
 * @author ukaegbu
 *
 */
@ApplicationScoped
public class CalloverDAO extends AbstractDAO {
	
	@Inject
	private Logger logger;

	@Inject
	private EntityManager em;
	
	@Resource(mappedName = "java:jboss/datasources/eagle")
	private DataSource ds;
	
	
	
	public List<CalloverSummary> getCalloverCategories(User user, Integer start, Integer size) {

		StringBuilder builder = new StringBuilder();
		List<CalloverSummary> vl = new ArrayList<>();

		builder.append(" select  ");
		builder.append(" 	'SYSTEM' as txn_type ");
		builder.append(" 	, count(1) as txn_count ");
		builder.append(" from finacle.dtd ");
		builder.append(" where left(trim(tran_id),1) = 'S' and entry_user_id in ('CDCI') ");
		builder.append("  ");
		builder.append(" union all ");
		builder.append(" select  ");
		builder.append(" 	'MANUAL' as txn_type ");
		builder.append(" 	, count(1) as txn_count ");
		builder.append(" from finacle.dtd ");
		builder.append(" where left(trim(tran_id),1) = 'M'  ");

		Connection conn = null;
		ResultSet rst = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rst = stmt.executeQuery(builder.toString());
			Date dt = new Date();
					
			while (rst.next()) {
				CalloverSummary v = new CalloverSummary();
				v.setTxnType(rst.getString("txn_type"));
				v.setTxnCount(rst.getLong("txn_count"));
				v.setTxnDate(dt);
				
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

	
	
	public CalloverResult getAllCalloverSummaries(User user,  String category, Date tranDate, Integer start, Integer size ) {
		List<CalloverSummary> vl = new ArrayList<CalloverSummary>();
		CalloverResult ur = new CalloverResult();
		StringBuilder builder = new StringBuilder();
		StringBuilder cBuilder = new StringBuilder();
		
		builder.append(getCalloverSummaryListQuery(category, tranDate));
		cBuilder.append(getCalloverSummaryCountQuery(category, tranDate));
		
		
		if ("admin".equalsIgnoreCase(user.getRole().getId())) {
			
		} 
		
		StringBuilder additional = new StringBuilder();
		if(null != category) {
			if(category.equalsIgnoreCase("SYSTEM")) {
				additional.append(" where left(trim(tran_id),1) = 'S' and entry_user_id in ('CDCI')");
			}else if(category.equalsIgnoreCase("MANUAL")) {
				additional.append(" where left(trim(tran_id),1) = 'M' ");
			}
			
			builder.append(additional.toString());
			cBuilder.append(additional.toString());
		}
		
		
		//builder.append(" order by t.id ");
		builder.append(" limit  ");builder.append(size);
		builder.append(" offset  ");builder.append(start);
		
		logger.info(" the sql is "+builder.toString());
				
		Connection conn = null;
		ResultSet rst = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rst = stmt.executeQuery(builder.toString());
			

			vl = formCalloverSummaryList(rst);
			ur.setSummaries(vl);
			
			CalloverSummaryDTO us = new CalloverSummaryDTO();
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

	public DTD getTxn(User user, Date tranDate, String tranId, String serialNum) {
		
		TransactionPK pk = new TransactionPK();
		pk.setPart_tran_srl_num(serialNum);
		pk.setTran_date(tranDate);
		pk.setTran_id(tranId);
		
		DTD d = em.find(DTD.class, pk);
		
		return d;
		
	}
	
	/*public CalloverResult getAllCalloverTxnOld(User user, Date tranDate, String tranId,  Integer start, Integer size ) {
		CalloverResult ur = new CalloverResult();
		
		Query q = em.createNamedQuery("DTD.findTxnByTranDateAndTranId")
				.setParameter("tranId", tranId)
				.setParameter("tranDate", tranDate);
		
		List<DTD> dl = q.getResultList();
		ur.setTxns(dl);
		
		CalloverSummaryDTO us = new CalloverSummaryDTO();
		us.setTotalSize(dl.size());
		
		ur.setSummary(us);
		
		return ur;
	}*/
	
	public CalloverResult getAllCalloverTxns(User user, Date tranDate, String tranId,  Integer start, Integer size ) {
		List<DTD> vl = new ArrayList<DTD>();
		CalloverResult ur = new CalloverResult();
		StringBuilder builder = new StringBuilder();
		StringBuilder cBuilder = new StringBuilder();
		
		builder.append(getCalloverTxnListQuery());
		cBuilder.append(getCalloverTxnCountQuery());
		
		
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
			pstmt.setDate(2, new java.sql.Date(tranDate.getTime()));
			pstmt.setString(1, tranId);
			
			rst = pstmt.executeQuery();
			

			vl = getDtdFromResultSet(rst);
			ur.setTxns(vl);
			
			CalloverSummaryDTO us = new CalloverSummaryDTO();
			if(start == 0) {
				if(null != pstmt)pstmt.close();
				pstmt = conn.prepareStatement(cBuilder.toString());
				pstmt.setDate(2, new java.sql.Date(tranDate.getTime()));
				pstmt.setString(1, tranId);
				
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

	
	
	
	private List<CalloverSummary> formCalloverSummaryList(ResultSet rst) {
		List<CalloverSummary> vl = new ArrayList<CalloverSummary>();
		
		try {
			while (rst.next()) {
				CalloverSummary v = new CalloverSummary();
				v.setDifference(rst.getBigDecimal("difference"));
				v.setEntry_user_id(rst.getString("entry_user_id"));
				v.setNum_entries(rst.getInt("num_entries"));
				v.setSol_id(rst.getString("sol_id"));
				v.setTotal_credit(rst.getBigDecimal("total_credit"));
				v.setTotal_debit(rst.getBigDecimal("total_debit"));
				v.setTran_date(rst.getDate("tran_date"));
				v.setTran_id(rst.getString("tran_id"));
				
				
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


	
	
	private static String CALLOVER_LIST_SQL = null;
	private static String CALLOVER_COUNT_SQL = null;
	
	
	private  String getCalloverSummaryListQuery(String category, Date tranDate) {
		if(null == CALLOVER_LIST_SQL) {
			StringBuilder builder = new StringBuilder();
			
			builder.append(" select ");
			builder.append(" 	t.* ");
			builder.append(" from finacle.v_callover_summary t ");
			
			
			// LET US IGNORE THE DATE DURING THE POC
			
			CALLOVER_LIST_SQL = builder.toString();
			
		}
		return CALLOVER_LIST_SQL;
	}
	
	
	private  String getCalloverSummaryCountQuery(String category, Date tranDate) {
		if(null == CALLOVER_COUNT_SQL) {
			StringBuilder builder = new StringBuilder();
			
			builder.append(" select count(1) as total_size   ");
			builder.append(" from finacle.v_callover_summary t ");
			
			
			CALLOVER_COUNT_SQL = builder.toString();
			
		}
		return CALLOVER_COUNT_SQL;
	}
	

	
	private static String TXN_LIST_SQL = null;
	private static String TXN_COUNT_SQL = null;
	
	
	private  String getCalloverTxnListQuery() {
		if(null == TXN_LIST_SQL) {
			StringBuilder builder = new StringBuilder();
			
			builder.append(" select  ");
			builder.append(" 	g.foracid ");
			builder.append(" 	, g.acct_name ");
			builder.append(" 	, t.* ");
			builder.append(" from finacle.dtd t  ");
			builder.append(" join finacle.gam g on g.acid = t.acid ");
			builder.append(" where trim(t.tran_id) = ? ");
			builder.append(" and t.tran_date =  ? ");
			
			
			
			TXN_LIST_SQL = builder.toString();
			
		}
		return TXN_LIST_SQL;
	}
	
	
	private  String getCalloverTxnCountQuery() {
		if(null == TXN_COUNT_SQL) {
			StringBuilder builder = new StringBuilder();
			
			builder.append(" select count(1) as total_size   ");
			builder.append(" from finacle.dtd t  ");
			builder.append(" join finacle.gam g on g.acid = t.acid ");
			builder.append(" where trim(t.tran_id) = ? ");
			builder.append(" and t.tran_date =  ? ");
			
			TXN_COUNT_SQL = builder.toString();
			
		}
		return TXN_COUNT_SQL;
	}
}
