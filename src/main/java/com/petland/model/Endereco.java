package com.petland.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Endereco {
    private String logradouro;
    private String numero;
}
