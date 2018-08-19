/**
 * 
 */
package com.exelon.ee.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import com.exelon.ee.enums.SexType;
import com.exelon.ee.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author ukaegbu
 *
 */
@Entity
@Table(name = "core_user")
@NamedQueries( {
	@NamedQuery(name = "User.findAll", 	query = "select c from User c where c.deleted = false order by c.id  "),
	@NamedQuery(name = "User.findUserByIdAndPassword", 	
			query = "select c from User c where lower(c.email) = :id and c.password = :password "),
	@NamedQuery(name = "User.findUserByMobileNumber", 	
		query = "select c from User c where c.mobileNumber = :phone and c.deleted = false order by c.id "),
	@NamedQuery(name = "User.findUserByEmail", 	
		query = "select c from User c where lower(c.email) = :email and c.deleted = false order by c.id ")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@SequenceGenerator(name="user_id_gen",  sequenceName="user_id_seq", initialValue = 1, allocationSize = 1)
	@Id	@GeneratedValue(generator="user_id_gen")
	private long id;
	
	@Column(length = 30, name = "first_name", unique = false, nullable = false)
	private String firstName;
	
	@Column(length = 30, name = "middle_name", unique = false, nullable = true)
	private String middleName;
	
	@Column(length = 30, name = "last_name", unique = false, nullable = false)
	private String lastName;
	
	@Column(length = 80, name = "email", unique = false, nullable = false)
	private String email;
	
	@Column(length = 30, name = "mobile_number", unique = false, nullable = false)
	private String mobileNumber;
	
	@Column(length = 30, name = "logged_in_ip", unique = false, nullable = true)
	private String loggedInIp;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sex", length=10)
	private SexType sex;
	
	@ManyToOne(/*fetch = FetchType.LAZY*/)
	@JoinColumn(name="role", nullable=false)
	private Role role;
	
	@JsonIgnore
	@NotNull
	//@Length(min = 6, max = 20)
	@Column(length = 80)
	private String password;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "profile_start_date")
	private Date profileStartDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "profile_end_date")
	private Date profileEndDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "last_log_date")
	private Date lastLoggedInDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss")
	@Temporal(TemporalType.TIME)
	@Column(name = "last_log_time")
	private Date lastLoggedInTime;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="user_status")
	private UserStatus userStatus;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_date", nullable = true)
	protected Date deletedDate;
	
	@ManyToOne
	@JoinColumn(name="deleted_by")
	protected User deletedBy;
	
	protected boolean deleted;
	
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_active_time")
	private Date lastActiveTime;
	
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expected_expiry_time")
	private Date expectedExpiryTime;
	
	@Transient
	private Date dateOfBirth;
	
	@Transient
	private String residentCountry;
	@Transient
    public String birthCountry;
	
	@Transient
    public String homeAddress;
	@Transient
    public String reference;
	
	@Transient
    public String plainTextPswd;
	
	@Transient
	private List<String> rolesList = new ArrayList<String>();
	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLoggedInDate() {
		return lastLoggedInDate;
	}

	public void setLastLoggedInDate(Date lastLoggedInDate) {
		this.lastLoggedInDate = lastLoggedInDate;
	}

	public Date getLastLoggedInTime() {
		return lastLoggedInTime;
	}

	public void setLastLoggedInTime(Date lastLoggedInTime) {
		this.lastLoggedInTime = lastLoggedInTime;
	}

	public List<String> getRolesList() {
		return rolesList;
	}

	public void setRolesList(List<String> rolesList) {
		this.rolesList = rolesList;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public String getLoggedInIp() {
		return loggedInIp;
	}


	public void setLoggedInIp(String loggedInIp) {
		this.loggedInIp = loggedInIp;
	}



	/**
	 * @return the startDate
	 */
	public Date getProfileStartDate() {
		return profileStartDate;
	}


	/**
	 * @param startDate the startDate to set
	 */
	public void setProfileStartDate(Date startDate) {
		this.profileStartDate = startDate;
	}


	/**
	 * @return the profileEndDate
	 */
	public Date getProfileEndDate() {
		return profileEndDate;
	}


	/**
	 * @param profileEndDate the profileEndDate to set
	 */
	public void setProfileEndDate(Date profileEndDate) {
		this.profileEndDate = profileEndDate;
	}


	/**
	 * @return the sex
	 */
	public SexType getSex() {
		return sex;
	}


	/**
	 * @param sex the sex to set
	 */
	public void setSex(SexType sex) {
		this.sex = sex;
	}


	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}


	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}


	

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	/**
	 * @return the residentCountry
	 */
	public String getResidentCountry() {
		return residentCountry;
	}


	/**
	 * @param residentCountry the residentCountry to set
	 */
	public void setResidentCountry(String residentCountry) {
		this.residentCountry = residentCountry;
	}


	/**
	 * @return the birthCountry
	 */
	public String getBirthCountry() {
		return birthCountry;
	}


	/**
	 * @param birthCountry the birthCountry to set
	 */
	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}


	/**
	 * @return the homeAddress
	 */
	public String getHomeAddress() {
		return homeAddress;
	}


	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}


	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}


	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}


	/**
	 * @return the plainTextPswd
	 */
	public String getPlainTextPswd() {
		return plainTextPswd;
	}


	/**
	 * @param plainTextPswd the plainTextPswd to set
	 */
	public void setPlainTextPswd(String plainTextPswd) {
		this.plainTextPswd = plainTextPswd;
	}


	/**
	 * @return the userStatus
	 */
	public UserStatus getUserStatus() {
		return userStatus;
	}


	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}



	/**
	 * @return the deletedDate
	 */
	public Date getDeletedDate() {
		return deletedDate;
	}


	/**
	 * @param deletedDate the deletedDate to set
	 */
	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}


	/**
	 * @return the deletedBy
	 */
	public User getDeletedBy() {
		return deletedBy;
	}


	/**
	 * @param deletedBy the deletedBy to set
	 */
	public void setDeletedBy(User deletedBy) {
		this.deletedBy = deletedBy;
	}


	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}


	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	/**
	 * @return the lastActiveTime
	 */
	public Date getLastActiveTime() {
		return lastActiveTime;
	}


	/**
	 * @param lastActiveTime the lastActiveTime to set
	 */
	public void setLastActiveTime(Date lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}


	/**
	 * @return the expectedExpiryTime
	 */
	public Date getExpectedExpiryTime() {
		return expectedExpiryTime;
	}


	/**
	 * @param expectedExpiryTime the expectedExpiryTime to set
	 */
	public void setExpectedExpiryTime(Date expectedExpiryTime) {
		this.expectedExpiryTime = expectedExpiryTime;
	}


}
