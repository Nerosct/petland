package com.petland.atendimento.model.dto;

import java.time.LocalDate;

import com.petland.atendimento.model.AtendimentoStatus;
import com.petland.atendimento.model.AtendimentoTipo;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class AtendimentoRequest {
    private String descricao;
    private LocalDate data;
    private double valor;
    private boolean emergencia;
    @Enumerated(EnumType.STRING)
    private AtendimentoTipo tipo;
    @Enumerated(EnumType.STRING)
    private AtendimentoStatus status;
    private Integer animalId;
    private Integer produtoServico;
    private Integer cadastroId;

}
