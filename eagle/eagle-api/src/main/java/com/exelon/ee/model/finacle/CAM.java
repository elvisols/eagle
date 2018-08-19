/**
 * 
 */
package com.exelon.ee.model.finacle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * @author oji
 *
 */
@Entity
@Table(name="finacle.cam")
@NamedQueries( {
	@NamedQuery(name = "CAM.findAllByStatus", query = "select c from CAM c  where  c.acct_status = :status")
})
public class CAM implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String  acid                     ; //  VARCHAR2(11 CHAR),
	private BigDecimal  max_alwd_advn_lim        ; //  NUMBER(20,4),
	private String  acct_crfile_ref_id       ; //  VARCHAR2(15 CHAR),
	private Long  lf_chrg_pend_lines       ; //  NUMBER(4),
	private String  health_code              ; //  VARCHAR2(5 CHAR),
	private Date  last_lf_calc_date        ; //  DATE,
	private Date  last_aod_aos_date        ; //  DATE,
	private String  rcre_user_id             ; //  VARCHAR2(15 CHAR),
	private Date  rcre_time                ; //  DATE,
	private String  lchg_user_id             ; //  VARCHAR2(15 CHAR),
	private Date  lchg_time                ; //  DATE,
	private Date  due_date                 ; //  DATE,
	private Date  ext_due_date             ; //  DATE,
	private Character  ecgc_appl_flg            ; //  CHAR(1 BYTE),
	private String  ecgc_dr_acid             ; //  VARCHAR2(11 CHAR),
	private Character  acct_status              ; //  CHAR(1 BYTE),
	private Date  lst_ecgc_cal_date        ; //  DATE,
	private Date  acct_status_date         ; //  DATE,
	private String  ts_cnt                   ; //  NUMBER(5),
	private Character  rpc_acct_flg             ; //  CHAR(1 BYTE),
	private String  sticky_date              ; //  DATE,
	private Character  disb_ind                 ; //  CHAR(1 BYTE),
	private Character  entity_cre_flg           ; //  CHAR(1 BYTE),
	private Character  del_flg                  ; //  CHAR(1 BYTE),
	private String  delink_acid              ; //  VARCHAR2(11 CHAR),
	private String  internal_limit_upd_flg   ; //  VARCHAR2(5 CHAR),
	private String  acct_cls_reason_code     ; //  VARCHAR2(5 CHAR),
	private String  collection_officer       ; //  VARCHAR2(12 CHAR),
	private String  bank_id                  ; //  VARCHAR2(8 CHAR),
	private Date  next_inact_chrg_calc_date; //  DATE,
	private Date  next_dorm_chrg_calc_date ; //  DATE,
	private Long  notice_days              ; //  NUMBER(3)
	

	/**
	 * 
	 */
	public CAM() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the acid
	 */
	public String getAcid() {
		return acid;
	}


	/**
	 * @param acid the acid to set
	 */
	public void setAcid(String acid) {
		this.acid = acid;
	}


	/**
	 * @return the max_alwd_advn_lim
	 */
	public BigDecimal getMax_alwd_advn_lim() {
		return max_alwd_advn_lim;
	}


	/**
	 * @param max_alwd_advn_lim the max_alwd_advn_lim to set
	 */
	public void setMax_alwd_advn_lim(BigDecimal max_alwd_advn_lim) {
		this.max_alwd_advn_lim = max_alwd_advn_lim;
	}


	/**
	 * @return the acct_crfile_ref_id
	 */
	public String getAcct_crfile_ref_id() {
		return acct_crfile_ref_id;
	}


	/**
	 * @param acct_crfile_ref_id the acct_crfile_ref_id to set
	 */
	public void setAcct_crfile_ref_id(String acct_crfile_ref_id) {
		this.acct_crfile_ref_id = acct_crfile_ref_id;
	}


	/**
	 * @return the lf_chrg_pend_lines
	 */
	public Long getLf_chrg_pend_lines() {
		return lf_chrg_pend_lines;
	}


	/**
	 * @param lf_chrg_pend_lines the lf_chrg_pend_lines to set
	 */
	public void setLf_chrg_pend_lines(Long lf_chrg_pend_lines) {
		this.lf_chrg_pend_lines = lf_chrg_pend_lines;
	}


	/**
	 * @return the health_code
	 */
	public String getHealth_code() {
		return health_code;
	}


	/**
	 * @param health_code the health_code to set
	 */
	public void setHealth_code(String health_code) {
		this.health_code = health_code;
	}


	/**
	 * @return the last_lf_calc_date
	 */
	public Date getLast_lf_calc_date() {
		return last_lf_calc_date;
	}


	/**
	 * @param last_lf_calc_date the last_lf_calc_date to set
	 */
	public void setLast_lf_calc_date(Date last_lf_calc_date) {
		this.last_lf_calc_date = last_lf_calc_date;
	}


	/**
	 * @return the last_aod_aos_date
	 */
	public Date getLast_aod_aos_date() {
		return last_aod_aos_date;
	}


	/**
	 * @param last_aod_aos_date the last_aod_aos_date to set
	 */
	public void setLast_aod_aos_date(Date last_aod_aos_date) {
		this.last_aod_aos_date = last_aod_aos_date;
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
	 * @return the due_date
	 */
	public Date getDue_date() {
		return due_date;
	}


	/**
	 * @param due_date the due_date to set
	 */
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}


	/**
	 * @return the ext_due_date
	 */
	public Date getExt_due_date() {
		return ext_due_date;
	}


	/**
	 * @param ext_due_date the ext_due_date to set
	 */
	public void setExt_due_date(Date ext_due_date) {
		this.ext_due_date = ext_due_date;
	}


	/**
	 * @return the ecgc_appl_flg
	 */
	public Character getEcgc_appl_flg() {
		return ecgc_appl_flg;
	}


	/**
	 * @param ecgc_appl_flg the ecgc_appl_flg to set
	 */
	public void setEcgc_appl_flg(Character ecgc_appl_flg) {
		this.ecgc_appl_flg = ecgc_appl_flg;
	}


	/**
	 * @return the ecgc_dr_acid
	 */
	public String getEcgc_dr_acid() {
		return ecgc_dr_acid;
	}


	/**
	 * @param ecgc_dr_acid the ecgc_dr_acid to set
	 */
	public void setEcgc_dr_acid(String ecgc_dr_acid) {
		this.ecgc_dr_acid = ecgc_dr_acid;
	}


	/**
	 * @return the acct_status
	 */
	public Character getAcct_status() {
		return acct_status;
	}


	/**
	 * @param acct_status the acct_status to set
	 */
	public void setAcct_status(Character acct_status) {
		this.acct_status = acct_status;
	}


	/**
	 * @return the lst_ecgc_cal_date
	 */
	public Date getLst_ecgc_cal_date() {
		return lst_ecgc_cal_date;
	}


	/**
	 * @param lst_ecgc_cal_date the lst_ecgc_cal_date to set
	 */
	public void setLst_ecgc_cal_date(Date lst_ecgc_cal_date) {
		this.lst_ecgc_cal_date = lst_ecgc_cal_date;
	}


	/**
	 * @return the acct_status_date
	 */
	public Date getAcct_status_date() {
		return acct_status_date;
	}


	/**
	 * @param acct_status_date the acct_status_date to set
	 */
	public void setAcct_status_date(Date acct_status_date) {
		this.acct_status_date = acct_status_date;
	}


	/**
	 * @return the ts_cnt
	 */
	public String getTs_cnt() {
		return ts_cnt;
	}


	/**
	 * @param ts_cnt the ts_cnt to set
	 */
	public void setTs_cnt(String ts_cnt) {
		this.ts_cnt = ts_cnt;
	}


	/**
	 * @return the rpc_acct_flg
	 */
	public Character getRpc_acct_flg() {
		return rpc_acct_flg;
	}


	/**
	 * @param rpc_acct_flg the rpc_acct_flg to set
	 */
	public void setRpc_acct_flg(Character rpc_acct_flg) {
		this.rpc_acct_flg = rpc_acct_flg;
	}


	/**
	 * @return the sticky_date
	 */
	public String getSticky_date() {
		return sticky_date;
	}


	/**
	 * @param sticky_date the sticky_date to set
	 */
	public void setSticky_date(String sticky_date) {
		this.sticky_date = sticky_date;
	}


	/**
	 * @return the disb_ind
	 */
	public Character getDisb_ind() {
		return disb_ind;
	}


	/**
	 * @param disb_ind the disb_ind to set
	 */
	public void setDisb_ind(Character disb_ind) {
		this.disb_ind = disb_ind;
	}


	/**
	 * @return the entity_cre_flg
	 */
	public Character getEntity_cre_flg() {
		return entity_cre_flg;
	}


	/**
	 * @param entity_cre_flg the entity_cre_flg to set
	 */
	public void setEntity_cre_flg(Character entity_cre_flg) {
		this.entity_cre_flg = entity_cre_flg;
	}


	/**
	 * @return the del_flg
	 */
	public Character getDel_flg() {
		return del_flg;
	}


	/**
	 * @param del_flg the del_flg to set
	 */
	public void setDel_flg(Character del_flg) {
		this.del_flg = del_flg;
	}


	/**
	 * @return the delink_acid
	 */
	public String getDelink_acid() {
		return delink_acid;
	}


	/**
	 * @param delink_acid the delink_acid to set
	 */
	public void setDelink_acid(String delink_acid) {
		this.delink_acid = delink_acid;
	}


	/**
	 * @return the internal_limit_upd_flg
	 */
	public String getInternal_limit_upd_flg() {
		return internal_limit_upd_flg;
	}


	/**
	 * @param internal_limit_upd_flg the internal_limit_upd_flg to set
	 */
	public void setInternal_limit_upd_flg(String internal_limit_upd_flg) {
		this.internal_limit_upd_flg = internal_limit_upd_flg;
	}


	/**
	 * @return the acct_cls_reason_code
	 */
	public String getAcct_cls_reason_code() {
		return acct_cls_reason_code;
	}


	/**
	 * @param acct_cls_reason_code the acct_cls_reason_code to set
	 */
	public void setAcct_cls_reason_code(String acct_cls_reason_code) {
		this.acct_cls_reason_code = acct_cls_reason_code;
	}


	/**
	 * @return the collection_officer
	 */
	public String getCollection_officer() {
		return collection_officer;
	}


	/**
	 * @param collection_officer the collection_officer to set
	 */
	public void setCollection_officer(String collection_officer) {
		this.collection_officer = collection_officer;
	}


	/**
	 * @return the bank_id
	 */
	public String getBank_id() {
		return bank_id;
	}


	/**
	 * @param bank_id the bank_id to set
	 */
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}


	/**
	 * @return the next_inact_chrg_calc_date
	 */
	public Date getNext_inact_chrg_calc_date() {
		return next_inact_chrg_calc_date;
	}


	/**
	 * @param next_inact_chrg_calc_date the next_inact_chrg_calc_date to set
	 */
	public void setNext_inact_chrg_calc_date(Date next_inact_chrg_calc_date) {
		this.next_inact_chrg_calc_date = next_inact_chrg_calc_date;
	}


	/**
	 * @return the next_dorm_chrg_calc_date
	 */
	public Date getNext_dorm_chrg_calc_date() {
		return next_dorm_chrg_calc_date;
	}


	/**
	 * @param next_dorm_chrg_calc_date the next_dorm_chrg_calc_date to set
	 */
	public void setNext_dorm_chrg_calc_date(Date next_dorm_chrg_calc_date) {
		this.next_dorm_chrg_calc_date = next_dorm_chrg_calc_date;
	}


	/**
	 * @return the notice_days
	 */
	public Long getNotice_days() {
		return notice_days;
	}


	/**
	 * @param notice_days the notice_days to set
	 */
	public void setNotice_days(Long notice_days) {
		this.notice_days = notice_days;
	}

}
