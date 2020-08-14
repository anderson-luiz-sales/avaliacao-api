package br.com.cast.avaliacao.dtos.responses;

import br.com.cast.avaliacao.dtos.responses.CategoryResponseDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CourseResponseDTO implements Serializable {

    private String id;
    private String subjectDescription;
    private Date startDate;
    private Date endDate;
    private Integer studentQuantity;

    private List<CategoryResponseDTO> category;
}
