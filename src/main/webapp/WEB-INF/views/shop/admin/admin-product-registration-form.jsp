<%--
  Created by IntelliJ IDEA.
  User: parkminsu
  Date: 2024. 9. 16.
  Time: 오후 3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/admin/product/register.do" method="post" enctype="multipart/form-data">
    <div>
        <label for="product-number">상품 번호</label>
        <input id="product-number" name="product-number" type="text">
    </div>

    <div>
        <label for="product-name">상품 이름</label>
        <input id="product-name" name="product-name" type="text">
    </div>
    <div>
        <label for="product-cost">상품 가격</label>
        <input id="product-cost" name="product-cost" type="text">
    </div>
    <div>
        <label for="product-inventory">재고</label>
        <input id="product-inventory" name="product-inventory" type="text">
    </div>
    <div>
        <label for="product-description">설명</label>
        <input id="product-description" name="product-description" type="text">
    </div>

    <div>
        <label for="product-image">이미지 등록</label>
        <input type="file" id="product-image" name="product-image">
    </div>

    <button type="submit" class="btn-primary">등록</button>

</form>