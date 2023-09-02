import React, { useEffect, useState } from 'react';
import axios from 'axios';
import todo from './todo';


const TodoList = () => {
  const [todos, setTodos] = useState([]);



  const fetchTodos = async () => {
    try {
      const response =await todo.apiFindAll();
      setTodos(response.data);
    } catch (error) {
      console.error('Error fetching todos:', error);
    }
  };



  const handleDelete = async (id) => {
    try {
      await todo.apiDelete(id);
      fetchTodos();
    } catch (error) {
      console.error('Error deleting todo:', error);
    }
  };



  const markAsDone = async (id) => {
    try {
      todo.apiDone(id);
      fetchTodos();
    } catch (error) {
      console.error('Error marking as done:', error);
    }
  };



  useEffect(() => {
    fetchTodos();
  }, []);



  return (
    <div>
      <ul>
        {todos.map((todo) => (
         
          <li key={todo.id} className="todo-item">
            <div className={todo.status === 'DONE' ? 'done' : ''}>
              {todo.header} — {todo.description}
            </div>
            <div className="button-container">
              {todo.status === 'IN_PROGRESS' && (
                <button style={{ backgroundColor: 'white' }} onClick={() => markAsDone(todo.id)}> ✔️ </button>
              )}
              <button onClick={() => handleDelete(todo.id)}>Delete</button>
            </div>
          </li>
          
        ))}
      </ul>
    </div>
  );
};



export default TodoList;
