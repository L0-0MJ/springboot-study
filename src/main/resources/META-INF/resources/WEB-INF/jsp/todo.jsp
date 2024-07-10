<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>
        add todos page
        </title>
    </head>

    <body>

     <div>welcome name is ${name}</div>

     <h1>Enter Todo Details</h1>
     <form:form method="post" modelAttribute = "todo"> <!--bean에 맵핑(addNewTodo에 있는 Todo todo -->
        Description: <form:input type = "text" path="description" required = "required"/> <!--path 통해서 description 멤버변수에 맵핑-->
        <!--숨겨진 변수 만들기-->
        <form:error path="description"/>
        <form:input type = "hidden" path="id"/>
        <form:input type = "hidden" path="done"/>

        <input type = "submit"  />
     </form:form>
     <table>
        <thead>
            <tr>
                <th>id</th>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
            </tr>
         </thead>
         <tbody>

             <c:forEach items="${todos}" var = "todo">
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                </tr>
             </c:forEach>
            </tbody>
        </table>
        <a href="add-todo">Add Todo</a>
        </body>
    </html>




