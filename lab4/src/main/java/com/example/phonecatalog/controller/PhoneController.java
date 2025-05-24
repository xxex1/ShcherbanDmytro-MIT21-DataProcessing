package com.example.phonecatalog.controller;

import com.example.phonecatalog.entity.Phone;
import com.example.phonecatalog.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api/phones")
@CrossOrigin(origins = "http://localhost:5173")
public class PhoneController {


    @Autowired
    private PhoneRepository phoneRepository;

    @PostConstruct
    public void init() {
        System.out.println("✅ PhoneController is loaded!");
    }
    @GetMapping
    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    @PostMapping
    public Phone createPhone(@RequestBody Phone phone) {
        return phoneRepository.save(phone);
    }
}
