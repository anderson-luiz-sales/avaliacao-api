package br.com.cast.avaliacao.dtos.responses;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CourseResponseDTO implements Serializable {

    private String id;
    private String subjectDescription;
    private Date startDate;
    private Date endDate;
    private Integer studentQuantity;

    private CategoryResponseDTO category;
}
