package com.example.Employee.Model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Employee.Model.Repository.ComplainRepository;
import com.example.Employee.Model.Entities.Complain ;

import java.util.List;
import java.util.Optional;
@Service
public class ComplainService {
    private ComplainRepository complainRepository ;
    @Autowired
    public ComplainService(ComplainRepository complainRepository){
        this.complainRepository = complainRepository ;
    }
    public List<Complain> getComplains() {
        return complainRepository.findAll();
    }

    public Optional<Complain> getComplain(Integer complainId) {
        return complainRepository.findById(complainId);
    }

    public void addNewComplain(Complain complain) {
        complainRepository.save(complain);

    }
    public void deleteComplain(Integer complainId) {
        complainRepository.deleteById(complainId);
    }
}
