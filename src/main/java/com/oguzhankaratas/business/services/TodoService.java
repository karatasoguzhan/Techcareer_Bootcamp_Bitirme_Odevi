package com.oguzhankaratas.business.services;

import com.oguzhankaratas.assist.Status;
import com.oguzhankaratas.bean.ModelMapperBean;
import com.oguzhankaratas.business.dto.CreateTodoItemRequest;
import com.oguzhankaratas.business.dto.TodoDto;
import com.oguzhankaratas.data.entity.TodoItem;
import com.oguzhankaratas.data.repository.TodoItemRepository;
import com.oguzhankaratas.exception.MyCustomException;
import com.oguzhankaratas.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TodoService {

    private final TodoItemRepository repository;
    private final ModelMapperBean modelMapperBean;

    public TodoService(final TodoItemRepository repository, ModelMapperBean modelMapperBean) {
        this.repository = repository;
        this.modelMapperBean = modelMapperBean;
    }
    public TodoDto entityToDto(TodoItem todoItem){
        return modelMapperBean.modelMapperMethod().map(todoItem,TodoDto.class);
    }
    public TodoItem dtoToEntity(TodoDto todoDto){
        return modelMapperBean.modelMapperMethod().map(todoDto,TodoItem.class);
    }

    public TodoDto todoItemFindById(Long id) {
     TodoItem findTodoItem = null;
     if (id!=null){
         findTodoItem =repository.findById(id).orElseThrow(()->new NotFoundException(id + " nolu id bulunamadı"));
     } else if (id==null) {
         throw new MyCustomException("id null olarak geldi");
     }
     return entityToDto(findTodoItem);
    }
    @Transactional
    public TodoDto create(CreateTodoItemRequest request) {
        final TodoItem todoItem = new TodoItem();
        todoItem.setDescription(request.getDescription());
        todoItem.setHeader(request.getHeader());
        final TodoItem saved = repository.save(todoItem);
        return new TodoDto(saved.getId(),saved.getHeader(), saved.getDescription(), saved.getStatus());
    }
    @Transactional
    public TodoDto update(Long id, TodoDto todoDto){
        TodoDto todoFindDto = todoItemFindById(id);
        if (todoFindDto!=null){
            TodoItem todoItem = dtoToEntity(todoFindDto);
            todoItem.setHeader(todoDto.getHeader());
            todoItem.setDescription(todoDto.getDescription());
            repository.save(todoItem);
        }
        return todoDto;
    }
    @Transactional
    public TodoDto delete(Long id){
        TodoDto todoFindDto = todoItemFindById(id);
        if (todoFindDto!=null){
            repository.deleteById(id);
        }
        return todoFindDto;
    }

    public TodoDto done(Long id) {
        final Optional<TodoItem> maybeTodoItem = repository.findById(id); //nullable
        final TodoItem todoItem = maybeTodoItem.orElseThrow(() -> new NotFoundException("Todo item with id: " + id + " not found"));
        todoItem.setStatus(Status.DONE);
        final TodoItem saved = repository.save(todoItem);
        return new TodoDto(saved.getId(),saved.getHeader(), saved.getDescription(), saved.getStatus());
    }

}
