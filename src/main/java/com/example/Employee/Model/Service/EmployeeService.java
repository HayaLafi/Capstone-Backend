package com.example.Employee.Model.Service;

import com.example.Employee.Model.Entities.Employee;
import com.example.Employee.Model.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);

    }
    public void deleteEmployee(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
        //boolean exist = employeeRepository.existsById(employeeId);
        // put a condition on 'exist'. if exist then delete
    }
    public String getCheck(String email ,String password) {
        if( employeeRepository.existsByEmail(email) == true){
            String pass = employeeRepository.findPasswordByEmail(email);
            if (pass.equals(password)){
                return "authenticated" ;
            }
            else {
                return "Password does not match"; }
        }

        return "Username not found";
    }
}