package com.todo.model;

import io.quarkus.mongodb.panache.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Todo extends PanacheMongoEntity {

    private String name;

    private String status;
}
