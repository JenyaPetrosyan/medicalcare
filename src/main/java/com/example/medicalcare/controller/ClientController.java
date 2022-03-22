package com.example.medicalcare.controller;

import com.example.medicalcare.repository.ClientRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ClientController {

 private  final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
}
