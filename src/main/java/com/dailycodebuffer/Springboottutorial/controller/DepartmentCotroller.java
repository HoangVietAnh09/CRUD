package com.dailycodebuffer.Springboottutorial.controller;

import com.dailycodebuffer.Springboottutorial.Eror.DepartmentNotFoundException;
import com.dailycodebuffer.Springboottutorial.entity.Department;
import com.dailycodebuffer.Springboottutorial.service.DepartmentService;
import com.dailycodebuffer.Springboottutorial.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class DepartmentCotroller {
    @Autowired
    private DepartmentService departmentService;

//    private final Logger logger = LoggerFactory.getLogger(DepartmentCotroller.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
//        logger.info("Inside saveDepartment");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
//        logger.info("Inside saveDepartment list");
        return departmentService.fetchDepartmentsList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentByID(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
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
