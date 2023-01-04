package com.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.repository.entity.DepartmentEntity;
import com.hrms.repository.entity.HRMEntity;

public interface HRMService {
	public HRMEntity getHRMAdmin(String userName,String password);
	public DepartmentEntity addDepartments(DepartmentEntity departmentEntity);
}
