package com.petland.model;

import com.petland.model.entity.CadastroEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "tab_produto_servico")
public class ProdutoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(length = 40, nullable = false)
    private String nome;

    private Double valor;
    private boolean servico;

    @ManyToOne
    private CadastroEntity cliente;
}
