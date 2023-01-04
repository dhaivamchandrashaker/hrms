package com.hrms.repository.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="HRMS_TL")
@Data
public class HRMEntity {
	@Id
	@GeneratedValue
	@Column
	private Integer userId;
	@Column(name="USER_NAME")
	private String  userName;
	@Column(name="EMAIL_ID")
	private String  emailId;
	@Column(name="MOBILE_NUMBER")
	private String  mobileNumber;
	@Column(name="PASSWORD")
	private String password;
	
}
