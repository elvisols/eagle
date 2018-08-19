/**
 * 
 */
package com.exelon.ee.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exelon.ee.model.finacle.DTD;
import com.exelon.ee.model.finacle.TransactionPK;

/**
 * @author ukaegbu
 *
 */
public class AbstractDAO {

	/**
	 * 
	 */
	public AbstractDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	protected List<DTD> getDtdFromResultSet(ResultSet rst) {
		List<DTD> vl = new ArrayList<DTD>();
		
		try {
			while (rst.next()) {
				DTD v = new DTD();
				v.setForacid(rst.getString("foracid"));
				v.setAcct_name(rst.getString("acct_name"));
				v.setCrncy_code(rst.getString("crncy_code"));
				v.setCust_id(rst.getString("cust_id"));
				v.setEntry_date(rst.getDate("entry_date"));
				v.setEntry_user_id(rst.getString("entry_user_id"));
				
				TransactionPK id = new TransactionPK();
				id.setPart_tran_srl_num(rst.getString("pART_TRAN_SRL_NUM"));
				id.setTran_date(rst.getDate("tran_date"));
				id.setTran_id(rst.getString("tran_id").trim());
				v.setId(id);
				v.setAcid(rst.getString("acid"));
				v.setPart_tran_type(rst.getString("part_tran_type"));
				v.setPstd_date(rst.getDate("pstd_date"));
				v.setSol_id(rst.getString("sol_id"));
				v.setTran_amt(rst.getBigDecimal("tran_amt"));
				v.setTran_crncy_code(rst.getString("tran_crncy_code"));
				v.setTran_particular(rst.getString("tran_particular"));
				v.setTran_rmks(rst.getString("tran_rmks"));
				v.setTran_crncy_code(rst.getString("tran_crncy_code"));
				v.setTran_sub_type(rst.getString("tran_sub_type"));
				v.setTran_type(rst.getString("tran_type"));
				v.setCrncy_code(rst.getString("crncy_code"));
				v.setValue_date(rst.getDate("value_date"));
				v.setVfd_date(rst.getDate("vfd_date"));
				v.setVfd_user_id(rst.getString("vfd_user_id"));
				
				
				vl.add(v);
								
			}
		} catch (SQLException e) {
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


}
