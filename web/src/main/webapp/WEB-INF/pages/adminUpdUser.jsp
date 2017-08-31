<%@ include file="begin-html.jsp" %>
<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<div style="margin-left: 1%; margin-top: 1%">
    <b>
        <div class="row">
            <div class=col-md-1 style="width: 90px">ID</div>
            <div class=col-md-2>Пароль</div>
            <div class=col-md-2>Имя пользователя</div>
            <div class=col-md-2>Email</div>
            <div class=col-md-2>Роль</div>
            <div class=col-md-2>Действие</div>
        </div>
    </b>
    <c:forEach var="users" items="${userDTOS}">
        <f:form modelAttribute="user" action="${pageContext.request.contextPath}/updateUserByAdmin" method="post"
                enctype="multipart/form-data">

            <div class="row">
                <div class=col-md-1 style="width: 90px">
                    <f:input id="id" value="${users.id}" path="id" type="text" class="form-control input-md"/>
                </div>
                <div class=col-md-2>
                    <f:input id="title" value="${users.password}" path="password" type="text"
                             class="form-control input-md"/>
                </div>
                <div class=col-md-2>
                    <f:input id="title" value="${users.username}" path="username" type="text"
                             class="form-control input-md"/>
                </div>
                <div class=col-md-2>
                    <f:input id="title" value="${users.email}" path="email" type="text"
                             class="form-control input-md"/>
                </div>
                <div class=col-md-2>
                    <f:input id="title" value="${users.role}" path="role" type="text"
                             class="form-control input-md"/>
                </div>
                <div class=col-md-1>
                    <button class="btn btn-default" type="submit" name="save" style="height: 40px;  border: 0px; font-size: unset;  background: #9fd81b;
                                    color: #fff; font-weight: 700; margin-left: -5px"/>
                    Cохранить</button>
                </div>
                <div class=col-md-1>
                    <button class="btn btn-default" type="submit" name="update" style="height: 40px;  border: 0px; font-size: unset;  background: green;
                                           color: #fff; font-weight: 700"/>
                    Oбновить</button>
                </div>
                <div class=col-md-1>
                    <button class="btn btn-default"  name="delete" style="height: 40px;  border: 0px; font-size: unset;  background: red;
                                           color: #fff; font-weight: 700"/>
                    Удалить</button>
                </div>
                <br>
                <br>
            </div>
        </f:form>
    </c:forEach>
</div>

