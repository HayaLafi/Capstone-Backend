package com.example.Employee.Controller;
import com.example.Employee.Model.Entities.Employee;
import com.example.Employee.Model.Entities.Holiday;
import com.example.Employee.Model.Service.HolidayService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/holiday")
public class HolidayController {
    @Value("${upload.path}")
    private String uploadLocation;

    private HolidayService holidayService;
    @Autowired
    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }
    @GetMapping
    public List<Holiday> getHolidays() {
        return holidayService.getHolidays();
    }
    @GetMapping(path = "{holidayId}")
    public Optional<Holiday> getHoliday(@PathVariable(name = "holidayId") Integer holidayId) {
        return holidayService.getHoliday(holidayId) ;
    }
    @PostMapping(path = "add")
    public void registerNewHoliday(@RequestBody Holiday holiday){
        holidayService.addNewHoliday(holiday);
    }


    @DeleteMapping(path = "delete/{HolidayId}")
    public void deleteHoliday(@PathVariable ("HolidayId") String HolidayId){
        int holyID= Integer.parseInt(HolidayId);
        holidayService.deleteHoliday(holyID);
    }

    @PostMapping(path="/New", consumes = {"multipart/form-data"})
    public Void fileUpload(@RequestParam MultipartFile file , @RequestParam String holidayStr ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Holiday holiday   = mapper.readValue(holidayStr, Holiday.class) ;
        try {
            File directory = new File(uploadLocation);
            if (!directory.exists()) {
                directory.mkdir();
            }
            byte[] bytes = file.getBytes();
            Path path = Paths.get(  uploadLocation + file.getOriginalFilename());
            Files.write(path, bytes);


            holiday.setPhoto("http://localhost:8080"+ path.toString());

        }  catch (IOException e) {
            e.printStackTrace();
        }
        holidayService.addNewHoliday(holiday);

        return null;
    }
}
