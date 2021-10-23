package com.todo.service;

import com.todo.model.Todo;
import org.bson.types.ObjectId;
import com.todo.repository.TodoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class TodoService {

    private final TodoRepository todoRepository;

    @Inject
    public TodoService(TodoRepository knightRepository) {
        this.todoRepository = knightRepository;
    }

    public void create(Todo todo) {
        todoRepository.persist(todo);
    }

    public void update(String id, Todo todo) {
        todo.id = new ObjectId(id);
        todoRepository.update(todo);
    }

    public void delete(String id) {
        Todo todo = todoRepository.findById(new ObjectId(id));
        todoRepository.delete(todo);
    }

    public Todo get(String id) {
        return todoRepository.findById(new ObjectId(id));
    }

    public List<Todo> list() {
        return todoRepository.listAll();
    }

    public List<Todo> listAllOrderedByName() {
        return todoRepository.findOrderedByName();
    }

    public Todo search(String name) {
        return todoRepository.findByName(name);
    }

    public Long count() {
        return todoRepository.count();
    }


}
