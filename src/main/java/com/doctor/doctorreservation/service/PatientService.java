package com.doctor.doctorreservation.service;

import com.doctor.doctorreservation.entity.Patient;



public interface PatientService {

    Patient create (Patient patient);

    Patient findById(long id);
}
