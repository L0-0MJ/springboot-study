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

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get(); //todo의 스트림을 생성, 하나씩 모든 todo 확인, filter에 predicate 사용해서 필터링, 첫번째 값만 가져감, 찾으면 그걸 받기위해 get사용
        //for문으로 todo를 반복해서 원하는 것을 찾을 수도 있고, 함수형 프로그래밍을 사용할 수도 있음
        return todo;
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo); //업데이트하기 위해 기존값을 삭제하고 새로운값을 추가
    }
}
