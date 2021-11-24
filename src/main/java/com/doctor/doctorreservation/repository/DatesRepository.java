package com.doctor.doctorreservation.repository;

import com.doctor.doctorreservation.entity.DatesCondition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatesRepository extends JpaRepository<DatesCondition,Long> {
    List<DatesCondition> findAllByStatus(String status);

}
