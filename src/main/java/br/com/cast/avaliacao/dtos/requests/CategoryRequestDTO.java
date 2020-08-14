package br.com.cast.avaliacao.dtos.requests;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryRequestDTO implements Serializable {

    private String id;
    private String description;
}
