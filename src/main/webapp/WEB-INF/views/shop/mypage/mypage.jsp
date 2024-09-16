<%--
  Created by IntelliJ IDEA.
  User: parkminsu
  Date: 2024. 9. 7.
  Time: 오후 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  session="false" %>

<div class="container mt-5">
<div class="row">
        <!-- 사이드바 -->
        <div class="col-md-3">
            <div class="list-group">
                <a href="/mypage/order.do" class="list-group-item list-group-item-action active" id="order-link">주문 목록</a>
                <a href="/mypage/user-info.do" class="list-group-item list-group-item-action" id="profile-link">회원 정보</a>
                <a href="#" class="list-group-item list-group-item-action" id="address-link">주소</a>
                <a href="#" class="list-group-item list-group-item-action" id="points-link">포인트 내역</a>
            </div>
        </div>
        <!-- 콘텐츠 영역 -->
        <div class="col-md-9">
            <div id="profile-order-list">
                <h4>주문 목록</h4>
                <div>
                </div>
            </div>

            <div id="profile-content" style="display: none">
                <h4>회원 정보</h4>
                <form>
                    <div class="form-group">
                        <label for="userId">아이디</label>
                        <p id="userId" name="${user.getUserId()}"></p>
                    </div>
                    <div class="form-group">
                        <label for="userName">이름</label>
                        <p id="userName">${user.name}</p>
                    </div>
                    <div class="form-group">
                        <label for="userBirth">생일</label>
                        <p id="userBirth">${user.birth}</p>
                    </div>
                    <div class="form-group">
                        <label for="userPoints">보유 포인트</label>
                        <p id="userPoints">${user.point}</p>
                    </div>
                </form>
            </div>
            <div id="address-content" style="display: none;">
                <h4>주소</h4>
                <p>여기에 주소 정보를 보여줍니다.</p>
            </div>
            <div id="points-content" style="display: none;">
                <h4>포인트 내역</h4>
                <p>여기에 포인트 내역을 보여줍니다.</p>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script>
    $(document).ready(function() {
        // 회원 정보 버튼 클릭 시
        $('#order-link').click(function (){
           showContent('#profile-order-list',this)
        });
        $('#profile-link').click(function() {
            showContent('#profile-content', this);
        });

        // 주소 버튼 클릭 시
        $('#address-link').click(function() {
            showContent('#address-content', this);
        });

        // 포인트 내역 버튼 클릭 시
        $('#points-link').click(function() {
            showContent('#points-content', this);
        });

        function showContent(contentId, clickedLink) {
            // 모든 콘텐츠 숨김
            $('#profile-content, #address-content, #points-content, #profile-order-list').hide();
            // 선택된 콘텐츠만 표시
            $(contentId).show();

            // 사이드바의 모든 버튼에서 active 클래스 제거
            $('.list-group-item').removeClass('active');
            // 클릭된 버튼에 active 클래스 추가
            $(clickedLink).addClass('active');
        }
    });
</script>
