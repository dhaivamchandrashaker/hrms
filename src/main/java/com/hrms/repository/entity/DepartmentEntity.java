package com.hrms.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="DEP_TL")
@Data
public class DepartmentEntity {
	@Id
	@GeneratedValue
	@Column
	private Integer departmentId;
	private String departmentName;
	private String department;
	private String departmentStatus;
	//private Date departmentCreatedOn;
}
