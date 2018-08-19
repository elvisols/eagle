/**
 * 
 */
package ng.exelon.ee.finacle.model;

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
@Table(name="tbaadm.smt")
@NamedQueries( {
	@NamedQuery(name = "SMT.findAllByStatus", query = "select c from SMT c  where  c.acct_status = :status")
})
public class SMT implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String  acid                     ; //  VARCHAR2(11 CHAR),
	private Character  acct_status              ; //  CHAR(1 BYTE),
	private Long  lf_chrg_pend_lines       ; //  NUMBER(4),
	private Character  sbca_acct_type           ; //  CHAR(1 BYTE),
	private Character  acct_instnt_cr_facil_flg ; //  CHAR(1 BYTE),
	private Date  last_lf_calc_date        ; //  DATE,
	private String  rcre_user_id             ; //  VARCHAR2(15 CHAR),
	private Date  rcre_time                ; //  DATE,
	private String  lchg_user_id             ; //  VARCHAR2(15 CHAR),
	private Date  lchg_time                ; //  DATE,
	private Date  acct_status_date         ; //  DATE,
	private BigDecimal  max_alwd_advn_lim        ; //  NUMBER(20,4),
	private String  acct_crfile_ref_id       ; //  VARCHAR2(15 CHAR),
	private Date  last_aod_aos_date        ; //  DATE,
	private String  health_code              ; //  VARCHAR2(5 CHAR),
	private Long  ts_cnt                   ; //  NUMBER(5),
	private String  bank_id                  ; //  VARCHAR2(8 CHAR),
	private Date  next_inact_chrg_calc_date; //  DATE,
	private Date  next_dorm_chrg_calc_date ; //  DATE,
	private String  acct_cls_reason_code     ; //  VARCHAR2(5 CHAR),
	private BigDecimal  acct_min_balance         ; //  NUMBER(20,4),
	private Character  acct_min_bal_ind         ; //  CHAR(1 BYTE),
	private Character  product_type             ; //  CHAR(1 BYTE),
	private Long  ns_perd_wd_mths          ; //  NUMBER(3),
	private Long  ns_perd_wd_days          ; //  NUMBER(3),
	private String  dr_freq_start_date       ; //  DATE,
	private Long  ns_perd_cls_mths         ; //  NUMBER(3),
	private Long  ns_perd_cls_days         ; //  NUMBER(3)
	

	/**
	 * 
	 */
	public SMT() {
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
	 * @return the sbca_acct_type
	 */
	public Character getSbca_acct_type() {
		return sbca_acct_type;
	}


	/**
	 * @param sbca_acct_type the sbca_acct_type to set
	 */
	public void setSbca_acct_type(Character sbca_acct_type) {
		this.sbca_acct_type = sbca_acct_type;
	}


	/**
	 * @return the acct_instnt_cr_facil_flg
	 */
	public Character getAcct_instnt_cr_facil_flg() {
		return acct_instnt_cr_facil_flg;
	}


	/**
	 * @param acct_instnt_cr_facil_flg the acct_instnt_cr_facil_flg to set
	 */
	public void setAcct_instnt_cr_facil_flg(Character acct_instnt_cr_facil_flg) {
		this.acct_instnt_cr_facil_flg = acct_instnt_cr_facil_flg;
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
	 * @return the ts_cnt
	 */
	public Long getTs_cnt() {
		return ts_cnt;
	}


	/**
	 * @param ts_cnt the ts_cnt to set
	 */
	public void setTs_cnt(Long ts_cnt) {
		this.ts_cnt = ts_cnt;
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
	 * @return the acct_min_balance
	 */
	public BigDecimal getAcct_min_balance() {
		return acct_min_balance;
	}


	/**
	 * @param acct_min_balance the acct_min_balance to set
	 */
	public void setAcct_min_balance(BigDecimal acct_min_balance) {
		this.acct_min_balance = acct_min_balance;
	}


	/**
	 * @return the acct_min_bal_ind
	 */
	public Character getAcct_min_bal_ind() {
		return acct_min_bal_ind;
	}


	/**
	 * @param acct_min_bal_ind the acct_min_bal_ind to set
	 */
	public void setAcct_min_bal_ind(Character acct_min_bal_ind) {
		this.acct_min_bal_ind = acct_min_bal_ind;
	}


	/**
	 * @return the product_type
	 */
	public Character getProduct_type() {
		return product_type;
	}


	/**
	 * @param product_type the product_type to set
	 */
	public void setProduct_type(Character product_type) {
		this.product_type = product_type;
	}


	/**
	 * @return the ns_perd_wd_mths
	 */
	public Long getNs_perd_wd_mths() {
		return ns_perd_wd_mths;
	}


	/**
	 * @param ns_perd_wd_mths the ns_perd_wd_mths to set
	 */
	public void setNs_perd_wd_mths(Long ns_perd_wd_mths) {
		this.ns_perd_wd_mths = ns_perd_wd_mths;
	}


	/**
	 * @return the ns_perd_wd_days
	 */
	public Long getNs_perd_wd_days() {
		return ns_perd_wd_days;
	}


	/**
	 * @param ns_perd_wd_days the ns_perd_wd_days to set
	 */
	public void setNs_perd_wd_days(Long ns_perd_wd_days) {
		this.ns_perd_wd_days = ns_perd_wd_days;
	}


	/**
	 * @return the dr_freq_start_date
	 */
	public String getDr_freq_start_date() {
		return dr_freq_start_date;
	}


	/**
	 * @param dr_freq_start_date the dr_freq_start_date to set
	 */
	public void setDr_freq_start_date(String dr_freq_start_date) {
		this.dr_freq_start_date = dr_freq_start_date;
	}


	/**
	 * @return the ns_perd_cls_mths
	 */
	public Long getNs_perd_cls_mths() {
		return ns_perd_cls_mths;
	}


	/**
	 * @param ns_perd_cls_mths the ns_perd_cls_mths to set
	 */
	public void setNs_perd_cls_mths(Long ns_perd_cls_mths) {
		this.ns_perd_cls_mths = ns_perd_cls_mths;
	}


	/**
	 * @return the ns_perd_cls_days
	 */
	public Long getNs_perd_cls_days() {
		return ns_perd_cls_days;
	}


	/**
	 * @param ns_perd_cls_days the ns_perd_cls_days to set
	 */
	public void setNs_perd_cls_days(Long ns_perd_cls_days) {
		this.ns_perd_cls_days = ns_perd_cls_days;
	}

}
