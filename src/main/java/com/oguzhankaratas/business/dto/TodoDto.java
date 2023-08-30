package com.oguzhankaratas.business.dto;

import com.oguzhankaratas.assist.Status;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

@Data
@NoArgsConstructor // parametresiz constructor
@AllArgsConstructor //parametreli constructor
@Builder
@Log4j2
public class TodoDto implements Serializable {

    public static final Long serialVersionUID=1L;

    private Long id;
    //Category
    @NotEmpty(message = "{blog.category.validation.constraints.NotNull.message}") // header boş geçilirse
    @Size(min=10, message = "{blog.category.least.validation.constraints.NotNull.message}") //10 karakterden az ise
    private String header;

    private String description;

    private Status status;
}
