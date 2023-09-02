import axios from "axios";
import React, { useState, useEffect } from 'react';
import TodoForm from './TodoForm';
import TodoList from './TodoList';



const TODO_URL="http://localhost:4444/api/todo/v1";

 class TodoItemController { 

    apiCreate(createTodoItemRequest) {
        return axios.post(`${TODO_URL}/create`, createTodoItemRequest)
    }

    
    apiFindById(id) {
        return axios.get(`${TODO_URL}/find/${id}`)
    }

   
    apiUpdate(id,todoDto) {
        return axios.put(`${TODO_URL}/update/${id}`,todoDto)
    }
    
    apiFindAll() {
        return axios.get(`${TODO_URL}/findAll`)
    }

    
    apiDelete(id) {
        return axios.delete(`${TODO_URL}/delete/${id}`)
    }

   
    apiDone(id) {
        return axios.put(`${TODO_URL}/done/${id}`)
    }
}

export default new TodoItemController();
