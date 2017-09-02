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
                    <a href="${pageContext.request.contextPath}/notes" class="swagBtn">Закладки</a>
                </div>
                <div>
                    <a href="#" class="swagBtn">Сообщения</a>
                </div>
                <div>
                    <a href="${pageContext.request.contextPath}/updateBlank" class="swagBtn">Настройки</a>
                </div>
                <div class="exit" style="padding-top: 50px; padding-bottom: 50px; ">
                    <a href="<c:url value="/logout" />" class="swagBtn">Выход</a>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-7" style="margin-left: 15%; margin-top: 25%">
    <div  id="register">
        <div class="Mymodal" style="width: 400px; height: 400px; background-color: #5cb85c" >
            <f:form method="POST" modelAttribute="user" action="${pageContext.request.contextPath}/updateUser">
                <strong modal="m" style="font-size: 35px">Настройки аккаунта</strong>
                <f:input modal="m" value="${user.id}" path="id" type="hidden"/>
                <f:input modal="m" value="${user.email}" path="email"    type="hidden" />
                <f:input modal="m" value="${user.password}" path="password"    type="hidden" /><br>
                <p class="bg-danger" ><f:errors path="username"/></p>
                <f:input modal="m" value="${user.username}" path="username" type="text" placeholder="Имя"/><br>
                <input modal="m" value="${user.email}" disabled="disabled"/>
                <input modal="m" name="newPassword"  type="password" placeholder="Пароль"/><br>
                <input modal="m" name="confirmPassword" type="password" placeholder="Повторите Пароль"/><br>
                <input modal="m" type="submit" name="save" class="BtnRegister"
                       style="font-size: 25pt; font-family: CitricaCyrillic" value="Обновить">
            </f:form>
        </div>
    </div>
    </div>
</div>