package com.hydra.Springboot.tutorial.service;

import com.hydra.Springboot.tutorial.entity.Department;
import com.hydra.Springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(int departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(int departmentId);

    public Department updateDepartment(int departmentId, Department department);

    public Department fetchDepartmentByName(String deptName);
}
