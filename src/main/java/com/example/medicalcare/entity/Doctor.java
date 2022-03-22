package com.example.medicalcare.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctor")
@Builder
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String position;
    private Gender gender;
    private String cardImg;//??
    @ManyToOne
    private Hospital hospital;

}

