package com.petland.atendimento.model.entity;

import java.time.LocalDate;

import com.petland.atendimento.model.AtendimentoStatus;
import com.petland.atendimento.model.AtendimentoTipo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "tab_atendimento")
public class AtendimentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    private String descricao;
    private LocalDate data;
    private double valor;
    private boolean emergencia;

    @Enumerated(EnumType.STRING)
    private AtendimentoTipo tipo;

    @Enumerated(EnumType.STRING)
    private AtendimentoStatus status;

    @Column(name = "pet_id")
    private Integer animalId;

    @Column(name = "produto_servico_id")
    private Integer produtoServico;

    @Column(name = "cadastro_id")
    private Integer cadastroId;
}
