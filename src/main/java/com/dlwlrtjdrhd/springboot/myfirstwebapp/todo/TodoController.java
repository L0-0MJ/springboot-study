package com.dlwlrtjdrhd.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private  TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // /list-todos
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        List<Todo> todos = todoService.findByUsername("mj");
        model.addAttribute("todos", todos);
        return "listTodos";
    }
    @RequestMapping(value = "add-todo" , method = RequestMethod.GET) //add todo페이지를 로딩 시 add todo에 GET요청을 전송하고 있음
    public String showNewTodoPage(ModelMap model){
        String username = (String)model.get("name");
        Todo todo = new Todo(0,username, "",LocalDate.now().plusYears(1),false); //Todo를 생성하고 안에 있는 양식에 맵핑하고 있음
        //description에 값 넣으면 컨트롤러 양식에 표시되는 값으로 바인딩됨=> 단방향 바인딩
        model.put("todo", todo);

        return "todo";
    }

    @RequestMapping(value = "add-todo" , method = RequestMethod.POST)  //post 요청을 하고 이게 Todo에 이루어지는 바인딩, 제출버튼 누르면 todo 변수의 description필드에 바인딩됨
    //=> 양방향 바인딩, Bean에서 폼으로 바인딩되고, 폼에서 bean으로 바인딩됨
    //@RequestParam으로 하면 필드10개 있을 때 10개의 RequestParam을 추가해야함 대신에 todo bean에 직접 바인딩
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){ //todo bean에 직접 바인딩하기
        if(result.hasErrors()){
            return "todo";
        }
        String username = (String)model.get("name");
        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);

        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){ //id값을 잡기위해 RequestParam 사용
        //Delete todo
        todoService.deleteById(id); //todo를 삭제하는 로직
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model){ //id값을 잡기위해 RequestParam 사용
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo); //attributeName todo는 todo.jsp에서 정한 이름과 매칭되어야함
        return "todo";
    }
    @RequestMapping(value = "update-todo" , method = RequestMethod.POST)
    //=> 양방향 바인딩, Bean에서 폼으로 바인딩되고, 폼에서 bean으로 바인딩됨
    //@RequestParam으로 하면 필드10개 있을 때 10개의 RequestParam을 추가해야함 대신에 todo bean에 직접 바인딩
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){ //todo bean에 직접 바인딩하기
        if(result.hasErrors()){
            return "todo";
        }
        String username = (String)model.get("name");
        todo.setUsername(username);
        todoService.updateTodo(todo);


        return "redirect:list-todos";
    }


}
