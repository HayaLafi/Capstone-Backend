package com.example.Employee.Model.Service;

import com.example.Employee.Model.Entities.Complain;
import com.example.Employee.Model.Entities.Employee;
import com.example.Employee.Model.Repository.ComplainRepository;
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

class ComplainServiceTest {
    @Mock
    ComplainRepository complainRepository;
    @InjectMocks
    ComplainService complainService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetComplains() {
        List<Complain> result = complainService.getComplains();
        Assertions.assertEquals(Arrays.<Complain>asList(new Complain(0, "type", "description", new Employee(0, "name", "email", 0, "password", "photo"))), result);
    }

    @Test
    void testGetComplain() {
        Optional<Complain> result = complainService.getComplain(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddNewComplain() {
        complainService.addNewComplain(new Complain(0, "type", "description", new Employee(0, "name", "email", 0, "password", "photo")));
    }

    @Test
    void testDeleteComplain() {
        complainService.deleteComplain(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme