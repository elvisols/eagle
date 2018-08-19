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
import javax.persistence.Query;
import javax.sql.DataSource;

import com.exelon.ee.model.User;
import com.exelon.ee.rs.user.SearchUserDTO;
import com.exelon.ee.rs.user.UserDTO;
import com.exelon.ee.rs.user.UserResult;
import com.exelon.ee.rs.user.UserSummaryDTO;
import com.exelon.ee.util.Util;

/**
 * @author ukaegbu
 *
 */
@ApplicationScoped
public class UserDAO {
	
	@Inject
	private Logger logger;

	@Inject
	private EntityManager em;
	
	@Resource(mappedName = "java:jboss/datasources/eagle")
	private DataSource ds;
	
	public boolean emailExists(User person) {
		Query q = em.createNamedQuery("User.findUserByEmail").setParameter("email", person.getEmail().toLowerCase().trim());
		return !q.getResultList().isEmpty();
	}


	public boolean phoneExists(User person) {
		Query q = em.createNamedQuery("User.findUserByMobileNumber").setParameter("phone", person.getMobileNumber());
		return !q.getResultList().isEmpty();
	}
	
	
	@SuppressWarnings("unchecked")
	public User getUserByMobileNumber(String mobile) {
		Query q = em.createNamedQuery("User.findUserByMobileNumber").setParameter("phone", mobile);
		List<User> rs = q.getResultList() ;
		return rs.isEmpty() ? null : rs.get(0);
	}
	

	@SuppressWarnings("unchecked")
	public User getUserByEmail(String email) {
		Query q = em.createNamedQuery("User.findUserByEmail").setParameter("email", email);
		List<User> rs = q.getResultList() ;
		return rs.isEmpty() ? null : rs.get(0);
	}
	
	
	public UserResult getAllUsers(User user,  Integer start, Integer size ) {
		List<UserDTO> vl = new ArrayList<UserDTO>();
		UserResult ur = new UserResult();
		StringBuilder builder = new StringBuilder();
		StringBuilder cBuilder = new StringBuilder();
		
		builder.append(getUserListQuery());
		cBuilder.append(getUserCountQuery());
		
		
		builder.append(" where t.deleted = false ");
		cBuilder.append(" where t.deleted = false ");
		
		if ("admin".equalsIgnoreCase(user.getRole().getId())) {
			
		} 
		
		builder.append(" order by t.id ");
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
			

			vl = formUserList(rst);
			ur.setUsers(vl);
			
			UserSummaryDTO us = new UserSummaryDTO();
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

	
	public UserResult search(User u, Integer start, Integer size, SearchUserDTO search) {
		StringBuilder builder = new StringBuilder();
		StringBuilder cBuilder = new StringBuilder();
		
		UserResult tr = new UserResult();
		User user = em.find(User.class, search.getUserId());
		if (null == user) { // confirm user from the token too
			// strange. return an empty lsist
			return tr;
		}

		Map<String,String> pMap = new HashMap<>();
		
		builder.append(getUserListQuery());
		cBuilder.append(getUserCountQuery());
		
		if (null != search.getFirstName() && search.getFirstName().length() != 0) {
			StringBuilder b = new StringBuilder();
			b.append(" lower(t.first_name) like '%");b.append(search.getFirstName().toLowerCase());b.append("%'");
			
			pMap.put("first_name", b.toString());
		}
		
		String ln = search.getLastName();
		if(null != ln && ln.length() != 0) {
			StringBuilder b = new StringBuilder();
			b.append(" lower(t.last_name) like '%");b.append(ln.toLowerCase());b.append("%'");
			
			pMap.put("last_name", b.toString());
			
		}
		
		String em = search.getEmail();
		if(null != em && em.length() != 0) {
			StringBuilder b = new StringBuilder();
			b.append(" lower(t.email) like '%");b.append(em.toLowerCase());b.append("%'");
			
			pMap.put("email", b.toString());
			
		}
		
		String rol = search.getUserRole();
		if(null != rol && rol.length() != 0) {
			StringBuilder b = new StringBuilder();
			b.append(" t.role = '");b.append(rol);b.append("'");
			pMap.put("role", b.toString());
		}
		
		Date st, ed;
		st = search.getStartDate();
		ed = search.getEndDate();
		String dateTypes = search.getDateType();
		
		if (null != st || null != ed) {
			StringBuilder b = new StringBuilder();
			if (null == ed)
				ed = st;
			if (null == st)
				st = ed; // TrainingDateType
			
			b.append(" t.last_log_date between '");
			b.append(Util.convertDateToString(st, "yyyy-MM-dd"));b.append("' and '");
			b.append(Util.convertDateToString(ed, "yyyy-MM-dd"));b.append("' ");
			
			
			pMap.put("date", b.toString());

		}
		
		
		
		if (!("admin".equalsIgnoreCase(user.getRole().getId()) || "googler".equalsIgnoreCase(user.getRole().getId()))) {
			StringBuilder b = new StringBuilder();
			// restrict further
			/*if ("partner".equalsIgnoreCase(user.getRole().getId())) {
				// restrict to partner
				AbstractDSPerson ap = user.getPerson();
				b.append(" t.partner =  ");b.append(((PartnerEmployee) ap).getPartner().getId());
			} else if ("trainer".equalsIgnoreCase(user.getRole().getId())) {
				// restrict to partner
				AbstractDSPerson ap = user.getPerson();
				b.append(" t.trainer =  ");b.append(ap.getId());
			}*/
			pMap.put("restrict", b.toString());
		}
		
		if(!pMap.isEmpty()) {
			StringBuilder b = new StringBuilder(); 
			Collection<String> values = pMap.values();
			values.forEach(v -> {
				b.append(" and ");b.append(v);
				//cBuilder.append(" and ");cBuilder.append(v);
			});
			String t = b.toString();
			// replace the first occurence of and with where
			t = t.replaceFirst("and", "where");
			builder.append(t);
			cBuilder.append(t);
		}
		

		builder.append(" order by t.id desc  ");
		builder.append(" limit  ");builder.append(size);
		builder.append(" offset  ");builder.append(start);
		
		//logger.info(" the sql is "+cBuilder.toString());
		
		Connection conn = null;
		ResultSet rst = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		List<UserDTO> vl = new ArrayList<UserDTO>();
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rst = stmt.executeQuery(builder.toString());

			vl = formUserList(rst);
			
			UserSummaryDTO td = new UserSummaryDTO();
			if(start == 0) {
				rst = stmt.executeQuery(cBuilder.toString());
				if(rst.next()) {
					Long totalSize = rst.getLong("total_size");
					
					td.setTotalSize(totalSize.intValue());
					
				}
			}
			
			tr.setSummary(td);

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
		
		tr.setUsers(vl);
		
		return tr;
	}

	
	private List<UserDTO> formUserList(ResultSet rst) {
		List<UserDTO> vl = new ArrayList<UserDTO>();
		
		try {
			while (rst.next()) {
				UserDTO v = new UserDTO();
				v.setId(rst.getLong("id"));
				v.setEmail(rst.getString("email"));
				v.setFirstName(rst.getString("first_name"));
				v.setLastName(rst.getString("last_name"));
				v.setRole(rst.getString("role"));
				//v.setThumbnail(rst.getString("profile_image"));
				
				
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


	public UserDTO getUserDTO(User user) {
		UserDTO v = new UserDTO();
		
		v.setId(user.getId());
		v.setEmail(user.getEmail());
		v.setFirstName(user.getFirstName());
		v.setLastName(user.getLastName());
		v.setRole(user.getRole().getId());
		//v.setThumbnail(null != user.getProfileImage() ? user.getProfileImage().getThumbnail() : null);
		
		return v;
	}
	
	private static String USER_LIST_SQL = null;
	private static String USER_COUNT_SQL = null;
	
	private  String getUserListQuery() {
		if(null == USER_LIST_SQL) {
			StringBuilder builder = new StringBuilder();
			
			builder.append(" select ");
			builder.append(" 	t.id ");
			builder.append(" 	, t.first_name ");
			builder.append(" 	, t.last_name ");
			builder.append(" 	, t.email ");
			builder.append(" 	, t.role ");
			
			builder.append(" from core_user t ");
			
			
			USER_LIST_SQL = builder.toString();
			
		}
		return USER_LIST_SQL;
	}
	
	
	private  String getUserCountQuery() {
		if(null == USER_COUNT_SQL) {
			StringBuilder builder = new StringBuilder();
			
			builder.append(" select count(1) as total_size   ");
			builder.append(" from core_user t ");
			
			USER_COUNT_SQL = builder.toString();
			
		}
		return USER_COUNT_SQL;
	}
	

}
