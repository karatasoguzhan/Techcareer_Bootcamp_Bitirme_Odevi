package com.oguzhankaratas.controller.api;

import com.oguzhankaratas.business.dto.CreateTodoItemRequest;
import com.oguzhankaratas.business.dto.TodoDto;
import com.oguzhankaratas.business.services.TodoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class TodoItemController {

    private final TodoService todoService;

    public TodoItemController(final TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/create")
    public TodoDto create(@RequestBody CreateTodoItemRequest request){
        return todoService.create(request);
    }
    @PostMapping("/done/{id}")
    public TodoDto done(@PathVariable Long id){
        return todoService.done(id);
    }
}
