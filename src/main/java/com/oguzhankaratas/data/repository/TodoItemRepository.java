package com.oguzhankaratas.data.repository;

import com.oguzhankaratas.data.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem,Long> {
}
