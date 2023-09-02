import React, { useState } from 'react';
import './App.css';
import TodoForm from './TodoForm';
import TodoList from './TodoList';



function App() {
  const [refreshKey, setRefreshKey] = useState(0);



  const refreshTodoList = () => {
    // refreshKey'i güncelleyerek TodoList bileşenini yenile
    setRefreshKey(refreshKey + 1);
  };



  return (
    <div className="App">
      <h1>Todo App</h1>
      <TodoForm refreshTodoList={refreshTodoList} />
      <TodoList key={refreshKey} />
    </div>
  );
}



export default App;