package com.oguzhankaratas.business.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateTodoItemRequest {

    private String header;

    private String description;
}
