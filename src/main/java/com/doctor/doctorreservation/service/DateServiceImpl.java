package com.doctor.doctorreservation.service;

import com.doctor.doctorreservation.entity.DatesCondition;
import com.doctor.doctorreservation.repository.DatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class DateServiceImpl implements DateService {

       private DatesRepository datesRepository;

       @Autowired
    public void setDatesRepository(DatesRepository datesRepository) {
        this.datesRepository = datesRepository;
    }

    @Override
    public DatesCondition create(DatesCondition date) {
           return datesRepository.save(date);

    }

    @Override
    public List<DatesCondition> findAllDatesByStatus(String status) {
        return datesRepository.findAllByStatus(status);
    }


}
