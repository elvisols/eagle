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

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * @author oji
 *
 */
@Entity
@Table(name="finacle.lam")
@NamedQueries( {
	@NamedQuery(name = "LAM.findByCustId", query = "select c from GAM c  where  c.cust_id = :cust_id")
})
public class LAM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String  acid                          ; // VARCHAR2(11 CHAR),
	
	private String  entity_cre_flg                ; // CHAR(1 BYTE),
	private String  del_flg                       ; // CHAR(1 BYTE),
	private String  rep_shdl_num                  ; // VARCHAR2(2 CHAR),
	private Date  rep_shdl_date                 ; // DATE,
	private String  dis_shdl_num                  ; // VARCHAR2(2 CHAR),
	private Date  dis_shdl_date                 ; // DATE,
	private BigDecimal  dis_amt                       ; // NUMBER(20,4),
	private BigDecimal  oflow_amt                     ; // NUMBER(20,4),
	private Date  last_adj_date                 ; // DATE,
	private String  op_acid                       ; // VARCHAR2(11 CHAR),
	private BigDecimal  dicgc_fee_pcnt                ; // NUMBER(9,6),
	private String  valuation_flg                 ; // CHAR(1 BYTE),
	private Date  deferred_upto_date            ; // DATE,
	private BigDecimal  cum_norm_int_amt              ; // NUMBER(20,4),
	private BigDecimal  cum_pen_int_amt               ; // NUMBER(20,4),
	private BigDecimal  cum_addnl_int_amt             ; // NUMBER(20,4),
	private String  acct_state                    ; // CHAR(1 BYTE),
	private Date  xfer_eff_date                 ; // DATE,
	private BigDecimal  liab_as_on_xfer_eff_date      ; // NUMBER(20,4),
	private String  lchg_user_id                  ; // VARCHAR2(15 CHAR),
	private Date  lchg_time                     ; // DATE,
	private String  rcre_user_id                  ; // VARCHAR2(15 CHAR),
	private Date  rcre_time                     ; // DATE,
	private String  rel_deposit_acid              ; // VARCHAR2(11 CHAR),
	private String  int_route_flg                 ; // CHAR(1 BYTE),
	private String  dmd_satisfy_mthd              ; // CHAR(1 BYTE),
	private String  lien_on_oper_acct_flg         ; // CHAR(1 BYTE),
	private Long  rep_perd_mths                 ; // NUMBER(3),
	private Long  rep_perd_days                 ; // NUMBER(3),
	private Long  pdmd_ovdu_perd_mths           ; // NUMBER(3),
	private Long  pdmd_ovdu_perd_days           ; // NUMBER(3),
	private String  pdmd_ovdu_eom_flg             ; // CHAR(1 BYTE),
	private Long  idmd_ovdu_perd_mths           ; // NUMBER(3),
	private Long  idmd_ovdu_perd_days           ; // NUMBER(3),
	private String  idmd_ovdu_eom_flg             ; // CHAR(1 BYTE),
	private String  ds_rate_code                  ; // VARCHAR2(5 CHAR),
	private String  rep_shdl_state                ; // CHAR(1 BYTE),
	private String  health_code                   ; // VARCHAR2(5 CHAR),
	private Long  ts_cnt                        ; // NUMBER(5),
	private String  apply_late_fee_flg            ; // CHAR(1 BYTE),
	private Long  late_fee_grace_perd_mnths     ; // NUMBER(3),
	private Long  late_fee_grace_perd_days      ; // NUMBER(3),
	private BigDecimal  rephasement_principal         ; // NUMBER(20,4),
	private BigDecimal  dealer_contr_amt              ; // NUMBER(20,4),
	private String  upfront_instl_coll            ; // CHAR(1 BYTE),
	private Long  num_advance_instlmnt          ; // NUMBER(2),
	private BigDecimal  sum_principal_dmd_amt         ; // NUMBER(20,4),
	private BigDecimal  upfront_instl_amt             ; // NUMBER(20,4),
	private String  payoff_flg                    ; // CHAR(1 BYTE),
	private BigDecimal  bank_irr_rate                 ; // NUMBER(9,6),
	private BigDecimal  value_of_asset                ; // NUMBER(20,4),
	private String  xfer_cycle_str                ; // VARCHAR2(45 CHAR),
	private Date  payoff_date                   ; // DATE,
	private String  dsa_base_rate_comm_paid       ; // CHAR(1 BYTE),
	private String  calc_ovdu_int_flg             ; // CHAR(1 BYTE),
	private Date  ei_perd_start_date            ; // DATE,
	private Date  ei_perd_end_date              ; // DATE,
	private String  rephase_accept_new_pdcs       ; // CHAR(1 BYTE),
	private String  employer_id                   ; // VARCHAR2(12 CHAR),
	private String  int_rest_freq                 ; // CHAR(1 BYTE),
	private String  int_rest_basis                ; // CHAR(1 BYTE),
	private BigDecimal  sys_calc_bank_irr             ; // NUMBER(9,6),
	private BigDecimal  sys_calc_actual_irr           ; // NUMBER(9,6),
	private BigDecimal  pre_process_fee               ; // NUMBER(20,4),
	private String  final_disb_flg                ; // CHAR(1 BYTE),
	private BigDecimal  deferred_int_amt              ; // NUMBER(20,4),
	private BigDecimal  hldy_perd_int_amt             ; // NUMBER(20,4),
	private String  auto_reshdl_after_hldy_perd   ; // CHAR(1 BYTE),
	private String  chrg_route_flg                ; // CHAR(1 BYTE),
	private String  int_rate_based_on_sanct_lim   ; // CHAR(1 BYTE),
	private String  ntnl_pool_param_type          ; // CHAR(1 BYTE),
	private String  opt_in_mnth_year              ; // VARCHAR2(6 CHAR),
	private Date  next_defmnt_date              ; // DATE,
	private String  defmnt_ind                    ; // CHAR(1 BYTE),
	private Long  tot_num_defmnts               ; // NUMBER(2),
	private Long  num_defmnt_curr_shdl          ; // NUMBER(2),
	private String  lam_crncy_code                ; // VARCHAR2(3 CHAR),
	private String  pdc_linked_acct_ind           ; // CHAR(1 BYTE),
	private String  ei_schm_flg                   ; // CHAR(1 BYTE),
	private String  crystallisation_reqd          ; // CHAR(1 BYTE),
	private String  crystallisation_crncy         ; // VARCHAR2(3 CHAR),
	private Date  installment_date_extd         ; // DATE,
	private Date  extd_dmd_ovdu_date            ; // DATE,
	private String  draw_down_level_int_rate      ; // CHAR(1 BYTE),
	private String  reserve_acid                  ; // VARCHAR2(11 CHAR),
	private String  coll_int_till_rollover        ; // CHAR(1 BYTE),
	private String  comnt_fee_mthds               ; // CHAR(1 BYTE),
	private String  shift_instlmnt_flg            ; // CHAR(1 BYTE),
	private Date  last_prepayment_date          ; // DATE,
	private String  acct_status_flg               ; // CHAR(1 BYTE),
	private BigDecimal  def_appl_int_rate             ; // NUMBER(9,6),
	private String  def_appl_int_rate_flg         ; // CHAR(1 BYTE),
	private Date  contract_date                 ; // DATE,
	private String  crystallisation_acct_id       ; // VARCHAR2(11 CHAR),
	private Date  last_crystallised_date        ; // DATE,
	private Long  no_of_times_crystallised      ; // NUMBER(3),
	private String  pi_based_on_outstanding       ; // CHAR(1 BYTE),
	private String  delinq_reshdl_mthd_flg        ; // CHAR(1 BYTE),
	private Long  probation_prd_mths            ; // NUMBER(3),
	private Long  probation_prd_days            ; // NUMBER(3),
	private Long  dpd_before_reshdl             ; // NUMBER(5),
	private String  delinquency_reshdl_status     ; // CHAR(1 BYTE),
	private String  auto_reshdl_not_allowed       ; // CHAR(1 BYTE),
	private String  non_starter_flg               ; // CHAR(1 BYTE),
	private Long  total_num_of_switchover       ; // NUMBER(3),
	private Date  last_switchover_time          ; // DATE,
	private String  sec_status_flg                ; // CHAR(1 BYTE),
	private String  sec_pool_id                   ; // VARCHAR2(12 CHAR),
	private Date  int_wef_date                  ; // DATE,
	private BigDecimal  reshdl_overdue_prin           ; // NUMBER(20,4),
	private BigDecimal  reshdl_overdue_int            ; // NUMBER(20,4),
	private String  loan_type                     ; // CHAR(1 BYTE),
	private Date  max_pending_dmd_date          ; // DATE,
	private String  payoff_reason_code            ; // VARCHAR2(5 CHAR),
	private BigDecimal  install_income_ratio          ; // NUMBER(9,6),
	private BigDecimal  prin_dmd_os                   ; // NUMBER(20,4),
	private BigDecimal  int_dmd_os                    ; // NUMBER(20,4),
	private BigDecimal  bchg_dmd_os                   ; // NUMBER(20,4),
	private BigDecimal  ochg_dmd_os                   ; // NUMBER(20,4),
	private String  linked_acct_id                ; // VARCHAR2(11 CHAR),
	private Date  last_prin_dmd_date            ; // DATE,
	private String  full_penal_mthd_flg           ; // CHAR(1 BYTE),
	private String  penal_prod_mthd_flg           ; // CHAR(1 BYTE),
	private String  penal_rate_mthd_flg           ; // CHAR(1 BYTE),
	private String  eir_event_type                ; // VARCHAR2(5 CHAR),
	private BigDecimal  eir_rate                      ; // NUMBER(9,6),
	private String  past_due_flg                  ; // CHAR(1 BYTE),
	private String  chrge_off_flg                 ; // CHAR(1 BYTE),
	private String  mr_event_flg                  ; // CHAR(1 BYTE),
	private Date  dmd_raised_sys_date           ; // DATE,
	private String  sbsdy_status_ind              ; // CHAR(1 BYTE),
	private String  dicgc_fee_borr_flg            ; // CHAR(1 BYTE),
	private Long  cdmd_ovdu_perd_mths           ; // NUMBER(3),
	private Long  cdmd_ovdu_perd_days           ; // NUMBER(3),
	private String  cdmd_ovdu_eom_flg             ; // CHAR(1 BYTE),
	private String  hldy_prd_frm_first_disb_flg   ; // CHAR(1 BYTE),
	private String  ei_method                     ; // CHAR(1 BYTE),
	private String  ei_formula_flg                ; // CHAR(1 BYTE),
	private String  hldy_perd_int_flg             ; // CHAR(1 BYTE),
	private String  topup_ind                     ; // CHAR(1 BYTE),
	private Long  nrml_hldy_perd_mnths          ; // NUMBER(3),
	private String  collection_officer            ; // VARCHAR2(12 CHAR),
	private String  rshdl_tenor_ei_flg            ; // CHAR(1 BYTE),
	private String  rshdl_disbt_flg               ; // CHAR(1 BYTE),
	private String  rshdl_rate_chng_flg           ; // CHAR(1 BYTE),
	private String  rshdl_prepay_flg              ; // CHAR(1 BYTE),
	private String  rshdl_amt_flg                 ; // CHAR(1 BYTE),
	private String  rephase_capitalize_int        ; // CHAR(1 BYTE),
	private String  rephase_carry_ovdu_dmds       ; // CHAR(1 BYTE),
	private String  rollover_allowed              ; // CHAR(1 BYTE),
	private String  cap_emi_flg                   ; // CHAR(1 BYTE),
	private BigDecimal  emicap_deferred_int           ; // NUMBER(20,4),
	private String  include_matu_date_flg         ; // CHAR(1 BYTE),
	private Long  instlmnt_grace_perd_mnths     ; // NUMBER(3),
	private BigDecimal  cum_capitalize_fees           ; // NUMBER(20,4),
	private String  instlmnt_grace_perd_term_flg  ; // CHAR(1 BYTE),
	private Long  penal_int_grace_perd_mths     ; // NUMBER(3),
	private Long  penal_int_grace_perd_days     ; // NUMBER(3),
	private BigDecimal  upfront_instl_int_amt         ; // NUMBER(20,4),
	private String  recall_flg                    ; // CHAR(1 BYTE),
	private Date  recall_date                   ; // DATE,
	private String  bank_id                       ; // VARCHAR2(8 CHAR),
	private String  resp_acct_ref_no              ; // VARCHAR2(16 CHAR),
	private BigDecimal  accr_penal_dmd_os             ; // NUMBER(20,4),
	private BigDecimal  accr_penal_int_unrealized_amt ; // NUMBER(20,4),
	private BigDecimal  accr_penal_int_refund_amt     ; // NUMBER(20,4),
	private Date  last_ach_run_date             ; // DATE,
	private String  int_pen_breakup_reqd_flg      ; // CHAR(1 BYTE),
	private Date  min_oflow_date                ; // DATE,
	private String  acct_type                     ; // VARCHAR2(5 CHAR),
	private String  ccy_hol_treatment_flg         ; // CHAR(1 BYTE),
	private String  purchase_ref                  ; // VARCHAR2(12 CHAR),
	private String  pool_code                     ; // VARCHAR2(12 CHAR),
	private String  apply_int_on_pymt             ; // CHAR(1 BYTE),
	private String  first_drdn_val_date_int_rate  ; // CHAR(1 BYTE),
	private String  restructuring_state           ; // CHAR(1 BYTE),
	private String  markup_int_rate_appl_flg      ; // CHAR(1 BYTE),
	private String  prioritising_mtd              ; // CHAR(1 BYTE),
	private Long  priority_num                  ; // NUMBER(3),
	private String  tranche_id                    ; // VARCHAR2(16 CHAR),
	private String  syn_account_type              ; // CHAR(1 BYTE),
	private String  syn_agent_ref_num             ; // VARCHAR2(36 CHAR),
	private String  next_rep_shdl_num             ; // VARCHAR2(2 CHAR),
	private String  int_rate_ref_crncy_code       ; // VARCHAR2(3 CHAR),
	private String  project_crncy_code            ; // VARCHAR2(3 CHAR),
	private Date  crystallisation_time_stamp    ; // DATE,
	private String  refin_ref_num                 ; // VARCHAR2(25 CHAR),
	private Date  refin_end_date                ; // DATE,
	private String  rollover_allowed_flg          ; // CHAR(1 BYTE)
	/**
	 * 
	 */
	public LAM() {
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
	 * @return the entity_cre_flg
	 */
	public String getEntity_cre_flg() {
		return entity_cre_flg;
	}
	/**
	 * @param entity_cre_flg the entity_cre_flg to set
	 */
	public void setEntity_cre_flg(String entity_cre_flg) {
		this.entity_cre_flg = entity_cre_flg;
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
	 * @return the rep_shdl_num
	 */
	public String getRep_shdl_num() {
		return rep_shdl_num;
	}
	/**
	 * @param rep_shdl_num the rep_shdl_num to set
	 */
	public void setRep_shdl_num(String rep_shdl_num) {
		this.rep_shdl_num = rep_shdl_num;
	}
	/**
	 * @return the rep_shdl_date
	 */
	public Date getRep_shdl_date() {
		return rep_shdl_date;
	}
	/**
	 * @param rep_shdl_date the rep_shdl_date to set
	 */
	public void setRep_shdl_date(Date rep_shdl_date) {
		this.rep_shdl_date = rep_shdl_date;
	}
	/**
	 * @return the dis_shdl_num
	 */
	public String getDis_shdl_num() {
		return dis_shdl_num;
	}
	/**
	 * @param dis_shdl_num the dis_shdl_num to set
	 */
	public void setDis_shdl_num(String dis_shdl_num) {
		this.dis_shdl_num = dis_shdl_num;
	}
	/**
	 * @return the dis_shdl_date
	 */
	public Date getDis_shdl_date() {
		return dis_shdl_date;
	}
	/**
	 * @param dis_shdl_date the dis_shdl_date to set
	 */
	public void setDis_shdl_date(Date dis_shdl_date) {
		this.dis_shdl_date = dis_shdl_date;
	}
	/**
	 * @return the dis_amt
	 */
	public BigDecimal getDis_amt() {
		return dis_amt;
	}
	/**
	 * @param dis_amt the dis_amt to set
	 */
	public void setDis_amt(BigDecimal dis_amt) {
		this.dis_amt = dis_amt;
	}
	/**
	 * @return the oflow_amt
	 */
	public BigDecimal getOflow_amt() {
		return oflow_amt;
	}
	/**
	 * @param oflow_amt the oflow_amt to set
	 */
	public void setOflow_amt(BigDecimal oflow_amt) {
		this.oflow_amt = oflow_amt;
	}
	/**
	 * @return the last_adj_date
	 */
	public Date getLast_adj_date() {
		return last_adj_date;
	}
	/**
	 * @param last_adj_date the last_adj_date to set
	 */
	public void setLast_adj_date(Date last_adj_date) {
		this.last_adj_date = last_adj_date;
	}
	/**
	 * @return the op_acid
	 */
	public String getOp_acid() {
		return op_acid;
	}
	/**
	 * @param op_acid the op_acid to set
	 */
	public void setOp_acid(String op_acid) {
		this.op_acid = op_acid;
	}
	/**
	 * @return the dicgc_fee_pcnt
	 */
	public BigDecimal getDicgc_fee_pcnt() {
		return dicgc_fee_pcnt;
	}
	/**
	 * @param dicgc_fee_pcnt the dicgc_fee_pcnt to set
	 */
	public void setDicgc_fee_pcnt(BigDecimal dicgc_fee_pcnt) {
		this.dicgc_fee_pcnt = dicgc_fee_pcnt;
	}
	/**
	 * @return the valuation_flg
	 */
	public String getValuation_flg() {
		return valuation_flg;
	}
	/**
	 * @param valuation_flg the valuation_flg to set
	 */
	public void setValuation_flg(String valuation_flg) {
		this.valuation_flg = valuation_flg;
	}
	/**
	 * @return the deferred_upto_date
	 */
	public Date getDeferred_upto_date() {
		return deferred_upto_date;
	}
	/**
	 * @param deferred_upto_date the deferred_upto_date to set
	 */
	public void setDeferred_upto_date(Date deferred_upto_date) {
		this.deferred_upto_date = deferred_upto_date;
	}
	/**
	 * @return the cum_norm_int_amt
	 */
	public BigDecimal getCum_norm_int_amt() {
		return cum_norm_int_amt;
	}
	/**
	 * @param cum_norm_int_amt the cum_norm_int_amt to set
	 */
	public void setCum_norm_int_amt(BigDecimal cum_norm_int_amt) {
		this.cum_norm_int_amt = cum_norm_int_amt;
	}
	/**
	 * @return the cum_pen_int_amt
	 */
	public BigDecimal getCum_pen_int_amt() {
		return cum_pen_int_amt;
	}
	/**
	 * @param cum_pen_int_amt the cum_pen_int_amt to set
	 */
	public void setCum_pen_int_amt(BigDecimal cum_pen_int_amt) {
		this.cum_pen_int_amt = cum_pen_int_amt;
	}
	/**
	 * @return the cum_addnl_int_amt
	 */
	public BigDecimal getCum_addnl_int_amt() {
		return cum_addnl_int_amt;
	}
	/**
	 * @param cum_addnl_int_amt the cum_addnl_int_amt to set
	 */
	public void setCum_addnl_int_amt(BigDecimal cum_addnl_int_amt) {
		this.cum_addnl_int_amt = cum_addnl_int_amt;
	}
	/**
	 * @return the acct_state
	 */
	public String getAcct_state() {
		return acct_state;
	}
	/**
	 * @param acct_state the acct_state to set
	 */
	public void setAcct_state(String acct_state) {
		this.acct_state = acct_state;
	}
	/**
	 * @return the xfer_eff_date
	 */
	public Date getXfer_eff_date() {
		return xfer_eff_date;
	}
	/**
	 * @param xfer_eff_date the xfer_eff_date to set
	 */
	public void setXfer_eff_date(Date xfer_eff_date) {
		this.xfer_eff_date = xfer_eff_date;
	}
	/**
	 * @return the liab_as_on_xfer_eff_date
	 */
	public BigDecimal getLiab_as_on_xfer_eff_date() {
		return liab_as_on_xfer_eff_date;
	}
	/**
	 * @param liab_as_on_xfer_eff_date the liab_as_on_xfer_eff_date to set
	 */
	public void setLiab_as_on_xfer_eff_date(BigDecimal liab_as_on_xfer_eff_date) {
		this.liab_as_on_xfer_eff_date = liab_as_on_xfer_eff_date;
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
	 * @return the rel_deposit_acid
	 */
	public String getRel_deposit_acid() {
		return rel_deposit_acid;
	}
	/**
	 * @param rel_deposit_acid the rel_deposit_acid to set
	 */
	public void setRel_deposit_acid(String rel_deposit_acid) {
		this.rel_deposit_acid = rel_deposit_acid;
	}
	/**
	 * @return the int_route_flg
	 */
	public String getInt_route_flg() {
		return int_route_flg;
	}
	/**
	 * @param int_route_flg the int_route_flg to set
	 */
	public void setInt_route_flg(String int_route_flg) {
		this.int_route_flg = int_route_flg;
	}
	/**
	 * @return the dmd_satisfy_mthd
	 */
	public String getDmd_satisfy_mthd() {
		return dmd_satisfy_mthd;
	}
	/**
	 * @param dmd_satisfy_mthd the dmd_satisfy_mthd to set
	 */
	public void setDmd_satisfy_mthd(String dmd_satisfy_mthd) {
		this.dmd_satisfy_mthd = dmd_satisfy_mthd;
	}
	/**
	 * @return the lien_on_oper_acct_flg
	 */
	public String getLien_on_oper_acct_flg() {
		return lien_on_oper_acct_flg;
	}
	/**
	 * @param lien_on_oper_acct_flg the lien_on_oper_acct_flg to set
	 */
	public void setLien_on_oper_acct_flg(String lien_on_oper_acct_flg) {
		this.lien_on_oper_acct_flg = lien_on_oper_acct_flg;
	}
	/**
	 * @return the rep_perd_mths
	 */
	public Long getRep_perd_mths() {
		return rep_perd_mths;
	}
	/**
	 * @param rep_perd_mths the rep_perd_mths to set
	 */
	public void setRep_perd_mths(Long rep_perd_mths) {
		this.rep_perd_mths = rep_perd_mths;
	}
	/**
	 * @return the rep_perd_days
	 */
	public Long getRep_perd_days() {
		return rep_perd_days;
	}
	/**
	 * @param rep_perd_days the rep_perd_days to set
	 */
	public void setRep_perd_days(Long rep_perd_days) {
		this.rep_perd_days = rep_perd_days;
	}
	/**
	 * @return the pdmd_ovdu_perd_mths
	 */
	public Long getPdmd_ovdu_perd_mths() {
		return pdmd_ovdu_perd_mths;
	}
	/**
	 * @param pdmd_ovdu_perd_mths the pdmd_ovdu_perd_mths to set
	 */
	public void setPdmd_ovdu_perd_mths(Long pdmd_ovdu_perd_mths) {
		this.pdmd_ovdu_perd_mths = pdmd_ovdu_perd_mths;
	}
	/**
	 * @return the pdmd_ovdu_perd_days
	 */
	public Long getPdmd_ovdu_perd_days() {
		return pdmd_ovdu_perd_days;
	}
	/**
	 * @param pdmd_ovdu_perd_days the pdmd_ovdu_perd_days to set
	 */
	public void setPdmd_ovdu_perd_days(Long pdmd_ovdu_perd_days) {
		this.pdmd_ovdu_perd_days = pdmd_ovdu_perd_days;
	}
	/**
	 * @return the pdmd_ovdu_eom_flg
	 */
	public String getPdmd_ovdu_eom_flg() {
		return pdmd_ovdu_eom_flg;
	}
	/**
	 * @param pdmd_ovdu_eom_flg the pdmd_ovdu_eom_flg to set
	 */
	public void setPdmd_ovdu_eom_flg(String pdmd_ovdu_eom_flg) {
		this.pdmd_ovdu_eom_flg = pdmd_ovdu_eom_flg;
	}
	/**
	 * @return the idmd_ovdu_perd_mths
	 */
	public Long getIdmd_ovdu_perd_mths() {
		return idmd_ovdu_perd_mths;
	}
	/**
	 * @param idmd_ovdu_perd_mths the idmd_ovdu_perd_mths to set
	 */
	public void setIdmd_ovdu_perd_mths(Long idmd_ovdu_perd_mths) {
		this.idmd_ovdu_perd_mths = idmd_ovdu_perd_mths;
	}
	/**
	 * @return the idmd_ovdu_perd_days
	 */
	public Long getIdmd_ovdu_perd_days() {
		return idmd_ovdu_perd_days;
	}
	/**
	 * @param idmd_ovdu_perd_days the idmd_ovdu_perd_days to set
	 */
	public void setIdmd_ovdu_perd_days(Long idmd_ovdu_perd_days) {
		this.idmd_ovdu_perd_days = idmd_ovdu_perd_days;
	}
	/**
	 * @return the idmd_ovdu_eom_flg
	 */
	public String getIdmd_ovdu_eom_flg() {
		return idmd_ovdu_eom_flg;
	}
	/**
	 * @param idmd_ovdu_eom_flg the idmd_ovdu_eom_flg to set
	 */
	public void setIdmd_ovdu_eom_flg(String idmd_ovdu_eom_flg) {
		this.idmd_ovdu_eom_flg = idmd_ovdu_eom_flg;
	}
	/**
	 * @return the ds_rate_code
	 */
	public String getDs_rate_code() {
		return ds_rate_code;
	}
	/**
	 * @param ds_rate_code the ds_rate_code to set
	 */
	public void setDs_rate_code(String ds_rate_code) {
		this.ds_rate_code = ds_rate_code;
	}
	/**
	 * @return the rep_shdl_state
	 */
	public String getRep_shdl_state() {
		return rep_shdl_state;
	}
	/**
	 * @param rep_shdl_state the rep_shdl_state to set
	 */
	public void setRep_shdl_state(String rep_shdl_state) {
		this.rep_shdl_state = rep_shdl_state;
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
	 * @return the apply_late_fee_flg
	 */
	public String getApply_late_fee_flg() {
		return apply_late_fee_flg;
	}
	/**
	 * @param apply_late_fee_flg the apply_late_fee_flg to set
	 */
	public void setApply_late_fee_flg(String apply_late_fee_flg) {
		this.apply_late_fee_flg = apply_late_fee_flg;
	}
	/**
	 * @return the late_fee_grace_perd_mnths
	 */
	public Long getLate_fee_grace_perd_mnths() {
		return late_fee_grace_perd_mnths;
	}
	/**
	 * @param late_fee_grace_perd_mnths the late_fee_grace_perd_mnths to set
	 */
	public void setLate_fee_grace_perd_mnths(Long late_fee_grace_perd_mnths) {
		this.late_fee_grace_perd_mnths = late_fee_grace_perd_mnths;
	}
	/**
	 * @return the late_fee_grace_perd_days
	 */
	public Long getLate_fee_grace_perd_days() {
		return late_fee_grace_perd_days;
	}
	/**
	 * @param late_fee_grace_perd_days the late_fee_grace_perd_days to set
	 */
	public void setLate_fee_grace_perd_days(Long late_fee_grace_perd_days) {
		this.late_fee_grace_perd_days = late_fee_grace_perd_days;
	}
	/**
	 * @return the rephasement_principal
	 */
	public BigDecimal getRephasement_principal() {
		return rephasement_principal;
	}
	/**
	 * @param rephasement_principal the rephasement_principal to set
	 */
	public void setRephasement_principal(BigDecimal rephasement_principal) {
		this.rephasement_principal = rephasement_principal;
	}
	/**
	 * @return the dealer_contr_amt
	 */
	public BigDecimal getDealer_contr_amt() {
		return dealer_contr_amt;
	}
	/**
	 * @param dealer_contr_amt the dealer_contr_amt to set
	 */
	public void setDealer_contr_amt(BigDecimal dealer_contr_amt) {
		this.dealer_contr_amt = dealer_contr_amt;
	}
	/**
	 * @return the upfront_instl_coll
	 */
	public String getUpfront_instl_coll() {
		return upfront_instl_coll;
	}
	/**
	 * @param upfront_instl_coll the upfront_instl_coll to set
	 */
	public void setUpfront_instl_coll(String upfront_instl_coll) {
		this.upfront_instl_coll = upfront_instl_coll;
	}
	/**
	 * @return the num_advance_instlmnt
	 */
	public Long getNum_advance_instlmnt() {
		return num_advance_instlmnt;
	}
	/**
	 * @param num_advance_instlmnt the num_advance_instlmnt to set
	 */
	public void setNum_advance_instlmnt(Long num_advance_instlmnt) {
		this.num_advance_instlmnt = num_advance_instlmnt;
	}
	/**
	 * @return the sum_principal_dmd_amt
	 */
	public BigDecimal getSum_principal_dmd_amt() {
		return sum_principal_dmd_amt;
	}
	/**
	 * @param sum_principal_dmd_amt the sum_principal_dmd_amt to set
	 */
	public void setSum_principal_dmd_amt(BigDecimal sum_principal_dmd_amt) {
		this.sum_principal_dmd_amt = sum_principal_dmd_amt;
	}
	/**
	 * @return the upfront_instl_amt
	 */
	public BigDecimal getUpfront_instl_amt() {
		return upfront_instl_amt;
	}
	/**
	 * @param upfront_instl_amt the upfront_instl_amt to set
	 */
	public void setUpfront_instl_amt(BigDecimal upfront_instl_amt) {
		this.upfront_instl_amt = upfront_instl_amt;
	}
	/**
	 * @return the payoff_flg
	 */
	public String getPayoff_flg() {
		return payoff_flg;
	}
	/**
	 * @param payoff_flg the payoff_flg to set
	 */
	public void setPayoff_flg(String payoff_flg) {
		this.payoff_flg = payoff_flg;
	}
	/**
	 * @return the bank_irr_rate
	 */
	public BigDecimal getBank_irr_rate() {
		return bank_irr_rate;
	}
	/**
	 * @param bank_irr_rate the bank_irr_rate to set
	 */
	public void setBank_irr_rate(BigDecimal bank_irr_rate) {
		this.bank_irr_rate = bank_irr_rate;
	}
	/**
	 * @return the value_of_asset
	 */
	public BigDecimal getValue_of_asset() {
		return value_of_asset;
	}
	/**
	 * @param value_of_asset the value_of_asset to set
	 */
	public void setValue_of_asset(BigDecimal value_of_asset) {
		this.value_of_asset = value_of_asset;
	}
	/**
	 * @return the xfer_cycle_str
	 */
	public String getXfer_cycle_str() {
		return xfer_cycle_str;
	}
	/**
	 * @param xfer_cycle_str the xfer_cycle_str to set
	 */
	public void setXfer_cycle_str(String xfer_cycle_str) {
		this.xfer_cycle_str = xfer_cycle_str;
	}
	/**
	 * @return the payoff_date
	 */
	public Date getPayoff_date() {
		return payoff_date;
	}
	/**
	 * @param payoff_date the payoff_date to set
	 */
	public void setPayoff_date(Date payoff_date) {
		this.payoff_date = payoff_date;
	}
	/**
	 * @return the dsa_base_rate_comm_paid
	 */
	public String getDsa_base_rate_comm_paid() {
		return dsa_base_rate_comm_paid;
	}
	/**
	 * @param dsa_base_rate_comm_paid the dsa_base_rate_comm_paid to set
	 */
	public void setDsa_base_rate_comm_paid(String dsa_base_rate_comm_paid) {
		this.dsa_base_rate_comm_paid = dsa_base_rate_comm_paid;
	}
	/**
	 * @return the calc_ovdu_int_flg
	 */
	public String getCalc_ovdu_int_flg() {
		return calc_ovdu_int_flg;
	}
	/**
	 * @param calc_ovdu_int_flg the calc_ovdu_int_flg to set
	 */
	public void setCalc_ovdu_int_flg(String calc_ovdu_int_flg) {
		this.calc_ovdu_int_flg = calc_ovdu_int_flg;
	}
	/**
	 * @return the ei_perd_start_date
	 */
	public Date getEi_perd_start_date() {
		return ei_perd_start_date;
	}
	/**
	 * @param ei_perd_start_date the ei_perd_start_date to set
	 */
	public void setEi_perd_start_date(Date ei_perd_start_date) {
		this.ei_perd_start_date = ei_perd_start_date;
	}
	/**
	 * @return the ei_perd_end_date
	 */
	public Date getEi_perd_end_date() {
		return ei_perd_end_date;
	}
	/**
	 * @param ei_perd_end_date the ei_perd_end_date to set
	 */
	public void setEi_perd_end_date(Date ei_perd_end_date) {
		this.ei_perd_end_date = ei_perd_end_date;
	}
	/**
	 * @return the rephase_accept_new_pdcs
	 */
	public String getRephase_accept_new_pdcs() {
		return rephase_accept_new_pdcs;
	}
	/**
	 * @param rephase_accept_new_pdcs the rephase_accept_new_pdcs to set
	 */
	public void setRephase_accept_new_pdcs(String rephase_accept_new_pdcs) {
		this.rephase_accept_new_pdcs = rephase_accept_new_pdcs;
	}
	/**
	 * @return the employer_id
	 */
	public String getEmployer_id() {
		return employer_id;
	}
	/**
	 * @param employer_id the employer_id to set
	 */
	public void setEmployer_id(String employer_id) {
		this.employer_id = employer_id;
	}
	/**
	 * @return the int_rest_freq
	 */
	public String getInt_rest_freq() {
		return int_rest_freq;
	}
	/**
	 * @param int_rest_freq the int_rest_freq to set
	 */
	public void setInt_rest_freq(String int_rest_freq) {
		this.int_rest_freq = int_rest_freq;
	}
	/**
	 * @return the int_rest_basis
	 */
	public String getInt_rest_basis() {
		return int_rest_basis;
	}
	/**
	 * @param int_rest_basis the int_rest_basis to set
	 */
	public void setInt_rest_basis(String int_rest_basis) {
		this.int_rest_basis = int_rest_basis;
	}
	/**
	 * @return the sys_calc_bank_irr
	 */
	public BigDecimal getSys_calc_bank_irr() {
		return sys_calc_bank_irr;
	}
	/**
	 * @param sys_calc_bank_irr the sys_calc_bank_irr to set
	 */
	public void setSys_calc_bank_irr(BigDecimal sys_calc_bank_irr) {
		this.sys_calc_bank_irr = sys_calc_bank_irr;
	}
	/**
	 * @return the sys_calc_actual_irr
	 */
	public BigDecimal getSys_calc_actual_irr() {
		return sys_calc_actual_irr;
	}
	/**
	 * @param sys_calc_actual_irr the sys_calc_actual_irr to set
	 */
	public void setSys_calc_actual_irr(BigDecimal sys_calc_actual_irr) {
		this.sys_calc_actual_irr = sys_calc_actual_irr;
	}
	/**
	 * @return the pre_process_fee
	 */
	public BigDecimal getPre_process_fee() {
		return pre_process_fee;
	}
	/**
	 * @param pre_process_fee the pre_process_fee to set
	 */
	public void setPre_process_fee(BigDecimal pre_process_fee) {
		this.pre_process_fee = pre_process_fee;
	}
	/**
	 * @return the final_disb_flg
	 */
	public String getFinal_disb_flg() {
		return final_disb_flg;
	}
	/**
	 * @param final_disb_flg the final_disb_flg to set
	 */
	public void setFinal_disb_flg(String final_disb_flg) {
		this.final_disb_flg = final_disb_flg;
	}
	/**
	 * @return the deferred_int_amt
	 */
	public BigDecimal getDeferred_int_amt() {
		return deferred_int_amt;
	}
	/**
	 * @param deferred_int_amt the deferred_int_amt to set
	 */
	public void setDeferred_int_amt(BigDecimal deferred_int_amt) {
		this.deferred_int_amt = deferred_int_amt;
	}
	/**
	 * @return the hldy_perd_int_amt
	 */
	public BigDecimal getHldy_perd_int_amt() {
		return hldy_perd_int_amt;
	}
	/**
	 * @param hldy_perd_int_amt the hldy_perd_int_amt to set
	 */
	public void setHldy_perd_int_amt(BigDecimal hldy_perd_int_amt) {
		this.hldy_perd_int_amt = hldy_perd_int_amt;
	}
	/**
	 * @return the auto_reshdl_after_hldy_perd
	 */
	public String getAuto_reshdl_after_hldy_perd() {
		return auto_reshdl_after_hldy_perd;
	}
	/**
	 * @param auto_reshdl_after_hldy_perd the auto_reshdl_after_hldy_perd to set
	 */
	public void setAuto_reshdl_after_hldy_perd(String auto_reshdl_after_hldy_perd) {
		this.auto_reshdl_after_hldy_perd = auto_reshdl_after_hldy_perd;
	}
	/**
	 * @return the chrg_route_flg
	 */
	public String getChrg_route_flg() {
		return chrg_route_flg;
	}
	/**
	 * @param chrg_route_flg the chrg_route_flg to set
	 */
	public void setChrg_route_flg(String chrg_route_flg) {
		this.chrg_route_flg = chrg_route_flg;
	}
	/**
	 * @return the int_rate_based_on_sanct_lim
	 */
	public String getInt_rate_based_on_sanct_lim() {
		return int_rate_based_on_sanct_lim;
	}
	/**
	 * @param int_rate_based_on_sanct_lim the int_rate_based_on_sanct_lim to set
	 */
	public void setInt_rate_based_on_sanct_lim(String int_rate_based_on_sanct_lim) {
		this.int_rate_based_on_sanct_lim = int_rate_based_on_sanct_lim;
	}
	/**
	 * @return the ntnl_pool_param_type
	 */
	public String getNtnl_pool_param_type() {
		return ntnl_pool_param_type;
	}
	/**
	 * @param ntnl_pool_param_type the ntnl_pool_param_type to set
	 */
	public void setNtnl_pool_param_type(String ntnl_pool_param_type) {
		this.ntnl_pool_param_type = ntnl_pool_param_type;
	}
	/**
	 * @return the opt_in_mnth_year
	 */
	public String getOpt_in_mnth_year() {
		return opt_in_mnth_year;
	}
	/**
	 * @param opt_in_mnth_year the opt_in_mnth_year to set
	 */
	public void setOpt_in_mnth_year(String opt_in_mnth_year) {
		this.opt_in_mnth_year = opt_in_mnth_year;
	}
	/**
	 * @return the next_defmnt_date
	 */
	public Date getNext_defmnt_date() {
		return next_defmnt_date;
	}
	/**
	 * @param next_defmnt_date the next_defmnt_date to set
	 */
	public void setNext_defmnt_date(Date next_defmnt_date) {
		this.next_defmnt_date = next_defmnt_date;
	}
	/**
	 * @return the defmnt_ind
	 */
	public String getDefmnt_ind() {
		return defmnt_ind;
	}
	/**
	 * @param defmnt_ind the defmnt_ind to set
	 */
	public void setDefmnt_ind(String defmnt_ind) {
		this.defmnt_ind = defmnt_ind;
	}
	/**
	 * @return the tot_num_defmnts
	 */
	public Long getTot_num_defmnts() {
		return tot_num_defmnts;
	}
	/**
	 * @param tot_num_defmnts the tot_num_defmnts to set
	 */
	public void setTot_num_defmnts(Long tot_num_defmnts) {
		this.tot_num_defmnts = tot_num_defmnts;
	}
	/**
	 * @return the num_defmnt_curr_shdl
	 */
	public Long getNum_defmnt_curr_shdl() {
		return num_defmnt_curr_shdl;
	}
	/**
	 * @param num_defmnt_curr_shdl the num_defmnt_curr_shdl to set
	 */
	public void setNum_defmnt_curr_shdl(Long num_defmnt_curr_shdl) {
		this.num_defmnt_curr_shdl = num_defmnt_curr_shdl;
	}
	/**
	 * @return the lam_crncy_code
	 */
	public String getLam_crncy_code() {
		return lam_crncy_code;
	}
	/**
	 * @param lam_crncy_code the lam_crncy_code to set
	 */
	public void setLam_crncy_code(String lam_crncy_code) {
		this.lam_crncy_code = lam_crncy_code;
	}
	/**
	 * @return the pdc_linked_acct_ind
	 */
	public String getPdc_linked_acct_ind() {
		return pdc_linked_acct_ind;
	}
	/**
	 * @param pdc_linked_acct_ind the pdc_linked_acct_ind to set
	 */
	public void setPdc_linked_acct_ind(String pdc_linked_acct_ind) {
		this.pdc_linked_acct_ind = pdc_linked_acct_ind;
	}
	/**
	 * @return the ei_schm_flg
	 */
	public String getEi_schm_flg() {
		return ei_schm_flg;
	}
	/**
	 * @param ei_schm_flg the ei_schm_flg to set
	 */
	public void setEi_schm_flg(String ei_schm_flg) {
		this.ei_schm_flg = ei_schm_flg;
	}
	/**
	 * @return the crystallisation_reqd
	 */
	public String getCrystallisation_reqd() {
		return crystallisation_reqd;
	}
	/**
	 * @param crystallisation_reqd the crystallisation_reqd to set
	 */
	public void setCrystallisation_reqd(String crystallisation_reqd) {
		this.crystallisation_reqd = crystallisation_reqd;
	}
	/**
	 * @return the crystallisation_crncy
	 */
	public String getCrystallisation_crncy() {
		return crystallisation_crncy;
	}
	/**
	 * @param crystallisation_crncy the crystallisation_crncy to set
	 */
	public void setCrystallisation_crncy(String crystallisation_crncy) {
		this.crystallisation_crncy = crystallisation_crncy;
	}
	/**
	 * @return the installment_date_extd
	 */
	public Date getInstallment_date_extd() {
		return installment_date_extd;
	}
	/**
	 * @param installment_date_extd the installment_date_extd to set
	 */
	public void setInstallment_date_extd(Date installment_date_extd) {
		this.installment_date_extd = installment_date_extd;
	}
	/**
	 * @return the extd_dmd_ovdu_date
	 */
	public Date getExtd_dmd_ovdu_date() {
		return extd_dmd_ovdu_date;
	}
	/**
	 * @param extd_dmd_ovdu_date the extd_dmd_ovdu_date to set
	 */
	public void setExtd_dmd_ovdu_date(Date extd_dmd_ovdu_date) {
		this.extd_dmd_ovdu_date = extd_dmd_ovdu_date;
	}
	/**
	 * @return the draw_down_level_int_rate
	 */
	public String getDraw_down_level_int_rate() {
		return draw_down_level_int_rate;
	}
	/**
	 * @param draw_down_level_int_rate the draw_down_level_int_rate to set
	 */
	public void setDraw_down_level_int_rate(String draw_down_level_int_rate) {
		this.draw_down_level_int_rate = draw_down_level_int_rate;
	}
	/**
	 * @return the reserve_acid
	 */
	public String getReserve_acid() {
		return reserve_acid;
	}
	/**
	 * @param reserve_acid the reserve_acid to set
	 */
	public void setReserve_acid(String reserve_acid) {
		this.reserve_acid = reserve_acid;
	}
	/**
	 * @return the coll_int_till_rollover
	 */
	public String getColl_int_till_rollover() {
		return coll_int_till_rollover;
	}
	/**
	 * @param coll_int_till_rollover the coll_int_till_rollover to set
	 */
	public void setColl_int_till_rollover(String coll_int_till_rollover) {
		this.coll_int_till_rollover = coll_int_till_rollover;
	}
	/**
	 * @return the comnt_fee_mthds
	 */
	public String getComnt_fee_mthds() {
		return comnt_fee_mthds;
	}
	/**
	 * @param comnt_fee_mthds the comnt_fee_mthds to set
	 */
	public void setComnt_fee_mthds(String comnt_fee_mthds) {
		this.comnt_fee_mthds = comnt_fee_mthds;
	}
	/**
	 * @return the shift_instlmnt_flg
	 */
	public String getShift_instlmnt_flg() {
		return shift_instlmnt_flg;
	}
	/**
	 * @param shift_instlmnt_flg the shift_instlmnt_flg to set
	 */
	public void setShift_instlmnt_flg(String shift_instlmnt_flg) {
		this.shift_instlmnt_flg = shift_instlmnt_flg;
	}
	/**
	 * @return the last_prepayment_date
	 */
	public Date getLast_prepayment_date() {
		return last_prepayment_date;
	}
	/**
	 * @param last_prepayment_date the last_prepayment_date to set
	 */
	public void setLast_prepayment_date(Date last_prepayment_date) {
		this.last_prepayment_date = last_prepayment_date;
	}
	/**
	 * @return the acct_status_flg
	 */
	public String getAcct_status_flg() {
		return acct_status_flg;
	}
	/**
	 * @param acct_status_flg the acct_status_flg to set
	 */
	public void setAcct_status_flg(String acct_status_flg) {
		this.acct_status_flg = acct_status_flg;
	}
	/**
	 * @return the def_appl_int_rate
	 */
	public BigDecimal getDef_appl_int_rate() {
		return def_appl_int_rate;
	}
	/**
	 * @param def_appl_int_rate the def_appl_int_rate to set
	 */
	public void setDef_appl_int_rate(BigDecimal def_appl_int_rate) {
		this.def_appl_int_rate = def_appl_int_rate;
	}
	/**
	 * @return the def_appl_int_rate_flg
	 */
	public String getDef_appl_int_rate_flg() {
		return def_appl_int_rate_flg;
	}
	/**
	 * @param def_appl_int_rate_flg the def_appl_int_rate_flg to set
	 */
	public void setDef_appl_int_rate_flg(String def_appl_int_rate_flg) {
		this.def_appl_int_rate_flg = def_appl_int_rate_flg;
	}
	/**
	 * @return the contract_date
	 */
	public Date getContract_date() {
		return contract_date;
	}
	/**
	 * @param contract_date the contract_date to set
	 */
	public void setContract_date(Date contract_date) {
		this.contract_date = contract_date;
	}
	/**
	 * @return the crystallisation_acct_id
	 */
	public String getCrystallisation_acct_id() {
		return crystallisation_acct_id;
	}
	/**
	 * @param crystallisation_acct_id the crystallisation_acct_id to set
	 */
	public void setCrystallisation_acct_id(String crystallisation_acct_id) {
		this.crystallisation_acct_id = crystallisation_acct_id;
	}
	/**
	 * @return the last_crystallised_date
	 */
	public Date getLast_crystallised_date() {
		return last_crystallised_date;
	}
	/**
	 * @param last_crystallised_date the last_crystallised_date to set
	 */
	public void setLast_crystallised_date(Date last_crystallised_date) {
		this.last_crystallised_date = last_crystallised_date;
	}
	/**
	 * @return the no_of_times_crystallised
	 */
	public Long getNo_of_times_crystallised() {
		return no_of_times_crystallised;
	}
	/**
	 * @param no_of_times_crystallised the no_of_times_crystallised to set
	 */
	public void setNo_of_times_crystallised(Long no_of_times_crystallised) {
		this.no_of_times_crystallised = no_of_times_crystallised;
	}
	/**
	 * @return the pi_based_on_outstanding
	 */
	public String getPi_based_on_outstanding() {
		return pi_based_on_outstanding;
	}
	/**
	 * @param pi_based_on_outstanding the pi_based_on_outstanding to set
	 */
	public void setPi_based_on_outstanding(String pi_based_on_outstanding) {
		this.pi_based_on_outstanding = pi_based_on_outstanding;
	}
	/**
	 * @return the delinq_reshdl_mthd_flg
	 */
	public String getDelinq_reshdl_mthd_flg() {
		return delinq_reshdl_mthd_flg;
	}
	/**
	 * @param delinq_reshdl_mthd_flg the delinq_reshdl_mthd_flg to set
	 */
	public void setDelinq_reshdl_mthd_flg(String delinq_reshdl_mthd_flg) {
		this.delinq_reshdl_mthd_flg = delinq_reshdl_mthd_flg;
	}
	/**
	 * @return the probation_prd_mths
	 */
	public Long getProbation_prd_mths() {
		return probation_prd_mths;
	}
	/**
	 * @param probation_prd_mths the probation_prd_mths to set
	 */
	public void setProbation_prd_mths(Long probation_prd_mths) {
		this.probation_prd_mths = probation_prd_mths;
	}
	/**
	 * @return the probation_prd_days
	 */
	public Long getProbation_prd_days() {
		return probation_prd_days;
	}
	/**
	 * @param probation_prd_days the probation_prd_days to set
	 */
	public void setProbation_prd_days(Long probation_prd_days) {
		this.probation_prd_days = probation_prd_days;
	}
	/**
	 * @return the dpd_before_reshdl
	 */
	public Long getDpd_before_reshdl() {
		return dpd_before_reshdl;
	}
	/**
	 * @param dpd_before_reshdl the dpd_before_reshdl to set
	 */
	public void setDpd_before_reshdl(Long dpd_before_reshdl) {
		this.dpd_before_reshdl = dpd_before_reshdl;
	}
	/**
	 * @return the delinquency_reshdl_status
	 */
	public String getDelinquency_reshdl_status() {
		return delinquency_reshdl_status;
	}
	/**
	 * @param delinquency_reshdl_status the delinquency_reshdl_status to set
	 */
	public void setDelinquency_reshdl_status(String delinquency_reshdl_status) {
		this.delinquency_reshdl_status = delinquency_reshdl_status;
	}
	/**
	 * @return the auto_reshdl_not_allowed
	 */
	public String getAuto_reshdl_not_allowed() {
		return auto_reshdl_not_allowed;
	}
	/**
	 * @param auto_reshdl_not_allowed the auto_reshdl_not_allowed to set
	 */
	public void setAuto_reshdl_not_allowed(String auto_reshdl_not_allowed) {
		this.auto_reshdl_not_allowed = auto_reshdl_not_allowed;
	}
	/**
	 * @return the non_starter_flg
	 */
	public String getNon_starter_flg() {
		return non_starter_flg;
	}
	/**
	 * @param non_starter_flg the non_starter_flg to set
	 */
	public void setNon_starter_flg(String non_starter_flg) {
		this.non_starter_flg = non_starter_flg;
	}
	/**
	 * @return the total_num_of_switchover
	 */
	public Long getTotal_num_of_switchover() {
		return total_num_of_switchover;
	}
	/**
	 * @param total_num_of_switchover the total_num_of_switchover to set
	 */
	public void setTotal_num_of_switchover(Long total_num_of_switchover) {
		this.total_num_of_switchover = total_num_of_switchover;
	}
	/**
	 * @return the last_switchover_time
	 */
	public Date getLast_switchover_time() {
		return last_switchover_time;
	}
	/**
	 * @param last_switchover_time the last_switchover_time to set
	 */
	public void setLast_switchover_time(Date last_switchover_time) {
		this.last_switchover_time = last_switchover_time;
	}
	/**
	 * @return the sec_status_flg
	 */
	public String getSec_status_flg() {
		return sec_status_flg;
	}
	/**
	 * @param sec_status_flg the sec_status_flg to set
	 */
	public void setSec_status_flg(String sec_status_flg) {
		this.sec_status_flg = sec_status_flg;
	}
	/**
	 * @return the sec_pool_id
	 */
	public String getSec_pool_id() {
		return sec_pool_id;
	}
	/**
	 * @param sec_pool_id the sec_pool_id to set
	 */
	public void setSec_pool_id(String sec_pool_id) {
		this.sec_pool_id = sec_pool_id;
	}
	/**
	 * @return the int_wef_date
	 */
	public Date getInt_wef_date() {
		return int_wef_date;
	}
	/**
	 * @param int_wef_date the int_wef_date to set
	 */
	public void setInt_wef_date(Date int_wef_date) {
		this.int_wef_date = int_wef_date;
	}
	/**
	 * @return the reshdl_overdue_prin
	 */
	public BigDecimal getReshdl_overdue_prin() {
		return reshdl_overdue_prin;
	}
	/**
	 * @param reshdl_overdue_prin the reshdl_overdue_prin to set
	 */
	public void setReshdl_overdue_prin(BigDecimal reshdl_overdue_prin) {
		this.reshdl_overdue_prin = reshdl_overdue_prin;
	}
	/**
	 * @return the reshdl_overdue_int
	 */
	public BigDecimal getReshdl_overdue_int() {
		return reshdl_overdue_int;
	}
	/**
	 * @param reshdl_overdue_int the reshdl_overdue_int to set
	 */
	public void setReshdl_overdue_int(BigDecimal reshdl_overdue_int) {
		this.reshdl_overdue_int = reshdl_overdue_int;
	}
	/**
	 * @return the loan_type
	 */
	public String getLoan_type() {
		return loan_type;
	}
	/**
	 * @param loan_type the loan_type to set
	 */
	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}
	/**
	 * @return the max_pending_dmd_date
	 */
	public Date getMax_pending_dmd_date() {
		return max_pending_dmd_date;
	}
	/**
	 * @param max_pending_dmd_date the max_pending_dmd_date to set
	 */
	public void setMax_pending_dmd_date(Date max_pending_dmd_date) {
		this.max_pending_dmd_date = max_pending_dmd_date;
	}
	/**
	 * @return the payoff_reason_code
	 */
	public String getPayoff_reason_code() {
		return payoff_reason_code;
	}
	/**
	 * @param payoff_reason_code the payoff_reason_code to set
	 */
	public void setPayoff_reason_code(String payoff_reason_code) {
		this.payoff_reason_code = payoff_reason_code;
	}
	/**
	 * @return the install_income_ratio
	 */
	public BigDecimal getInstall_income_ratio() {
		return install_income_ratio;
	}
	/**
	 * @param install_income_ratio the install_income_ratio to set
	 */
	public void setInstall_income_ratio(BigDecimal install_income_ratio) {
		this.install_income_ratio = install_income_ratio;
	}
	/**
	 * @return the prin_dmd_os
	 */
	public BigDecimal getPrin_dmd_os() {
		return prin_dmd_os;
	}
	/**
	 * @param prin_dmd_os the prin_dmd_os to set
	 */
	public void setPrin_dmd_os(BigDecimal prin_dmd_os) {
		this.prin_dmd_os = prin_dmd_os;
	}
	/**
	 * @return the int_dmd_os
	 */
	public BigDecimal getInt_dmd_os() {
		return int_dmd_os;
	}
	/**
	 * @param int_dmd_os the int_dmd_os to set
	 */
	public void setInt_dmd_os(BigDecimal int_dmd_os) {
		this.int_dmd_os = int_dmd_os;
	}
	/**
	 * @return the bchg_dmd_os
	 */
	public BigDecimal getBchg_dmd_os() {
		return bchg_dmd_os;
	}
	/**
	 * @param bchg_dmd_os the bchg_dmd_os to set
	 */
	public void setBchg_dmd_os(BigDecimal bchg_dmd_os) {
		this.bchg_dmd_os = bchg_dmd_os;
	}
	/**
	 * @return the ochg_dmd_os
	 */
	public BigDecimal getOchg_dmd_os() {
		return ochg_dmd_os;
	}
	/**
	 * @param ochg_dmd_os the ochg_dmd_os to set
	 */
	public void setOchg_dmd_os(BigDecimal ochg_dmd_os) {
		this.ochg_dmd_os = ochg_dmd_os;
	}
	/**
	 * @return the linked_acct_id
	 */
	public String getLinked_acct_id() {
		return linked_acct_id;
	}
	/**
	 * @param linked_acct_id the linked_acct_id to set
	 */
	public void setLinked_acct_id(String linked_acct_id) {
		this.linked_acct_id = linked_acct_id;
	}
	/**
	 * @return the last_prin_dmd_date
	 */
	public Date getLast_prin_dmd_date() {
		return last_prin_dmd_date;
	}
	/**
	 * @param last_prin_dmd_date the last_prin_dmd_date to set
	 */
	public void setLast_prin_dmd_date(Date last_prin_dmd_date) {
		this.last_prin_dmd_date = last_prin_dmd_date;
	}
	/**
	 * @return the full_penal_mthd_flg
	 */
	public String getFull_penal_mthd_flg() {
		return full_penal_mthd_flg;
	}
	/**
	 * @param full_penal_mthd_flg the full_penal_mthd_flg to set
	 */
	public void setFull_penal_mthd_flg(String full_penal_mthd_flg) {
		this.full_penal_mthd_flg = full_penal_mthd_flg;
	}
	/**
	 * @return the penal_prod_mthd_flg
	 */
	public String getPenal_prod_mthd_flg() {
		return penal_prod_mthd_flg;
	}
	/**
	 * @param penal_prod_mthd_flg the penal_prod_mthd_flg to set
	 */
	public void setPenal_prod_mthd_flg(String penal_prod_mthd_flg) {
		this.penal_prod_mthd_flg = penal_prod_mthd_flg;
	}
	/**
	 * @return the penal_rate_mthd_flg
	 */
	public String getPenal_rate_mthd_flg() {
		return penal_rate_mthd_flg;
	}
	/**
	 * @param penal_rate_mthd_flg the penal_rate_mthd_flg to set
	 */
	public void setPenal_rate_mthd_flg(String penal_rate_mthd_flg) {
		this.penal_rate_mthd_flg = penal_rate_mthd_flg;
	}
	/**
	 * @return the eir_event_type
	 */
	public String getEir_event_type() {
		return eir_event_type;
	}
	/**
	 * @param eir_event_type the eir_event_type to set
	 */
	public void setEir_event_type(String eir_event_type) {
		this.eir_event_type = eir_event_type;
	}
	/**
	 * @return the eir_rate
	 */
	public BigDecimal getEir_rate() {
		return eir_rate;
	}
	/**
	 * @param eir_rate the eir_rate to set
	 */
	public void setEir_rate(BigDecimal eir_rate) {
		this.eir_rate = eir_rate;
	}
	/**
	 * @return the past_due_flg
	 */
	public String getPast_due_flg() {
		return past_due_flg;
	}
	/**
	 * @param past_due_flg the past_due_flg to set
	 */
	public void setPast_due_flg(String past_due_flg) {
		this.past_due_flg = past_due_flg;
	}
	/**
	 * @return the chrge_off_flg
	 */
	public String getChrge_off_flg() {
		return chrge_off_flg;
	}
	/**
	 * @param chrge_off_flg the chrge_off_flg to set
	 */
	public void setChrge_off_flg(String chrge_off_flg) {
		this.chrge_off_flg = chrge_off_flg;
	}
	/**
	 * @return the mr_event_flg
	 */
	public String getMr_event_flg() {
		return mr_event_flg;
	}
	/**
	 * @param mr_event_flg the mr_event_flg to set
	 */
	public void setMr_event_flg(String mr_event_flg) {
		this.mr_event_flg = mr_event_flg;
	}
	/**
	 * @return the dmd_raised_sys_date
	 */
	public Date getDmd_raised_sys_date() {
		return dmd_raised_sys_date;
	}
	/**
	 * @param dmd_raised_sys_date the dmd_raised_sys_date to set
	 */
	public void setDmd_raised_sys_date(Date dmd_raised_sys_date) {
		this.dmd_raised_sys_date = dmd_raised_sys_date;
	}
	/**
	 * @return the sbsdy_status_ind
	 */
	public String getSbsdy_status_ind() {
		return sbsdy_status_ind;
	}
	/**
	 * @param sbsdy_status_ind the sbsdy_status_ind to set
	 */
	public void setSbsdy_status_ind(String sbsdy_status_ind) {
		this.sbsdy_status_ind = sbsdy_status_ind;
	}
	/**
	 * @return the dicgc_fee_borr_flg
	 */
	public String getDicgc_fee_borr_flg() {
		return dicgc_fee_borr_flg;
	}
	/**
	 * @param dicgc_fee_borr_flg the dicgc_fee_borr_flg to set
	 */
	public void setDicgc_fee_borr_flg(String dicgc_fee_borr_flg) {
		this.dicgc_fee_borr_flg = dicgc_fee_borr_flg;
	}
	/**
	 * @return the cdmd_ovdu_perd_mths
	 */
	public Long getCdmd_ovdu_perd_mths() {
		return cdmd_ovdu_perd_mths;
	}
	/**
	 * @param cdmd_ovdu_perd_mths the cdmd_ovdu_perd_mths to set
	 */
	public void setCdmd_ovdu_perd_mths(Long cdmd_ovdu_perd_mths) {
		this.cdmd_ovdu_perd_mths = cdmd_ovdu_perd_mths;
	}
	/**
	 * @return the cdmd_ovdu_perd_days
	 */
	public Long getCdmd_ovdu_perd_days() {
		return cdmd_ovdu_perd_days;
	}
	/**
	 * @param cdmd_ovdu_perd_days the cdmd_ovdu_perd_days to set
	 */
	public void setCdmd_ovdu_perd_days(Long cdmd_ovdu_perd_days) {
		this.cdmd_ovdu_perd_days = cdmd_ovdu_perd_days;
	}
	/**
	 * @return the cdmd_ovdu_eom_flg
	 */
	public String getCdmd_ovdu_eom_flg() {
		return cdmd_ovdu_eom_flg;
	}
	/**
	 * @param cdmd_ovdu_eom_flg the cdmd_ovdu_eom_flg to set
	 */
	public void setCdmd_ovdu_eom_flg(String cdmd_ovdu_eom_flg) {
		this.cdmd_ovdu_eom_flg = cdmd_ovdu_eom_flg;
	}
	/**
	 * @return the hldy_prd_frm_first_disb_flg
	 */
	public String getHldy_prd_frm_first_disb_flg() {
		return hldy_prd_frm_first_disb_flg;
	}
	/**
	 * @param hldy_prd_frm_first_disb_flg the hldy_prd_frm_first_disb_flg to set
	 */
	public void setHldy_prd_frm_first_disb_flg(String hldy_prd_frm_first_disb_flg) {
		this.hldy_prd_frm_first_disb_flg = hldy_prd_frm_first_disb_flg;
	}
	/**
	 * @return the ei_method
	 */
	public String getEi_method() {
		return ei_method;
	}
	/**
	 * @param ei_method the ei_method to set
	 */
	public void setEi_method(String ei_method) {
		this.ei_method = ei_method;
	}
	/**
	 * @return the ei_formula_flg
	 */
	public String getEi_formula_flg() {
		return ei_formula_flg;
	}
	/**
	 * @param ei_formula_flg the ei_formula_flg to set
	 */
	public void setEi_formula_flg(String ei_formula_flg) {
		this.ei_formula_flg = ei_formula_flg;
	}
	/**
	 * @return the hldy_perd_int_flg
	 */
	public String getHldy_perd_int_flg() {
		return hldy_perd_int_flg;
	}
	/**
	 * @param hldy_perd_int_flg the hldy_perd_int_flg to set
	 */
	public void setHldy_perd_int_flg(String hldy_perd_int_flg) {
		this.hldy_perd_int_flg = hldy_perd_int_flg;
	}
	/**
	 * @return the topup_ind
	 */
	public String getTopup_ind() {
		return topup_ind;
	}
	/**
	 * @param topup_ind the topup_ind to set
	 */
	public void setTopup_ind(String topup_ind) {
		this.topup_ind = topup_ind;
	}
	/**
	 * @return the nrml_hldy_perd_mnths
	 */
	public Long getNrml_hldy_perd_mnths() {
		return nrml_hldy_perd_mnths;
	}
	/**
	 * @param nrml_hldy_perd_mnths the nrml_hldy_perd_mnths to set
	 */
	public void setNrml_hldy_perd_mnths(Long nrml_hldy_perd_mnths) {
		this.nrml_hldy_perd_mnths = nrml_hldy_perd_mnths;
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
	 * @return the rshdl_tenor_ei_flg
	 */
	public String getRshdl_tenor_ei_flg() {
		return rshdl_tenor_ei_flg;
	}
	/**
	 * @param rshdl_tenor_ei_flg the rshdl_tenor_ei_flg to set
	 */
	public void setRshdl_tenor_ei_flg(String rshdl_tenor_ei_flg) {
		this.rshdl_tenor_ei_flg = rshdl_tenor_ei_flg;
	}
	/**
	 * @return the rshdl_disbt_flg
	 */
	public String getRshdl_disbt_flg() {
		return rshdl_disbt_flg;
	}
	/**
	 * @param rshdl_disbt_flg the rshdl_disbt_flg to set
	 */
	public void setRshdl_disbt_flg(String rshdl_disbt_flg) {
		this.rshdl_disbt_flg = rshdl_disbt_flg;
	}
	/**
	 * @return the rshdl_rate_chng_flg
	 */
	public String getRshdl_rate_chng_flg() {
		return rshdl_rate_chng_flg;
	}
	/**
	 * @param rshdl_rate_chng_flg the rshdl_rate_chng_flg to set
	 */
	public void setRshdl_rate_chng_flg(String rshdl_rate_chng_flg) {
		this.rshdl_rate_chng_flg = rshdl_rate_chng_flg;
	}
	/**
	 * @return the rshdl_prepay_flg
	 */
	public String getRshdl_prepay_flg() {
		return rshdl_prepay_flg;
	}
	/**
	 * @param rshdl_prepay_flg the rshdl_prepay_flg to set
	 */
	public void setRshdl_prepay_flg(String rshdl_prepay_flg) {
		this.rshdl_prepay_flg = rshdl_prepay_flg;
	}
	/**
	 * @return the rshdl_amt_flg
	 */
	public String getRshdl_amt_flg() {
		return rshdl_amt_flg;
	}
	/**
	 * @param rshdl_amt_flg the rshdl_amt_flg to set
	 */
	public void setRshdl_amt_flg(String rshdl_amt_flg) {
		this.rshdl_amt_flg = rshdl_amt_flg;
	}
	/**
	 * @return the rephase_capitalize_int
	 */
	public String getRephase_capitalize_int() {
		return rephase_capitalize_int;
	}
	/**
	 * @param rephase_capitalize_int the rephase_capitalize_int to set
	 */
	public void setRephase_capitalize_int(String rephase_capitalize_int) {
		this.rephase_capitalize_int = rephase_capitalize_int;
	}
	/**
	 * @return the rephase_carry_ovdu_dmds
	 */
	public String getRephase_carry_ovdu_dmds() {
		return rephase_carry_ovdu_dmds;
	}
	/**
	 * @param rephase_carry_ovdu_dmds the rephase_carry_ovdu_dmds to set
	 */
	public void setRephase_carry_ovdu_dmds(String rephase_carry_ovdu_dmds) {
		this.rephase_carry_ovdu_dmds = rephase_carry_ovdu_dmds;
	}
	/**
	 * @return the rollover_allowed
	 */
	public String getRollover_allowed() {
		return rollover_allowed;
	}
	/**
	 * @param rollover_allowed the rollover_allowed to set
	 */
	public void setRollover_allowed(String rollover_allowed) {
		this.rollover_allowed = rollover_allowed;
	}
	/**
	 * @return the cap_emi_flg
	 */
	public String getCap_emi_flg() {
		return cap_emi_flg;
	}
	/**
	 * @param cap_emi_flg the cap_emi_flg to set
	 */
	public void setCap_emi_flg(String cap_emi_flg) {
		this.cap_emi_flg = cap_emi_flg;
	}
	/**
	 * @return the emicap_deferred_int
	 */
	public BigDecimal getEmicap_deferred_int() {
		return emicap_deferred_int;
	}
	/**
	 * @param emicap_deferred_int the emicap_deferred_int to set
	 */
	public void setEmicap_deferred_int(BigDecimal emicap_deferred_int) {
		this.emicap_deferred_int = emicap_deferred_int;
	}
	/**
	 * @return the include_matu_date_flg
	 */
	public String getInclude_matu_date_flg() {
		return include_matu_date_flg;
	}
	/**
	 * @param include_matu_date_flg the include_matu_date_flg to set
	 */
	public void setInclude_matu_date_flg(String include_matu_date_flg) {
		this.include_matu_date_flg = include_matu_date_flg;
	}
	/**
	 * @return the instlmnt_grace_perd_mnths
	 */
	public Long getInstlmnt_grace_perd_mnths() {
		return instlmnt_grace_perd_mnths;
	}
	/**
	 * @param instlmnt_grace_perd_mnths the instlmnt_grace_perd_mnths to set
	 */
	public void setInstlmnt_grace_perd_mnths(Long instlmnt_grace_perd_mnths) {
		this.instlmnt_grace_perd_mnths = instlmnt_grace_perd_mnths;
	}
	/**
	 * @return the cum_capitalize_fees
	 */
	public BigDecimal getCum_capitalize_fees() {
		return cum_capitalize_fees;
	}
	/**
	 * @param cum_capitalize_fees the cum_capitalize_fees to set
	 */
	public void setCum_capitalize_fees(BigDecimal cum_capitalize_fees) {
		this.cum_capitalize_fees = cum_capitalize_fees;
	}
	/**
	 * @return the instlmnt_grace_perd_term_flg
	 */
	public String getInstlmnt_grace_perd_term_flg() {
		return instlmnt_grace_perd_term_flg;
	}
	/**
	 * @param instlmnt_grace_perd_term_flg the instlmnt_grace_perd_term_flg to set
	 */
	public void setInstlmnt_grace_perd_term_flg(String instlmnt_grace_perd_term_flg) {
		this.instlmnt_grace_perd_term_flg = instlmnt_grace_perd_term_flg;
	}
	/**
	 * @return the penal_int_grace_perd_mths
	 */
	public Long getPenal_int_grace_perd_mths() {
		return penal_int_grace_perd_mths;
	}
	/**
	 * @param penal_int_grace_perd_mths the penal_int_grace_perd_mths to set
	 */
	public void setPenal_int_grace_perd_mths(Long penal_int_grace_perd_mths) {
		this.penal_int_grace_perd_mths = penal_int_grace_perd_mths;
	}
	/**
	 * @return the penal_int_grace_perd_days
	 */
	public Long getPenal_int_grace_perd_days() {
		return penal_int_grace_perd_days;
	}
	/**
	 * @param penal_int_grace_perd_days the penal_int_grace_perd_days to set
	 */
	public void setPenal_int_grace_perd_days(Long penal_int_grace_perd_days) {
		this.penal_int_grace_perd_days = penal_int_grace_perd_days;
	}
	/**
	 * @return the upfront_instl_int_amt
	 */
	public BigDecimal getUpfront_instl_int_amt() {
		return upfront_instl_int_amt;
	}
	/**
	 * @param upfront_instl_int_amt the upfront_instl_int_amt to set
	 */
	public void setUpfront_instl_int_amt(BigDecimal upfront_instl_int_amt) {
		this.upfront_instl_int_amt = upfront_instl_int_amt;
	}
	/**
	 * @return the recall_flg
	 */
	public String getRecall_flg() {
		return recall_flg;
	}
	/**
	 * @param recall_flg the recall_flg to set
	 */
	public void setRecall_flg(String recall_flg) {
		this.recall_flg = recall_flg;
	}
	/**
	 * @return the recall_date
	 */
	public Date getRecall_date() {
		return recall_date;
	}
	/**
	 * @param recall_date the recall_date to set
	 */
	public void setRecall_date(Date recall_date) {
		this.recall_date = recall_date;
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
	 * @return the resp_acct_ref_no
	 */
	public String getResp_acct_ref_no() {
		return resp_acct_ref_no;
	}
	/**
	 * @param resp_acct_ref_no the resp_acct_ref_no to set
	 */
	public void setResp_acct_ref_no(String resp_acct_ref_no) {
		this.resp_acct_ref_no = resp_acct_ref_no;
	}
	/**
	 * @return the accr_penal_dmd_os
	 */
	public BigDecimal getAccr_penal_dmd_os() {
		return accr_penal_dmd_os;
	}
	/**
	 * @param accr_penal_dmd_os the accr_penal_dmd_os to set
	 */
	public void setAccr_penal_dmd_os(BigDecimal accr_penal_dmd_os) {
		this.accr_penal_dmd_os = accr_penal_dmd_os;
	}
	/**
	 * @return the accr_penal_int_unrealized_amt
	 */
	public BigDecimal getAccr_penal_int_unrealized_amt() {
		return accr_penal_int_unrealized_amt;
	}
	/**
	 * @param accr_penal_int_unrealized_amt the accr_penal_int_unrealized_amt to set
	 */
	public void setAccr_penal_int_unrealized_amt(
			BigDecimal accr_penal_int_unrealized_amt) {
		this.accr_penal_int_unrealized_amt = accr_penal_int_unrealized_amt;
	}
	/**
	 * @return the accr_penal_int_refund_amt
	 */
	public BigDecimal getAccr_penal_int_refund_amt() {
		return accr_penal_int_refund_amt;
	}
	/**
	 * @param accr_penal_int_refund_amt the accr_penal_int_refund_amt to set
	 */
	public void setAccr_penal_int_refund_amt(BigDecimal accr_penal_int_refund_amt) {
		this.accr_penal_int_refund_amt = accr_penal_int_refund_amt;
	}
	/**
	 * @return the last_ach_run_date
	 */
	public Date getLast_ach_run_date() {
		return last_ach_run_date;
	}
	/**
	 * @param last_ach_run_date the last_ach_run_date to set
	 */
	public void setLast_ach_run_date(Date last_ach_run_date) {
		this.last_ach_run_date = last_ach_run_date;
	}
	/**
	 * @return the int_pen_breakup_reqd_flg
	 */
	public String getInt_pen_breakup_reqd_flg() {
		return int_pen_breakup_reqd_flg;
	}
	/**
	 * @param int_pen_breakup_reqd_flg the int_pen_breakup_reqd_flg to set
	 */
	public void setInt_pen_breakup_reqd_flg(String int_pen_breakup_reqd_flg) {
		this.int_pen_breakup_reqd_flg = int_pen_breakup_reqd_flg;
	}
	/**
	 * @return the min_oflow_date
	 */
	public Date getMin_oflow_date() {
		return min_oflow_date;
	}
	/**
	 * @param min_oflow_date the min_oflow_date to set
	 */
	public void setMin_oflow_date(Date min_oflow_date) {
		this.min_oflow_date = min_oflow_date;
	}
	/**
	 * @return the acct_type
	 */
	public String getAcct_type() {
		return acct_type;
	}
	/**
	 * @param acct_type the acct_type to set
	 */
	public void setAcct_type(String acct_type) {
		this.acct_type = acct_type;
	}
	/**
	 * @return the ccy_hol_treatment_flg
	 */
	public String getCcy_hol_treatment_flg() {
		return ccy_hol_treatment_flg;
	}
	/**
	 * @param ccy_hol_treatment_flg the ccy_hol_treatment_flg to set
	 */
	public void setCcy_hol_treatment_flg(String ccy_hol_treatment_flg) {
		this.ccy_hol_treatment_flg = ccy_hol_treatment_flg;
	}
	/**
	 * @return the purchase_ref
	 */
	public String getPurchase_ref() {
		return purchase_ref;
	}
	/**
	 * @param purchase_ref the purchase_ref to set
	 */
	public void setPurchase_ref(String purchase_ref) {
		this.purchase_ref = purchase_ref;
	}
	/**
	 * @return the pool_code
	 */
	public String getPool_code() {
		return pool_code;
	}
	/**
	 * @param pool_code the pool_code to set
	 */
	public void setPool_code(String pool_code) {
		this.pool_code = pool_code;
	}
	/**
	 * @return the apply_int_on_pymt
	 */
	public String getApply_int_on_pymt() {
		return apply_int_on_pymt;
	}
	/**
	 * @param apply_int_on_pymt the apply_int_on_pymt to set
	 */
	public void setApply_int_on_pymt(String apply_int_on_pymt) {
		this.apply_int_on_pymt = apply_int_on_pymt;
	}
	/**
	 * @return the first_drdn_val_date_int_rate
	 */
	public String getFirst_drdn_val_date_int_rate() {
		return first_drdn_val_date_int_rate;
	}
	/**
	 * @param first_drdn_val_date_int_rate the first_drdn_val_date_int_rate to set
	 */
	public void setFirst_drdn_val_date_int_rate(String first_drdn_val_date_int_rate) {
		this.first_drdn_val_date_int_rate = first_drdn_val_date_int_rate;
	}
	/**
	 * @return the restructuring_state
	 */
	public String getRestructuring_state() {
		return restructuring_state;
	}
	/**
	 * @param restructuring_state the restructuring_state to set
	 */
	public void setRestructuring_state(String restructuring_state) {
		this.restructuring_state = restructuring_state;
	}
	/**
	 * @return the markup_int_rate_appl_flg
	 */
	public String getMarkup_int_rate_appl_flg() {
		return markup_int_rate_appl_flg;
	}
	/**
	 * @param markup_int_rate_appl_flg the markup_int_rate_appl_flg to set
	 */
	public void setMarkup_int_rate_appl_flg(String markup_int_rate_appl_flg) {
		this.markup_int_rate_appl_flg = markup_int_rate_appl_flg;
	}
	/**
	 * @return the prioritising_mtd
	 */
	public String getPrioritising_mtd() {
		return prioritising_mtd;
	}
	/**
	 * @param prioritising_mtd the prioritising_mtd to set
	 */
	public void setPrioritising_mtd(String prioritising_mtd) {
		this.prioritising_mtd = prioritising_mtd;
	}
	/**
	 * @return the priority_num
	 */
	public Long getPriority_num() {
		return priority_num;
	}
	/**
	 * @param priority_num the priority_num to set
	 */
	public void setPriority_num(Long priority_num) {
		this.priority_num = priority_num;
	}
	/**
	 * @return the tranche_id
	 */
	public String getTranche_id() {
		return tranche_id;
	}
	/**
	 * @param tranche_id the tranche_id to set
	 */
	public void setTranche_id(String tranche_id) {
		this.tranche_id = tranche_id;
	}
	/**
	 * @return the syn_account_type
	 */
	public String getSyn_account_type() {
		return syn_account_type;
	}
	/**
	 * @param syn_account_type the syn_account_type to set
	 */
	public void setSyn_account_type(String syn_account_type) {
		this.syn_account_type = syn_account_type;
	}
	/**
	 * @return the syn_agent_ref_num
	 */
	public String getSyn_agent_ref_num() {
		return syn_agent_ref_num;
	}
	/**
	 * @param syn_agent_ref_num the syn_agent_ref_num to set
	 */
	public void setSyn_agent_ref_num(String syn_agent_ref_num) {
		this.syn_agent_ref_num = syn_agent_ref_num;
	}
	/**
	 * @return the next_rep_shdl_num
	 */
	public String getNext_rep_shdl_num() {
		return next_rep_shdl_num;
	}
	/**
	 * @param next_rep_shdl_num the next_rep_shdl_num to set
	 */
	public void setNext_rep_shdl_num(String next_rep_shdl_num) {
		this.next_rep_shdl_num = next_rep_shdl_num;
	}
	/**
	 * @return the int_rate_ref_crncy_code
	 */
	public String getInt_rate_ref_crncy_code() {
		return int_rate_ref_crncy_code;
	}
	/**
	 * @param int_rate_ref_crncy_code the int_rate_ref_crncy_code to set
	 */
	public void setInt_rate_ref_crncy_code(String int_rate_ref_crncy_code) {
		this.int_rate_ref_crncy_code = int_rate_ref_crncy_code;
	}
	/**
	 * @return the project_crncy_code
	 */
	public String getProject_crncy_code() {
		return project_crncy_code;
	}
	/**
	 * @param project_crncy_code the project_crncy_code to set
	 */
	public void setProject_crncy_code(String project_crncy_code) {
		this.project_crncy_code = project_crncy_code;
	}
	/**
	 * @return the crystallisation_time_stamp
	 */
	public Date getCrystallisation_time_stamp() {
		return crystallisation_time_stamp;
	}
	/**
	 * @param crystallisation_time_stamp the crystallisation_time_stamp to set
	 */
	public void setCrystallisation_time_stamp(Date crystallisation_time_stamp) {
		this.crystallisation_time_stamp = crystallisation_time_stamp;
	}
	/**
	 * @return the refin_ref_num
	 */
	public String getRefin_ref_num() {
		return refin_ref_num;
	}
	/**
	 * @param refin_ref_num the refin_ref_num to set
	 */
	public void setRefin_ref_num(String refin_ref_num) {
		this.refin_ref_num = refin_ref_num;
	}
	/**
	 * @return the refin_end_date
	 */
	public Date getRefin_end_date() {
		return refin_end_date;
	}
	/**
	 * @param refin_end_date the refin_end_date to set
	 */
	public void setRefin_end_date(Date refin_end_date) {
		this.refin_end_date = refin_end_date;
	}
	/**
	 * @return the rollover_allowed_flg
	 */
	public String getRollover_allowed_flg() {
		return rollover_allowed_flg;
	}
	/**
	 * @param rollover_allowed_flg the rollover_allowed_flg to set
	 */
	public void setRollover_allowed_flg(String rollover_allowed_flg) {
		this.rollover_allowed_flg = rollover_allowed_flg;
	}

}
