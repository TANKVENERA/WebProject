<%@ include file="begin-html.jsp" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<div class="row" style="margin-left:5%; margin-right: 5%; ">
    <div class="col-md-3">
        <div class="main">
            <div class="buttons" style="padding-top: 50px; display: inline-block; background-color: cornsilk; border-top-left-radius: 15px;
border-bottom-left-radius:15px;">
                <div>
                    <a href="${pageContext.request.contextPath}/new_ad" class="swagBtn" style="width: 200px">Cоздать
                        объявление</a>
                </div>
                <div>
                    <a href="${pageContext.request.contextPath}/userAds" class="swagBtn" style="width: 200px">Мои
                        объявления</a>
                </div>
                <div>
                    <a href="#" class="swagBtn">Закладки</a>
                </div>
                <div>
                    <a href="#" class="swagBtn">Сообщения</a>
                </div>
                <div>
                    <a href="${pageContext.request.contextPath}/updateUser" class="swagBtn">Настройки</a>
                </div>
                <div class="exit" style="padding-top: 50px; padding-bottom: 50px; ">
                    <a href="<c:url value="/logout" />" class="swagBtn">Выход</a>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-7" style="margin-left: 5%; margin-top: 3%; width: 849px; background-color: #fff; border-radius: 10px">
        <c:forEach var="ad" items="${userAds}">
            <div class="adv" style="width: 800px; ">
                <div>
                    <a href="${pageContext.request.contextPath}/deleteAdFromBasket/<c:out value="${ad.id}"/>"
                       class="close" style="position: inherit">X</a>
                </div>
                <div horizontal="hor" class="photo">
                    <a href="${pageContext.request.contextPath}/ad/<c:out value="${ad.id}"/>"><img
                            src="${pageContext.request.contextPath}/downloadEntity/<c:out value="${ad.adEntities[0].id}?type=ad"/>"
                            width="195" height="195" style="vertical-align: bottom; border-radius: 10px"></a>
                </div>
                <div horizontal="hor" class="price">
                    <ul align="a">
                        <ul v="v">
                            <li><a cursiv="c">г.в</a></li>
                            <li><a style="text-decoration: none"><strong>${ad.yearOfIssue} </strong></a></li>
                        </ul>
                        <ul v="v">
                            <li><a cursiv="c">цена</a></li>
                            <li><a style="text-decoration: none"><strong
                                    style="font-family: dkBlackBamboo; letter-spacing: 5px">${ad.price}</strong></a>
                            </li>
                        </ul>
                        <ul v="v">
                            <li><a cursiv="c">пробег</a></li>
                            <li><a style="text-decoration: none"><strong>${ad.mileAge}</strong></a></li>
                        </ul>
                    </ul>
                </div>
                <div horizontal="hor" class="info" style="width: 400px">
                    <div style="height: 35px; color: #1a60ba">
                        <a href="${pageContext.request.contextPath}/ad/<c:out value="${ad.id}"/>" style="text-decoration: none;">
                            <strong>${ad.modelAuto} ${ad.markAuto}</strong></a>
                    </div>
                    <div style="height:35px; font-size: 20px ">
                        <b> ${ad.transmission}, ${ad.engine}</b>
                    </div>
                    <div class="text">
                        <c:if test="${ad.carDescription.length() >= 200}">
                        <p>${ad.carDescription.substring(0, 200)}<p>
                        </c:if>
                        <c:if test="${ad.carDescription.length() < 200}">
                        <p>${ad.carDescription}<p>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

