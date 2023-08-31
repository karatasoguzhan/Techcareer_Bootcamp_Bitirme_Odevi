package com.oguzhankaratas.controller.api;


import com.oguzhankaratas.business.dto.CreateTodoItemRequest;
import com.oguzhankaratas.business.dto.TodoDto;
import org.springframework.http.ResponseEntity;

public interface TodoItemApi<D>{

    public ResponseEntity<CreateTodoItemRequest> apiCreate(CreateTodoItemRequest createTodoItemRequest);

    public ResponseEntity<?> apiFindById(Long id);

    public ResponseEntity<TodoDto> apiUpdate(Long id,TodoDto todoDto);

    public ResponseEntity<?> apiDelete(Long id);

    public ResponseEntity<?> apiDone(Long id);

}
