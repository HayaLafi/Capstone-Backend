package com.example.Employee.Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int holidayId;
    private String date;
    private String starting_date ;
    private String ending_date ;
    private String title;
    private String description;
    private String photo ;



    @ManyToOne
    @JoinColumn(name= "employee_id" ,referencedColumnName = "id")
    private Employee employee;

    public Holiday(int holidayId, String date, String title, String description, String starting_date , String photo , String ending_date,  Employee employee) {
        this.holidayId = holidayId;
        this.date = date;
        this.title = title;
        this.description = description;
        this.employee = employee;
        this.starting_date = starting_date ;
        this.ending_date= ending_date ;
        this.photo = photo ;
    }

    public Holiday() {
    }


    public int getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(int holidayId) {
        this.holidayId = holidayId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public String getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(String starting_date) {
        this.starting_date = starting_date;
    }

    public String getEnding_date() {
        return ending_date;
    }

    public void setEnding_date(String ending_date) {
        this.ending_date = ending_date;
    }
}
