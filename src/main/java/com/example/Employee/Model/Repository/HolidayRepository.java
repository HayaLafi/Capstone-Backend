package com.example.Employee.Model.Repository;

import com.example.Employee.Model.Entities.Employee;
import com.example.Employee.Model.Entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository  extends JpaRepository<Holiday, Integer> {
}