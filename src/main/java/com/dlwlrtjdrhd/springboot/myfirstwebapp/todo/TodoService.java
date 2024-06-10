package com.dlwlrtjdrhd.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>() ;

    static {
        todos.add(new Todo(1, "mj", "learn spring boot", LocalDate.now().plusDays(1), false));
        todos.add(new Todo(1, "mjj", "learn spring boot", LocalDate.now().plusDays(1), false));
        todos.add(new Todo(1, "mjj", "learn spring boot", LocalDate.now().plusDays(1), false));
    }
    //todo를 리턴하기 위한 메서드 ,특정 사용자 관련
    public List<Todo> findByUsername(String username){
        return todos;
    }
}
