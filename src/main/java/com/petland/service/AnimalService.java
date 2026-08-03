package com.petland.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.petland.model.dto.AnimalRequest;
import com.petland.model.dto.AnimalResponse;
import com.petland.model.entity.AnimalEntity;
import com.petland.repository.AnimalRepository;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Integer create(@RequestBody AnimalRequest animal) {
        try {
            AnimalEntity entity = new AnimalEntity();
            BeanUtils.copyProperties(animal, entity);
            return animalRepository.save(entity).getId();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<AnimalResponse> listAll() {
        List<AnimalEntity> entities = animalRepository.findAll();
        List<AnimalResponse> responses = new ArrayList<>();

        for (AnimalEntity e : entities) {
            AnimalResponse response = new AnimalResponse();
            BeanUtils.copyProperties(e, response);
            responses.add(response);
        }
        return responses;
    }

    public AnimalResponse findById(Integer id) {
        try {
            var animal = animalRepository.findById(id);
            if (animal.isEmpty()) {
                throw new RuntimeException("Animal not found");
            }
            AnimalResponse response = new AnimalResponse();
            BeanUtils.copyProperties(animal.get(), response);
            return response;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public AnimalResponse update(Integer id, AnimalRequest request) {
        var animalOpt = animalRepository.findById(id);
        if (animalOpt.isEmpty()) {
            throw new RuntimeException("Animal not found");
        }
        AnimalEntity e = animalOpt.get();
        e.setNome(request.getNome());
        e.setEspecie(request.getEspecie());
        e.setAniversario(request.getAniversario());

        animalRepository.save(e);
        AnimalResponse response = new AnimalResponse();
        BeanUtils.copyProperties(e, response);
        return response;
    }

}
