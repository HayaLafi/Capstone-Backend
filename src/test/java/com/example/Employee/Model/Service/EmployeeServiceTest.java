package com.example.Employee.Model.Service;

import com.example.Employee.Model.Entities.Employee;
import com.example.Employee.Model.Repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class EmployeeServiceTest {
    @Mock
    EmployeeRepository employeeRepository;
    @InjectMocks
    EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetEmployees() {
        List<Employee> result = employeeService.getEmployees();
        Assertions.assertEquals(Arrays.<Employee>asList(new Employee(0, "name", "email", 0, "password", "photo")), result);
    }

    @Test
    void testGetEmployee() {
        Optional<Employee> result = employeeService.getEmployee(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddNewEmployee() {
        employeeService.addNewEmployee(new Employee(0, "name", "email", 0, "password", "photo"));
    }

    @Test
    void testDeleteEmployee() {
        employeeService.deleteEmployee(Integer.valueOf(0));
    }

    @Test
    void testGetCheck() {
        when(employeeRepository.findPasswordByEmail(anyString())).thenReturn("findPasswordByEmailResponse");
        when(employeeRepository.existsByEmail(anyString())).thenReturn(Boolean.TRUE);

        String result = employeeService.getCheck("email", "password");
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme