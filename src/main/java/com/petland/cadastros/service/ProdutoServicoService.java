package com.petland.cadastros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petland.cadastros.model.ProdutoServico;
import com.petland.cadastros.model.dto.ProdutoServicoRequest;
import com.petland.cadastros.model.dto.ProdutoServicoResponse;
import com.petland.cadastros.model.entity.CadastroEntity;
import com.petland.cadastros.repository.CadastroRepository;
import com.petland.cadastros.repository.ProdutoServicoRepository;

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

        CadastroEntity cliente = cadastroRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        ProdutoServico produto = new ProdutoServico();
        produto.setNome(request.getNome());
        produto.setValor(request.getValor());
        produto.setServico(request.isServico());
        produto.setClienteId(cliente.getId());

        return produtoRepository.save(produto).getId();
    }

    public ProdutoServicoResponse update(Integer id, ProdutoServicoRequest request) {

        ProdutoServico produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        CadastroEntity cliente = cadastroRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        produto.setNome(request.getNome());
        produto.setValor(request.getValor());
        produto.setServico(request.isServico());
        produto.setClienteId(cliente.getId());

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
        response.setClienteId(produto.getClienteId());

        return response;
    }
}