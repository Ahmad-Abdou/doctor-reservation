package com.doctor.doctorreservation.service;


import com.doctor.doctorreservation.entity.Patient;
import com.doctor.doctorreservation.repository.DatesRepository;
import com.doctor.doctorreservation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
    private DatesRepository datesRepository;

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Autowired
    public void setDatesRepository(DatesRepository datesRepository) {
        this.datesRepository = datesRepository;
    }

    @Override
    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findById(long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent()){
            return patient.get();
        }
      throw new IllegalStateException("Patient not found");
    }
}
