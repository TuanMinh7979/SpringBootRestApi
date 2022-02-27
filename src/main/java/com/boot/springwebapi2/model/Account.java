package com.boot.springwebapi2.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "accounts")
public class Account {
	public Account(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Set<Role> getRole() {
		return roles;
	}

	public void setRole(Set<Role> role) {
		this.roles = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String password;
	private String gender;
	private String fullName;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	//de ta nhan post la String va tu dong convert qua luon khong can 
	//simpleDateFormat nua 
	private Date birthday;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "account_role", joinColumns = {
			@JoinColumn(name = "account_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })

	private Set<Role> roles;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private Set<Invoice> invoices;

}
