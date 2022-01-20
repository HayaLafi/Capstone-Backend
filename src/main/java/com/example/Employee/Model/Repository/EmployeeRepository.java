package com.example.Employee.Model.Repository;

import com.example.Employee.Model.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT password FROM Employee WHERE email = :email" )
    String findPasswordByEmail(@Param("email") String email);
    @Query("select case when count(email) > 0 then true else false end from Employee where email = :email")
    Boolean existsByEmail(@Param("email") String email);
}
