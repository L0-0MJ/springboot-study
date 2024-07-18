<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
            <link href = "webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel = "stylesheet">
        <title>
        List todos page
        </title>
    </head>

    <body>

     <div>welcome name is ${name}</div>
    <div class = "container">
     <h1>Your Todos</h1>
     <table class = "table">
        <thead>
            <tr>

                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
                <th></th>
                <th></th>
            </tr>
         </thead>
         <tbody>

             <c:forEach items="${todos}" var = "todo">
                <tr>

                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                    <td><a href="delete-todo?id=${todo.id}">DELETE</a></td> <!--쿼리 파라미터 사용해서 컨트롤러에게 todoid 전달-->
                    <td><a href="update-todo?id=${todo.id}">UPDATE</a></td>
                </tr>

             </c:forEach>
            </tbody>
        </table>
        <a href="add-todo">Add Todo</a>
        </div>
        </body>
    </html>




