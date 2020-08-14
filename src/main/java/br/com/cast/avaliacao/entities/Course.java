package br.com.cast.avaliacao.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Course implements Serializable {

    private String id;
    private String subjectDescription;
    private Date startDate;
    private Date endDate;
    private Integer studentQuantity;

    private List<Category> category;




}
