package com.petland.atendimento.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.petland.atendimento.model.dto.AtendimentoRequest;
import com.petland.atendimento.model.entity.AtendimentoEntity;
import com.petland.atendimento.repository.AtendimentoRepository;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public Integer create(@RequestBody AtendimentoRequest atendimento) {
        try {
            AtendimentoEntity entity = new AtendimentoEntity();
            BeanUtils.copyProperties(atendimento, entity);
            return atendimentoRepository.save(entity).getId();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
