<%@ include file="begin-html.jsp" %>
<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<div class="container-fluid">
    <form action="${pageContext.request.contextPath}/selectAds" class="form-inline navbar-form" method="POST">
        <div inline="eee">
            <select name="CarModel" id="level" onchange="showNames(this.value)" class="option">
                <option value="Start">Модель</option>
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
            </select>
        </div>
        <div inline="eee" class="option">
            <select name="CarMark" id="model">
            </select>
        </div>
        <div inline="eee">
            <input title="qwert"  name="YearOfIssueFrom" size="16" id="YearOfIssueFrom" placeholder="Год выпуска с">
        </div>
        <div inline="eee">
            <input title="qwert" name="YearOfIssueTo" size="16" id="YearOfIssueTo" placeholder="Год выпуска по">
        </div>
        <div inline="eee">
            <input title="qwert" name="PriceFrom" size="16" id="PriceFrom" placeholder="Цена с $">
        </div>
        <div inline="eee">
            <input title="qwert" name="PriceTo" size="16" id="PriceTo" placeholder="Цена по $">
        </div>
        <div inline="eee">
            <button submit="submit" type="submit">Submit</button>
        </div>
    </form>
</div>
<div class="col-md-2">
    <aside class="aside">
        <ul>
            <li><a href="#">Alfa Romeo</a></li>
            <li><a href="#">Acura</a></li>
            <li><a href="#">Audi</a></li>
            <li><a href="#">BMW</a></li>
            <li><a href="#">Caddilac</a></li>
            <li><a href="#">Chevrolet</a></li>
            <li><a href="#">Chrysler</a></li>
            <li><a href="#">Citroen</a></li>
            <li><a href="#">Daewoo</a></li>
            <li><a href="#">Dodge</a></li>
            <li><a href="#">Fiat</a></li>
            <li><a href="#">Ford</a></li>
        </ul>
    </aside>
</div>
<div class="col-md-2">
    <aside class="aside">
        <ul>
            <li><a href="#">Honda</a></li>
            <li><a href="#">Hyundai</a></li>
            <li><a href="#">Infiniti</a></li>
            <li><a href="#">Jaguar</a></li>
            <li><a href="#">Jeep</a></li>
            <li><a href="#">Kia</a></li>
            <li><a href="#">Lada</a></li>
            <li><a href="#">Lancia</a></li>
            <li><a href="#">Land Rover</a></li>
            <li><a href="#">Lexus</a></li>
            <li><a href="#">Mazda</a></li>
            <li><a href="#">Mercedes-Benz</a></li>
        </ul>
    </aside>
</div>
<div class="col-md-4">
    <div id="locations" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner" class="cars">
            <div class="item active">
                <a class="carousel" href="#">
                    <img src="${pageContext.request.contextPath}/resources/images/typoi.gif" alt=""> </a>
                <div class="carousel-caption">
                    <h3> News </h3>
                </div>
            </div>
            <div class="item">
                <a class="carousel" href="#">
                    <img src="${pageContext.request.contextPath}/resources/images/nikulin.gif" alt=""> </a>
                <div class="carousel-caption">
                    <h3> NEWS </h3>
                </div>
            </div>
            <div class="item">
                <a class="carousel" href="#">
                    <img src="${pageContext.request.contextPath}/resources/images/mers.jpg" alt=""> </a>
                <div class="carousel-caption">
                    <h3> News </h3>
                </div>
            </div>
            <div class="item">
                <a class="carousel" href="#">
                    <img src="${pageContext.request.contextPath}/resources/images/audi.jpg" alt="">
                </a>
                <div class="carousel-caption">
                    <h3> Новость </h3>
                </div>
            </div>
            <div class="item">
                <a class="carousel" href="#">
                    <img src="${pageContext.request.contextPath}/resources/images/porsh.jpg" alt=""></a>
                <div class="carousel-caption">
                    <h3> Something new </h3>
                </div>
            </div>
            <div class="item">
                <a class="carousel" href="#">
                    <img src="${pageContext.request.contextPath}/resources/images/vaz.jpg" alt=""></a>
                <div class="carousel-caption">
                    <h6> NEWS </h6>
                </div>
            </div>
        </div>
        <a class="left carousel-control" href="#locations" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="right carousel-control" href="#locations" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span></a>
    </div>
</div>
<div class="col-md-2">
    <aside class="aside">
        <ul>
            <li><a href="#">Mitsubishi</a></li>
            <li><a href="#">Nissan</a></li>
            <li><a href="#">Opel</a></li>
            <li><a href="#">Peugeot</a></li>
            <li><a href="#">Porshe</a></li>
            <li><a href="#">Renault</a></li>
            <li><a href="#">Rover</a></li>
            <li><a href="#">Saab</a></li>
            <li><a href="#">Seat</a></li>
            <li><a href="#">Skoda</a></li>
            <li><a href="#">Subaru</a></li>
            <li><a href="#">Suzuki</a></li>
        </ul>
    </aside>
</div>
<div class="col-md-2">
    <aside class="aside">
        <ul>
            <li><a href="#">Toyota</a></li>
            <li><a href="#">Volkswagen</a></li>
            <li><a href="#">Volvo</a></li>
            <li><a href="#">Mocквич</a></li>
            <li><a href="#">УАЗ</a></li>
            <li><a href="#">ГАЗ</a></li>
            <li><a href="#">МАЗ</a></li>
            <li><a href="#">КАМАЗ</a></li>
            <li><a href="#">Волга</a></li>
            <li><a href="#">Cherry</a></li>
            <li><a href="#">Great Wall</a></li>
            <li><a href="#">Lincoln</a></li>
        </ul>
    </aside>
</div>

<div class="modal_container" id="register" style="opacity: 0.9; pointer-events: auto;">
    <div class="Mymodal" style="top: -605px; left: 5px; height: 470px">
        <a href="${pageContext.request.contextPath}/close" class="close">X</a>
        <span class="modal_head">
                  REGISTRATION
                </span>
        <f:form  method="POST" modelAttribute="user" action="${pageContext.request.contextPath}/profile">
            <p class="bg-danger" ><f:errors path="username"/></p>
            <f:input  modal="m" path="username"  type="text" placeholder="Имя"/><br>
            <p class="bg-danger"><f:errors path="email"/></p>
            <f:input modal="m" path="email" type="text"  placeholder="Адрес почты"/><br>
            <p class="bg-danger"><f:errors path="password"/></p>
            <f:input modal="m" path="password" type="text" placeholder="Пароль"/><br>
            <input modal="m"  type="submit" name="save" class="BtnRegister"
                   style="font-size: 25pt; font-family: CitricaCyrillic" value="Зарегестрировать">
        </f:form>
    </div>
</div>
