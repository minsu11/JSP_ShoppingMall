<%@ page import="com.nhnacademy.shoppingmall.user.dto.LoginResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">



    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <title>nhn아카데미 shopping mall</title>

</head>
<body>
<%
    HttpSession session = request.getSession(false);
    if(session != null){
        LoginResponse loginResponse =(LoginResponse) session.getAttribute("loginResponse");
        if(loginResponse != null){
            request.setAttribute("login",loginResponse);
        }
    }
%>
<div class="mainContainer">
    <header class="p-3 bg-dark text-white">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                    <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
                </a>

                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="/index.do" class="nav-link px-2 text-secondary">Home</a></li>
                    <li><a href="/mypage/mypage.do" class="nav-link px-2 text-white">마이페이지</a></li>

                    <c:choose>
                        <c:when test="${login.auth.equalsIgnoreCase('ROLE_ADMIN')}">
                            <li><a href="/admin/auth/admin/list.do" class="nav-link px-2 text-white">관리자페이지</a></li>
                        </c:when>
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>
                </ul>

                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                    <input type="search" class="form-control form-control-dark" placeholder="Search..." aria-label="Search">
                </form>

                <c:choose>
                    <c:when test="${empty login }">
                        <div class="text-end">
                            <a class="btn btn-outline-light me-2" href="/login.do" >로그인</a>
                            <a class="btn btn-warning" href="signup.do" >회원가입</a>
                        </div>
                    </c:when>

                    <c:otherwise>
                        <div class="text-end">
                            <a class="btn btn-outline-light me-2" href="/logoutAction.do" >로그아웃</a>
                        </div>
                    </c:otherwise>

                </c:choose>
            </div>
        </div>
    </header>

    <main>

        <div class="container mt-5">
            <div class="row">
                <!-- 사이드바 -->
                <div class="col-md-3">
                    <div class="list-group">
                        <a href="/admin/auth/admin/list.do" class="list-group-item list-group-item-action"
                           id="admin-link">관리자 목록</a>
                        <a href="/admin/auth/user/list.do" class="list-group-item list-group-item-action" id="user-link">회원
                            목록</a>
                        <a href="/admin/product/list.do" class="list-group-item list-group-item-action" id="product-link">상품 목록</a>
                        <a href="/admin/category/list.do" class="list-group-item" >카테고리 관리</a>
                    </div>

                </div>
                <div class="col-md-9" style="background: white">

                    <div class="album py-5 bg-white">
                        <div class="container">
                            <jsp:include page="${layout_content_holder}" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <footer class="text-muted py-5">
        <div class="container">
            <p class="float-end mb-1">
                <a href="#">Back to top</a>
            </p>
            <p class="mb-1">shoppingmall example is © nhnacademy.com</p>
        </div>
    </footer>

</div>

</body>
</html>