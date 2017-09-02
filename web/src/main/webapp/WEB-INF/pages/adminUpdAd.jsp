<%@ include file="begin-html.jsp" %>
<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<div style="margin-left: 1%; margin-top: 1%">
    <b>
        <div class="row">
            <div class=col-md-1 style="width: 90px">ID</div>
            <div class=col-md-1>Модель</div>
            <div class=col-md-1>Марка</div>
            <div class=col-md-1>Двигатель</div>
            <div class=col-md-1>Цена</div>
            <div class=col-md-1>г. в.</div>
            <div class=col-md-1>Описание</div>
        </div>
    </b>
    <c:forEach var="adList" items="${listAds}">
        <f:form modelAttribute="ads" action="${pageContext.request.contextPath}/updateAdByAdmin" method="post"
                enctype="multipart/form-data">
            <f:input id="id" value="${adList.bodyStyle}" path="bodyStyle" type="hidden"/>
            <f:input id="id" value="${adList.color}" path="color" type="hidden"/>
            <f:input id="id" value="${adList.transmission}" path="transmission" type="hidden"/>
            <f:input id="id" value="${adList.mileAge}" path="mileAge" type="hidden"/>
            <f:input id="id" value="${adList.user}" path="user" type="hidden"/>
            <div class="row">
                <div class=col-md-1 style="width: 90px">
                    <f:input id="id" value="${adList.id}" path="id" type="text" class="form-control input-md"/>
                </div>
                <div class=col-md-1>
                    <f:input id="title" value="${adList.modelAuto}" path="modelAuto" type="text"
                             class="form-control input-md"/>
                </div>
                <div class=col-md-1>
                    <f:input id="title" value="${adList.markAuto}" path="markAuto" type="text"
                             class="form-control input-md"/>
                </div>
                <div class=col-md-1>
                    <f:input id="title" value="${adList.engine}" path="engine" type="text"
                             class="form-control input-md"/>
                </div>
                <div class=col-md-1>
                    <f:input id="title" value="${adList.price}" path="price" type="text"
                             class="form-control input-md" />
                </div>
                <div class=col-md-1>
                    <f:input id="title" value="${adList.yearOfIssue}" path="yearOfIssue" type="text"
                             class="form-control input-md"/>
                </div>
                <div class=col-md-1>
                    <textarea id="text" name="carDescription" rows="1" cols="7"
                              style="max-width: 430px">${adList.carDescription}</textarea>
                </div>

                <div class="col-md-1">
                    <img src="${pageContext.request.contextPath}/downloadEntity/<c:out value="${adList.adEntities[0].id}?type=ad"/>"
                         alt="Smiley face"
                         height="60" width="60" style="border-radius: 10px">
                </div>
                <div class=col-md-1 style="margin-left: -55px">
                    <label in="upload" for="file-${adList.id}">
                        <i class="fa fa-upload fa-2x" aria-hidden="true"
                           style="margin-right: 9px"></i>
                        <span id="label_span"></span></label>
                    <div id="imgpreview-${adList.id}" style="margin-left: -13px">
                    </div>
                    <f:input type="file" id="file-${adList.id}" data-id="${adList.id}" path="file" class="files"
                             style="display: inline-block"/>
                </div>
                <div class=col-md-1>
                    <button class="btn btn-default" type="submit" name="save" style="height: 40px;  border: 0; font-size: unset;  background: #9fd81b;
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
<script src="resources/script/uploadbutton.js"></script>
<script src="resources/script/imgpreview.js"></script>

