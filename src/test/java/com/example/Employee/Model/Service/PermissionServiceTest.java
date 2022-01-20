package com.example.Employee.Model.Service;

import com.example.Employee.Model.Entities.Employee;
import com.example.Employee.Model.Entities.Permission;
import com.example.Employee.Model.Repository.EmployeeRepository;
import com.example.Employee.Model.Repository.PermissionRepository;
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

class PermissionServiceTest {
    @Mock
    PermissionRepository permissionRepository;
    @Mock
    EmployeeRepository employeeRepository;
    @InjectMocks
    PermissionService permissionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPermissions() {
        List<Permission> result = permissionService.getPermissions();
        Assertions.assertEquals(Arrays.<Permission>asList(new Permission(0, "title", "description", "date", "starting_hour", "ending_hour", new Employee(0, "name", "email", 0, "password", "photo"))), result);
    }

    @Test
    void testGetPermission() {
        Optional<Permission> result = permissionService.getPermission(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddNewPermission() {
        permissionService.addNewPermission(new Permission(0, "title", "description", "date", "starting_hour", "ending_hour", new Employee(0, "name", "email", 0, "password", "photo")));
    }

    @Test
    void testDeletePermission() {
        permissionService.deletePermission(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme