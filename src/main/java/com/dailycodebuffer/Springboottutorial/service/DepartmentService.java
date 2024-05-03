package com.dailycodebuffer.Springboottutorial.service;

import com.dailycodebuffer.Springboottutorial.Eror.DepartmentNotFoundException;
import com.dailycodebuffer.Springboottutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentsList();

    public Department fetchDepartmentId(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByDepartmentName(String departmentName);

}
