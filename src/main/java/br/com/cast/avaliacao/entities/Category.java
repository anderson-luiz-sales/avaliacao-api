package br.com.cast.avaliacao.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Category implements Serializable {

    private String id;
    private String description;

}
