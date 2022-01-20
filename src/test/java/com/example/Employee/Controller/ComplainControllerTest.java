package com.example.Employee.Controller;

import com.example.Employee.Model.Entities.Complain;
import com.example.Employee.Model.Entities.Employee;
import com.example.Employee.Model.Service.ComplainService;
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

class ComplainControllerTest {
    @Mock
    ComplainService complainService;
    @InjectMocks
    ComplainController complainController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetComplains() {
        when(complainService.getComplains()).thenReturn(Arrays.<Complain>asList(new Complain(0, "type", "description", new Employee(0, "name", "email", 0, "password", "photo"))));

        List<Complain> result = complainController.getComplains();
        Assertions.assertEquals(Arrays.<Complain>asList(new Complain(0, "type", "description", new Employee(0, "name", "email", 0, "password", "photo"))), result);
    }

    @Test
    void testGetComplain() {
        when(complainService.getComplain(anyInt())).thenReturn(null);

        Optional<Complain> result = complainController.getComplain(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testRegisterNewComplain() {
        complainController.registerNewComplain(new Complain(0, "type", "description", new Employee(0, "name", "email", 0, "password", "photo")));
    }

    @Test
    void testDeleteComplain() {
        complainController.deleteComplain(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme