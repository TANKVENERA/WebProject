<%@ include file="begin-html.jsp" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<div class="main" >
    <f:form action="${pageContext.request.contextPath}/createAd" modelAttribute="ad" method="POST"  enctype="multipart/form-data">
    <h1 style="text-align: center; padding-top: 25px"><strong>Новое объявление</strong></h1>
    <div>
        <label>Марка автомобиля</label>
        <f:select name="CarModel" id="level" path="modelAuto" onchange="showNames(this.value)" class="textarea">
            <option value="Start">Model</option>
            <option value="Alfa_Romeo">Alfa Romeo</option>
            <option value="Audi">Audi</option>
            <option value="Acura">Acura</option>
            <option value="BMW">BMW</option>
            <option value="Cadillac">Cadillac</option>
            <option value="Chevrolet">Chevrolet</option>
            <option value="Chrysler">Chrysler</option>
            <option value="Citroen">Citroen</option>
            <option value="Daewoo">Daewoo</option>
            <option value="Fiat">Fiat</option>
            <option value="Ford">Ford</option>
            <option value="Honda">Honda</option>
            <option value="Hyundai">Hyundai</option>
            <option value="Toyota">Toyota</option>
            <option value="Audi">Audi</option>
            <option value="Toyota">Toyota</option>
            <option value="Mercedes_Benz">Mercedes_Benz</option>
            <option value="Volkswagen">Volkswagen</option>
        </f:select>
    </div>
    <div>
        <label>Модель</label>
        <f:select name="CarMark" path="markAuto" id="model" class="textarea"> </f:select>
    </div>
    <div>
        <label for="YearOfIssue">Год выпуска</label>
        <f:input type="text" path="yearOfIssue"  id="YearOfIssue" size="15" class="textarea"/>
    </div>
    <div>
        <label for="Price">Цена</label>
        <f:input type="text" path="price"  id="Price" size="15" class="textarea"/>
    </div>
    <div>
        <label for="Description" style="float: left;">Описание автомобиля</label>
        <textarea name="carDescription" maxlength="4000" id="Description" cols="50" rows="5"
                  style="resize: none; overflow: hidden; height: 160px;" class="textarea"></textarea>
    </div>
    <div>
        <label for="Engine">Объем двигателя и тип топлива</label>
        <f:input type="text" path="engine"  id="Engine" size="25" class="textarea"/>
    </div>
    <div>
        <label for="Transmission">Трансмиссия</label>
        <f:input type="text" path="transmission"  id="Transmission" size="25" class="textarea"/>
    </div>
    <div>
        <label for="Color">Цвет</label>
        <f:input type="text" path="color"  id="Color" size="25" class="textarea"/>
    </div>
    <div>
        <label for="MileAge">Пробег</label>
        <f:input type="text" path="mileAge"  id="MileAge" size="25" class="textarea"/>
    </div>
    <div>
        <label for="BodyStyle">Тип кузова</label>
        <f:select  path="bodyStyle" id="BodyStyle" class="textarea">
            <option value="Cabriolet">Кабриолет</option>
            <option value="Coupe">Купе</option>
            <option value="Sedan">Седан</option>
            <option value="Miniven">Минивен</option>
            <option value="Universal">Универсал</option>
            <option value="Allroad">Внедорожник</option>
            <option value="Other">Другое</option>
        </f:select>
    </div>
    <div class="div-form">
            <label in="upload" for="file"><i class="fa fa-upload fa-2x" aria-hidden="true" style="margin-right: 9px"></i>
                <span id="label_span">Выберите фото для загрузки</span></label>
            <div id="imgprev">
            </div>
            <f:input type="file" id="file" name="file" multiple="true" path="file"  style="display: inline-block"/>
            <input type="submit" style="height: 40px; border-radius: 3px; border: 0px; transition: 0.3ms;  background: #009688;
color: #fff; font-weight: 700; margin-left: 40%; width: 30%"/>
    </div>

    </f:form>
</div>
<script src="resources/script/uploadbutton.js"></script>
<script src="resources/script/imgprev.js"></script>


