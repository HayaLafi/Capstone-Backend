package com.example.Employee.Controller;
import com.example.Employee.Model.Entities.Permission;
import com.example.Employee.Model.Service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "api/permission")
public class PermissionController {
    private PermissionService permissionService ;
    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }
    @GetMapping
    public List<Permission> getPermissions() {
        return permissionService.getPermissions();
    }
    @GetMapping(path = "{permissionId}")
    public Optional<Permission> getPermission(@PathVariable(name = "permissionId") Integer permissionId) {
        return permissionService.getPermission(permissionId);
    }

    @PostMapping(path = "add")
    public void registerNewPermission(@RequestBody Permission permission){
        permissionService.addNewPermission(permission);
    }


    @DeleteMapping(path = "delete/{permissionId}")
    public void deleteService(@PathVariable ("permissionId") String permissionId){
        int perID= Integer.parseInt(permissionId);
        permissionService.deletePermission(perID);
    }

}
