package com.dailycodebuffer.Springboottutorial.repository;

import com.dailycodebuffer.Springboottutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    private TestEntityManager testEntityManager;


    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Mechanical Engineering")
                .departmentCode("ME-01")
                .departmentAddress("Viet Nam")
                .build();
        testEntityManager.persist(department);
    }

    public void WhenFindByIdThenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Mechanical Engineering");
    }

}