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
 * @author OJI
 *
 */
@Entity
@Table(name="finacle.tam")
@NamedQueries( {
	@NamedQuery(name = "TAM.findByCustId", query = "select c from GAM c  where  c.cust_id = :cust_id")
})
public class TAM implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String acid                            ;//varchar2(11 char),
	
	private Long deposit_period_mths             ;//number(3),
	private Long deposit_period_days             ;//number(3),
	private Date open_effective_date             ;//date,
	private Date maturity_date                   ;//date,
	private BigDecimal deposit_amount                  ;//number(20,4),
	private BigDecimal maturity_amount                 ;//number(20,4),
	private BigDecimal adjusted_comm_amt               ;//number(20,4),
	private Character deposit_status                  ;//char(1 byte),
	private Character acct_segment                    ;//char(1 byte),
	private Character safe_custody_flg                ;//char(1 byte),
	private Character nominee_print_flg               ;//char(1 byte),
	private Character printing_flg                    ;//char(1 byte),
	private Character spl_catg_ind                    ;//char(1 byte),
	private Character xfer_in_ind                     ;//char(1 byte),
	private Date last_int_provision_date         ;//date,
	private Date last_repayment_date             ;//date,
	private BigDecimal cumulative_principal            ;//number(20,4),
	private BigDecimal cumulative_instl_paid           ;//number(25,4),
	private BigDecimal cumulative_repayment_paid       ;//number(20,4),
	private BigDecimal cumulative_int_paid             ;//number(20,4),
	private BigDecimal cumulative_int_credited         ;//number(20,4),
	private Character int_accrual_flg                 ;//char(1 byte),
	private String related_acid                    ;//varchar2(11 char),
	private BigDecimal penal_pcnt                      ;//number(9,6),
	private String repayment_acid                  ;//varchar2(11 char),
	private String loan_acid                       ;//varchar2(11 char),
	private BigDecimal penalty_amount                  ;//number(20,4),
	private BigDecimal penalty_recovered               ;//number(20,4),
	private BigDecimal penalty_waived                  ;//number(20,4),
	private Character agent_emp_ind                   ;//char(1 byte),
	private String agent_code                      ;//varchar2(10 char),
	private Date maturity_notice_date            ;//date,
	private String lchg_user_id                    ;//varchar2(15 char),
	private Date lchg_time                       ;//date,
	private String rcre_user_id                    ;//varchar2(15 char),
	private Date rcre_time                       ;//date,
	private BigDecimal tds_amt                         ;//number(20,4),
	private String int_cr_rate_code                ;//varchar2(5 char),
	private Date nostro_value_date               ;//date,
	private BigDecimal overdue_int_amt                 ;//number(20,4),
	private Date cls_value_date                  ;//date,
	private Character auto_renewal_flg                ;//char(1 byte),
	private Long perd_mths_for_auto_renew        ;//number(3),
	private Long perd_days_for_auto_renew        ;//number(3),
	private Long max_auto_renewal_allowed        ;//number(3),
	private Long auto_renewed_counter            ;//number(3),
	private Character close_on_maturity_flg           ;//char(1 byte),
	private String auto_renewal_schm_code          ;//varchar2(5 char),
	private String auto_renewal_int_tbl_code       ;//varchar2(5 char),
	private String auto_renwl_gl_subhead_code      ;//varchar2(5 char),
	private String renewal_crncy                   ;//varchar2(3 char),
	private String renewal_rate_code               ;//varchar2(5 char),
	private BigDecimal renewal_rate                    ;//number(21,10),
	private Long ts_cnt                          ;//number(5),
	private String sol_id                          ;//varchar2(8 char),
	private BigDecimal original_deposit_amount         ;//number(20,4),
	private Long notice_period_mnths             ;//number(3),
	private Long notice_period_days              ;//number(3),
	private Date notice_date                     ;//date,
	private BigDecimal acct_close_interest_rate        ;//number(21,10),
	private String tran_id                         ;//varchar2(9 char),
	private Character txod_regl_overdraft             ;//char(1 byte),
	private BigDecimal original_maturity_amount        ;//number(20,4),
	private String ren_srl_num                     ;//varchar2(4 char),
	private Character deposit_type                    ;//char(1 byte),
	private String link_oper_account               ;//varchar2(11 char),
	private BigDecimal outflow_multiple_amt            ;//number(20,4),
	private BigDecimal avail_deposit_amt               ;//number(20,4),
	private Character cust_inst_type                  ;//char(1 byte),
	private BigDecimal tds_total_from_self_acct        ;//number(20,4),
	private Long int_flow_freq_mths              ;//number(3),
	private Long int_flow_freq_days              ;//number(3),
	private String tam_crncy_code                  ;//varchar2(3 char),
	private String master_b2k_id                   ;//varchar2(12 char),
	private Character acct_status                     ;//char(1 byte),
	private Date acct_status_date                ;//date,
	private BigDecimal fixed_installment_amt           ;//number(20,4),
	private BigDecimal nrml_installment_pcnt           ;//number(9,6),
	private Character installment_basis               ;//char(1 byte),
	private Long max_miss_contrib_allow          ;//number(3),
	private Character auto_closure_of_irregular_acct  ;//char(1 byte),
	private Long total_no_of_miss_contrib        ;//number(3),
	private Character acct_irregular_status           ;//char(1 byte),
	private Date acct_irregular_status_date      ;//date,
	private BigDecimal cumulative_nrml_instl_paid      ;//number(20,4),
	private BigDecimal cumulative_initial_dep_paid     ;//number(20,4),
	private BigDecimal cumulative_top_up_paid          ;//number(20,4),
	private Long auto_closure_of_zero_bal_mnths  ;//number(3),
	private Long auto_closure_of_zero_bal_days   ;//number(3),
	private String bank_id                         ;//varchar2(8 char),
	private String penalty_charge_event_id         ;//varchar2(25 char),
	private Long num_of_grace_days_util          ;//number(3),
	private BigDecimal absolute_penal_int_amt          ;//number(20,4),
	private Date last_bonus_run_date             ;//date,
	private BigDecimal last_calc_bonus_amount          ;//number(20,4),
	private BigDecimal bonus_upto_date                 ;//number(20,4),
	private Date next_bonus_run_date             ;//date,
	private BigDecimal nrml_int_paid_til_lst_bonus     ;//number(20,4),
	private String bonus_cycle                     ;//number(3),
	private BigDecimal last_calc_bonus_pcnt            ;//number(9,6),
	private String acct_cls_reason_code            ;//varchar2(5 char),
	private Date last_local_cal_update           ;//date,
	private Long loc_deposit_period_mths         ;//number(3),
	private Long loc_deposit_period_days         ;//number(3),
	private String acct_close_fwc_num              ;//varchar2(16 char),
	private String acct_close_fwc_sol_id           ;//varchar2(8 char)
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
	 * @return the deposit_period_mths
	 */
	public Long getDeposit_period_mths() {
		return deposit_period_mths;
	}
	/**
	 * @param deposit_period_mths the deposit_period_mths to set
	 */
	public void setDeposit_period_mths(Long deposit_period_mths) {
		this.deposit_period_mths = deposit_period_mths;
	}
	/**
	 * @return the deposit_period_days
	 */
	public Long getDeposit_period_days() {
		return deposit_period_days;
	}
	/**
	 * @param deposit_period_days the deposit_period_days to set
	 */
	public void setDeposit_period_days(Long deposit_period_days) {
		this.deposit_period_days = deposit_period_days;
	}
	/**
	 * @return the open_effective_date
	 */
	public Date getOpen_effective_date() {
		return open_effective_date;
	}
	/**
	 * @param open_effective_date the open_effective_date to set
	 */
	public void setOpen_effective_date(Date open_effective_date) {
		this.open_effective_date = open_effective_date;
	}
	/**
	 * @return the maturity_date
	 */
	public Date getMaturity_date() {
		return maturity_date;
	}
	/**
	 * @param maturity_date the maturity_date to set
	 */
	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}
	/**
	 * @return the deposit_amount
	 */
	public BigDecimal getDeposit_amount() {
		return deposit_amount;
	}
	/**
	 * @param deposit_amount the deposit_amount to set
	 */
	public void setDeposit_amount(BigDecimal deposit_amount) {
		this.deposit_amount = deposit_amount;
	}
	/**
	 * @return the maturity_amount
	 */
	public BigDecimal getMaturity_amount() {
		return maturity_amount;
	}
	/**
	 * @param maturity_amount the maturity_amount to set
	 */
	public void setMaturity_amount(BigDecimal maturity_amount) {
		this.maturity_amount = maturity_amount;
	}
	/**
	 * @return the adjusted_comm_amt
	 */
	public BigDecimal getAdjusted_comm_amt() {
		return adjusted_comm_amt;
	}
	/**
	 * @param adjusted_comm_amt the adjusted_comm_amt to set
	 */
	public void setAdjusted_comm_amt(BigDecimal adjusted_comm_amt) {
		this.adjusted_comm_amt = adjusted_comm_amt;
	}
	/**
	 * @return the deposit_status
	 */
	public Character getDeposit_status() {
		return deposit_status;
	}
	/**
	 * @param deposit_status the deposit_status to set
	 */
	public void setDeposit_status(Character deposit_status) {
		this.deposit_status = deposit_status;
	}
	/**
	 * @return the acct_segment
	 */
	public Character getAcct_segment() {
		return acct_segment;
	}
	/**
	 * @param acct_segment the acct_segment to set
	 */
	public void setAcct_segment(Character acct_segment) {
		this.acct_segment = acct_segment;
	}
	/**
	 * @return the safe_custody_flg
	 */
	public Character getSafe_custody_flg() {
		return safe_custody_flg;
	}
	/**
	 * @param safe_custody_flg the safe_custody_flg to set
	 */
	public void setSafe_custody_flg(Character safe_custody_flg) {
		this.safe_custody_flg = safe_custody_flg;
	}
	/**
	 * @return the nominee_print_flg
	 */
	public Character getNominee_print_flg() {
		return nominee_print_flg;
	}
	/**
	 * @param nominee_print_flg the nominee_print_flg to set
	 */
	public void setNominee_print_flg(Character nominee_print_flg) {
		this.nominee_print_flg = nominee_print_flg;
	}
	/**
	 * @return the printing_flg
	 */
	public Character getPrinting_flg() {
		return printing_flg;
	}
	/**
	 * @param printing_flg the printing_flg to set
	 */
	public void setPrinting_flg(Character printing_flg) {
		this.printing_flg = printing_flg;
	}
	/**
	 * @return the spl_catg_ind
	 */
	public Character getSpl_catg_ind() {
		return spl_catg_ind;
	}
	/**
	 * @param spl_catg_ind the spl_catg_ind to set
	 */
	public void setSpl_catg_ind(Character spl_catg_ind) {
		this.spl_catg_ind = spl_catg_ind;
	}
	/**
	 * @return the xfer_in_ind
	 */
	public Character getXfer_in_ind() {
		return xfer_in_ind;
	}
	/**
	 * @param xfer_in_ind the xfer_in_ind to set
	 */
	public void setXfer_in_ind(Character xfer_in_ind) {
		this.xfer_in_ind = xfer_in_ind;
	}
	/**
	 * @return the last_int_provision_date
	 */
	public Date getLast_int_provision_date() {
		return last_int_provision_date;
	}
	/**
	 * @param last_int_provision_date the last_int_provision_date to set
	 */
	public void setLast_int_provision_date(Date last_int_provision_date) {
		this.last_int_provision_date = last_int_provision_date;
	}
	/**
	 * @return the last_repayment_date
	 */
	public Date getLast_repayment_date() {
		return last_repayment_date;
	}
	/**
	 * @param last_repayment_date the last_repayment_date to set
	 */
	public void setLast_repayment_date(Date last_repayment_date) {
		this.last_repayment_date = last_repayment_date;
	}
	/**
	 * @return the cumulative_principal
	 */
	public BigDecimal getCumulative_principal() {
		return cumulative_principal;
	}
	/**
	 * @param cumulative_principal the cumulative_principal to set
	 */
	public void setCumulative_principal(BigDecimal cumulative_principal) {
		this.cumulative_principal = cumulative_principal;
	}
	/**
	 * @return the cumulative_instl_paid
	 */
	public BigDecimal getCumulative_instl_paid() {
		return cumulative_instl_paid;
	}
	/**
	 * @param cumulative_instl_paid the cumulative_instl_paid to set
	 */
	public void setCumulative_instl_paid(BigDecimal cumulative_instl_paid) {
		this.cumulative_instl_paid = cumulative_instl_paid;
	}
	/**
	 * @return the cumulative_repayment_paid
	 */
	public BigDecimal getCumulative_repayment_paid() {
		return cumulative_repayment_paid;
	}
	/**
	 * @param cumulative_repayment_paid the cumulative_repayment_paid to set
	 */
	public void setCumulative_repayment_paid(BigDecimal cumulative_repayment_paid) {
		this.cumulative_repayment_paid = cumulative_repayment_paid;
	}
	/**
	 * @return the cumulative_int_paid
	 */
	public BigDecimal getCumulative_int_paid() {
		return cumulative_int_paid;
	}
	/**
	 * @param cumulative_int_paid the cumulative_int_paid to set
	 */
	public void setCumulative_int_paid(BigDecimal cumulative_int_paid) {
		this.cumulative_int_paid = cumulative_int_paid;
	}
	/**
	 * @return the cumulative_int_credited
	 */
	public BigDecimal getCumulative_int_credited() {
		return cumulative_int_credited;
	}
	/**
	 * @param cumulative_int_credited the cumulative_int_credited to set
	 */
	public void setCumulative_int_credited(BigDecimal cumulative_int_credited) {
		this.cumulative_int_credited = cumulative_int_credited;
	}
	/**
	 * @return the int_accrual_flg
	 */
	public Character getInt_accrual_flg() {
		return int_accrual_flg;
	}
	/**
	 * @param int_accrual_flg the int_accrual_flg to set
	 */
	public void setInt_accrual_flg(Character int_accrual_flg) {
		this.int_accrual_flg = int_accrual_flg;
	}
	/**
	 * @return the related_acid
	 */
	public String getRelated_acid() {
		return related_acid;
	}
	/**
	 * @param related_acid the related_acid to set
	 */
	public void setRelated_acid(String related_acid) {
		this.related_acid = related_acid;
	}
	/**
	 * @return the penal_pcnt
	 */
	public BigDecimal getPenal_pcnt() {
		return penal_pcnt;
	}
	/**
	 * @param penal_pcnt the penal_pcnt to set
	 */
	public void setPenal_pcnt(BigDecimal penal_pcnt) {
		this.penal_pcnt = penal_pcnt;
	}
	/**
	 * @return the repayment_acid
	 */
	public String getRepayment_acid() {
		return repayment_acid;
	}
	/**
	 * @param repayment_acid the repayment_acid to set
	 */
	public void setRepayment_acid(String repayment_acid) {
		this.repayment_acid = repayment_acid;
	}
	/**
	 * @return the loan_acid
	 */
	public String getLoan_acid() {
		return loan_acid;
	}
	/**
	 * @param loan_acid the loan_acid to set
	 */
	public void setLoan_acid(String loan_acid) {
		this.loan_acid = loan_acid;
	}
	/**
	 * @return the penalty_amount
	 */
	public BigDecimal getPenalty_amount() {
		return penalty_amount;
	}
	/**
	 * @param penalty_amount the penalty_amount to set
	 */
	public void setPenalty_amount(BigDecimal penalty_amount) {
		this.penalty_amount = penalty_amount;
	}
	/**
	 * @return the penalty_recovered
	 */
	public BigDecimal getPenalty_recovered() {
		return penalty_recovered;
	}
	/**
	 * @param penalty_recovered the penalty_recovered to set
	 */
	public void setPenalty_recovered(BigDecimal penalty_recovered) {
		this.penalty_recovered = penalty_recovered;
	}
	/**
	 * @return the penalty_waived
	 */
	public BigDecimal getPenalty_waived() {
		return penalty_waived;
	}
	/**
	 * @param penalty_waived the penalty_waived to set
	 */
	public void setPenalty_waived(BigDecimal penalty_waived) {
		this.penalty_waived = penalty_waived;
	}
	/**
	 * @return the agent_emp_ind
	 */
	public Character getAgent_emp_ind() {
		return agent_emp_ind;
	}
	/**
	 * @param agent_emp_ind the agent_emp_ind to set
	 */
	public void setAgent_emp_ind(Character agent_emp_ind) {
		this.agent_emp_ind = agent_emp_ind;
	}
	/**
	 * @return the agent_code
	 */
	public String getAgent_code() {
		return agent_code;
	}
	/**
	 * @param agent_code the agent_code to set
	 */
	public void setAgent_code(String agent_code) {
		this.agent_code = agent_code;
	}
	/**
	 * @return the maturity_notice_date
	 */
	public Date getMaturity_notice_date() {
		return maturity_notice_date;
	}
	/**
	 * @param maturity_notice_date the maturity_notice_date to set
	 */
	public void setMaturity_notice_date(Date maturity_notice_date) {
		this.maturity_notice_date = maturity_notice_date;
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
	 * @return the tds_amt
	 */
	public BigDecimal getTds_amt() {
		return tds_amt;
	}
	/**
	 * @param tds_amt the tds_amt to set
	 */
	public void setTds_amt(BigDecimal tds_amt) {
		this.tds_amt = tds_amt;
	}
	/**
	 * @return the int_cr_rate_code
	 */
	public String getInt_cr_rate_code() {
		return int_cr_rate_code;
	}
	/**
	 * @param int_cr_rate_code the int_cr_rate_code to set
	 */
	public void setInt_cr_rate_code(String int_cr_rate_code) {
		this.int_cr_rate_code = int_cr_rate_code;
	}
	/**
	 * @return the nostro_value_date
	 */
	public Date getNostro_value_date() {
		return nostro_value_date;
	}
	/**
	 * @param nostro_value_date the nostro_value_date to set
	 */
	public void setNostro_value_date(Date nostro_value_date) {
		this.nostro_value_date = nostro_value_date;
	}
	/**
	 * @return the overdue_int_amt
	 */
	public BigDecimal getOverdue_int_amt() {
		return overdue_int_amt;
	}
	/**
	 * @param overdue_int_amt the overdue_int_amt to set
	 */
	public void setOverdue_int_amt(BigDecimal overdue_int_amt) {
		this.overdue_int_amt = overdue_int_amt;
	}
	/**
	 * @return the cls_value_date
	 */
	public Date getCls_value_date() {
		return cls_value_date;
	}
	/**
	 * @param cls_value_date the cls_value_date to set
	 */
	public void setCls_value_date(Date cls_value_date) {
		this.cls_value_date = cls_value_date;
	}
	/**
	 * @return the auto_renewal_flg
	 */
	public Character getAuto_renewal_flg() {
		return auto_renewal_flg;
	}
	/**
	 * @param auto_renewal_flg the auto_renewal_flg to set
	 */
	public void setAuto_renewal_flg(Character auto_renewal_flg) {
		this.auto_renewal_flg = auto_renewal_flg;
	}
	/**
	 * @return the perd_mths_for_auto_renew
	 */
	public Long getPerd_mths_for_auto_renew() {
		return perd_mths_for_auto_renew;
	}
	/**
	 * @param perd_mths_for_auto_renew the perd_mths_for_auto_renew to set
	 */
	public void setPerd_mths_for_auto_renew(Long perd_mths_for_auto_renew) {
		this.perd_mths_for_auto_renew = perd_mths_for_auto_renew;
	}
	/**
	 * @return the perd_days_for_auto_renew
	 */
	public Long getPerd_days_for_auto_renew() {
		return perd_days_for_auto_renew;
	}
	/**
	 * @param perd_days_for_auto_renew the perd_days_for_auto_renew to set
	 */
	public void setPerd_days_for_auto_renew(Long perd_days_for_auto_renew) {
		this.perd_days_for_auto_renew = perd_days_for_auto_renew;
	}
	/**
	 * @return the max_auto_renewal_allowed
	 */
	public Long getMax_auto_renewal_allowed() {
		return max_auto_renewal_allowed;
	}
	/**
	 * @param max_auto_renewal_allowed the max_auto_renewal_allowed to set
	 */
	public void setMax_auto_renewal_allowed(Long max_auto_renewal_allowed) {
		this.max_auto_renewal_allowed = max_auto_renewal_allowed;
	}
	/**
	 * @return the auto_renewed_counter
	 */
	public Long getAuto_renewed_counter() {
		return auto_renewed_counter;
	}
	/**
	 * @param auto_renewed_counter the auto_renewed_counter to set
	 */
	public void setAuto_renewed_counter(Long auto_renewed_counter) {
		this.auto_renewed_counter = auto_renewed_counter;
	}
	/**
	 * @return the close_on_maturity_flg
	 */
	public Character getClose_on_maturity_flg() {
		return close_on_maturity_flg;
	}
	/**
	 * @param close_on_maturity_flg the close_on_maturity_flg to set
	 */
	public void setClose_on_maturity_flg(Character close_on_maturity_flg) {
		this.close_on_maturity_flg = close_on_maturity_flg;
	}
	/**
	 * @return the auto_renewal_schm_code
	 */
	public String getAuto_renewal_schm_code() {
		return auto_renewal_schm_code;
	}
	/**
	 * @param auto_renewal_schm_code the auto_renewal_schm_code to set
	 */
	public void setAuto_renewal_schm_code(String auto_renewal_schm_code) {
		this.auto_renewal_schm_code = auto_renewal_schm_code;
	}
	/**
	 * @return the auto_renewal_int_tbl_code
	 */
	public String getAuto_renewal_int_tbl_code() {
		return auto_renewal_int_tbl_code;
	}
	/**
	 * @param auto_renewal_int_tbl_code the auto_renewal_int_tbl_code to set
	 */
	public void setAuto_renewal_int_tbl_code(String auto_renewal_int_tbl_code) {
		this.auto_renewal_int_tbl_code = auto_renewal_int_tbl_code;
	}
	/**
	 * @return the auto_renwl_gl_subhead_code
	 */
	public String getAuto_renwl_gl_subhead_code() {
		return auto_renwl_gl_subhead_code;
	}
	/**
	 * @param auto_renwl_gl_subhead_code the auto_renwl_gl_subhead_code to set
	 */
	public void setAuto_renwl_gl_subhead_code(String auto_renwl_gl_subhead_code) {
		this.auto_renwl_gl_subhead_code = auto_renwl_gl_subhead_code;
	}
	/**
	 * @return the renewal_crncy
	 */
	public String getRenewal_crncy() {
		return renewal_crncy;
	}
	/**
	 * @param renewal_crncy the renewal_crncy to set
	 */
	public void setRenewal_crncy(String renewal_crncy) {
		this.renewal_crncy = renewal_crncy;
	}
	/**
	 * @return the renewal_rate_code
	 */
	public String getRenewal_rate_code() {
		return renewal_rate_code;
	}
	/**
	 * @param renewal_rate_code the renewal_rate_code to set
	 */
	public void setRenewal_rate_code(String renewal_rate_code) {
		this.renewal_rate_code = renewal_rate_code;
	}
	/**
	 * @return the renewal_rate
	 */
	public BigDecimal getRenewal_rate() {
		return renewal_rate;
	}
	/**
	 * @param renewal_rate the renewal_rate to set
	 */
	public void setRenewal_rate(BigDecimal renewal_rate) {
		this.renewal_rate = renewal_rate;
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
	 * @return the sol_id
	 */
	public String getSol_id() {
		return sol_id;
	}
	/**
	 * @param sol_id the sol_id to set
	 */
	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}
	/**
	 * @return the original_deposit_amount
	 */
	public BigDecimal getOriginal_deposit_amount() {
		return original_deposit_amount;
	}
	/**
	 * @param original_deposit_amount the original_deposit_amount to set
	 */
	public void setOriginal_deposit_amount(BigDecimal original_deposit_amount) {
		this.original_deposit_amount = original_deposit_amount;
	}
	/**
	 * @return the notice_period_mnths
	 */
	public Long getNotice_period_mnths() {
		return notice_period_mnths;
	}
	/**
	 * @param notice_period_mnths the notice_period_mnths to set
	 */
	public void setNotice_period_mnths(Long notice_period_mnths) {
		this.notice_period_mnths = notice_period_mnths;
	}
	/**
	 * @return the notice_period_days
	 */
	public Long getNotice_period_days() {
		return notice_period_days;
	}
	/**
	 * @param notice_period_days the notice_period_days to set
	 */
	public void setNotice_period_days(Long notice_period_days) {
		this.notice_period_days = notice_period_days;
	}
	/**
	 * @return the notice_date
	 */
	public Date getNotice_date() {
		return notice_date;
	}
	/**
	 * @param notice_date the notice_date to set
	 */
	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}
	/**
	 * @return the acct_close_interest_rate
	 */
	public BigDecimal getAcct_close_interest_rate() {
		return acct_close_interest_rate;
	}
	/**
	 * @param acct_close_interest_rate the acct_close_interest_rate to set
	 */
	public void setAcct_close_interest_rate(BigDecimal acct_close_interest_rate) {
		this.acct_close_interest_rate = acct_close_interest_rate;
	}
	/**
	 * @return the tran_id
	 */
	public String getTran_id() {
		return tran_id;
	}
	/**
	 * @param tran_id the tran_id to set
	 */
	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}
	/**
	 * @return the txod_regl_overdraft
	 */
	public Character getTxod_regl_overdraft() {
		return txod_regl_overdraft;
	}
	/**
	 * @param txod_regl_overdraft the txod_regl_overdraft to set
	 */
	public void setTxod_regl_overdraft(Character txod_regl_overdraft) {
		this.txod_regl_overdraft = txod_regl_overdraft;
	}
	/**
	 * @return the original_maturity_amount
	 */
	public BigDecimal getOriginal_maturity_amount() {
		return original_maturity_amount;
	}
	/**
	 * @param original_maturity_amount the original_maturity_amount to set
	 */
	public void setOriginal_maturity_amount(BigDecimal original_maturity_amount) {
		this.original_maturity_amount = original_maturity_amount;
	}
	/**
	 * @return the ren_srl_num
	 */
	public String getRen_srl_num() {
		return ren_srl_num;
	}
	/**
	 * @param ren_srl_num the ren_srl_num to set
	 */
	public void setRen_srl_num(String ren_srl_num) {
		this.ren_srl_num = ren_srl_num;
	}
	/**
	 * @return the deposit_type
	 */
	public Character getDeposit_type() {
		return deposit_type;
	}
	/**
	 * @param deposit_type the deposit_type to set
	 */
	public void setDeposit_type(Character deposit_type) {
		this.deposit_type = deposit_type;
	}
	/**
	 * @return the link_oper_account
	 */
	public String getLink_oper_account() {
		return link_oper_account;
	}
	/**
	 * @param link_oper_account the link_oper_account to set
	 */
	public void setLink_oper_account(String link_oper_account) {
		this.link_oper_account = link_oper_account;
	}
	/**
	 * @return the outflow_multiple_amt
	 */
	public BigDecimal getOutflow_multiple_amt() {
		return outflow_multiple_amt;
	}
	/**
	 * @param outflow_multiple_amt the outflow_multiple_amt to set
	 */
	public void setOutflow_multiple_amt(BigDecimal outflow_multiple_amt) {
		this.outflow_multiple_amt = outflow_multiple_amt;
	}
	/**
	 * @return the avail_deposit_amt
	 */
	public BigDecimal getAvail_deposit_amt() {
		return avail_deposit_amt;
	}
	/**
	 * @param avail_deposit_amt the avail_deposit_amt to set
	 */
	public void setAvail_deposit_amt(BigDecimal avail_deposit_amt) {
		this.avail_deposit_amt = avail_deposit_amt;
	}
	/**
	 * @return the cust_inst_type
	 */
	public Character getCust_inst_type() {
		return cust_inst_type;
	}
	/**
	 * @param cust_inst_type the cust_inst_type to set
	 */
	public void setCust_inst_type(Character cust_inst_type) {
		this.cust_inst_type = cust_inst_type;
	}
	/**
	 * @return the tds_total_from_self_acct
	 */
	public BigDecimal getTds_total_from_self_acct() {
		return tds_total_from_self_acct;
	}
	/**
	 * @param tds_total_from_self_acct the tds_total_from_self_acct to set
	 */
	public void setTds_total_from_self_acct(BigDecimal tds_total_from_self_acct) {
		this.tds_total_from_self_acct = tds_total_from_self_acct;
	}
	/**
	 * @return the int_flow_freq_mths
	 */
	public Long getInt_flow_freq_mths() {
		return int_flow_freq_mths;
	}
	/**
	 * @param int_flow_freq_mths the int_flow_freq_mths to set
	 */
	public void setInt_flow_freq_mths(Long int_flow_freq_mths) {
		this.int_flow_freq_mths = int_flow_freq_mths;
	}
	/**
	 * @return the int_flow_freq_days
	 */
	public Long getInt_flow_freq_days() {
		return int_flow_freq_days;
	}
	/**
	 * @param int_flow_freq_days the int_flow_freq_days to set
	 */
	public void setInt_flow_freq_days(Long int_flow_freq_days) {
		this.int_flow_freq_days = int_flow_freq_days;
	}
	/**
	 * @return the tam_crncy_code
	 */
	public String getTam_crncy_code() {
		return tam_crncy_code;
	}
	/**
	 * @param tam_crncy_code the tam_crncy_code to set
	 */
	public void setTam_crncy_code(String tam_crncy_code) {
		this.tam_crncy_code = tam_crncy_code;
	}
	/**
	 * @return the master_b2k_id
	 */
	public String getMaster_b2k_id() {
		return master_b2k_id;
	}
	/**
	 * @param master_b2k_id the master_b2k_id to set
	 */
	public void setMaster_b2k_id(String master_b2k_id) {
		this.master_b2k_id = master_b2k_id;
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
	 * @return the fixed_installment_amt
	 */
	public BigDecimal getFixed_installment_amt() {
		return fixed_installment_amt;
	}
	/**
	 * @param fixed_installment_amt the fixed_installment_amt to set
	 */
	public void setFixed_installment_amt(BigDecimal fixed_installment_amt) {
		this.fixed_installment_amt = fixed_installment_amt;
	}
	/**
	 * @return the nrml_installment_pcnt
	 */
	public BigDecimal getNrml_installment_pcnt() {
		return nrml_installment_pcnt;
	}
	/**
	 * @param nrml_installment_pcnt the nrml_installment_pcnt to set
	 */
	public void setNrml_installment_pcnt(BigDecimal nrml_installment_pcnt) {
		this.nrml_installment_pcnt = nrml_installment_pcnt;
	}
	/**
	 * @return the installment_basis
	 */
	public Character getInstallment_basis() {
		return installment_basis;
	}
	/**
	 * @param installment_basis the installment_basis to set
	 */
	public void setInstallment_basis(Character installment_basis) {
		this.installment_basis = installment_basis;
	}
	/**
	 * @return the max_miss_contrib_allow
	 */
	public Long getMax_miss_contrib_allow() {
		return max_miss_contrib_allow;
	}
	/**
	 * @param max_miss_contrib_allow the max_miss_contrib_allow to set
	 */
	public void setMax_miss_contrib_allow(Long max_miss_contrib_allow) {
		this.max_miss_contrib_allow = max_miss_contrib_allow;
	}
	/**
	 * @return the auto_closure_of_irregular_acct
	 */
	public Character getAuto_closure_of_irregular_acct() {
		return auto_closure_of_irregular_acct;
	}
	/**
	 * @param auto_closure_of_irregular_acct the auto_closure_of_irregular_acct to set
	 */
	public void setAuto_closure_of_irregular_acct(
			Character auto_closure_of_irregular_acct) {
		this.auto_closure_of_irregular_acct = auto_closure_of_irregular_acct;
	}
	/**
	 * @return the total_no_of_miss_contrib
	 */
	public Long getTotal_no_of_miss_contrib() {
		return total_no_of_miss_contrib;
	}
	/**
	 * @param total_no_of_miss_contrib the total_no_of_miss_contrib to set
	 */
	public void setTotal_no_of_miss_contrib(Long total_no_of_miss_contrib) {
		this.total_no_of_miss_contrib = total_no_of_miss_contrib;
	}
	/**
	 * @return the acct_irregular_status
	 */
	public Character getAcct_irregular_status() {
		return acct_irregular_status;
	}
	/**
	 * @param acct_irregular_status the acct_irregular_status to set
	 */
	public void setAcct_irregular_status(Character acct_irregular_status) {
		this.acct_irregular_status = acct_irregular_status;
	}
	/**
	 * @return the acct_irregular_status_date
	 */
	public Date getAcct_irregular_status_date() {
		return acct_irregular_status_date;
	}
	/**
	 * @param acct_irregular_status_date the acct_irregular_status_date to set
	 */
	public void setAcct_irregular_status_date(Date acct_irregular_status_date) {
		this.acct_irregular_status_date = acct_irregular_status_date;
	}
	/**
	 * @return the cumulative_nrml_instl_paid
	 */
	public BigDecimal getCumulative_nrml_instl_paid() {
		return cumulative_nrml_instl_paid;
	}
	/**
	 * @param cumulative_nrml_instl_paid the cumulative_nrml_instl_paid to set
	 */
	public void setCumulative_nrml_instl_paid(BigDecimal cumulative_nrml_instl_paid) {
		this.cumulative_nrml_instl_paid = cumulative_nrml_instl_paid;
	}
	/**
	 * @return the cumulative_initial_dep_paid
	 */
	public BigDecimal getCumulative_initial_dep_paid() {
		return cumulative_initial_dep_paid;
	}
	/**
	 * @param cumulative_initial_dep_paid the cumulative_initial_dep_paid to set
	 */
	public void setCumulative_initial_dep_paid(
			BigDecimal cumulative_initial_dep_paid) {
		this.cumulative_initial_dep_paid = cumulative_initial_dep_paid;
	}
	/**
	 * @return the cumulative_top_up_paid
	 */
	public BigDecimal getCumulative_top_up_paid() {
		return cumulative_top_up_paid;
	}
	/**
	 * @param cumulative_top_up_paid the cumulative_top_up_paid to set
	 */
	public void setCumulative_top_up_paid(BigDecimal cumulative_top_up_paid) {
		this.cumulative_top_up_paid = cumulative_top_up_paid;
	}
	/**
	 * @return the auto_closure_of_zero_bal_mnths
	 */
	public Long getAuto_closure_of_zero_bal_mnths() {
		return auto_closure_of_zero_bal_mnths;
	}
	/**
	 * @param auto_closure_of_zero_bal_mnths the auto_closure_of_zero_bal_mnths to set
	 */
	public void setAuto_closure_of_zero_bal_mnths(
			Long auto_closure_of_zero_bal_mnths) {
		this.auto_closure_of_zero_bal_mnths = auto_closure_of_zero_bal_mnths;
	}
	/**
	 * @return the auto_closure_of_zero_bal_days
	 */
	public Long getAuto_closure_of_zero_bal_days() {
		return auto_closure_of_zero_bal_days;
	}
	/**
	 * @param auto_closure_of_zero_bal_days the auto_closure_of_zero_bal_days to set
	 */
	public void setAuto_closure_of_zero_bal_days(Long auto_closure_of_zero_bal_days) {
		this.auto_closure_of_zero_bal_days = auto_closure_of_zero_bal_days;
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
	 * @return the penalty_charge_event_id
	 */
	public String getPenalty_charge_event_id() {
		return penalty_charge_event_id;
	}
	/**
	 * @param penalty_charge_event_id the penalty_charge_event_id to set
	 */
	public void setPenalty_charge_event_id(String penalty_charge_event_id) {
		this.penalty_charge_event_id = penalty_charge_event_id;
	}
	/**
	 * @return the num_of_grace_days_util
	 */
	public Long getNum_of_grace_days_util() {
		return num_of_grace_days_util;
	}
	/**
	 * @param num_of_grace_days_util the num_of_grace_days_util to set
	 */
	public void setNum_of_grace_days_util(Long num_of_grace_days_util) {
		this.num_of_grace_days_util = num_of_grace_days_util;
	}
	/**
	 * @return the absolute_penal_int_amt
	 */
	public BigDecimal getAbsolute_penal_int_amt() {
		return absolute_penal_int_amt;
	}
	/**
	 * @param absolute_penal_int_amt the absolute_penal_int_amt to set
	 */
	public void setAbsolute_penal_int_amt(BigDecimal absolute_penal_int_amt) {
		this.absolute_penal_int_amt = absolute_penal_int_amt;
	}
	/**
	 * @return the last_bonus_run_date
	 */
	public Date getLast_bonus_run_date() {
		return last_bonus_run_date;
	}
	/**
	 * @param last_bonus_run_date the last_bonus_run_date to set
	 */
	public void setLast_bonus_run_date(Date last_bonus_run_date) {
		this.last_bonus_run_date = last_bonus_run_date;
	}
	/**
	 * @return the last_calc_bonus_amount
	 */
	public BigDecimal getLast_calc_bonus_amount() {
		return last_calc_bonus_amount;
	}
	/**
	 * @param last_calc_bonus_amount the last_calc_bonus_amount to set
	 */
	public void setLast_calc_bonus_amount(BigDecimal last_calc_bonus_amount) {
		this.last_calc_bonus_amount = last_calc_bonus_amount;
	}
	/**
	 * @return the bonus_upto_date
	 */
	public BigDecimal getBonus_upto_date() {
		return bonus_upto_date;
	}
	/**
	 * @param bonus_upto_date the bonus_upto_date to set
	 */
	public void setBonus_upto_date(BigDecimal bonus_upto_date) {
		this.bonus_upto_date = bonus_upto_date;
	}
	/**
	 * @return the next_bonus_run_date
	 */
	public Date getNext_bonus_run_date() {
		return next_bonus_run_date;
	}
	/**
	 * @param next_bonus_run_date the next_bonus_run_date to set
	 */
	public void setNext_bonus_run_date(Date next_bonus_run_date) {
		this.next_bonus_run_date = next_bonus_run_date;
	}
	/**
	 * @return the nrml_int_paid_til_lst_bonus
	 */
	public BigDecimal getNrml_int_paid_til_lst_bonus() {
		return nrml_int_paid_til_lst_bonus;
	}
	/**
	 * @param nrml_int_paid_til_lst_bonus the nrml_int_paid_til_lst_bonus to set
	 */
	public void setNrml_int_paid_til_lst_bonus(
			BigDecimal nrml_int_paid_til_lst_bonus) {
		this.nrml_int_paid_til_lst_bonus = nrml_int_paid_til_lst_bonus;
	}
	/**
	 * @return the bonus_cycle
	 */
	public String getBonus_cycle() {
		return bonus_cycle;
	}
	/**
	 * @param bonus_cycle the bonus_cycle to set
	 */
	public void setBonus_cycle(String bonus_cycle) {
		this.bonus_cycle = bonus_cycle;
	}
	/**
	 * @return the last_calc_bonus_pcnt
	 */
	public BigDecimal getLast_calc_bonus_pcnt() {
		return last_calc_bonus_pcnt;
	}
	/**
	 * @param last_calc_bonus_pcnt the last_calc_bonus_pcnt to set
	 */
	public void setLast_calc_bonus_pcnt(BigDecimal last_calc_bonus_pcnt) {
		this.last_calc_bonus_pcnt = last_calc_bonus_pcnt;
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
	 * @return the last_local_cal_update
	 */
	public Date getLast_local_cal_update() {
		return last_local_cal_update;
	}
	/**
	 * @param last_local_cal_update the last_local_cal_update to set
	 */
	public void setLast_local_cal_update(Date last_local_cal_update) {
		this.last_local_cal_update = last_local_cal_update;
	}
	/**
	 * @return the loc_deposit_period_mths
	 */
	public Long getLoc_deposit_period_mths() {
		return loc_deposit_period_mths;
	}
	/**
	 * @param loc_deposit_period_mths the loc_deposit_period_mths to set
	 */
	public void setLoc_deposit_period_mths(Long loc_deposit_period_mths) {
		this.loc_deposit_period_mths = loc_deposit_period_mths;
	}
	/**
	 * @return the loc_deposit_period_days
	 */
	public Long getLoc_deposit_period_days() {
		return loc_deposit_period_days;
	}
	/**
	 * @param loc_deposit_period_days the loc_deposit_period_days to set
	 */
	public void setLoc_deposit_period_days(Long loc_deposit_period_days) {
		this.loc_deposit_period_days = loc_deposit_period_days;
	}
	/**
	 * @return the acct_close_fwc_num
	 */
	public String getAcct_close_fwc_num() {
		return acct_close_fwc_num;
	}
	/**
	 * @param acct_close_fwc_num the acct_close_fwc_num to set
	 */
	public void setAcct_close_fwc_num(String acct_close_fwc_num) {
		this.acct_close_fwc_num = acct_close_fwc_num;
	}
	/**
	 * @return the acct_close_fwc_sol_id
	 */
	public String getAcct_close_fwc_sol_id() {
		return acct_close_fwc_sol_id;
	}
	/**
	 * @param acct_close_fwc_sol_id the acct_close_fwc_sol_id to set
	 */
	public void setAcct_close_fwc_sol_id(String acct_close_fwc_sol_id) {
		this.acct_close_fwc_sol_id = acct_close_fwc_sol_id;
	}
	
	

}
