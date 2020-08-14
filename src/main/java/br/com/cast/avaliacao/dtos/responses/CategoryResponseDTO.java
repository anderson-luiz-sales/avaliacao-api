package br.com.cast.avaliacao.dtos.responses;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryResponseDTO implements Serializable {

    private String id;
    private String description;
}
