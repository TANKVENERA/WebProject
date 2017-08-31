<%@ include file="begin-html.jsp" %>
<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<div style="margin-left: 1%; margin-top: 5%">
    <b>
        <div class="row">
            <div class=col-md-2>Все пользователи</div>
            <div class=col-md-2>Пользов. по ID</div>
            <div class=col-md-2>Пользов. по имени</div>
            <div class=col-md-2>Все оъявления</div>
            <div class=col-md-2>Объявл. по ID</div>
            <div class=col-md-2 style="padding-left: 4px">Объявл. по имени</div>
        </div>
    </b>
    <form action="${pageContext.request.contextPath}/getAllUsers" method="get">
        <div class=col-md-2>
            <button super="super" class="btn btn-default" type="submit" name="getAllUsers"/>
            Подобрать</button>
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/getUserByID" method="post">
        <div class=col-md-2>
            <div style="padding-bottom: 10px">
                <input name="getUserByID" type="text" size="3" class="form-control input-md" placeholder="ID"
                       style=" font-size: 25px; width:120px"/>
            </div>
            <button super="super" class="btn btn-default" type="submit"/>
            Подобрать</button>
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/getUserByName" method="post">
        <div class=col-md-2>
            <div style="padding-bottom: 10px">
                <input name="getUserByName" type="text" class="form-control input-md" placeholder="UserName"
                       style=" font-size: 20px; width:120px"/>
            </div>
            <button super="super" class="btn btn-default" type="submit"/>
            Подобрать</button>
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/allAdsByAdmin" method="get">
        <div class=col-md-2>
            <button super="super" class="btn btn-default" type="submit" />
            Подобрать</button>
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/allAdsByID" method="post">
    <div class=col-md-2>
        <div style="padding-bottom: 10px">
            <input name="getAdById" type="text" class="form-control input-md" placeholder="ID"
                   style=" font-size: 25px; width:120px"/>
        </div>
        <button super="super" class="btn btn-default" />
        Подобрать</button>
    </div>
    </form>
    <form action="${pageContext.request.contextPath}/allAdsByName" method="post">
    <div class=col-md-2>
        <div style="padding-bottom: 10px">
            <input name="getAdByUsername" type="text" class="form-control input-md" placeholder="Username"
                   style=" font-size: 20px; width:120px"/>
        </div>
        <button super="super" class="btn btn-default" />
        Подобрать</button>
    </div>
    </form>

</div>


