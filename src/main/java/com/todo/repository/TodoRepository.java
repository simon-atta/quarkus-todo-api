package com.todo.repository;

import com.todo.model.Todo;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class TodoRepository implements PanacheMongoRepository<Todo> {

    public Todo findByName(String name){
        return find("name", name).firstResult();
    }

    public List<Todo> findOrderedByName(){
        return findAll(Sort.by("name")).list();
    }

}

