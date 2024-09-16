<%--
  Created by IntelliJ IDEA.
  User: parkminsu
  Date: 2024. 9. 16.
  Time: 오후 3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <h4>회원 목록</h4>
    <table class="table table-striped table-bordered">
        <thead class="thead-dark">
        <tr>
            <th scope="col">이름</th>
            <th scope="col">생년월일</th>
            <th scope="col">포인트</th>
            <th scope="col">가입일</th>
            <th scope="col">마지막 로그인일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.name}</td>
                <td>${user.birth}</td>
                <td>${user.point}</td>
                <td>${user.createdAt}</td>
                <td>${user.lastedLoginAt}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

