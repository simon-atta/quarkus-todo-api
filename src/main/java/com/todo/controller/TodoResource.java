package com.todo.controller;

import com.todo.model.Todo;
import com.todo.service.TodoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/api")
@Produces("application/json")
@Consumes("application/json")
public class TodoResource {

    private final TodoService todoService;

    @Inject
    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @POST
    public Response create(Todo todo) {
        todoService.create(todo);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") String id, Todo todo) {
        todoService.update(id, todo);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id) {
        todoService.delete(id);
    }

    @GET
    @Path("/{id}")
    public Todo get(@PathParam("id") String id) {
        return todoService.get(id);
    }

    @GET
    public List<Todo> list() {
        return todoService.list();
    }

    @GET
    @Path("/orderedByName")
    public List<Todo> listAllOrderedByName() {
        return todoService.listAllOrderedByName();
    }

    @GET
    @Path("/search/{name}")
    public Todo search(@PathParam("name") String name) {
        return todoService.search(name);
    }

    @GET
    @Path("/count")
    public Long count() {
        return todoService.count();
    }

}