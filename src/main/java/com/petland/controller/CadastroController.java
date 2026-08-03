package com.petland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petland.model.Cadastro;
import com.petland.repository.CadastroRepository;

@RestController
@RequestMapping("/api/cadastro")
public class CadastroController {

    @Autowired
    private CadastroRepository cadastroRepository;

    @GetMapping("/listAll")
    public List<Cadastro> listAll() {
        try {
            var list = cadastroRepository.findAll();
            System.out.println("Cadastros retornados com sucesso");
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/save")
    public Cadastro save(@RequestBody Cadastro cadastro) {
        try {
            var success = cadastroRepository.save(cadastro);
            return success;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PutMapping("/update")
    public Cadastro update(@RequestBody Cadastro cadastro) {
        if (cadastroRepository.existsById(cadastro.getId())) {
            return cadastroRepository.save(cadastro);
        }
        return null;
    }

}
