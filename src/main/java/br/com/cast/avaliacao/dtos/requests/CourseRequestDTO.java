package br.com.cast.avaliacao.dtos.requests;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CourseRequestDTO implements Serializable {

    private String id;
    private String subjectDescription;
    private Date startDate;
    private Date endDate;
    private Integer studentQuantity;

    private CategoryRequestDTO category;
}
