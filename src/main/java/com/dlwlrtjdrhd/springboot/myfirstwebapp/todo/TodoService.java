package com.dlwlrtjdrhd.springboot.myfirstwebapp.todo;

import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>() ;
    private  static  int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "mj", "learn spring boot", LocalDate.now().plusDays(1), false));
        todos.add(new Todo(++todosCount, "mjj", "learn spring boot", LocalDate.now().plusDays(1), false));
        todos.add(new Todo(++todosCount, "mjj", "learn spring boot", LocalDate.now().plusDays(1), false));
    }
    //todo를 리턴하기 위한 메서드 ,특정 사용자 관련
    public List<Todo> findByUsername(String username){
        return todos;
    }

    public void addTodo(String username, String description,LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);

    }

    public void deleteById(int id){
        //함수형 프로그래밍
        //todo.getId() == id
        //todo -> todo.getId() == id
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }
}
