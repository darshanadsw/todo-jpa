package com.myapp.todo.repository;

import com.myapp.todo.domain.ToDo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoRepository extends CrudRepository<ToDo,String> {

    List<ToDo> findByDescriptionContains(String desc);

}
