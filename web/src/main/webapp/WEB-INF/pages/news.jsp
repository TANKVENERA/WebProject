<%@ include file="begin-html.jsp" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<div class="main" >
    <div horizontal="hor" class="photo">
        <img src="${pageContext.request.contextPath}/downloadEntity/<c:out value="${issue.newsEntity.id}?type=news"/>" alt="Smiley face"
             height="300" width="450" style="border-radius: 10px">
    </div>
    <div horizontal="hor" class="news_title">
        <div style="height: 270px;  width:500px;">
                <strong>${issue.title}</strong></a>
        </div>
        <div style="height: 35px; font-size: 18px; ">
            ${issue.date}
        </div>
    </div>
    <div  class="text" style="width: 980px">
        <p>${issue.text}<p>
    </div>
</div>