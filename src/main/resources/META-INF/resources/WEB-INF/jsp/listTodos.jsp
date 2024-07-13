<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>
        List todos page
        </title>
    </head>

    <body>

     <div>welcome name is ${name}</div>

     <h1>Your Todos</h1>
     <table>
        <thead>
            <tr>
                <th>id</th>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
                <th></th>
            </tr>
         </thead>
         <tbody>

             <c:forEach items="${todos}" var = "todo">
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                    <td><a href="delete-todo?id=${todo.id}">DELETE ${todo.id}</a></td> <!--쿼리 파라미터 사용해서 컨트롤러에게 todoid 전달-->
                </tr>

             </c:forEach>
            </tbody>
        </table>
        <a href="add-todo">Add Todo</a>
        </body>
    </html>




