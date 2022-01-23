package com.example.Employee.Controller;
import com.example.Employee.Model.Entities.Complain;
import com.example.Employee.Model.Service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "https://employeeservices.herokuapp.com/")
@RestController
@RequestMapping(path = "api/complain")
public class ComplainController {
    private ComplainService complainService ;

    @Autowired
    public ComplainController(ComplainService complainService){this.complainService = complainService;}
    @GetMapping
    public List<Complain> getComplains() {
        return complainService.getComplains() ;
    }

    @GetMapping(path = "{complainId}")
    public Optional<Complain> getComplain(@PathVariable(name = "complainId") Integer complainId) {
        return complainService.getComplain(complainId);
    }

    @PostMapping(path = "add")
    public void registerNewComplain(@RequestBody Complain complain){
        complainService.addNewComplain(complain);
    }


    @DeleteMapping(path = "delete/{complainId}")
    public void deleteComplain(@PathVariable ("complainId") Integer complainId){

        complainService.deleteComplain(complainId);
    }
}
