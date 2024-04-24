package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity

@Table(
		
		name = "tbrabbitmqdemo",	
	
		uniqueConstraints=
			{
					@UniqueConstraint(  columnNames = {"accountid", "fullname", "accountstatus"})
			}
			 
)
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name="id" )	
	long id;
	 
	 
	@Column(name="accountid")
	String accountId;
	
	@Column(name="fullname")
	String fullname;
	
	@Column(name="accountstatus")
	String accountstatus;
	
	@Column(name="camstatus")
	String camStcamstatusatus;

	public Account(long id, String accountId, String fullname, String accountstatus, String camStcamstatusatus) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.fullname = fullname;
		this.accountstatus = accountstatus;
		this.camStcamstatusatus = camStcamstatusatus;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountId=" + accountId + ", fullname=" + fullname + ", accountstatus="
				+ accountstatus + ", camStcamstatusatus=" + camStcamstatusatus + "]";
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAccountstatus() {
		return accountstatus;
	}

	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}

	public String getCamStcamstatusatus() {
		return camStcamstatusatus;
	}

	public void setCamStcamstatusatus(String camStcamstatusatus) {
		this.camStcamstatusatus = camStcamstatusatus;
	}
 

	
}
