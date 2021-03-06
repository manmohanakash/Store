package com.StoreApp.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;


@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name="email",columnNames = "email"),@UniqueConstraint(name="user_name",columnNames = "userName")})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( columnDefinition="INTEGER(10) UNSIGNED")
	private Integer userId;

	@Column(length=25,nullable=false)
	private String userName;
	
	@Column(length=25,nullable=false)
	private String password;
	
	@Email
	@Column(length=50,nullable=false)
	private String email;
	
	@Column( length=10,nullable=false)
	private String userType;
	
	@Column( length=10,nullable=false)
	private String accountStatus;
	
	@Column(nullable=false)
	private Date lastLogin;
	
	@OneToOne
	@JoinColumn(name="customer_id",columnDefinition="INTEGER(10) UNSIGNED UNIQUE",foreignKey=@ForeignKey(name="Fk_customer_customerId"))
	private Customer customer;
	
	User(){}


	public User(Integer userId, String userName, String password, String email, String userType, String accountStatus,
			Date lastLogin, Customer customer) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.userType = userType;
		this.accountStatus = accountStatus;
		this.lastLogin = lastLogin;
		this.customer = customer;
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserID(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", userType=" + userType + ", accountStatus=" + accountStatus + ", lastLogin=" + lastLogin
				+ ", customerId=" + customer + "]";
	}

	
	
}