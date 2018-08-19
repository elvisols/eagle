/**
 * 
 */
package ng.exelon.ee.finacle.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="tbaadm.htd")
@NamedQueries( {
	@NamedQuery(name = "HTD.findByCustId", query = "select c from GAM c  where  c.cust_id = :cust_id"),
	@NamedQuery(name = "HTD.findCotByAccount", 
		query = "select c from HTD c  where  c.id.tran_date = :tranDate and c.acid = :acid "
				+ " and c.tran_sub_type not in ( 'BI', 'IC', 'SC', 'BS', 'IP','O') and c.del_flg = 'N' "
				+ " order by c.id.tran_id "),
	@NamedQuery(name = "HTD.findTxnByAccount", 
		query = "select c from HTD c  where  c.id.tran_date = :tranDate and c.acid = :acid "
			+ " and c.del_flg = 'N'  order by c.id.tran_id "),
	@NamedQuery(name = "HTD.findTxnByAccountByTranId", 
		query = "select c from HTD c  where  c.id.tran_date = :tranDate and c.acid = :acid "
				+ " and c.del_flg = 'N'  and c.id.tran_id = :tranId order by c.id.tran_id ")
})
public class HTD implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TransactionPK id;
	
	@Column(length=1)
	private String  del_flg             ; // char(1 byte),
	
	@Column(length=1)
	private String  tran_type           ; // char(1 byte),
	
	@Column(length=2)
	private String  tran_sub_type       ; // varchar2(2 byte),
	
	@Column(length=1)
	private Character  part_tran_type      ; //  char(1 byte),
	
	@Column(length=5)
	private String  gl_sub_head_code    ; //  varchar2(5 byte),
	
	/*@Column(length=11)
	private String  acid                ; //  varchar2(11 byte),
	*/
	
	@ManyToOne
    @JoinColumn(name = "acid", referencedColumnName = "acid",  insertable = false, updatable = false)
	private GAM  acid;
	
	private Date  value_date          ; //  Date,
	
	
	private BigDecimal  tran_amt            ; //  number(20,4),
	private String  tran_particular     ; // varchar2(50 byte),
	
	@Column(length=15)
	private String  entry_user_id       ; // varchar2(15 byte),
	
	@Column(length=15)
	private String  pstd_user_id        ; //  varchar2(15 byte),
	
	@Column(length=15)
	private String  vfd_user_id         ; // varchar2(15 byte),
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date  entry_date          ; //  Date, @Column(length=)
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date  pstd_date           ; // Date,
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date  vfd_date            ; //  Date,
	
	@Column(length=5)
	private String  rpt_code            ; //  varchar2(5 byte),
	
	@Column(length=20)
	private String  ref_num             ; // varchar2(20 byte),
	
	@Column(length=5)
	private String  instrmnt_type       ; // varchar2(5 byte),
	
	@Temporal(TemporalType.DATE)
	private Date  instrmnt_date       ; // Date,
	
	@Column(length=8)
	private String  instrmnt_num        ; //  varchar2(8 byte),
	
	@Column(length=6)
	private String  instrmnt_alpha      ; //  varchar2(6 byte),
	
	@Column(length=30)
	private String  tran_rmks           ; // varchar2(30 byte),
	
	@Column(length=1)
	private String  pstd_flg            ; //  char(1 byte),
	
	@Column(length=1)
	private String  prnt_advc_ind       ; // char(1 byte),
	
	@Column(length=1)
	private String  amt_reservation_ind ; // char(1 byte),
	
	private BigDecimal  reservation_amt     ; // number(20,4),
	
	@Column(length=1)
	private String  restrict_modify_ind ; // char(1 byte),
	
	@Column(length=15)
	private String  lchg_user_id        ; //  varchar2(15 byte),
	
	@Temporal(TemporalType.DATE)
	private Date  lchg_time           ; // Date,
	
	@Column(length=15)
	private String  rcre_user_id        ; //  varchar2(15 byte),
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date  rcre_time           ; // Date,
	
	@Column(length=9)
	private String  cust_id             ; // varchar2(9 byte),
	
	@Column(length=1)
	private String  voucher_print_flg   ; // char(1 byte),
	
	@Column(length=3)
	private String  module_id           ; // varchar2(3 byte),
	
	@Column(length=6)
	private String  br_code             ; // varchar2(6 byte),
		
	private BigDecimal  fx_tran_amt         ; // number(20,4),
	
	@Column(length=5)
	private String  rate_code           ; // varchar2(5 byte),
	
	
	private BigDecimal  rate                ; //  number(21,10),
	
	@Column(length=3)
	private String  crncy_code          ; //  varchar2(3 byte),
	
	@Column(length=1)
	private String  navigation_flg      ; //  char(1 byte),
	
	@Column(length=3)
	private String  tran_crncy_code     ; // varchar2(3 byte),
	
	@Column(length=3)
	private String  ref_crncy_code      ; //  varchar2(3 byte),
	
	private BigDecimal  ref_amt             ; // number(20,4),
	
	@Column(length=8)
	private String  sol_id              ; //  varchar2(8 byte),
	
	@Column(length=6)
	private String  bank_code           ; // varchar2(6 byte),
	
	@Column(length=16)
	private String  trea_ref_num        ; //  varchar2(16 byte),
	private BigDecimal  trea_rate           ; // number(21,10),
	
	
	private Integer  ts_cnt              ; //  number(5),
	
	@Column(length=50)
	private String  tran_particular_2   ; // varchar2(50 byte),
	
	@Column(length=5)
	private String  tran_particular_code; //  varchar2(5 byte)
	
	/**
	 * 
	 */
	public HTD() {
	}

	/**
	 * @return the acid
	 */
	public GAM getAcid() {
		return acid;
	}

	/**
	 * @param acid the acid to set
	 */
	public void setAcid(GAM acid) {
		this.acid = acid;
	}

	/**
	 * @return the amt_reservation_ind
	 */
	public String getAmt_reservation_ind() {
		return amt_reservation_ind;
	}

	/**
	 * @param amt_reservation_ind the amt_reservation_ind to set
	 */
	public void setAmt_reservation_ind(String amt_reservation_ind) {
		this.amt_reservation_ind = amt_reservation_ind;
	}

	/**
	 * @return the bank_code
	 */
	public String getBank_code() {
		return bank_code;
	}

	/**
	 * @param bank_code the bank_code to set
	 */
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	/**
	 * @return the br_code
	 */
	public String getBr_code() {
		return br_code;
	}

	/**
	 * @param br_code the br_code to set
	 */
	public void setBr_code(String br_code) {
		this.br_code = br_code;
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
	 * @return the entry_date
	 */
	public Date getEntry_date() {
		return entry_date;
	}

	/**
	 * @param entry_date the entry_date to set
	 */
	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

	/**
	 * @return the entry_user_id
	 */
	public String getEntry_user_id() {
		return entry_user_id;
	}

	/**
	 * @param entry_user_id the entry_user_id to set
	 */
	public void setEntry_user_id(String entry_user_id) {
		this.entry_user_id = entry_user_id;
	}

	/**
	 * @return the fx_tran_amt
	 */
	public BigDecimal getFx_tran_amt() {
		return fx_tran_amt;
	}

	/**
	 * @param fx_tran_amt the fx_tran_amt to set
	 */
	public void setFx_tran_amt(BigDecimal fx_tran_amt) {
		this.fx_tran_amt = fx_tran_amt;
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
	 * @return the id
	 */
	public TransactionPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(TransactionPK id) {
		this.id = id;
	}

	/**
	 * @return the instrmnt_alpha
	 */
	public String getInstrmnt_alpha() {
		return instrmnt_alpha;
	}

	/**
	 * @param instrmnt_alpha the instrmnt_alpha to set
	 */
	public void setInstrmnt_alpha(String instrmnt_alpha) {
		this.instrmnt_alpha = instrmnt_alpha;
	}

	/**
	 * @return the instrmnt_date
	 */
	public Date getInstrmnt_date() {
		return instrmnt_date;
	}

	/**
	 * @param instrmnt_date the instrmnt_date to set
	 */
	public void setInstrmnt_date(Date instrmnt_date) {
		this.instrmnt_date = instrmnt_date;
	}

	/**
	 * @return the instrmnt_num
	 */
	public String getInstrmnt_num() {
		return instrmnt_num;
	}

	/**
	 * @param instrmnt_num the instrmnt_num to set
	 */
	public void setInstrmnt_num(String instrmnt_num) {
		this.instrmnt_num = instrmnt_num;
	}

	/**
	 * @return the instrmnt_type
	 */
	public String getInstrmnt_type() {
		return instrmnt_type;
	}

	/**
	 * @param instrmnt_type the instrmnt_type to set
	 */
	public void setInstrmnt_type(String instrmnt_type) {
		this.instrmnt_type = instrmnt_type;
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
	 * @return the module_id
	 */
	public String getModule_id() {
		return module_id;
	}

	/**
	 * @param module_id the module_id to set
	 */
	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}

	/**
	 * @return the navigation_flg
	 */
	public String getNavigation_flg() {
		return navigation_flg;
	}

	/**
	 * @param navigation_flg the navigation_flg to set
	 */
	public void setNavigation_flg(String navigation_flg) {
		this.navigation_flg = navigation_flg;
	}

	/**
	 * @return the part_tran_type
	 */
	public Character getPart_tran_type() {
		return part_tran_type;
	}

	/**
	 * @param part_tran_type the part_tran_type to set
	 */
	public void setPart_tran_type(Character part_tran_type) {
		this.part_tran_type = part_tran_type;
	}

	/**
	 * @return the prnt_advc_ind
	 */
	public String getPrnt_advc_ind() {
		return prnt_advc_ind;
	}

	/**
	 * @param prnt_advc_ind the prnt_advc_ind to set
	 */
	public void setPrnt_advc_ind(String prnt_advc_ind) {
		this.prnt_advc_ind = prnt_advc_ind;
	}

	/**
	 * @return the pstd_date
	 */
	public Date getPstd_date() {
		return pstd_date;
	}

	/**
	 * @param pstd_date the pstd_date to set
	 */
	public void setPstd_date(Date pstd_date) {
		this.pstd_date = pstd_date;
	}

	/**
	 * @return the pstd_flg
	 */
	public String getPstd_flg() {
		return pstd_flg;
	}

	/**
	 * @param pstd_flg the pstd_flg to set
	 */
	public void setPstd_flg(String pstd_flg) {
		this.pstd_flg = pstd_flg;
	}

	/**
	 * @return the pstd_user_id
	 */
	public String getPstd_user_id() {
		return pstd_user_id;
	}

	/**
	 * @param pstd_user_id the pstd_user_id to set
	 */
	public void setPstd_user_id(String pstd_user_id) {
		this.pstd_user_id = pstd_user_id;
	}

	/**
	 * @return the rate
	 */
	public BigDecimal getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	/**
	 * @return the rate_code
	 */
	public String getRate_code() {
		return rate_code;
	}

	/**
	 * @param rate_code the rate_code to set
	 */
	public void setRate_code(String rate_code) {
		this.rate_code = rate_code;
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
	 * @return the ref_amt
	 */
	public BigDecimal getRef_amt() {
		return ref_amt;
	}

	/**
	 * @param ref_amt the ref_amt to set
	 */
	public void setRef_amt(BigDecimal ref_amt) {
		this.ref_amt = ref_amt;
	}

	/**
	 * @return the ref_crncy_code
	 */
	public String getRef_crncy_code() {
		return ref_crncy_code;
	}

	/**
	 * @param ref_crncy_code the ref_crncy_code to set
	 */
	public void setRef_crncy_code(String ref_crncy_code) {
		this.ref_crncy_code = ref_crncy_code;
	}

	/**
	 * @return the ref_num
	 */
	public String getRef_num() {
		return ref_num;
	}

	/**
	 * @param ref_num the ref_num to set
	 */
	public void setRef_num(String ref_num) {
		this.ref_num = ref_num;
	}

	/**
	 * @return the reservation_amt
	 */
	public BigDecimal getReservation_amt() {
		return reservation_amt;
	}

	/**
	 * @param reservation_amt the reservation_amt to set
	 */
	public void setReservation_amt(BigDecimal reservation_amt) {
		this.reservation_amt = reservation_amt;
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
	 * @return the rpt_code
	 */
	public String getRpt_code() {
		return rpt_code;
	}

	/**
	 * @param rpt_code the rpt_code to set
	 */
	public void setRpt_code(String rpt_code) {
		this.rpt_code = rpt_code;
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
	 * @return the tran_amt
	 */
	public BigDecimal getTran_amt() {
		return tran_amt;
	}

	/**
	 * @param tran_amt the tran_amt to set
	 */
	public void setTran_amt(BigDecimal tran_amt) {
		this.tran_amt = tran_amt;
	}

	/**
	 * @return the tran_crncy_code
	 */
	public String getTran_crncy_code() {
		return tran_crncy_code;
	}

	/**
	 * @param tran_crncy_code the tran_crncy_code to set
	 */
	public void setTran_crncy_code(String tran_crncy_code) {
		this.tran_crncy_code = tran_crncy_code;
	}

	/**
	 * @return the tran_particular
	 */
	public String getTran_particular() {
		return tran_particular;
	}

	/**
	 * @param tran_particular the tran_particular to set
	 */
	public void setTran_particular(String tran_particular) {
		this.tran_particular = tran_particular;
	}

	/**
	 * @return the tran_particular_2
	 */
	public String getTran_particular_2() {
		return tran_particular_2;
	}

	/**
	 * @param tran_particular_2 the tran_particular_2 to set
	 */
	public void setTran_particular_2(String tran_particular_2) {
		this.tran_particular_2 = tran_particular_2;
	}

	/**
	 * @return the tran_particular_code
	 */
	public String getTran_particular_code() {
		return tran_particular_code;
	}

	/**
	 * @param tran_particular_code the tran_particular_code to set
	 */
	public void setTran_particular_code(String tran_particular_code) {
		this.tran_particular_code = tran_particular_code;
	}

	/**
	 * @return the tran_rmks
	 */
	public String getTran_rmks() {
		return tran_rmks;
	}

	/**
	 * @param tran_rmks the tran_rmks to set
	 */
	public void setTran_rmks(String tran_rmks) {
		this.tran_rmks = tran_rmks;
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
	 * @return the trea_rate
	 */
	public BigDecimal getTrea_rate() {
		return trea_rate;
	}

	/**
	 * @param trea_rate the trea_rate to set
	 */
	public void setTrea_rate(BigDecimal trea_rate) {
		this.trea_rate = trea_rate;
	}

	/**
	 * @return the trea_ref_num
	 */
	public String getTrea_ref_num() {
		return trea_ref_num;
	}

	/**
	 * @param trea_ref_num the trea_ref_num to set
	 */
	public void setTrea_ref_num(String trea_ref_num) {
		this.trea_ref_num = trea_ref_num;
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

	/**
	 * @return the value_date
	 */
	public Date getValue_date() {
		return value_date;
	}

	/**
	 * @param value_date the value_date to set
	 */
	public void setValue_date(Date value_date) {
		this.value_date = value_date;
	}

	/**
	 * @return the vfd_date
	 */
	public Date getVfd_date() {
		return vfd_date;
	}

	/**
	 * @param vfd_date the vfd_date to set
	 */
	public void setVfd_date(Date vfd_date) {
		this.vfd_date = vfd_date;
	}

	/**
	 * @return the vfd_user_id
	 */
	public String getVfd_user_id() {
		return vfd_user_id;
	}

	/**
	 * @param vfd_user_id the vfd_user_id to set
	 */
	public void setVfd_user_id(String vfd_user_id) {
		this.vfd_user_id = vfd_user_id;
	}

	/**
	 * @return the voucher_print_flg
	 */
	public String getVoucher_print_flg() {
		return voucher_print_flg;
	}

	/**
	 * @param voucher_print_flg the voucher_print_flg to set
	 */
	public void setVoucher_print_flg(String voucher_print_flg) {
		this.voucher_print_flg = voucher_print_flg;
	}

	
}
