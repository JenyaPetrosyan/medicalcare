package com.example.medicalcare.service;

import com.example.medicalcare.entity.Hospital;
import com.example.medicalcare.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalService {


    private final HospitalRepository hospitalRepository;


    public void save(Hospital hospital ) {
       hospitalRepository.save(hospital);
    }

    public void deleteById(int id) {
       hospitalRepository.deleteById(id);
    }

    public List<Hospital> findAll() {
        return hospitalRepository.findAll();
    }

    public Hospital findById(int companyId) {
        return hospitalRepository.findById(companyId).orElse(null);
    }


}
