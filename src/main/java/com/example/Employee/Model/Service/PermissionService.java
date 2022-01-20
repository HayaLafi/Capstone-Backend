package com.example.Employee.Model.Service;
import com.example.Employee.Model.Entities.Employee;
import com.example.Employee.Model.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Employee.Model.Repository.PermissionRepository;
import com.example.Employee.Model.Entities.Permission ;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {
    private PermissionRepository permissionRepository ;
    private EmployeeRepository employeeRepository ;
    @Autowired
    public PermissionService(PermissionRepository permissionRepository ,EmployeeRepository employeeRepository) {this.permissionRepository=permissionRepository;
    this.employeeRepository = employeeRepository ; }

    public List<Permission> getPermissions() {
        return permissionRepository.findAll();
    }

    public Optional<Permission> getPermission(Integer permissionId) {
        return permissionRepository.findById(permissionId);
    }

    public void addNewPermission(Permission permission) {
        Permission permission2 = permissionRepository.save(permission);
       /* final Integer[] i = new Integer[1];
        System.out.println("hello");
         permission.getPermissionemployee().forEach(employee -> {
           i[0] = employee.getId() ;
        } );
        System.out.println(i[0]);
       Employee employee =  employeeRepository.getById( i[0]) ;
            employee.getEmpolyeePermission().add(permission) ;
           permission.getPermissionemployee().add(employee);

        employee.getEmpolyeePermission().add(permission2) ;

        employeeRepository.save(employee) ;*/

    }
    public void deletePermission(Integer permissionId) {
        permissionRepository.deleteById(permissionId);
        //boolean exist = employeeRepository.existsById(employeeId);
        // put a condition on 'exist'. if exist then delete
    }

}
