package com.hrms.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.repository.DepartmentRepository;
import com.hrms.repository.HRMRepository;
import com.hrms.repository.entity.DepartmentEntity;
import com.hrms.repository.entity.HRMEntity;
import com.hrms.service.HRMService;

@Service
public class HRMServiceImpl implements HRMService {

	@Autowired
	private HRMRepository hrmRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public HRMEntity getHRMAdmin(String userName, String password) {
		HRMEntity hrm1=hrmRepository.findByUserNameAndPassword(userName, password);
		return hrm1;	
		}

	@Override
	public DepartmentEntity addDepartments(DepartmentEntity departmentEntity) {
		DepartmentEntity department=null;
		department=departmentRepository.save(departmentEntity);
		return department;	}
	
	
	

}
