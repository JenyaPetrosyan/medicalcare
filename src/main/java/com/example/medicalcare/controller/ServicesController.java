package com.example.medicalcare.controller;

import com.example.medicalcare.entity.Hospital;
import com.example.medicalcare.entity.Services;
import com.example.medicalcare.service.HospitalService;
import com.example.medicalcare.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Controller
public class ServicesController {

    @Autowired
    private ServicesService servicesService;
    @Autowired
    private HospitalService hospitalService;

    @Value("${myservice.upload.paht}")
    private String imagePath;

    public ServicesController() {
    }

    @GetMapping("/services")
    public String itemsPage(ModelMap map) {
        List<Services> items = servicesService.findAll();
        map.addAttribute("items", items);
        return "services";
    }

    @GetMapping("/services/byHospital/{id}")
    public String servicesByHospitalPage(ModelMap map, @PathVariable("id") int id) {
        Hospital hospital = hospitalService.findById(id);
        List<Services> services = servicesService.findAllByHospital(hospital);
        map.addAttribute("services", services);
        return "services";
    }

    @GetMapping("/services/add")
    public String addServicesPage(ModelMap map) {
        map.addAttribute("hospitals", hospitalService.findAll());
        return "saveServices";
    }

  /*  @PostMapping("/services/add")
    public String addServices(@ModelAttribute Services services,
                              @RequestParam("picture") MultipartFile file) {

        return
    }*/

}
