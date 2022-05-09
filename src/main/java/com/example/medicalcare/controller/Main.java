package com.example.medicalcare.controller;

import com.example.medicalcare.entity.Hospital;
import com.example.medicalcare.repository.HospitalRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@Controller
public class Main {

    @Autowired
    private HospitalRepository hospitalRepository;
    @Value("${myservice.upload.paht}")
    private String imagePath;

    @GetMapping("/")
    public String main(ModelMap map) {
        Iterable<Hospital> hospitals = hospitalRepository.findAll();
        map.addAttribute("hospitals",hospitals);
        return "main";
    }

    @GetMapping(value = "/getImage",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getImage(@RequestParam("picName") String picName) throws IOException {
        InputStream inputStream = new FileInputStream(imagePath + picName);
        return IOUtils.toByteArray(inputStream);
    }
}
