<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: parkminsu
  Date: 2024. 9. 8.
  Time: 오후 4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


            <div id="admin-list-content">
                <h4>관리자 목록</h4>
                <c:forEach var="admin" items="${adminUserList}">
                    <div>
                        <div>
                            <label for="admin-name">이름</label>
                            <p id="admin-name">${admin.name}</p>
                        </div>
                        <div>
                            <label for="admin-birth">
                            </label>
                            <p id="admin-birth">${admin.birth}</p>
                        </div>
                        <div>
                            <label for="admin-point">
                            </label>
                            <p id="admin-point">${admin.point}</p>
                        </div>
                    </div>
                </c:forEach>
</div>