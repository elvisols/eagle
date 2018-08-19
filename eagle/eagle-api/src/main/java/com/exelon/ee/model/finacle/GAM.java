/**
 * 
 */
package com.exelon.ee.model.finacle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * @author oji
 *
 */
@Entity
@Table(name="finacle.gam")
@NamedQueries( {
	@NamedQuery(name = "GAM.findByCustId", query = "select c from GAM c  where  c.cust_id = :cust_id"),
	@NamedQuery(name = "GAM.findByAcid", query = "select c from GAM c  where  c.acid = :acid and c.del_flg = 'N' "),
})
@XmlType(name="account_info")
public class GAM implements Serializable {
	private static final long serialVersionUID = 1L;

	private String acid;
	private Character entity_cre_flg;
	private String del_flg;
	private String sol_id;
	private String acct_prefix;
	private String acct_num;
	private String bacid;

	@Id
	private String foracid;
	private String acct_name;
	private String acct_short_name;
	private String cust_id;
	private String emp_id;
	private String gl_sub_head_code;
	private String acct_ownership;
	private String schm_code;
	private BigDecimal dr_bal_lim;
	private String acct_rpt_code;
	private String frez_code;
	private String frez_reason_code;
	private Date acct_opn_date;
	private String acct_cls_flg;
	private Date acct_cls_date;
	private BigDecimal clr_bal_amt;
	private Long tot_mod_times;
	private Long ledg_num;
	private BigDecimal un_clr_bal_amt;
	private BigDecimal drwng_power;
	private BigDecimal sanct_lim;
	private BigDecimal adhoc_lim;
	private BigDecimal emer_advn;
	private BigDecimal dacc_lim;
	private BigDecimal system_reserved_amt;
	private BigDecimal single_tran_lim;
	private BigDecimal clean_adhoc_lim;
	private BigDecimal clean_emer_advn;
	private BigDecimal clean_single_tran_lim;
	private BigDecimal system_gen_lim;
	private Character chq_alwd_flg;
	private BigDecimal cash_excp_amt_lim;
	private BigDecimal clg_excp_amt_lim;
	private BigDecimal xfer_excp_amt_lim;
	private BigDecimal cash_cr_excp_amt_lim;
	private BigDecimal clg_cr_excp_amt_lim;
	private BigDecimal xfer_cr_excp_amt_lim;
	private BigDecimal cash_abnrml_amt_lim;
	private BigDecimal clg_abnrml_amt_lim;
	private BigDecimal xfer_abnrml_amt_lim;
	private BigDecimal cum_dr_amt;
	private BigDecimal cum_cr_amt;
	private BigDecimal acrd_cr_amt;
	private Date last_tran_date;
	private String acct_turnover_det_flg;
	private Date last_any_tran_date;
	private String lchg_user_id;
	private Date lchg_time;
	private String rcre_user_id;
	private Date rcre_time;
	private Date last_turnover_date;
	private String crncy_code;
	private String acct_crncy_code;
	private BigDecimal lien_amt;
	private String acct_classification_flg;
	private String acct_mgr_user_id;
	private String schm_type;
	private Date last_frez_date;
	private Date last_unfrez_date;
	private BigDecimal bal_on_frez_date;
	private String cif_id;
	private String frez_reason_code_2;
	private String frez_reason_code_3;
	private String frez_reason_code_4;
	private String frez_reason_code_5;
	
	
	@Transient
	private SMT smt = null;
	
	@Transient
	private CAM cam = null;
	
	
	@Transient
	private Character statusCode;
	
	@Transient
	private Character tableName;
	
	public boolean hasStatus(){
		if(null != smt || null != cam)return true;
		return false;
	}
	
	public BigDecimal getEffectiveBalance(){
		if(null != lien_amt)return clr_bal_amt.subtract(lien_amt);
		else return clr_bal_amt;
		
	}
	/**
	 * 
	 */
	public GAM() {
	}

	public Character getAccountStatus(){
		if(hasStatus()){
			if(null != smt)return smt.getAcct_status();
			else return cam.getAcct_status();
		}
		return null;
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
	 * @return the acct_prefix
	 */
	public String getAcct_prefix() {
		return acct_prefix;
	}

	/**
	 * @param acct_prefix the acct_prefix to set
	 */
	public void setAcct_prefix(String acct_prefix) {
		this.acct_prefix = acct_prefix;
	}

	/**
	 * @return the acct_num
	 */
	public String getAcct_num() {
		return acct_num;
	}

	/**
	 * @param acct_num the acct_num to set
	 */
	public void setAcct_num(String acct_num) {
		this.acct_num = acct_num;
	}

	/**
	 * @return the bacid
	 */
	public String getBacid() {
		return bacid;
	}

	/**
	 * @param bacid the bacid to set
	 */
	public void setBacid(String bacid) {
		this.bacid = bacid;
	}

	/**
	 * @return the foracid
	 */
	public String getForacid() {
		return foracid;
	}

	/**
	 * @param foracid the foracid to set
	 */
	public void setForacid(String foracid) {
		this.foracid = foracid;
	}

	/**
	 * @return the acct_name
	 */
	public String getAcct_name() {
		return acct_name;
	}

	/**
	 * @param acct_name the acct_name to set
	 */
	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}

	/**
	 * @return the acct_short_name
	 */
	public String getAcct_short_name() {
		return acct_short_name;
	}

	/**
	 * @param acct_short_name the acct_short_name to set
	 */
	public void setAcct_short_name(String acct_short_name) {
		this.acct_short_name = acct_short_name;
	}

	/**
	 * @return the cust_id
	 */
	public String getCust_id() {
		return cust_id;
	}

	/**
	 * @param cust_id the cust_id to set
	 */
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	/**
	 * @return the emp_id
	 */
	public String getEmp_id() {
		return emp_id;
	}

	/**
	 * @param emp_id the emp_id to set
	 */
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	/**
	 * @return the gl_sub_head_code
	 */
	public String getGl_sub_head_code() {
		return gl_sub_head_code;
	}

	/**
	 * @param gl_sub_head_code the gl_sub_head_code to set
	 */
	public void setGl_sub_head_code(String gl_sub_head_code) {
		this.gl_sub_head_code = gl_sub_head_code;
	}

	/**
	 * @return the acct_ownership
	 */
	public String getAcct_ownership() {
		return acct_ownership;
	}

	/**
	 * @param acct_ownership the acct_ownership to set
	 */
	public void setAcct_ownership(String acct_ownership) {
		this.acct_ownership = acct_ownership;
	}

	/**
	 * @return the schm_code
	 */
	public String getSchm_code() {
		return schm_code;
	}

	/**
	 * @param schm_code the schm_code to set
	 */
	public void setSchm_code(String schm_code) {
		this.schm_code = schm_code;
	}

	/**
	 * @return the dr_bal_lim
	 */
	public BigDecimal getDr_bal_lim() {
		return dr_bal_lim;
	}

	/**
	 * @param dr_bal_lim the dr_bal_lim to set
	 */
	public void setDr_bal_lim(BigDecimal dr_bal_lim) {
		this.dr_bal_lim = dr_bal_lim;
	}

	/**
	 * @return the acct_rpt_code
	 */
	public String getAcct_rpt_code() {
		return acct_rpt_code;
	}

	/**
	 * @param acct_rpt_code the acct_rpt_code to set
	 */
	public void setAcct_rpt_code(String acct_rpt_code) {
		this.acct_rpt_code = acct_rpt_code;
	}

	/**
	 * @return the frez_code
	 */
	public String getFrez_code() {
		return frez_code;
	}

	/**
	 * @param frez_code the frez_code to set
	 */
	public void setFrez_code(String frez_code) {
		this.frez_code = frez_code;
	}

	/**
	 * @return the frez_reason_code
	 */
	public String getFrez_reason_code() {
		return frez_reason_code;
	}

	/**
	 * @param frez_reason_code the frez_reason_code to set
	 */
	public void setFrez_reason_code(String frez_reason_code) {
		this.frez_reason_code = frez_reason_code;
	}

	/**
	 * @return the acct_opn_date
	 */
	public Date getAcct_opn_date() {
		return acct_opn_date;
	}

	/**
	 * @param acct_opn_date the acct_opn_date to set
	 */
	public void setAcct_opn_date(Date acct_opn_date) {
		this.acct_opn_date = acct_opn_date;
	}

	/**
	 * @return the acct_cls_flg
	 */
	public String getAcct_cls_flg() {
		return acct_cls_flg;
	}

	/**
	 * @param acct_cls_flg the acct_cls_flg to set
	 */
	public void setAcct_cls_flg(String acct_cls_flg) {
		this.acct_cls_flg = acct_cls_flg;
	}

	/**
	 * @return the acct_cls_date
	 */
	public Date getAcct_cls_date() {
		return acct_cls_date;
	}

	/**
	 * @param acct_cls_date the acct_cls_date to set
	 */
	public void setAcct_cls_date(Date acct_cls_date) {
		this.acct_cls_date = acct_cls_date;
	}

	/**
	 * @return the clr_bal_amt
	 */
	public BigDecimal getClr_bal_amt() {
		return clr_bal_amt;
	}

	/**
	 * @param clr_bal_amt the clr_bal_amt to set
	 */
	public void setClr_bal_amt(BigDecimal clr_bal_amt) {
		this.clr_bal_amt = clr_bal_amt;
	}

	/**
	 * @return the tot_mod_times
	 */
	public Long getTot_mod_times() {
		return tot_mod_times;
	}

	/**
	 * @param tot_mod_times the tot_mod_times to set
	 */
	public void setTot_mod_times(Long tot_mod_times) {
		this.tot_mod_times = tot_mod_times;
	}

	/**
	 * @return the ledg_num
	 */
	public Long getLedg_num() {
		return ledg_num;
	}

	/**
	 * @param ledg_num the ledg_num to set
	 */
	public void setLedg_num(Long ledg_num) {
		this.ledg_num = ledg_num;
	}

	/**
	 * @return the un_clr_bal_amt
	 */
	public BigDecimal getUn_clr_bal_amt() {
		return un_clr_bal_amt;
	}

	/**
	 * @param un_clr_bal_amt the un_clr_bal_amt to set
	 */
	public void setUn_clr_bal_amt(BigDecimal un_clr_bal_amt) {
		this.un_clr_bal_amt = un_clr_bal_amt;
	}

	/**
	 * @return the drwng_power
	 */
	public BigDecimal getDrwng_power() {
		return drwng_power;
	}

	/**
	 * @param drwng_power the drwng_power to set
	 */
	public void setDrwng_power(BigDecimal drwng_power) {
		this.drwng_power = drwng_power;
	}

	/**
	 * @return the sanct_lim
	 */
	public BigDecimal getSanct_lim() {
		return sanct_lim;
	}

	/**
	 * @param sanct_lim the sanct_lim to set
	 */
	public void setSanct_lim(BigDecimal sanct_lim) {
		this.sanct_lim = sanct_lim;
	}

	/**
	 * @return the adhoc_lim
	 */
	public BigDecimal getAdhoc_lim() {
		return adhoc_lim;
	}

	/**
	 * @param adhoc_lim the adhoc_lim to set
	 */
	public void setAdhoc_lim(BigDecimal adhoc_lim) {
		this.adhoc_lim = adhoc_lim;
	}

	/**
	 * @return the emer_advn
	 */
	public BigDecimal getEmer_advn() {
		return emer_advn;
	}

	/**
	 * @param emer_advn the emer_advn to set
	 */
	public void setEmer_advn(BigDecimal emer_advn) {
		this.emer_advn = emer_advn;
	}

	/**
	 * @return the dacc_lim
	 */
	public BigDecimal getDacc_lim() {
		return dacc_lim;
	}

	/**
	 * @param dacc_lim the dacc_lim to set
	 */
	public void setDacc_lim(BigDecimal dacc_lim) {
		this.dacc_lim = dacc_lim;
	}

	/**
	 * @return the system_reserved_amt
	 */
	public BigDecimal getSystem_reserved_amt() {
		return system_reserved_amt;
	}

	/**
	 * @param system_reserved_amt the system_reserved_amt to set
	 */
	public void setSystem_reserved_amt(BigDecimal system_reserved_amt) {
		this.system_reserved_amt = system_reserved_amt;
	}

	/**
	 * @return the single_tran_lim
	 */
	public BigDecimal getSingle_tran_lim() {
		return single_tran_lim;
	}

	/**
	 * @param single_tran_lim the single_tran_lim to set
	 */
	public void setSingle_tran_lim(BigDecimal single_tran_lim) {
		this.single_tran_lim = single_tran_lim;
	}

	/**
	 * @return the clean_adhoc_lim
	 */
	public BigDecimal getClean_adhoc_lim() {
		return clean_adhoc_lim;
	}

	/**
	 * @param clean_adhoc_lim the clean_adhoc_lim to set
	 */
	public void setClean_adhoc_lim(BigDecimal clean_adhoc_lim) {
		this.clean_adhoc_lim = clean_adhoc_lim;
	}

	/**
	 * @return the clean_emer_advn
	 */
	public BigDecimal getClean_emer_advn() {
		return clean_emer_advn;
	}

	/**
	 * @param clean_emer_advn the clean_emer_advn to set
	 */
	public void setClean_emer_advn(BigDecimal clean_emer_advn) {
		this.clean_emer_advn = clean_emer_advn;
	}

	/**
	 * @return the clean_single_tran_lim
	 */
	public BigDecimal getClean_single_tran_lim() {
		return clean_single_tran_lim;
	}

	/**
	 * @param clean_single_tran_lim the clean_single_tran_lim to set
	 */
	public void setClean_single_tran_lim(BigDecimal clean_single_tran_lim) {
		this.clean_single_tran_lim = clean_single_tran_lim;
	}

	/**
	 * @return the system_gen_lim
	 */
	public BigDecimal getSystem_gen_lim() {
		return system_gen_lim;
	}

	/**
	 * @param system_gen_lim the system_gen_lim to set
	 */
	public void setSystem_gen_lim(BigDecimal system_gen_lim) {
		this.system_gen_lim = system_gen_lim;
	}

	/**
	 * @return the chq_alwd_flg
	 */
	public Character getChq_alwd_flg() {
		return chq_alwd_flg;
	}

	/**
	 * @param chq_alwd_flg the chq_alwd_flg to set
	 */
	public void setChq_alwd_flg(Character chq_alwd_flg) {
		this.chq_alwd_flg = chq_alwd_flg;
	}

	/**
	 * @return the cash_excp_amt_lim
	 */
	public BigDecimal getCash_excp_amt_lim() {
		return cash_excp_amt_lim;
	}

	/**
	 * @param cash_excp_amt_lim the cash_excp_amt_lim to set
	 */
	public void setCash_excp_amt_lim(BigDecimal cash_excp_amt_lim) {
		this.cash_excp_amt_lim = cash_excp_amt_lim;
	}

	/**
	 * @return the clg_excp_amt_lim
	 */
	public BigDecimal getClg_excp_amt_lim() {
		return clg_excp_amt_lim;
	}

	/**
	 * @param clg_excp_amt_lim the clg_excp_amt_lim to set
	 */
	public void setClg_excp_amt_lim(BigDecimal clg_excp_amt_lim) {
		this.clg_excp_amt_lim = clg_excp_amt_lim;
	}

	/**
	 * @return the xfer_excp_amt_lim
	 */
	public BigDecimal getXfer_excp_amt_lim() {
		return xfer_excp_amt_lim;
	}

	/**
	 * @param xfer_excp_amt_lim the xfer_excp_amt_lim to set
	 */
	public void setXfer_excp_amt_lim(BigDecimal xfer_excp_amt_lim) {
		this.xfer_excp_amt_lim = xfer_excp_amt_lim;
	}

	/**
	 * @return the cash_cr_excp_amt_lim
	 */
	public BigDecimal getCash_cr_excp_amt_lim() {
		return cash_cr_excp_amt_lim;
	}

	/**
	 * @param cash_cr_excp_amt_lim the cash_cr_excp_amt_lim to set
	 */
	public void setCash_cr_excp_amt_lim(BigDecimal cash_cr_excp_amt_lim) {
		this.cash_cr_excp_amt_lim = cash_cr_excp_amt_lim;
	}

	/**
	 * @return the clg_cr_excp_amt_lim
	 */
	public BigDecimal getClg_cr_excp_amt_lim() {
		return clg_cr_excp_amt_lim;
	}

	/**
	 * @param clg_cr_excp_amt_lim the clg_cr_excp_amt_lim to set
	 */
	public void setClg_cr_excp_amt_lim(BigDecimal clg_cr_excp_amt_lim) {
		this.clg_cr_excp_amt_lim = clg_cr_excp_amt_lim;
	}

	/**
	 * @return the xfer_cr_excp_amt_lim
	 */
	public BigDecimal getXfer_cr_excp_amt_lim() {
		return xfer_cr_excp_amt_lim;
	}

	/**
	 * @param xfer_cr_excp_amt_lim the xfer_cr_excp_amt_lim to set
	 */
	public void setXfer_cr_excp_amt_lim(BigDecimal xfer_cr_excp_amt_lim) {
		this.xfer_cr_excp_amt_lim = xfer_cr_excp_amt_lim;
	}

	/**
	 * @return the cash_abnrml_amt_lim
	 */
	public BigDecimal getCash_abnrml_amt_lim() {
		return cash_abnrml_amt_lim;
	}

	/**
	 * @param cash_abnrml_amt_lim the cash_abnrml_amt_lim to set
	 */
	public void setCash_abnrml_amt_lim(BigDecimal cash_abnrml_amt_lim) {
		this.cash_abnrml_amt_lim = cash_abnrml_amt_lim;
	}

	/**
	 * @return the clg_abnrml_amt_lim
	 */
	public BigDecimal getClg_abnrml_amt_lim() {
		return clg_abnrml_amt_lim;
	}

	/**
	 * @param clg_abnrml_amt_lim the clg_abnrml_amt_lim to set
	 */
	public void setClg_abnrml_amt_lim(BigDecimal clg_abnrml_amt_lim) {
		this.clg_abnrml_amt_lim = clg_abnrml_amt_lim;
	}

	/**
	 * @return the xfer_abnrml_amt_lim
	 */
	public BigDecimal getXfer_abnrml_amt_lim() {
		return xfer_abnrml_amt_lim;
	}

	/**
	 * @param xfer_abnrml_amt_lim the xfer_abnrml_amt_lim to set
	 */
	public void setXfer_abnrml_amt_lim(BigDecimal xfer_abnrml_amt_lim) {
		this.xfer_abnrml_amt_lim = xfer_abnrml_amt_lim;
	}

	/**
	 * @return the cum_dr_amt
	 */
	public BigDecimal getCum_dr_amt() {
		return cum_dr_amt;
	}

	/**
	 * @param cum_dr_amt the cum_dr_amt to set
	 */
	public void setCum_dr_amt(BigDecimal cum_dr_amt) {
		this.cum_dr_amt = cum_dr_amt;
	}

	/**
	 * @return the cum_cr_amt
	 */
	public BigDecimal getCum_cr_amt() {
		return cum_cr_amt;
	}

	/**
	 * @param cum_cr_amt the cum_cr_amt to set
	 */
	public void setCum_cr_amt(BigDecimal cum_cr_amt) {
		this.cum_cr_amt = cum_cr_amt;
	}

	/**
	 * @return the acrd_cr_amt
	 */
	public BigDecimal getAcrd_cr_amt() {
		return acrd_cr_amt;
	}

	/**
	 * @param acrd_cr_amt the acrd_cr_amt to set
	 */
	public void setAcrd_cr_amt(BigDecimal acrd_cr_amt) {
		this.acrd_cr_amt = acrd_cr_amt;
	}

	/**
	 * @return the last_tran_date
	 */
	public Date getLast_tran_date() {
		return last_tran_date;
	}

	/**
	 * @param last_tran_date the last_tran_date to set
	 */
	public void setLast_tran_date(Date last_tran_date) {
		this.last_tran_date = last_tran_date;
	}

	/**
	 * @return the acct_turnover_det_flg
	 */
	public String getAcct_turnover_det_flg() {
		return acct_turnover_det_flg;
	}

	/**
	 * @param acct_turnover_det_flg the acct_turnover_det_flg to set
	 */
	public void setAcct_turnover_det_flg(String acct_turnover_det_flg) {
		this.acct_turnover_det_flg = acct_turnover_det_flg;
	}

	/**
	 * @return the last_any_tran_date
	 */
	public Date getLast_any_tran_date() {
		return last_any_tran_date;
	}

	/**
	 * @param last_any_tran_date the last_any_tran_date to set
	 */
	public void setLast_any_tran_date(Date last_any_tran_date) {
		this.last_any_tran_date = last_any_tran_date;
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
	 * @return the last_turnover_date
	 */
	public Date getLast_turnover_date() {
		return last_turnover_date;
	}

	/**
	 * @param last_turnover_date the last_turnover_date to set
	 */
	public void setLast_turnover_date(Date last_turnover_date) {
		this.last_turnover_date = last_turnover_date;
	}

	/**
	 * @return the crncy_code
	 */
	public String getCrncy_code() {
		return crncy_code;
	}

	/**
	 * @param crncy_code the crncy_code to set
	 */
	public void setCrncy_code(String crncy_code) {
		this.crncy_code = crncy_code;
	}

	/**
	 * @return the acct_crncy_code
	 */
	public String getAcct_crncy_code() {
		return acct_crncy_code;
	}

	/**
	 * @param acct_crncy_code the acct_crncy_code to set
	 */
	public void setAcct_crncy_code(String acct_crncy_code) {
		this.acct_crncy_code = acct_crncy_code;
	}

	/**
	 * @return the lien_amt
	 */
	public BigDecimal getLien_amt() {
		return lien_amt;
	}

	/**
	 * @param lien_amt the lien_amt to set
	 */
	public void setLien_amt(BigDecimal lien_amt) {
		this.lien_amt = lien_amt;
	}

	/**
	 * @return the acct_classification_flg
	 */
	public String getAcct_classification_flg() {
		return acct_classification_flg;
	}

	/**
	 * @param acct_classification_flg the acct_classification_flg to set
	 */
	public void setAcct_classification_flg(String acct_classification_flg) {
		this.acct_classification_flg = acct_classification_flg;
	}

	/**
	 * @return the acct_mgr_user_id
	 */
	public String getAcct_mgr_user_id() {
		return acct_mgr_user_id;
	}

	/**
	 * @param acct_mgr_user_id the acct_mgr_user_id to set
	 */
	public void setAcct_mgr_user_id(String acct_mgr_user_id) {
		this.acct_mgr_user_id = acct_mgr_user_id;
	}

	/**
	 * @return the schm_type
	 */
	public String getSchm_type() {
		return schm_type;
	}

	/**
	 * @param schm_type the schm_type to set
	 */
	public void setSchm_type(String schm_type) {
		this.schm_type = schm_type;
	}

	/**
	 * @return the last_frez_date
	 */
	public Date getLast_frez_date() {
		return last_frez_date;
	}

	/**
	 * @param last_frez_date the last_frez_date to set
	 */
	public void setLast_frez_date(Date last_frez_date) {
		this.last_frez_date = last_frez_date;
	}

	/**
	 * @return the last_unfrez_date
	 */
	public Date getLast_unfrez_date() {
		return last_unfrez_date;
	}

	/**
	 * @param last_unfrez_date the last_unfrez_date to set
	 */
	public void setLast_unfrez_date(Date last_unfrez_date) {
		this.last_unfrez_date = last_unfrez_date;
	}

	/**
	 * @return the bal_on_frez_date
	 */
	public BigDecimal getBal_on_frez_date() {
		return bal_on_frez_date;
	}

	/**
	 * @param bal_on_frez_date the bal_on_frez_date to set
	 */
	public void setBal_on_frez_date(BigDecimal bal_on_frez_date) {
		this.bal_on_frez_date = bal_on_frez_date;
	}

	/**
	 * @return the cif_id
	 */
	public String getCif_id() {
		return cif_id;
	}

	/**
	 * @param cif_id the cif_id to set
	 */
	public void setCif_id(String cif_id) {
		this.cif_id = cif_id;
	}

	/**
	 * @return the frez_reason_code_2
	 */
	public String getFrez_reason_code_2() {
		return frez_reason_code_2;
	}

	/**
	 * @param frez_reason_code_2 the frez_reason_code_2 to set
	 */
	public void setFrez_reason_code_2(String frez_reason_code_2) {
		this.frez_reason_code_2 = frez_reason_code_2;
	}

	/**
	 * @return the frez_reason_code_3
	 */
	public String getFrez_reason_code_3() {
		return frez_reason_code_3;
	}

	/**
	 * @param frez_reason_code_3 the frez_reason_code_3 to set
	 */
	public void setFrez_reason_code_3(String frez_reason_code_3) {
		this.frez_reason_code_3 = frez_reason_code_3;
	}

	/**
	 * @return the frez_reason_code_4
	 */
	public String getFrez_reason_code_4() {
		return frez_reason_code_4;
	}

	/**
	 * @param frez_reason_code_4 the frez_reason_code_4 to set
	 */
	public void setFrez_reason_code_4(String frez_reason_code_4) {
		this.frez_reason_code_4 = frez_reason_code_4;
	}

	/**
	 * @return the frez_reason_code_5
	 */
	public String getFrez_reason_code_5() {
		return frez_reason_code_5;
	}

	/**
	 * @param frez_reason_code_5 the frez_reason_code_5 to set
	 */
	public void setFrez_reason_code_5(String frez_reason_code_5) {
		this.frez_reason_code_5 = frez_reason_code_5;
	}


	/**
	 * @return the smt
	 */
	@XmlTransient
	public SMT getSmt() {
		return smt;
	}
	/**
	 * @param smt the smt to set
	 */
	public void setSmt(SMT smt) {
		this.smt = smt;
	}
	/**
	 * @return the cam
	 */
	@XmlTransient
	public CAM getCam() {
		return cam;
	}
	/**
	 * @param cam the cam to set
	 */
	public void setCam(CAM cam) {
		this.cam = cam;
	}
	/**
	 * @return the statusCode
	 */
	public Character getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(Character statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the tableName
	 */
	public Character getTableName() {
		return tableName;
	}
	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(Character tableName) {
		this.tableName = tableName;
	}

}
