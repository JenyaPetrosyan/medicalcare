package com.example.medicalcare.service;

import com.example.medicalcare.entity.Hospital;
import com.example.medicalcare.entity.Services;
import com.example.medicalcare.repository.ServicesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesService {
    private ServicesRepository servicesRepository;

    public List<Services> findAllByHospital(Hospital hospital) {
        return ServicesRepository.findAllByHospital(hospital);
    }


    public void save(Services services) {
        servicesRepository.save(services);
    }

    public void deleteById(int id) {
        servicesRepository.deleteById(id);
    }

    public List<Services> findAll() {
        return servicesRepository.findAll();
    }

    public Services findById(int companyId) {
        return servicesRepository.findById(companyId).orElse(null);
    }


}
