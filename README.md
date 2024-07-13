
<h2>validation</h2>


(7/11)


---


* 검증과 관련된 starter 프로젝트 import => spring-boot-starter-validation
  * pom.xml에 추가
  

* 커멘드 빈 (form backing object) 개념 사용
  * 양방향 바인딩 구현


* bean에 검증 추가 
  * Todo.java에 추가


* 검증 오류를 뷰에 표시 
  * todo.jsp 


<h2>Delete todo</h2>
* delete 버튼 링크추가
* todo id를 받아오기 위해 쿼리파라미터 추가
  * listTodo.jsp


* todo id 값을 잡기위해 RequestParam 사용
* todo 삭제로직 추가
* list-todos로 리턴
  * TodoController.java

* 함수형 프로그래밍
* bean -> 조건
* removeIf로 predicate를 모든 todo에 실행
  * TodoService.java