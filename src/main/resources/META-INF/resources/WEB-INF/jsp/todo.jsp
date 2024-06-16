<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>
        add todos page
        </title>
    </head>

    <body>

     <div>welcome name is ${name}</div>

     <h1>Enter Todo Details</h1>
     <form method="post">
        Description: <input type = "text" name="description"/>
        <input type = "submit"  />
     </form>
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




