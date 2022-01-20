package com.example.Employee.Model.Repository;
import com.example.Employee.Model.Entities.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplainRepository extends JpaRepository <Complain,Integer> {
}
