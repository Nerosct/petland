package com.petland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petland.model.ProdutoServico;
import com.petland.repository.ProdutoServicoRepository;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoServicoRepository produtoServicoRepository;

    @GetMapping()
    public List<ProdutoServico> listAll() {
        try {
            var list = produtoServicoRepository.findAll();
            System.out.println("Produtos retornados com sucesso");
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping()
    public ProdutoServico save(@RequestBody ProdutoServico produto) {
        try {
            var success = produtoServicoRepository.save(produto);
            return success;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/{id}")
    public ProdutoServico findById(@PathVariable("id") Integer id) {
        try {
            var produto = produtoServicoRepository.findById(id);
            System.out.println("Produto retornado com sucesso");
            return produto.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PutMapping("/{id}")
    public ProdutoServico update(@PathVariable("id") Integer id, @RequestBody ProdutoServico produto) {
        try {
            var success = produtoServicoRepository.save(produto);
            return success;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        try {
            produtoServicoRepository.deleteById(id);
            System.out.println("Produto deletado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
