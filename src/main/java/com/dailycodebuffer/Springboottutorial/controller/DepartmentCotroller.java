package com.dailycodebuffer.Springboottutorial.controller;

import com.dailycodebuffer.Springboottutorial.entity.Department;
import com.dailycodebuffer.Springboottutorial.service.DepartmentService;
import com.dailycodebuffer.Springboottutorial.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentCotroller {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }
    @GetMapping("departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentsList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentByID(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentId(departmentId);
    }


    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentID(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Delete successfully!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }





}
