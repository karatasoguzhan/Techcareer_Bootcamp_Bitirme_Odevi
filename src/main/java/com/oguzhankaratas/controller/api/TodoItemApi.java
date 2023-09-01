package com.oguzhankaratas.controller.api;


import com.oguzhankaratas.business.dto.CreateTodoItemRequest;
import com.oguzhankaratas.business.dto.TodoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoItemApi<D>{

    public ResponseEntity<CreateTodoItemRequest> Create(CreateTodoItemRequest createTodoItemRequest);

    public ResponseEntity<List<D>> todoList();

    public ResponseEntity<?> FindById(Long id);

    public ResponseEntity<TodoDto> Update(Long id,TodoDto todoDto);

    public ResponseEntity<?> Delete(Long id);

    public ResponseEntity<?> Done(Long id);

}
