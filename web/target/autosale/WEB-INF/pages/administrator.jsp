<%@ include file="begin-html.jsp" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div style="margin-left: 1%; margin-top: 1%">
    <%--<f:form modelAttribute="news" action="${pageContext.request.contextPath}/uploadNews" method="post" enctype="multipart/form-data">--%>
    <%--<div class="row">--%>
    <%--<b>--%>
    <%--<div class=col-md-2>Название новости</div>--%>
    <%--<div class=col-md-5>Содержание</div>--%>
    <%--<div class=col-md-2>Изображение</div>--%>
    <%--</b>--%>
    <%--</div>--%>
    <%--<div class="row">--%>
    <%--<div class=col-md-2>--%>
    <%--<p class="bg-danger"><f:errors path="title"/></p>--%>
    <%--<f:input id="title" path="title" type="text" class="form-control input-md"/>--%>
    <%--</div>--%>
    <%--<div class=col-md-5>--%>
    <%--<p class="bg-danger"><f:errors path="title"/></p>--%>
    <%--<f:textarea rows="1" cssStyle="max-width: 550px" id="text" path="text" type="text"--%>
    <%--class="form-control input-md"/>--%>
    <%--</div>--%>
    <%--<div class=col-md-2>--%>
    <%--<label in="upload" for="file" style="margin-left: auto">--%>
    <%--<i class="fa fa-upload fa-2x" aria-hidden="true"--%>
    <%--style="margin-right: 9px"></i>--%>
    <%--<span id="label_span">Выберите фото</span></label>--%>
    <%--<div id="imgpreview" style="margin-left: -13px">--%>
    <%--</div>--%>
    <%--<f:input type="file" id="file" path="file" style="display: inline-block"/>--%>
    <%--</div>--%>
    <%--<div class=col-md-2>--%>
    <%--<button class="btn btn-default" type="submit" style="height: 40px;  border: 0px; font-size: unset;  background: #9fd81b;--%>
    <%--color: #fff; font-weight: 700"/>--%>
    <%--Добавить</button>--%>
    <%--</div>--%>
    <%--<br>--%>
    <%--<br>--%>
    <%--</div>--%>
    <%--</f:form>--%>
    <b>
        <div class="row">
            <div class=col-md-2>Название новости</div>
            <div class=col-md-5>Содержание</div>
            <div class=col-md-2>Изображение</div>
        </div>
    </b>
    <c:forEach var="element" items="${n}">
        <f:form modelAttribute="news" action="${pageContext.request.contextPath}/uploadNews" method="post"
                enctype="multipart/form-data">
            <div class="row">
                <div class=col-md-1 style="width: 90px">
                    <p class="bg-danger"><f:errors path="title"/></p>
                    <f:input id="id" value="${element.id}" path="id" type="text" class="form-control input-md"/>
                </div>
                <div class=col-md-2>
                    <p class="bg-danger"><f:errors path="title"/></p>
                    <f:input id="title" value="${element.title}" path="title" type="text"
                             class="form-control input-md"/>
                </div>
                <div class=col-md-5>
                    <p class="bg-danger"><f:errors path="title"/></p>
                        <%--<f:textarea rows="1"  cssStyle="max-width: 550px"   path="text" type="text"--%>
                        <%--class="form-control input-md"  placeholder="${element.text}"/>--%>
                    <textarea id="text" name="text" rows="1" cols="100"
                              style="max-width: 550px">${element.text}</textarea>
                </div>
                <div class=col-md-1>
                    <label in="upload" for="file" >
                        <i class="fa fa-upload fa-2x" aria-hidden="true"
                           style="margin-right: 9px"></i>
                        <span id="label_span"></span></label>
                    <div id="imgpreview" style="margin-left: -13px">
                    </div>
                    <f:input type="file" id="file" path="file" style="display: inline-block"/>
                </div>
                <div class=col-md-1>
                    <button class="btn btn-default" type="submit" name="save" style="height: 40px;  border: 0px; font-size: unset;  background: green;
                    color: #fff; font-weight: 700"/>
                    Cохранить</button>
                </div>
                <div class=col-md-1>
                    <button class="btn btn-default" type="submit" name="update" style="height: 40px;  border: 0px; font-size: unset;  background: green;
                           color: #fff; font-weight: 700"/>
                    Oбновить</button>
                </div>
                <div class=col-md-1>
                    <button class="btn btn-default" type="submit" name="delete" style="height: 40px;  border: 0px; font-size: unset;  background: red;
                           color: #fff; font-weight: 700"/>
                   Удалить</button>
                </div>
                <br>
                <br>
            </div>
        </f:form>
    </c:forEach>
    <%--<c:forEach var="element" items="${n}" >--%>
    <%--<div class="row">--%>
    <%--<form  action="${pageContext.request.contextPath}/updateOrDelete"  method="post" >--%>
    <%--<div class=col-md-1>--%>
    <%--<input id="${element.id}" name="ID" type="text"--%>
    <%--value="${element.id}" class="form-control input-md">--%>
    <%--</div>--%>
    <%--<div class=col-md-2>--%>
    <%--<input id="${element.title}" name="title" type="text"--%>
    <%--value="${element.title}" class="form-control input-md">--%>
    <%--</div>--%>
    <%--<div class=col-md-5>--%>
    <%--<textarea id="${element.text}" name="aaa">${element.text}</textarea>--%>
    <%--<input id="${element.text}" name="text" type="textarea"--%>
    <%--&lt;%&ndash;value="${element.text}" class="form-control input-md" style="width: 500px;">&ndash;%&gt;--%>
    <%--</div>--%>
    <%--<div horizontal="hor" class=col-md-1>--%>
    <%--<img src="${pageContext.request.contextPath}/downloadNews/<c:out value="${element.fileEntity.id}"/>" alt="Smiley face"--%>
    <%--height="60" width="60" style="border-radius: 10px">--%>
    <%--</div>--%>
    <%--<div class=col-md-1>--%>
    <%--<button  name="singlebutton" class="btn btn-success" type="submit">--%>
    <%--Обновить--%>
    <%--</button>--%>
    <%--</div>--%>
    <%--<div class=col-md-1>--%>
    <%--<button  name="singlebutton" class="btn btn-danger" type="submit">--%>
    <%--Удалить--%>
    <%--</button>--%>
    <%--</div>--%>
    <%--</form>--%>
    <%--</div>--%>
    <%--<br>--%>
    <%--</c:forEach>--%>
</div>

<script src="resources/script/uploadbutton.js"></script>
<script src="resources/script/imgpreview.js"></script>

