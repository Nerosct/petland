package com.petland.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.petland.model.dto.ClientRequest;
import com.petland.model.dto.ClientResponse;
import com.petland.model.entity.CadastroEntity;
import com.petland.repository.CadastroRepository;

@Service
public class ClientService {
    
    @Autowired
    private CadastroRepository cadastroRepository;

    public Integer create(@RequestBody ClientRequest client) {
        try {
            CadastroEntity entity = new CadastroEntity();
            BeanUtils.copyProperties(client, entity);
            return cadastroRepository.save(entity).getId();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<ClientResponse> listAll() {
        List<CadastroEntity> entities = cadastroRepository.findAll();
        List<ClientResponse> responses = new ArrayList<>();

        for (CadastroEntity e : entities) {
            ClientResponse response = new ClientResponse();
            BeanUtils.copyProperties(e, response);
            responses.add(response);
        }
        return responses;
    }

    public ClientResponse findById(Integer id) {
        try {
            var client = cadastroRepository.findById(id);
            if (client.isEmpty()) {
                throw new RuntimeException("Client not found");
            }
            ClientResponse response = new ClientResponse();
            BeanUtils.copyProperties(client.get(), response);
            return response;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public ClientResponse update(Integer id, ClientRequest request) {
        var clientOpt = cadastroRepository.findById(id);
        if (clientOpt.isEmpty()) {
            throw new RuntimeException("Client not found");
        }
        CadastroEntity e = clientOpt.get();
        e.setNome(request.getNome());
        e.setPerfil(request.getPerfil());
        e.setEndereco(request.getEndereco());

        cadastroRepository.save(e);
        ClientResponse response = new ClientResponse();
        BeanUtils.copyProperties(e, response);
        return response;
    }
}
