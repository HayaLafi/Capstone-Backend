package com.example.Employee.Model.Service;

import com.example.Employee.Model.Entities.Employee;
import com.example.Employee.Model.Entities.Holiday;
import com.example.Employee.Model.Repository.HolidayRepository;
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

class HolidayServiceTest {
    @Mock
    HolidayRepository holidayRepository;
    @InjectMocks
    HolidayService holidayService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetHolidays() {
        List<Holiday> result = holidayService.getHolidays();
        Assertions.assertEquals(Arrays.<Holiday>asList(new Holiday(0, "date", "title", "description", "starting_date", "photo", "ending_date", new Employee(0, "name", "email", 0, "password", "photo"))), result);
    }

    @Test
    void testGetHoliday() {
        Optional<Holiday> result = holidayService.getHoliday(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddNewHoliday() {
        holidayService.addNewHoliday(new Holiday(0, "date", "title", "description", "starting_date", "photo", "ending_date", new Employee(0, "name", "email", 0, "password", "photo")));
    }

    @Test
    void testDeleteHoliday() {
        holidayService.deleteHoliday(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme