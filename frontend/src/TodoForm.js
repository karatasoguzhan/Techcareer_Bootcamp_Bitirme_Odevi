import React, { useState } from 'react';
import axios from 'axios';
import { Input, Button, Form, Row, Col } from 'antd';
import todo from './todo'
const { TextArea } = Input;

const TodoForm = ({ refreshTodoList }) => {
  const [formData, setFormData] = useState({ header: '', description: '' });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleCreate = async () => {
    try {
      todo.apiCreate(formData);
      refreshTodoList();
      setFormData({ header: '', description: '' });
    } catch (error) {
      console.error('Error creating todo:', error);
    }
  };

  return (
    <div className="todo-form-container">
      <Form className="form">
        <Row gutter={16}>
          <Col span={24}>
            <Form.Item
              name="header"
              rules={[{ required: true, message: 'Please input the header!' }]}
            >
              <Input
                placeholder="Header"
                className="header-input"
                name="header"
                value={formData.header}
                onChange={handleChange}
              />
            </Form.Item>
          </Col>
          <Col span={24}>
            <Form.Item
              name="description"
              rules={[{ required: true, message: 'Please input the description!' }]}
            >
              <TextArea
                rows={4}
                placeholder="Description"
                className="description-input"
                name="description"
                value={formData.description}
                onChange={handleChange}
              />
            </Form.Item>
          </Col>
          <Col span={24}>
            <Form.Item>
              <div className="button-container">
                <Button
                  type="primary"
                  onClick={handleCreate} // onClick kullanarak form gönderimini engelleme
                  className="create-button"
                  style={{ width: '100%' }}
                >
                  Create
                </Button>
              </div>
            </Form.Item>
          </Col>
        </Row>
      </Form>
    </div>
  );
};

export default TodoForm;