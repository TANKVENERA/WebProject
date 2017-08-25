<%@ include file="begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<c:forEach var="ad" items="${listAds}">
    <div class="adv">
        <div horizontal="hor" class="photo">
            <a href="#"><img src="${pageContext.request.contextPath}/images?foto=${ad.carPhotos[0].filePath}"
                             width="195" height="195" style="vertical-align: bottom; border-radius: 10px"></a>
        </div>
        <div horizontal="hor" class="price">
            <ul align="a">
                <ul v="v">
                    <li><a cursiv="c">г.в</a></li>
                    <li><a style="text-decoration: none"><strong>${ad.yearOfIssue}</strong></a></li>
                </ul>
                <ul v="v">
                    <li><a cursiv="c">цена</a></li>
                    <li><a style="text-decoration: none"><strong
                            style="font-family: dkBlackBamboo; letter-spacing: 5px">${ad.price}</strong></a></li>
                </ul>
                <ul v="v">
                    <li><a cursiv="c">пробег</a></li>
                    <li><a style="text-decoration: none"><strong>${ad.mileAge}</strong></a></li>
                </ul>
            </ul>
        </div>
        <div horizontal="hor" class="info">
            <div style="height: 35px; color: #1a60ba">
                <a href="#" style="text-decoration: none;"><strong>${ad.modelAuto} ${ad.markAuto}</strong></a>
            </div>
            <div style="height:35px; font-size: 20px ">
                <b> ${ad.transmission}, ${ad.engine}</b>
            </div>
            <div class="text">
                <c:if test="${ad.carDescription.length() >= 300}">
                <p>${ad.carDescription.substring(0, 300)}<p>
                </c:if>
                <c:if test="${ad.carDescription.length() < 300}">
                <p>${ad.carDescription}<p>
                </c:if>
            </div>
        </div>
        <div horizontal="hor" class="basket">
            <a href="#"><i class="fa fa-shopping-basket fa-3x" aria-hidden="true" style="color: #987c7c"></i></a>
        </div>
    </div>
</c:forEach>
