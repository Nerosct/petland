package com.petland.cadastros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.petland.cadastros.model.dto.ProdutoServicoRequest;
import com.petland.cadastros.model.dto.ProdutoServicoResponse;
import com.petland.cadastros.service.ProdutoServicoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoServicoService produtoServicoService;

    @GetMapping
    public List<ProdutoServicoResponse> listAll() {
        return produtoServicoService.listAll();
    }

    @GetMapping("/{id}")
    public ProdutoServicoResponse findById(@PathVariable Integer id) {
        return produtoServicoService.findById(id);
    }

    @PostMapping
    public Integer create(@RequestBody ProdutoServicoRequest request) {
        return produtoServicoService.create(request);
    }

    @PutMapping("/{id}")
    public ProdutoServicoResponse update(
            @PathVariable Integer id,
            @RequestBody ProdutoServicoRequest request) {

        return produtoServicoService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        produtoServicoService.delete(id);
    }
}