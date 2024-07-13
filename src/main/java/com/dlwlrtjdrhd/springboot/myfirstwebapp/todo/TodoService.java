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
        //todo.getId() == id 이면 그 todo를 삭제
        //todo -> todo.getId() == id  람다함수 형식, bean -> 조건 , todo에 있는 모든 bean에 대해 이 조건을 실행
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);// removeif로 predicate를 모든 todo에 실행 , 조건이 맞으면 삭제
    }
}
