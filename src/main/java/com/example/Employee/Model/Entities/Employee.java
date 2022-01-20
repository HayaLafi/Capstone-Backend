package com.example.Employee.Model.Entities;
        import com.fasterxml.jackson.annotation.JsonIgnore;
        import org.aspectj.weaver.ast.Or;
        import javax.persistence.*;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Set;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private int mobile;
    private String password;
    private String photo;


    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Holiday> items = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Complain> complains = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Permission> permissions = new ArrayList<>();


    public Employee(int id, String name, String email, int mobile, String password, String photo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.photo = photo;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Holiday> getItems() {
        return items;
    }

    public void setItems(List<Holiday> items) {
        this.items = items;
    }

    public List<Complain> getComplains() {
        return complains;
    }

    public void setComplains(List<Complain> complains) {
        this.complains = complains;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getPhoto() {
        return photo;
    }


    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                ", password='" + password + '\'' +
                ", holiday=" + getItems().listIterator() +
                '}';
    }
}