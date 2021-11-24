package com.doctor.doctorreservation.service;


import com.doctor.doctorreservation.entity.DatesCondition;
import java.util.List;


public interface DateService {

    DatesCondition create (DatesCondition date);

    List<DatesCondition> findAllDatesByStatus(String status);


}
