package com.example.Employee.Model.Service;

import com.example.Employee.Model.Entities.Employee;
import com.example.Employee.Model.Entities.Holiday;
import com.example.Employee.Model.Repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

@Service
public class HolidayService {

    private HolidayRepository holidayRepository;

    @Autowired
    public HolidayService(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    public List<Holiday> getHolidays() {
        return holidayRepository.findAll();
    }

    public Optional<Holiday> getHoliday(Integer HolidayId) {
        return holidayRepository.findById(HolidayId);
    }

    public void addNewHoliday(Holiday holiday) {
        holidayRepository.save(holiday);

    }
    public void deleteHoliday(Integer HolidayId) {
        holidayRepository.deleteById(HolidayId);

    }
}
