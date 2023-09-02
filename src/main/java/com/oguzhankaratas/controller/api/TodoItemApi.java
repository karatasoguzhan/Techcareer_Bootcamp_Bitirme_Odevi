package com.oguzhankaratas.controller.api;


import com.oguzhankaratas.business.dto.CreateTodoItemRequest;
import com.oguzhankaratas.business.dto.TodoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoItemApi<D>{

    public ResponseEntity<CreateTodoItemRequest> create(CreateTodoItemRequest createTodoItemRequest);

    public ResponseEntity<List<D>> findAll();

    public ResponseEntity<?> findById(Long id);

    public ResponseEntity<TodoDto> update(Long id,TodoDto todoDto);

    public ResponseEntity<?> delete(Long id);

    public ResponseEntity<?> done(Long id);

}
