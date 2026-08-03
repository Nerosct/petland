package com.petland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petland.model.dto.ClientRequest;
import com.petland.model.dto.ClientResponse;
import com.petland.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

 @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientResponse> listAll() {
        try {
            var list = clientService.listAll();
            return list;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ClientResponse findById(@PathVariable Integer id) {
        try {
            var client = clientService.findById(id);
            return client;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ClientRequest request) {
        return clientService.create(request);
    }

    @PutMapping("/{id}")
    public ClientResponse update(@PathVariable Integer id, @RequestBody ClientRequest request) {
        return clientService.update(id, request);
    }




}
