package com.myapp.todo;

import com.myapp.todo.domain.ToDo;
import com.myapp.todo.repository.ToDoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ToDoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoRepository toDoRepository;

    @Before
    public void setUp(){

    }

    @Test
    public void testGetToDos() throws Exception {
        ToDo toDo = new ToDo("description 1");
        when(toDoRepository.findAll()).thenReturn(Collections.singletonList(toDo));

        mockMvc.perform(get("/api/todo"))
                .andExpect(status().isOk());
    }

}
