<%--
  Created by IntelliJ IDEA.
  User: parkminsu
  Date: 2024. 9. 8.
  Time: 오후 4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container mt-5">
    <div class="row">
        <!-- 사이드바 -->
        <div class="col-md-3">
            <div class="list-group">
                <a href="/" class="list-group-item list-group-item-action active" id="admin-link">관리자 목록</a>
                <a href="#" class="list-group-item list-group-item-action" id="user-link">회원 목록</a>
                <a href="#" class="list-group-item list-group-item-action" id="product-link">상품 목록</a>
            </div>
        </div>
        <!-- 콘텐츠 영역 -->
        <div class="col-md-9">
            <div id="admin-list-content">
                <h4>관리자 목록</h4>

            </div>
            <div id="user-list-content" style="display: none;">
                <h4>회원 목록</h4>
                <p>여기에 주소 정보를 보여줍니다.</p>
            </div>
            <div id="product-list-content" style="display: none;">
                <h4>상품 목록</h4>
                <div>
                    <a href="/admin/product/register.do">등록</a>
                </div>

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

        $('#admin-link').click(function() {
            showContent('#admin-list-content', this);
        });

        // 주소 버튼 클릭 시
        $('#user-link').click(function() {
            showContent('#user-list-content', this);
        });

        // 포인트 내역 버튼 클릭 시
        $('#product-link').click(function() {
            showContent('#product-list-content', this);
        });

        function showContent(contentId, clickedLink) {
            // 모든 콘텐츠 숨김
            $('#admin-list-content, #user-list-content, #product-list-content').hide();
            // 선택된 콘텐츠만 표시
            $(contentId).show();

            // 사이드바의 모든 버튼에서 active 클래스 제거
            $('.list-group-item').removeClass('active');
            // 클릭된 버튼에 active 클래스 추가
            $(clickedLink).addClass('active');
        }
    });
</script>

