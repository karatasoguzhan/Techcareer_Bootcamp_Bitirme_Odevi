package com.oguzhankaratas.business.services;

import com.oguzhankaratas.assist.Status;
import com.oguzhankaratas.business.dto.CreateTodoItemRequest;
import com.oguzhankaratas.business.dto.TodoDto;
import com.oguzhankaratas.data.entity.TodoItem;
import com.oguzhankaratas.data.repository.TodoItemRepository;
import com.oguzhankaratas.exception.NotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    private final TodoItemRepository repository;

    public TodoService(final TodoItemRepository repository) {
        this.repository = repository;
    }

    public TodoDto create(CreateTodoItemRequest request) {
        final TodoItem todoItem = new TodoItem();
        todoItem.setDescription(request.getDescription());
        todoItem.setHeader(request.getHeader());
        final TodoItem saved = repository.save(todoItem);
        return new TodoDto(saved.getId(),saved.getHeader(), saved.getDescription(), saved.getStatus());
    }

    public TodoDto done(Long id) {
        final Optional<TodoItem> maybeTodoItem = repository.findById(id); //nullable
        final TodoItem todoItem = maybeTodoItem.orElseThrow(() -> new NotFoundException("Todo item with id: " + id + " not found"));
        todoItem.setStatus(Status.DONE);
        final TodoItem saved = repository.save(todoItem);
        return new TodoDto(saved.getId(),saved.getHeader(), saved.getDescription(), saved.getStatus());
    }

}
