package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.repository.entity.DepartmentEntity;
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer>{

}
