<%@ include file="begin-html.jsp" %>
<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<html>
<c:forEach var="element" items="${news}">
    <div class="news" >
        <div horizontal="hor" class="photo">
    <img src="${pageContext.request.contextPath}/downloadNews/<c:out value="${element.fileEntity.id}"/>" alt="Smiley face"
    height="300" width="450" style="border-radius: 10px">
</div>
<div horizontal="hor" class="news_title">
<div style="height: 270px;  width:500px;">
   <strong>${element.title}</strong>
</div>
    <div style="height: 35px; font-size: 18px; ">
  ${element.date}
    </div>
</div>
        <div  class="text" style="width: 980px">
            <c:if test="${element.text.length() >= 1210}">
            <p>${element.text.substring(0, 1210)}<p>
            </c:if>
            <c:if test="${element.text.length() < 1210}">
            <p>${element.text}<p>
            </c:if>
        </div>
</div>
</c:forEach>
</html>
