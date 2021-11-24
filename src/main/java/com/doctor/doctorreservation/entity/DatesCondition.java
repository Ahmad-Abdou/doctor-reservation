package com.doctor.doctorreservation.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.List;


@Entity
@Data
public class DatesCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String status;
    private String availableDates;
    @ElementCollection
    private List<String> time;



}
