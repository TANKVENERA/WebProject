<%@ include file="begin-html.jsp" %>
<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<div style="margin-left: 1%; margin-top: 1%">
    <b>
        <div class="row">
            <div class=col-md-1 style="width: 90px">ID</div>
            <div class=col-md-2>Название новости</div>
            <div class=col-md-4>Содержание</div>
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
                <div class=col-md-4>
                    <p class="bg-danger"><f:errors path="title"/></p>
                    <textarea id="text" name="text" rows="1" cols="100"
                              style="max-width: 430px">${element.text}</textarea>
                </div>
                <div class="col-md-1">
                    <img src="${pageContext.request.contextPath}/downloadEntity/<c:out value="${element.newsEntity.id}?type=news"/>"
                         alt="Smiley face"
                         height="60" width="60" style="border-radius: 10px">
                </div>
                <div class=col-md-1 style="margin-left: -30px">
                    <label in="upload" for="file-${element.id}">
                        <i class="fa fa-upload fa-2x" aria-hidden="true"
                           style="margin-right: 9px"></i>
                        <span id="label_span"></span></label>
                    <div id="imgpreview-${element.id}" style="margin-left: -13px">
                    </div>
                    <f:input type="file" id="file-${element.id}" data-id="${element.id}" path="file" class="files"
                             style="display: inline-block"/>
                </div>
                <div class=col-md-1>
                    <button class="btn btn-default" type="submit" name="save" style="height: 40px;  border: 0; font-size: unset;  background: #9fd81b;
                                    color: #fff; font-weight: 700; margin-left: -5px"/>
                    Cохранить</button>
                </div>
                <div class=col-md-1>
                    <button class="btn btn-default" type="submit" name="update" style="height: 40px;  border: 0; font-size: unset;  background: green;
                                           color: #fff; font-weight: 700"/>
                    Oбновить</button>
                </div>
                <div class=col-md-1>
                    <button class="btn btn-default"  name="delete" style="height: 40px;  border: 0; font-size: unset;  background: red;
                                           color: #fff; font-weight: 700"/>
                    Удалить</button>
                </div>
                <br>
                <br>
            </div>
        </f:form>
    </c:forEach>
</div>
<script src="resources/script/uploadbutton.js"></script>
<script src="resources/script/imgpreview.js"></script>

