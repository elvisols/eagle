/**
 * 
 */
package ng.exelon.ee.finacle.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * @author OJI
 *
 */
@Entity
@Table(name="tbaadm.eab")
@NamedQueries( {
	@NamedQuery(name = "EAB.findByAcidAndDate", 
			query = "select c from EAB c  where c.id.acid = :acid and  c.id.eod_date <= :eodDate and c.end_eod_date >= :eodDate")
})
public class EAB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EABPK id;
	
	private BigDecimal tran_date_bal        ;//number(25,4),
	private BigDecimal tran_date_tot_tran   ;//number(25,4),
	private BigDecimal value_date_bal       ;//number(25,4),
	private BigDecimal value_date_tot_tran  ;//number(25,4),
	private Date end_eod_date         ;//date,
	private String lchg_user_id         ;//varchar2(15 char),
	private Date lchg_time            ;//date,
	private String rcre_user_id         ;//varchar2(15 char),
	private Date rcre_time            ;//date,
	private Long ts_cnt               ;//number(5),
	private String eab_crncy_code       ;//varchar2(3 char),
	private String bank_id              ;//varchar2(8 char)
	/**
	 * @return the id
	 */
	public EABPK getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(EABPK id) {
		this.id = id;
	}
	/**
	 * @return the tran_date_bal
	 */
	public BigDecimal getTran_date_bal() {
		return tran_date_bal;
	}
	/**
	 * @param tran_date_bal the tran_date_bal to set
	 */
	public void setTran_date_bal(BigDecimal tran_date_bal) {
		this.tran_date_bal = tran_date_bal;
	}
	/**
	 * @return the tran_date_tot_tran
	 */
	public BigDecimal getTran_date_tot_tran() {
		return tran_date_tot_tran;
	}
	/**
	 * @param tran_date_tot_tran the tran_date_tot_tran to set
	 */
	public void setTran_date_tot_tran(BigDecimal tran_date_tot_tran) {
		this.tran_date_tot_tran = tran_date_tot_tran;
	}
	/**
	 * @return the value_date_bal
	 */
	public BigDecimal getValue_date_bal() {
		return value_date_bal;
	}
	/**
	 * @param value_date_bal the value_date_bal to set
	 */
	public void setValue_date_bal(BigDecimal value_date_bal) {
		this.value_date_bal = value_date_bal;
	}
	/**
	 * @return the value_date_tot_tran
	 */
	public BigDecimal getValue_date_tot_tran() {
		return value_date_tot_tran;
	}
	/**
	 * @param value_date_tot_tran the value_date_tot_tran to set
	 */
	public void setValue_date_tot_tran(BigDecimal value_date_tot_tran) {
		this.value_date_tot_tran = value_date_tot_tran;
	}
	/**
	 * @return the end_eod_date
	 */
	public Date getEnd_eod_date() {
		return end_eod_date;
	}
	/**
	 * @param end_eod_date the end_eod_date to set
	 */
	public void setEnd_eod_date(Date end_eod_date) {
		this.end_eod_date = end_eod_date;
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
	 * @return the eab_crncy_code
	 */
	public String getEab_crncy_code() {
		return eab_crncy_code;
	}
	/**
	 * @param eab_crncy_code the eab_crncy_code to set
	 */
	public void setEab_crncy_code(String eab_crncy_code) {
		this.eab_crncy_code = eab_crncy_code;
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
	

}
