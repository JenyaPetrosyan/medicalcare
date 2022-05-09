package com.example.medicalcare.controller;

import com.example.medicalcare.entity.Hospital;

import com.example.medicalcare.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HospitalController {
    @Autowired
    private final HospitalService hospitalService;

    @GetMapping("/hospital")
    public String companyPage(ModelMap map) {
        List<Hospital> hospitals = hospitalService.findAll();
        map.addAttribute("hospitals", hospitals);
        return "hospital";
    }


    @PostMapping("/addHospital")
    public String addCompany(@ModelAttribute Hospital hospital) {
        hospitalService.save(hospital);
        return "redirect:hospital";
    }


    @DeleteMapping("/Hospital/{id}")
    public String deleteHospital(@PathVariable("id") int id) {
        hospitalService.deleteById(id);
        return "redirect:/";


    }

    @GetMapping("/editHospital/{id}")
    public String editHospitalPage(ModelMap map, @PathVariable("id") int id) {
        map.addAttribute("hospital", hospitalService.findById(id));
        return "hospital";

    }

}
