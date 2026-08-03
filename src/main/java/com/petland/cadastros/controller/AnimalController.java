package com.petland.cadastros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petland.cadastros.model.dto.AnimalRequest;
import com.petland.cadastros.model.dto.AnimalResponse;
import com.petland.cadastros.service.AnimalService;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<AnimalResponse> listAll() {
        try {
            var list = animalService.listAll();
            return list;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public AnimalResponse findById(@PathVariable Integer id) {
        try {
            var animal = animalService.findById(id);
            return animal;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("/create")
    public Integer create(@RequestBody AnimalRequest request) {
        return animalService.create(request);
    }

    @PutMapping("/{id}")
    public AnimalResponse update(@PathVariable Integer id, @RequestBody AnimalRequest request) {
        return animalService.update(id, request);
    }

}
