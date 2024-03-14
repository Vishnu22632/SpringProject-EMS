package com.springproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.model.Department;
import com.springproject.repository.DepartmentRepository;
import com.springproject.service.DepartmentService;

@Service
public class DepartmentServiceImple implements DepartmentService {

	@Autowired
	private DepartmentRepository deptRepo;
	
	
	@Override
	public void addDept(Department dept) {
		deptRepo.save(dept);
		
	}

	@Override
	public void deleteDept(int id) {
		deptRepo.deleteById(id);;
		
	}

	@Override
	public void updateDept(Department dept) {
		deptRepo.save(dept);
		
	}

	@Override
	public Department getDeptById(int id) {
		return deptRepo.findById(id).get();
	}

	@Override
	public List<Department> getAllDepts() {		
		return deptRepo.findAll();
	}

}
