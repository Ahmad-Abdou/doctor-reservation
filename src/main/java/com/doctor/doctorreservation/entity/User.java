package com.doctor.doctorreservation.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String phone;
    private String password;
    @Column(unique = true)
    private String email;
    @Column(unique = true, nullable = false,length = 12)
    private String personalNumber;
}
