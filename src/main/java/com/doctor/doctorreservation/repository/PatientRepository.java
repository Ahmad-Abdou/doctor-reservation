package com.doctor.doctorreservation.repository;

import com.doctor.doctorreservation.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
