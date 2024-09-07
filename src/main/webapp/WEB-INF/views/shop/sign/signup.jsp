<%--
  Created by IntelliJ IDEA.
  User: parkminsu
  Date: 2024. 9. 7.
  Time: 오후 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div >

</div><div class="container mt-5">
    <h2 class="text-center">회원가입</h2>
    <form action="/signupAction.do" method="POST">
        <div class="mb-3">
            <label for="userInputId" class="form-label">아이디</label>
            <input type="text" class="form-control" id="userInputId" name="user_input_id" required>
        </div>
        <div class="mb-3">
            <label for="userName" class="form-label">이름</label>
            <input type="text" class="form-control" id="userName" name="user_name" required>
        </div>
        <div class="mb-3">
            <label for="userPassword" class="form-label">비밀번호</label>
            <input type="password" class="form-control" id="userPassword" name="user_password" required>
        </div>
        <div class="mb-3">
            <label for="userBirth" class="form-label">생년월일</label>
            <input type="text" class="form-control datepicker" id="userBirth" name="user_birth" required>
        </div>

        <div class="mb-3">
            <label for="userPoint" class="form-label">포인트 (기본값: 1000000)</label>
            <input type="number" class="form-control" id="userPoint" name="user_point" value="1000000" required>
        </div>
        <button type="submit" class="btn btn-primary">회원가입</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script>
    $(document).ready(function() {
        $('.datepicker').datepicker({
            format: 'yyyymmdd',
            autoclose: true,
            todayHighlight: true
        });
    });
</script>
