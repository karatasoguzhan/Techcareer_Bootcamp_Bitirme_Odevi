package com.oguzhankaratas.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.Map;

//LOMBOK
@Data    // get,set,toString ve hashcode metotlarını getirir.

//JSON
@JsonInclude(JsonInclude.Include.NON_NULL) // eğer bu fieldlarda null varsa backentte gitmez

public class ApiResult {

    private String path;
    private Map<String,String> validationErrors;
    private String message;
    private String error;
    private int status;
    private Date systemDate;

    //Parametresiz constructor
    public ApiResult() {
    }

    public ApiResult(String path, String message, int status) {
        this.path = path;
        this.message = message;
        this.status = status;
    }
}
