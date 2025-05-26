package com.example.Lab5.controller;

import com.example.Lab5.model.Item;
import com.example.Lab5.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("destinations")
public class ItemController {


    @Autowired
    private ItemRepository destinationRepository;

    @GetMapping
    public String listDestinations(Model model) {
        model.addAttribute("destinations", destinationRepository.findAll());
        return "destination-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("destination", new Item());
        return "destination-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Item destination = destinationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Невірний ID туристичного місця: " + id));
        model.addAttribute("destination", destination);
        return "destination-form";
    }

    @PostMapping("/save")
    public String saveDestination(@ModelAttribute("destination") Item destination) {
        destinationRepository.save(destination);
        return "redirect:/destinations";
    }


    @GetMapping("/delete/{id}")
    public String deleteDestination(@PathVariable Long id) {
        destinationRepository.deleteById(id);
        return "redirect:/destinations";
    }

}