package com.example.Employee.Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int permissionId;
    private String title;
    private String description;
    private String date ;
    private String starting_hour ;
    private String ending_hour ;


    @ManyToOne
    @JoinColumn(name= "employee_id" ,referencedColumnName = "id")
    private Employee employee;



    public Permission() {
    }

    public Permission(int permissionId, String title, String description, String date, String starting_hour, String ending_hour ,  Employee employee) {
        this.permissionId = permissionId;
        this.title = title;
        this.description = description;
        this.date = date;
        this.starting_hour = starting_hour;
        this.ending_hour = ending_hour;
        this.employee = employee ;

    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStarting_hour() {
        return starting_hour;
    }

    public void setStarting_hour(String starting_hour) {
        this.starting_hour = starting_hour;
    }

    public String getEnding_hour() {
        return ending_hour;
    }

    public void setEnding_hour(String ending_hour) {
        this.ending_hour = ending_hour;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
