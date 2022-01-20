package com.example.Employee.Model.Entities;

import javax.persistence.*;

@Entity
@Table
public class Complain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String description ;


    @ManyToOne
    @JoinColumn(name= "employee_id" ,referencedColumnName = "id")
    private Employee employee;

    public Complain(int id, String type, String description, Employee employee) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.employee = employee;
    }

    public Complain() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
