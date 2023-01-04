package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.repository.entity.DepartmentEntity;
import com.hrms.repository.entity.HRMEntity;
@Repository
public interface HRMRepository extends JpaRepository<HRMEntity, Integer> {

	public HRMEntity findByUserNameAndPassword(String userName, String password);
	public HRMEntity findByUserId(Integer userId);
	
}
