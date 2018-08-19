/**
 * 
 */
package com.exelon.ee.model.finacle;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author ukaegbu
 *
 */
@Entity
@Table(name="finacle.hth")
@NamedQueries( {
	@NamedQuery(name = "HTH.findByCustId", query = "select c from GAM c  where  c.cust_id = :cust_id")
})
public class HTH implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HTHPK id;
	
	@Column(length=1)
	private String del_flg                 ; // CHAR(1 BYTE),
	
	@Column(length=1)
	private String tran_type               ; // CHAR(1 BYTE),
	
	@Column(length=2)
	private String tran_sub_type           ; // VARCHAR2(2 BYTE),
	private Integer num_cr_tran_entry       ; // NUMBER(4),
	private Integer num_dr_tran_entry       ; // NUMBER(4),
	private Integer num_cr_tran_pstd        ; //  NUMBER(4),
	private Integer num_dr_tran_pstd        ; //  NUMBER(4),
	private Integer num_tran_vfd            ; //  NUMBER(4),
	private Integer num_tran_deleted        ; //  NUMBER(4),
	
	@Column(length=1)
	private String tran_cre_mode           ; // CHAR(1 BYTE),
	
	@Column(length=1)
	private String restrict_modify_ind     ; // CHAR(1 BYTE),
	
	@Column(length=30)
	private String remarks                 ; // VARCHAR2(30 BYTE),
	
	@Column(length=15)
	private String lchg_user_id            ; //  VARCHAR2(15 BYTE),
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lchg_time               ; // DATE,
	private String rcre_user_id            ; //  VARCHAR2(15 BYTE),
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date rcre_time               ; // DATE,
	
	@Column(length=1)
	private String pst_flg                 ; // CHAR(1 BYTE),
	
	@Column(length=10)
	private String delivery_channel_id     ; // VARCHAR2(10 BYTE),
	
	@Column(length=8)
	private String init_sol_id             ; // VARCHAR2(8 BYTE),
	
	@Column(length=1)
	private String ignore_xcpn_flg         ; // CHAR(1 BYTE),
	private Integer num_tran_purged         ; // NUMBER(4),
	
	@Column(length=5)
	private String b2k_event_type          ; //  VARCHAR2(5 BYTE),
	private Integer ts_cnt                  ; //  NUMBER(5),
	
	@Column(length=1)
	private String sys_entered_user_mod_flg; //  CHAR(1 BYTE)

	/**
	 * 
	 */
	public HTH() {
	}

	/**
	 * @return the b2k_event_type
	 */
	public String getB2k_event_type() {
		return b2k_event_type;
	}

	/**
	 * @param b2k_event_type the b2k_event_type to set
	 */
	public void setB2k_event_type(String b2k_event_type) {
		this.b2k_event_type = b2k_event_type;
	}

	/**
	 * @return the del_flg
	 */
	public String getDel_flg() {
		return del_flg;
	}

	/**
	 * @param del_flg the del_flg to set
	 */
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	/**
	 * @return the delivery_channel_id
	 */
	public String getDelivery_channel_id() {
		return delivery_channel_id;
	}

	/**
	 * @param delivery_channel_id the delivery_channel_id to set
	 */
	public void setDelivery_channel_id(String delivery_channel_id) {
		this.delivery_channel_id = delivery_channel_id;
	}

	/**
	 * @return the id
	 */
	public HTHPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(HTHPK id) {
		this.id = id;
	}

	/**
	 * @return the ignore_xcpn_flg
	 */
	public String getIgnore_xcpn_flg() {
		return ignore_xcpn_flg;
	}

	/**
	 * @param ignore_xcpn_flg the ignore_xcpn_flg to set
	 */
	public void setIgnore_xcpn_flg(String ignore_xcpn_flg) {
		this.ignore_xcpn_flg = ignore_xcpn_flg;
	}

	/**
	 * @return the init_sol_id
	 */
	public String getInit_sol_id() {
		return init_sol_id;
	}

	/**
	 * @param init_sol_id the init_sol_id to set
	 */
	public void setInit_sol_id(String init_sol_id) {
		this.init_sol_id = init_sol_id;
	}

	/**
	 * @return the lchg_time
	 */
	public Date getLchg_time() {
		return lchg_time;
	}

	/**
	 * @param lchg_time the lchg_time to set
	 */
	public void setLchg_time(Date lchg_time) {
		this.lchg_time = lchg_time;
	}

	/**
	 * @return the lchg_user_id
	 */
	public String getLchg_user_id() {
		return lchg_user_id;
	}

	/**
	 * @param lchg_user_id the lchg_user_id to set
	 */
	public void setLchg_user_id(String lchg_user_id) {
		this.lchg_user_id = lchg_user_id;
	}

	/**
	 * @return the num_cr_tran_entry
	 */
	public Integer getNum_cr_tran_entry() {
		return num_cr_tran_entry;
	}

	/**
	 * @param num_cr_tran_entry the num_cr_tran_entry to set
	 */
	public void setNum_cr_tran_entry(Integer num_cr_tran_entry) {
		this.num_cr_tran_entry = num_cr_tran_entry;
	}

	/**
	 * @return the num_cr_tran_pstd
	 */
	public Integer getNum_cr_tran_pstd() {
		return num_cr_tran_pstd;
	}

	/**
	 * @param num_cr_tran_pstd the num_cr_tran_pstd to set
	 */
	public void setNum_cr_tran_pstd(Integer num_cr_tran_pstd) {
		this.num_cr_tran_pstd = num_cr_tran_pstd;
	}

	/**
	 * @return the num_dr_tran_entry
	 */
	public Integer getNum_dr_tran_entry() {
		return num_dr_tran_entry;
	}

	/**
	 * @param num_dr_tran_entry the num_dr_tran_entry to set
	 */
	public void setNum_dr_tran_entry(Integer num_dr_tran_entry) {
		this.num_dr_tran_entry = num_dr_tran_entry;
	}

	/**
	 * @return the num_dr_tran_pstd
	 */
	public Integer getNum_dr_tran_pstd() {
		return num_dr_tran_pstd;
	}

	/**
	 * @param num_dr_tran_pstd the num_dr_tran_pstd to set
	 */
	public void setNum_dr_tran_pstd(Integer num_dr_tran_pstd) {
		this.num_dr_tran_pstd = num_dr_tran_pstd;
	}

	/**
	 * @return the num_tran_deleted
	 */
	public Integer getNum_tran_deleted() {
		return num_tran_deleted;
	}

	/**
	 * @param num_tran_deleted the num_tran_deleted to set
	 */
	public void setNum_tran_deleted(Integer num_tran_deleted) {
		this.num_tran_deleted = num_tran_deleted;
	}

	/**
	 * @return the num_tran_purged
	 */
	public Integer getNum_tran_purged() {
		return num_tran_purged;
	}

	/**
	 * @param num_tran_purged the num_tran_purged to set
	 */
	public void setNum_tran_purged(Integer num_tran_purged) {
		this.num_tran_purged = num_tran_purged;
	}

	/**
	 * @return the num_tran_vfd
	 */
	public Integer getNum_tran_vfd() {
		return num_tran_vfd;
	}

	/**
	 * @param num_tran_vfd the num_tran_vfd to set
	 */
	public void setNum_tran_vfd(Integer num_tran_vfd) {
		this.num_tran_vfd = num_tran_vfd;
	}

	/**
	 * @return the pst_flg
	 */
	public String getPst_flg() {
		return pst_flg;
	}

	/**
	 * @param pst_flg the pst_flg to set
	 */
	public void setPst_flg(String pst_flg) {
		this.pst_flg = pst_flg;
	}

	/**
	 * @return the rcre_time
	 */
	public Date getRcre_time() {
		return rcre_time;
	}

	/**
	 * @param rcre_time the rcre_time to set
	 */
	public void setRcre_time(Date rcre_time) {
		this.rcre_time = rcre_time;
	}

	/**
	 * @return the rcre_user_id
	 */
	public String getRcre_user_id() {
		return rcre_user_id;
	}

	/**
	 * @param rcre_user_id the rcre_user_id to set
	 */
	public void setRcre_user_id(String rcre_user_id) {
		this.rcre_user_id = rcre_user_id;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the restrict_modify_ind
	 */
	public String getRestrict_modify_ind() {
		return restrict_modify_ind;
	}

	/**
	 * @param restrict_modify_ind the restrict_modify_ind to set
	 */
	public void setRestrict_modify_ind(String restrict_modify_ind) {
		this.restrict_modify_ind = restrict_modify_ind;
	}

	/**
	 * @return the sys_entered_user_mod_flg
	 */
	public String getSys_entered_user_mod_flg() {
		return sys_entered_user_mod_flg;
	}

	/**
	 * @param sys_entered_user_mod_flg the sys_entered_user_mod_flg to set
	 */
	public void setSys_entered_user_mod_flg(String sys_entered_user_mod_flg) {
		this.sys_entered_user_mod_flg = sys_entered_user_mod_flg;
	}

	/**
	 * @return the tran_cre_mode
	 */
	public String getTran_cre_mode() {
		return tran_cre_mode;
	}

	/**
	 * @param tran_cre_mode the tran_cre_mode to set
	 */
	public void setTran_cre_mode(String tran_cre_mode) {
		this.tran_cre_mode = tran_cre_mode;
	}

	/**
	 * @return the tran_sub_type
	 */
	public String getTran_sub_type() {
		return tran_sub_type;
	}

	/**
	 * @param tran_sub_type the tran_sub_type to set
	 */
	public void setTran_sub_type(String tran_sub_type) {
		this.tran_sub_type = tran_sub_type;
	}

	/**
	 * @return the tran_type
	 */
	public String getTran_type() {
		return tran_type;
	}

	/**
	 * @param tran_type the tran_type to set
	 */
	public void setTran_type(String tran_type) {
		this.tran_type = tran_type;
	}

	/**
	 * @return the ts_cnt
	 */
	public Integer getTs_cnt() {
		return ts_cnt;
	}

	/**
	 * @param ts_cnt the ts_cnt to set
	 */
	public void setTs_cnt(Integer ts_cnt) {
		this.ts_cnt = ts_cnt;
	}


}
