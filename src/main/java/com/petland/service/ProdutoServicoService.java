package com.petland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petland.model.ProdutoServico;
import com.petland.model.dto.ProdutoServicoRequest;
import com.petland.model.dto.ProdutoServicoResponse;
import com.petland.model.entity.CadastroEntity;
import com.petland.repository.CadastroRepository;
import com.petland.repository.ProdutoServicoRepository;

@Service
public class ProdutoServicoService {

    @Autowired
    private ProdutoServicoRepository produtoRepository;

    @Autowired
    private CadastroRepository cadastroRepository;

    public List<ProdutoServicoResponse> listAll() {

        return produtoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public ProdutoServicoResponse findById(Integer id) {

        ProdutoServico produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return toResponse(produto);
    }

    public Integer create(ProdutoServicoRequest request) {

        CadastroEntity cliente = cadastroRepository.findById(request.getCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        ProdutoServico produto = new ProdutoServico();
        produto.setNome(request.getNome());
        produto.setValor(request.getValor());
        produto.setServico(request.isServico());
        produto.setCliente(cliente);

        return produtoRepository.save(produto).getId();
    }

    public ProdutoServicoResponse update(Integer id, ProdutoServicoRequest request) {

        ProdutoServico produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        CadastroEntity cliente = cadastroRepository.findById(request.getCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        produto.setNome(request.getNome());
        produto.setValor(request.getValor());
        produto.setServico(request.isServico());
        produto.setCliente(cliente);

        return toResponse(produtoRepository.save(produto));
    }

    public void delete(Integer id) {

        ProdutoServico produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produtoRepository.delete(produto);
    }

    private ProdutoServicoResponse toResponse(ProdutoServico produto) {

        ProdutoServicoResponse response = new ProdutoServicoResponse();

        response.setId(produto.getId());
        response.setNome(produto.getNome());
        response.setValor(produto.getValor());
        response.setServico(produto.isServico());
        response.setCliente(produto.getCliente().getId());

        return response;
    }
}