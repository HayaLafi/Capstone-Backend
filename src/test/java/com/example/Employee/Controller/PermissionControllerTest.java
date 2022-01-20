package com.example.Employee.Controller;

import com.example.Employee.Model.Entities.Employee;
import com.example.Employee.Model.Entities.Permission;
import com.example.Employee.Model.Service.PermissionService;
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

class PermissionControllerTest {
    @Mock
    PermissionService permissionService;
    @InjectMocks
    PermissionController permissionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPermissions() {
        when(permissionService.getPermissions()).thenReturn(Arrays.<Permission>asList(new Permission(0, "title", "description", "date", "starting_hour", "ending_hour", new Employee(0, "name", "email", 0, "password", "photo"))));

        List<Permission> result = permissionController.getPermissions();
        Assertions.assertEquals(Arrays.<Permission>asList(new Permission(0, "title", "description", "date", "starting_hour", "ending_hour", new Employee(0, "name", "email", 0, "password", "photo"))), result);
    }

    @Test
    void testGetPermission() {
        when(permissionService.getPermission(anyInt())).thenReturn(null);

        Optional<Permission> result = permissionController.getPermission(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testRegisterNewPermission() {
        permissionController.registerNewPermission(new Permission(0, "title", "description", "date", "starting_hour", "ending_hour", new Employee(0, "name", "email", 0, "password", "photo")));
    }

    @Test
    void testDeleteService() {
        permissionController.deleteService("permissionId");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme