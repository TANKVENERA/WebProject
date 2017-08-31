<%@ include file="begin-html.jsp" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<div class="main">
    <div class="buttons" style="padding-top: 50px; display: inline-block; background-color: cornsilk; border-top-left-radius: 15px;
border-bottom-left-radius:15px;">
        <div>
            <a href="${pageContext.request.contextPath}/new_ad" class="swagBtn" style="width: 200px">Cоздать
                объявление</a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/userAds" class="swagBtn" style="width: 200px">Мои объявления</a>
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
            <a href="<c:url value="/logout" />" class="swagBtn">Выход</a>
        </div>
    </div>

</div>
