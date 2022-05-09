package com.example.medicalcare.repository;

import com.example.medicalcare.entity.Hospital;
import com.example.medicalcare.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicesRepository extends JpaRepository<Services,Integer> {

    static List<Services> findAllByHospital(Hospital hospital) {
        return null;
    }


}
