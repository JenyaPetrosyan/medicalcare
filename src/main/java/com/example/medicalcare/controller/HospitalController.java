package com.example.medicalcare.controller;

import com.example.medicalcare.entity.Hospital;

import com.example.medicalcare.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping("/hospital")
    public String companyPage(ModelMap map) {
        List<Hospital> hospitals = hospitalService.findAll();
        map.addAttribute("hospitals", hospitals);
        return "hospital";
    }


    @PostMapping("/addHospital")
    public String addCompany(@ModelAttribute Hospital hospital){
        hospitalService.save(hospital);
        return "redirect:/hospital";
    }


    @GetMapping("/deleteHospital/{id}")
    public String deleteHospital(@PathVariable("id") int id) {
        hospitalService.deleteById(id);
        return "redirect:/hospital";
    }



}
