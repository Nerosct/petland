package com.petland.cadastros.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.Data;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalResponse extends AnimalRequest {
    private Integer id;
}
