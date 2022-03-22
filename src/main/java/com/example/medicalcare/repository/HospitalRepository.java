package com.example.medicalcare.repository;

import com.example.medicalcare.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {


}
