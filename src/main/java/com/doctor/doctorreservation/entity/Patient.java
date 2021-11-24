package com.doctor.doctorreservation.entity;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private User user;
    private String bookedDates;
    @OneToOne
    private DatesCondition datesCondition;
}
