package com.example.Employee.Model.Repository;

import com.example.Employee.Model.Entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
