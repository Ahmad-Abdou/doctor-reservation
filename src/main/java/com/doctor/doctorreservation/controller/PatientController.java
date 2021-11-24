package com.doctor.doctorreservation.controller;


import com.doctor.doctorreservation.entity.Patient;
import com.doctor.doctorreservation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@CrossOrigin("*")
public class PatientController {

   private PatientRepository patientRepository;

   @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PostMapping()
    public ResponseEntity<Patient> create(@RequestBody Patient patient){
       patient.setUser(RegisterUser.signedUser);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(patientRepository.save(patient));
    }
    @GetMapping
    public ResponseEntity<List<Patient>>findAllPatient(){
       return ResponseEntity.status(HttpStatus.OK).body(patientRepository.findAll());
    }
}
