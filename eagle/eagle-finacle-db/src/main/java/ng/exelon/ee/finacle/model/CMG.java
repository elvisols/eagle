/**
 * 
 */
package ng.exelon.ee.finacle.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlType;


/**
 * @author oji
 *
 */
@Entity
@Table(name="tbaadm.cmg")
/*@NamedQueries( {
	@NamedQuery(name = "CMG.findByManager", query = "select c from CMG c  where  c.manager = :manager"),
	@NamedQuery(name = "CMG.findByT24Id", query = "select c from CMG c  where  c.oldCustId = :oldCustId")
})*/
@XmlType(name="customer_info")
public class CMG implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cif_id;
	
	private String cust_id;
	private String bank_id;
	private String gcif_id;
	
	private String entity_cre_flg;
	private String del_flg;
	private String cust_short_name;
	private String alt1_cust_short_name;
	private String cust_title_code;
	private String cust_name;
	private String alt1_cust_name;
	private String cust_sex;
	private String cust_grp;
	private String cust_occp_code;
	private String cust_commu_code;
	private String cust_sector_code;
	private String cust_sub_sector_code;
	private String cust_rating_code;
	private Date cust_rating_date;
	private String cust_mgr_opin;
	private String cust_introd_cust_id;
	private String introd_title_code;
	private String cust_introd_name;
	private String alt1_cust_introd_name;
	private String cust_introd_stat_code;
	private String cust_type_code;
	private String cust_emp_id;
	private String cust_stat_code;
	private Date cust_stat_chg_date;
	private String cust_const;
	private String cust_minor_flg;
	private String cust_nre_flg;
	private String cust_hlth_code;
	private String cust_card_hold_flg;
	private String lchg_user_id;
	private String lchg_time;
	private String rcre_user_id;
	private String rcre_time;
	private String tds_tbl_code;
	private String tds_cust_id;
	private String nat_id_card_num;
	private Date date_of_birth;
	private String pan_gir_num;
	private String psprt_num;
	private Date psprt_issu_date;
	private String psprt_det;
	private Date psprt_exp_date;
	private String purge_allowed_flg;
	private String purge_text;
	private Date cust_pref_till_date;
	private String acct_mgr_user_id;
	private String crncy_code;
	private String party_flg;
	private String native_lang_name;
	private String nat_lang_title_code;
	private String lang_code;
	private String primary_sol_id;
	private String address_type;
	private String dsa_id;
	private String offline_cum_debit_limit;
	private Date cust_opn_date;
	private String cust_employee_no;
	private String cust_creation_mode;
	private String pref_code;
	private Long tot_mod_times;
	private String segmentation_class;
	private Long corp_id;
	private String phone;
	private String email;
	private Long risk_profile_score;
	private Date risk_profile_expiry_date;
	private String cust_first_name;
	private String cust_middle_name;
	private String cust_last_name;
	private String alt1_cust_first_name;
	private String alt1_cust_middle_name;
	private String alt1_cust_last_name;
	private String strfield14;
	private String strfield15;
	private String subsegment;
	private String asset_classification;
	private String customer_level_provisioning;
	private String islamic_banking_customer;
	private String preferential_cal_base;
	private String zakat_deduction;
	private String staff_flag;
	private String is_dummy;
	private String charge_level_code;
	private String secondaryrm_id;
	private String tertiaryrm_id;
	private String short_name_native;
	private String country_of_birth;
	
	@OneToMany(mappedBy="id.phone_b2kid",fetch=FetchType.LAZY)
	private Collection<CPhone> phones = new ArrayList<CPhone>();
	
	@OneToMany(mappedBy="id.email_b2kid",fetch=FetchType.LAZY)
	private Collection<CEmail> emails = new ArrayList<CEmail>();
	
	@OneToMany(mappedBy="id.addr_b2kid",fetch=FetchType.LAZY)
	private Collection<CAddress> addresses = new ArrayList<CAddress>();
	
	
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
	 * @return the gcif_id
	 */
	public String getGcif_id() {
		return gcif_id;
	}
	/**
	 * @param gcif_id the gcif_id to set
	 */
	public void setGcif_id(String gcif_id) {
		this.gcif_id = gcif_id;
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
	 * @return the cust_short_name
	 */
	public String getCust_short_name() {
		return cust_short_name;
	}
	/**
	 * @param cust_short_name the cust_short_name to set
	 */
	public void setCust_short_name(String cust_short_name) {
		this.cust_short_name = cust_short_name;
	}
	/**
	 * @return the alt1_cust_short_name
	 */
	public String getAlt1_cust_short_name() {
		return alt1_cust_short_name;
	}
	/**
	 * @param alt1_cust_short_name the alt1_cust_short_name to set
	 */
	public void setAlt1_cust_short_name(String alt1_cust_short_name) {
		this.alt1_cust_short_name = alt1_cust_short_name;
	}
	/**
	 * @return the cust_title_code
	 */
	public String getCust_title_code() {
		return cust_title_code;
	}
	/**
	 * @param cust_title_code the cust_title_code to set
	 */
	public void setCust_title_code(String cust_title_code) {
		this.cust_title_code = cust_title_code;
	}
	/**
	 * @return the cust_name
	 */
	public String getCust_name() {
		return cust_name;
	}
	/**
	 * @param cust_name the cust_name to set
	 */
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	/**
	 * @return the alt1_cust_name
	 */
	public String getAlt1_cust_name() {
		return alt1_cust_name;
	}
	/**
	 * @param alt1_cust_name the alt1_cust_name to set
	 */
	public void setAlt1_cust_name(String alt1_cust_name) {
		this.alt1_cust_name = alt1_cust_name;
	}
	/**
	 * @return the cust_sex
	 */
	public String getCust_sex() {
		return cust_sex;
	}
	/**
	 * @param cust_sex the cust_sex to set
	 */
	public void setCust_sex(String cust_sex) {
		this.cust_sex = cust_sex;
	}
	/**
	 * @return the cust_grp
	 */
	public String getCust_grp() {
		return cust_grp;
	}
	/**
	 * @param cust_grp the cust_grp to set
	 */
	public void setCust_grp(String cust_grp) {
		this.cust_grp = cust_grp;
	}
	/**
	 * @return the cust_occp_code
	 */
	public String getCust_occp_code() {
		return cust_occp_code;
	}
	/**
	 * @param cust_occp_code the cust_occp_code to set
	 */
	public void setCust_occp_code(String cust_occp_code) {
		this.cust_occp_code = cust_occp_code;
	}
	/**
	 * @return the cust_commu_code
	 */
	public String getCust_commu_code() {
		return cust_commu_code;
	}
	/**
	 * @param cust_commu_code the cust_commu_code to set
	 */
	public void setCust_commu_code(String cust_commu_code) {
		this.cust_commu_code = cust_commu_code;
	}
	/**
	 * @return the cust_sector_code
	 */
	public String getCust_sector_code() {
		return cust_sector_code;
	}
	/**
	 * @param cust_sector_code the cust_sector_code to set
	 */
	public void setCust_sector_code(String cust_sector_code) {
		this.cust_sector_code = cust_sector_code;
	}
	/**
	 * @return the cust_sub_sector_code
	 */
	public String getCust_sub_sector_code() {
		return cust_sub_sector_code;
	}
	/**
	 * @param cust_sub_sector_code the cust_sub_sector_code to set
	 */
	public void setCust_sub_sector_code(String cust_sub_sector_code) {
		this.cust_sub_sector_code = cust_sub_sector_code;
	}
	/**
	 * @return the cust_rating_code
	 */
	public String getCust_rating_code() {
		return cust_rating_code;
	}
	/**
	 * @param cust_rating_code the cust_rating_code to set
	 */
	public void setCust_rating_code(String cust_rating_code) {
		this.cust_rating_code = cust_rating_code;
	}
	/**
	 * @return the cust_rating_date
	 */
	public Date getCust_rating_date() {
		return cust_rating_date;
	}
	/**
	 * @param cust_rating_date the cust_rating_date to set
	 */
	public void setCust_rating_date(Date cust_rating_date) {
		this.cust_rating_date = cust_rating_date;
	}
	/**
	 * @return the cust_mgr_opin
	 */
	public String getCust_mgr_opin() {
		return cust_mgr_opin;
	}
	/**
	 * @param cust_mgr_opin the cust_mgr_opin to set
	 */
	public void setCust_mgr_opin(String cust_mgr_opin) {
		this.cust_mgr_opin = cust_mgr_opin;
	}
	/**
	 * @return the cust_introd_cust_id
	 */
	public String getCust_introd_cust_id() {
		return cust_introd_cust_id;
	}
	/**
	 * @param cust_introd_cust_id the cust_introd_cust_id to set
	 */
	public void setCust_introd_cust_id(String cust_introd_cust_id) {
		this.cust_introd_cust_id = cust_introd_cust_id;
	}
	/**
	 * @return the introd_title_code
	 */
	public String getIntrod_title_code() {
		return introd_title_code;
	}
	/**
	 * @param introd_title_code the introd_title_code to set
	 */
	public void setIntrod_title_code(String introd_title_code) {
		this.introd_title_code = introd_title_code;
	}
	/**
	 * @return the cust_introd_name
	 */
	public String getCust_introd_name() {
		return cust_introd_name;
	}
	/**
	 * @param cust_introd_name the cust_introd_name to set
	 */
	public void setCust_introd_name(String cust_introd_name) {
		this.cust_introd_name = cust_introd_name;
	}
	/**
	 * @return the alt1_cust_introd_name
	 */
	public String getAlt1_cust_introd_name() {
		return alt1_cust_introd_name;
	}
	/**
	 * @param alt1_cust_introd_name the alt1_cust_introd_name to set
	 */
	public void setAlt1_cust_introd_name(String alt1_cust_introd_name) {
		this.alt1_cust_introd_name = alt1_cust_introd_name;
	}
	/**
	 * @return the cust_introd_stat_code
	 */
	public String getCust_introd_stat_code() {
		return cust_introd_stat_code;
	}
	/**
	 * @param cust_introd_stat_code the cust_introd_stat_code to set
	 */
	public void setCust_introd_stat_code(String cust_introd_stat_code) {
		this.cust_introd_stat_code = cust_introd_stat_code;
	}
	/**
	 * @return the cust_type_code
	 */
	public String getCust_type_code() {
		return cust_type_code;
	}
	/**
	 * @param cust_type_code the cust_type_code to set
	 */
	public void setCust_type_code(String cust_type_code) {
		this.cust_type_code = cust_type_code;
	}
	/**
	 * @return the cust_emp_id
	 */
	public String getCust_emp_id() {
		return cust_emp_id;
	}
	/**
	 * @param cust_emp_id the cust_emp_id to set
	 */
	public void setCust_emp_id(String cust_emp_id) {
		this.cust_emp_id = cust_emp_id;
	}
	/**
	 * @return the cust_stat_code
	 */
	public String getCust_stat_code() {
		return cust_stat_code;
	}
	/**
	 * @param cust_stat_code the cust_stat_code to set
	 */
	public void setCust_stat_code(String cust_stat_code) {
		this.cust_stat_code = cust_stat_code;
	}
	/**
	 * @return the cust_stat_chg_date
	 */
	public Date getCust_stat_chg_date() {
		return cust_stat_chg_date;
	}
	/**
	 * @param cust_stat_chg_date the cust_stat_chg_date to set
	 */
	public void setCust_stat_chg_date(Date cust_stat_chg_date) {
		this.cust_stat_chg_date = cust_stat_chg_date;
	}
	/**
	 * @return the cust_const
	 */
	public String getCust_const() {
		return cust_const;
	}
	/**
	 * @param cust_const the cust_const to set
	 */
	public void setCust_const(String cust_const) {
		this.cust_const = cust_const;
	}
	/**
	 * @return the cust_minor_flg
	 */
	public String getCust_minor_flg() {
		return cust_minor_flg;
	}
	/**
	 * @param cust_minor_flg the cust_minor_flg to set
	 */
	public void setCust_minor_flg(String cust_minor_flg) {
		this.cust_minor_flg = cust_minor_flg;
	}
	/**
	 * @return the cust_nre_flg
	 */
	public String getCust_nre_flg() {
		return cust_nre_flg;
	}
	/**
	 * @param cust_nre_flg the cust_nre_flg to set
	 */
	public void setCust_nre_flg(String cust_nre_flg) {
		this.cust_nre_flg = cust_nre_flg;
	}
	/**
	 * @return the cust_hlth_code
	 */
	public String getCust_hlth_code() {
		return cust_hlth_code;
	}
	/**
	 * @param cust_hlth_code the cust_hlth_code to set
	 */
	public void setCust_hlth_code(String cust_hlth_code) {
		this.cust_hlth_code = cust_hlth_code;
	}
	/**
	 * @return the cust_card_hold_flg
	 */
	public String getCust_card_hold_flg() {
		return cust_card_hold_flg;
	}
	/**
	 * @param cust_card_hold_flg the cust_card_hold_flg to set
	 */
	public void setCust_card_hold_flg(String cust_card_hold_flg) {
		this.cust_card_hold_flg = cust_card_hold_flg;
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
	public String getLchg_time() {
		return lchg_time;
	}
	/**
	 * @param lchg_time the lchg_time to set
	 */
	public void setLchg_time(String lchg_time) {
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
	public String getRcre_time() {
		return rcre_time;
	}
	/**
	 * @param rcre_time the rcre_time to set
	 */
	public void setRcre_time(String rcre_time) {
		this.rcre_time = rcre_time;
	}
	/**
	 * @return the tds_tbl_code
	 */
	public String getTds_tbl_code() {
		return tds_tbl_code;
	}
	/**
	 * @param tds_tbl_code the tds_tbl_code to set
	 */
	public void setTds_tbl_code(String tds_tbl_code) {
		this.tds_tbl_code = tds_tbl_code;
	}
	/**
	 * @return the tds_cust_id
	 */
	public String getTds_cust_id() {
		return tds_cust_id;
	}
	/**
	 * @param tds_cust_id the tds_cust_id to set
	 */
	public void setTds_cust_id(String tds_cust_id) {
		this.tds_cust_id = tds_cust_id;
	}
	/**
	 * @return the nat_id_card_num
	 */
	public String getNat_id_card_num() {
		return nat_id_card_num;
	}
	/**
	 * @param nat_id_card_num the nat_id_card_num to set
	 */
	public void setNat_id_card_num(String nat_id_card_num) {
		this.nat_id_card_num = nat_id_card_num;
	}
	/**
	 * @return the date_of_birth
	 */
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	/**
	 * @param date_of_birth the date_of_birth to set
	 */
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	/**
	 * @return the pan_gir_num
	 */
	public String getPan_gir_num() {
		return pan_gir_num;
	}
	/**
	 * @param pan_gir_num the pan_gir_num to set
	 */
	public void setPan_gir_num(String pan_gir_num) {
		this.pan_gir_num = pan_gir_num;
	}
	/**
	 * @return the psprt_num
	 */
	public String getPsprt_num() {
		return psprt_num;
	}
	/**
	 * @param psprt_num the psprt_num to set
	 */
	public void setPsprt_num(String psprt_num) {
		this.psprt_num = psprt_num;
	}
	/**
	 * @return the psprt_issu_date
	 */
	public Date getPsprt_issu_date() {
		return psprt_issu_date;
	}
	/**
	 * @param psprt_issu_date the psprt_issu_date to set
	 */
	public void setPsprt_issu_date(Date psprt_issu_date) {
		this.psprt_issu_date = psprt_issu_date;
	}
	/**
	 * @return the psprt_det
	 */
	public String getPsprt_det() {
		return psprt_det;
	}
	/**
	 * @param psprt_det the psprt_det to set
	 */
	public void setPsprt_det(String psprt_det) {
		this.psprt_det = psprt_det;
	}
	/**
	 * @return the psprt_exp_date
	 */
	public Date getPsprt_exp_date() {
		return psprt_exp_date;
	}
	/**
	 * @param psprt_exp_date the psprt_exp_date to set
	 */
	public void setPsprt_exp_date(Date psprt_exp_date) {
		this.psprt_exp_date = psprt_exp_date;
	}
	/**
	 * @return the purge_allowed_flg
	 */
	public String getPurge_allowed_flg() {
		return purge_allowed_flg;
	}
	/**
	 * @param purge_allowed_flg the purge_allowed_flg to set
	 */
	public void setPurge_allowed_flg(String purge_allowed_flg) {
		this.purge_allowed_flg = purge_allowed_flg;
	}
	/**
	 * @return the purge_text
	 */
	public String getPurge_text() {
		return purge_text;
	}
	/**
	 * @param purge_text the purge_text to set
	 */
	public void setPurge_text(String purge_text) {
		this.purge_text = purge_text;
	}
	/**
	 * @return the cust_pref_till_date
	 */
	public Date getCust_pref_till_date() {
		return cust_pref_till_date;
	}
	/**
	 * @param cust_pref_till_date the cust_pref_till_date to set
	 */
	public void setCust_pref_till_date(Date cust_pref_till_date) {
		this.cust_pref_till_date = cust_pref_till_date;
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
	 * @return the party_flg
	 */
	public String getParty_flg() {
		return party_flg;
	}
	/**
	 * @param party_flg the party_flg to set
	 */
	public void setParty_flg(String party_flg) {
		this.party_flg = party_flg;
	}
	/**
	 * @return the native_lang_name
	 */
	public String getNative_lang_name() {
		return native_lang_name;
	}
	/**
	 * @param native_lang_name the native_lang_name to set
	 */
	public void setNative_lang_name(String native_lang_name) {
		this.native_lang_name = native_lang_name;
	}
	/**
	 * @return the nat_lang_title_code
	 */
	public String getNat_lang_title_code() {
		return nat_lang_title_code;
	}
	/**
	 * @param nat_lang_title_code the nat_lang_title_code to set
	 */
	public void setNat_lang_title_code(String nat_lang_title_code) {
		this.nat_lang_title_code = nat_lang_title_code;
	}
	/**
	 * @return the lang_code
	 */
	public String getLang_code() {
		return lang_code;
	}
	/**
	 * @param lang_code the lang_code to set
	 */
	public void setLang_code(String lang_code) {
		this.lang_code = lang_code;
	}
	/**
	 * @return the primary_sol_id
	 */
	public String getPrimary_sol_id() {
		return primary_sol_id;
	}
	/**
	 * @param primary_sol_id the primary_sol_id to set
	 */
	public void setPrimary_sol_id(String primary_sol_id) {
		this.primary_sol_id = primary_sol_id;
	}
	/**
	 * @return the address_type
	 */
	public String getAddress_type() {
		return address_type;
	}
	/**
	 * @param address_type the address_type to set
	 */
	public void setAddress_type(String address_type) {
		this.address_type = address_type;
	}
	/**
	 * @return the dsa_id
	 */
	public String getDsa_id() {
		return dsa_id;
	}
	/**
	 * @param dsa_id the dsa_id to set
	 */
	public void setDsa_id(String dsa_id) {
		this.dsa_id = dsa_id;
	}
	/**
	 * @return the offline_cum_debit_limit
	 */
	public String getOffline_cum_debit_limit() {
		return offline_cum_debit_limit;
	}
	/**
	 * @param offline_cum_debit_limit the offline_cum_debit_limit to set
	 */
	public void setOffline_cum_debit_limit(String offline_cum_debit_limit) {
		this.offline_cum_debit_limit = offline_cum_debit_limit;
	}
	/**
	 * @return the cust_opn_date
	 */
	public Date getCust_opn_date() {
		return cust_opn_date;
	}
	/**
	 * @param cust_opn_date the cust_opn_date to set
	 */
	public void setCust_opn_date(Date cust_opn_date) {
		this.cust_opn_date = cust_opn_date;
	}
	/**
	 * @return the cust_employee_no
	 */
	public String getCust_employee_no() {
		return cust_employee_no;
	}
	/**
	 * @param cust_employee_no the cust_employee_no to set
	 */
	public void setCust_employee_no(String cust_employee_no) {
		this.cust_employee_no = cust_employee_no;
	}
	/**
	 * @return the cust_creation_mode
	 */
	public String getCust_creation_mode() {
		return cust_creation_mode;
	}
	/**
	 * @param cust_creation_mode the cust_creation_mode to set
	 */
	public void setCust_creation_mode(String cust_creation_mode) {
		this.cust_creation_mode = cust_creation_mode;
	}
	/**
	 * @return the pref_code
	 */
	public String getPref_code() {
		return pref_code;
	}
	/**
	 * @param pref_code the pref_code to set
	 */
	public void setPref_code(String pref_code) {
		this.pref_code = pref_code;
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
	 * @return the segmentation_class
	 */
	public String getSegmentation_class() {
		return segmentation_class;
	}
	/**
	 * @param segmentation_class the segmentation_class to set
	 */
	public void setSegmentation_class(String segmentation_class) {
		this.segmentation_class = segmentation_class;
	}
	/**
	 * @return the corp_id
	 */
	public Long getCorp_id() {
		return corp_id;
	}
	/**
	 * @param corp_id the corp_id to set
	 */
	public void setCorp_id(Long corp_id) {
		this.corp_id = corp_id;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the risk_profile_score
	 */
	public Long getRisk_profile_score() {
		return risk_profile_score;
	}
	/**
	 * @param risk_profile_score the risk_profile_score to set
	 */
	public void setRisk_profile_score(Long risk_profile_score) {
		this.risk_profile_score = risk_profile_score;
	}
	/**
	 * @return the risk_profile_expiry_date
	 */
	public Date getRisk_profile_expiry_date() {
		return risk_profile_expiry_date;
	}
	/**
	 * @param risk_profile_expiry_date the risk_profile_expiry_date to set
	 */
	public void setRisk_profile_expiry_date(Date risk_profile_expiry_date) {
		this.risk_profile_expiry_date = risk_profile_expiry_date;
	}
	/**
	 * @return the cust_first_name
	 */
	public String getCust_first_name() {
		return cust_first_name;
	}
	/**
	 * @param cust_first_name the cust_first_name to set
	 */
	public void setCust_first_name(String cust_first_name) {
		this.cust_first_name = cust_first_name;
	}
	/**
	 * @return the cust_middle_name
	 */
	public String getCust_middle_name() {
		return cust_middle_name;
	}
	/**
	 * @param cust_middle_name the cust_middle_name to set
	 */
	public void setCust_middle_name(String cust_middle_name) {
		this.cust_middle_name = cust_middle_name;
	}
	/**
	 * @return the cust_last_name
	 */
	public String getCust_last_name() {
		return cust_last_name;
	}
	/**
	 * @param cust_last_name the cust_last_name to set
	 */
	public void setCust_last_name(String cust_last_name) {
		this.cust_last_name = cust_last_name;
	}
	/**
	 * @return the alt1_cust_first_name
	 */
	public String getAlt1_cust_first_name() {
		return alt1_cust_first_name;
	}
	/**
	 * @param alt1_cust_first_name the alt1_cust_first_name to set
	 */
	public void setAlt1_cust_first_name(String alt1_cust_first_name) {
		this.alt1_cust_first_name = alt1_cust_first_name;
	}
	/**
	 * @return the alt1_cust_middle_name
	 */
	public String getAlt1_cust_middle_name() {
		return alt1_cust_middle_name;
	}
	/**
	 * @param alt1_cust_middle_name the alt1_cust_middle_name to set
	 */
	public void setAlt1_cust_middle_name(String alt1_cust_middle_name) {
		this.alt1_cust_middle_name = alt1_cust_middle_name;
	}
	/**
	 * @return the alt1_cust_last_name
	 */
	public String getAlt1_cust_last_name() {
		return alt1_cust_last_name;
	}
	/**
	 * @param alt1_cust_last_name the alt1_cust_last_name to set
	 */
	public void setAlt1_cust_last_name(String alt1_cust_last_name) {
		this.alt1_cust_last_name = alt1_cust_last_name;
	}
	/**
	 * @return the strfield14
	 */
	public String getStrfield14() {
		return strfield14;
	}
	/**
	 * @param strfield14 the strfield14 to set
	 */
	public void setStrfield14(String strfield14) {
		this.strfield14 = strfield14;
	}
	/**
	 * @return the strfield15
	 */
	public String getStrfield15() {
		return strfield15;
	}
	/**
	 * @param strfield15 the strfield15 to set
	 */
	public void setStrfield15(String strfield15) {
		this.strfield15 = strfield15;
	}
	/**
	 * @return the subsegment
	 */
	public String getSubsegment() {
		return subsegment;
	}
	/**
	 * @param subsegment the subsegment to set
	 */
	public void setSubsegment(String subsegment) {
		this.subsegment = subsegment;
	}
	/**
	 * @return the asset_classification
	 */
	public String getAsset_classification() {
		return asset_classification;
	}
	/**
	 * @param asset_classification the asset_classification to set
	 */
	public void setAsset_classification(String asset_classification) {
		this.asset_classification = asset_classification;
	}
	/**
	 * @return the customer_level_provisioning
	 */
	public String getCustomer_level_provisioning() {
		return customer_level_provisioning;
	}
	/**
	 * @param customer_level_provisioning the customer_level_provisioning to set
	 */
	public void setCustomer_level_provisioning(String customer_level_provisioning) {
		this.customer_level_provisioning = customer_level_provisioning;
	}
	/**
	 * @return the islamic_banking_customer
	 */
	public String getIslamic_banking_customer() {
		return islamic_banking_customer;
	}
	/**
	 * @param islamic_banking_customer the islamic_banking_customer to set
	 */
	public void setIslamic_banking_customer(String islamic_banking_customer) {
		this.islamic_banking_customer = islamic_banking_customer;
	}
	/**
	 * @return the preferential_cal_base
	 */
	public String getPreferential_cal_base() {
		return preferential_cal_base;
	}
	/**
	 * @param preferential_cal_base the preferential_cal_base to set
	 */
	public void setPreferential_cal_base(String preferential_cal_base) {
		this.preferential_cal_base = preferential_cal_base;
	}
	/**
	 * @return the zakat_deduction
	 */
	public String getZakat_deduction() {
		return zakat_deduction;
	}
	/**
	 * @param zakat_deduction the zakat_deduction to set
	 */
	public void setZakat_deduction(String zakat_deduction) {
		this.zakat_deduction = zakat_deduction;
	}
	/**
	 * @return the staff_flag
	 */
	public String getStaff_flag() {
		return staff_flag;
	}
	/**
	 * @param staff_flag the staff_flag to set
	 */
	public void setStaff_flag(String staff_flag) {
		this.staff_flag = staff_flag;
	}
	/**
	 * @return the is_dummy
	 */
	public String getIs_dummy() {
		return is_dummy;
	}
	/**
	 * @param is_dummy the is_dummy to set
	 */
	public void setIs_dummy(String is_dummy) {
		this.is_dummy = is_dummy;
	}
	/**
	 * @return the charge_level_code
	 */
	public String getCharge_level_code() {
		return charge_level_code;
	}
	/**
	 * @param charge_level_code the charge_level_code to set
	 */
	public void setCharge_level_code(String charge_level_code) {
		this.charge_level_code = charge_level_code;
	}
	/**
	 * @return the secondaryrm_id
	 */
	public String getSecondaryrm_id() {
		return secondaryrm_id;
	}
	/**
	 * @param secondaryrm_id the secondaryrm_id to set
	 */
	public void setSecondaryrm_id(String secondaryrm_id) {
		this.secondaryrm_id = secondaryrm_id;
	}
	/**
	 * @return the tertiaryrm_id
	 */
	public String getTertiaryrm_id() {
		return tertiaryrm_id;
	}
	/**
	 * @param tertiaryrm_id the tertiaryrm_id to set
	 */
	public void setTertiaryrm_id(String tertiaryrm_id) {
		this.tertiaryrm_id = tertiaryrm_id;
	}
	/**
	 * @return the short_name_native
	 */
	public String getShort_name_native() {
		return short_name_native;
	}
	/**
	 * @param short_name_native the short_name_native to set
	 */
	public void setShort_name_native(String short_name_native) {
		this.short_name_native = short_name_native;
	}
	/**
	 * @return the country_of_birth
	 */
	public String getCountry_of_birth() {
		return country_of_birth;
	}
	/**
	 * @param country_of_birth the country_of_birth to set
	 */
	public void setCountry_of_birth(String country_of_birth) {
		this.country_of_birth = country_of_birth;
	}
	/**
	 * @return the phones
	 */
	public Collection<CPhone> getPhones() {
		return phones;
	}
	/**
	 * @param phones the phones to set
	 */
	public void setPhones(Collection<CPhone> phones) {
		this.phones = phones;
	}
	/**
	 * @return the emails
	 */
	public Collection<CEmail> getEmails() {
		return emails;
	}
	/**
	 * @param emails the emails to set
	 */
	public void setEmails(Collection<CEmail> emails) {
		this.emails = emails;
	}
	/**
	 * @return the addresses
	 */
	public Collection<CAddress> getAddresses() {
		return addresses;
	}
	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(Collection<CAddress> addresses) {
		this.addresses = addresses;
	}
	
	
	
}
