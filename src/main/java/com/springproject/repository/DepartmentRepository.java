package com.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
