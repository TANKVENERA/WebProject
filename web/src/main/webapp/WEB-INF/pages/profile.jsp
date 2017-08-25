<%@ include file="begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<div class="main" >
    <div class="buttons" style="padding-top: 100px; display: inline-block; background-color: cornsilk; border-top-left-radius: 15px;
border-bottom-left-radius:15px;">
    <div>
        <a href="${pageContext.request.contextPath}/createAd" class="swagBtn" style="width: 200px" >Мои объявления</a>
    </div>
    <div>
        <a href="#" class="swagBtn">Закладки</a>
    </div>
    <div>
        <a href="#" class="swagBtn">Сообщения</a>
    </div>
    <div>
        <a href="#" class="swagBtn">Настройки</a>

    </div>
    <div class="exit" style="padding-top: 50px; padding-bottom: 50px; ">
        <a href="#" class="swagBtn">Выход</a>
    </div>
    </div>

</div>
