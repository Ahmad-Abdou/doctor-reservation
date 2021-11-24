package com.doctor.doctorreservation.controller;

import com.doctor.doctorreservation.entity.DatesCondition;
import com.doctor.doctorreservation.service.DateService;
import com.doctor.doctorreservation.repository.DatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/dates")
@CrossOrigin("*")
public class DatesController {

   private DateService dateService;
   private DatesRepository datesRepository;

   @Autowired
    public void setDatesRepository(DatesRepository datesRepository) {
        this.datesRepository = datesRepository;
    }

    @Autowired
    public void setDateService(DateService dateService) {
        this.dateService = dateService;
    }

    @PostMapping
    public ResponseEntity<DatesCondition> create(@RequestBody DatesCondition datesCondition){
       datesCondition.setStatus("AVAILABLE");
        return ResponseEntity.status(HttpStatus.OK).body(dateService.create(datesCondition));
    }
    @GetMapping
    public ResponseEntity<List<DatesCondition>> findAllDates(){
        return ResponseEntity.status(HttpStatus.OK).body(datesRepository.findAll());
    }

}
