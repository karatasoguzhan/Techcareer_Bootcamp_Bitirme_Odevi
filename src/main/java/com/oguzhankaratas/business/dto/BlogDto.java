package com.oguzhankaratas.business.dto;

import com.oguzhankaratas.auditing.AuditingAwareBaseDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;


//LOMBOK
@Data
@NoArgsConstructor // parametresiz constructor
@AllArgsConstructor //parametreli constructor
@Builder
@Log4j2
//Yukarıdaki verileri dto'larda sürekli kullancağız

public class BlogDto extends AuditingAwareBaseDto implements Serializable {  //Serializable bir veriyi başka bir veriye aktarırken sıkıntı yaşanmamasını sağlar
    public static final Long serialVersionUID = 1L;


    //Header
    @NotEmpty(message = "{blog.header.validation.constraints.NotNull.message}") // header boş geçilirse
    @Size(min=10, message = "{blog.header.least.validation.constraints.NotNull.message}") //10 karakterden az ise
    private String header;

    //content
    @NotEmpty(message = "{blog.content.validation.constraints.NotNull.message}")
    @Size(min=10, message = "{blog.content.least.validation.constraints.NotNull.message}")
    private String content;


}
