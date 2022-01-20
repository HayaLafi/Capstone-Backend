package com.example.Employee.Controller;


import com.example.Employee.Model.Entities.Employee;
import com.example.Employee.Model.Service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "api/employee")
public class EmployeeController {
    @Value("${upload.path}")
    private String uploadLocation;

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }


    @GetMapping(path = "{employeeId}")
    public Optional<Employee> getEmployee(@PathVariable(name = "employeeId") Integer employeeId) {
        return employeeService.getEmployee(employeeId);
    }
    @GetMapping(path = "login")
    public String checkLogin(@RequestParam (name = "email") String email ,
                             @RequestParam (name = "password") String password ) {
        return employeeService.getCheck(email,password);

    }
    @PostMapping(path= "add")
    public void registerNewEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }


    @DeleteMapping(path = "delete/{employeeId}")
    public void deleteEmployee(@PathVariable ("employeeId") Integer employeeId){
        employeeService.deleteEmployee(employeeId);
    }
    @PostMapping(path="/New", consumes = {"multipart/form-data"})
    public Void fileUpload(@RequestParam MultipartFile file , @RequestParam String employeeStr ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Employee employee  = mapper.readValue(employeeStr, Employee.class) ;
        try {
            File directory = new File(uploadLocation);
            if (!directory.exists()) {
                directory.mkdir();
            }
            byte[] bytes = file.getBytes();
            Path path = Paths.get(  uploadLocation + file.getOriginalFilename());
            Files.write(path, bytes);


            employee.setPhoto("http://localhost:8080"+ path.toString());

        }  catch (IOException e) {
            e.printStackTrace();
        }
        employeeService.addNewEmployee(employee);

        return null;
    }

}
