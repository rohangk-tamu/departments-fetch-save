package com.hydra.Springboot.tutorial.service;

import com.hydra.Springboot.tutorial.entity.Department;
import com.hydra.Springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentAddress("Pune")
                .departmentCode("CSCE-685")
                .departmentId(1L)
                .departmentName("Directed Studies")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Directed Studies"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on valid department name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "Directed Studies";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}