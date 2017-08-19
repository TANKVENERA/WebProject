<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<f:form  method="POST" modelAttribute="user" action="${pageContext.request.contextPath}/profile">
    <p class="bg-danger"><f:errors path="username"/></p>
    <f:input  modal="m" path="username"  type="text" placeholder="Имя"/><br>
    <f:input modal="m" path="email" type="text"  placeholder="Адрес почты"/><br>
    <p class="bg-danger"><f:errors path="password"/></p>
    <f:input modal="m" path="password" type="text" placeholder="Пароль"/><br>
    <input modal="m"  type="submit" name="save" class="BtnRegister"
           style="font-size: 25pt; font-family: CitricaCyrillic" value="Зарегестрировать">
</f:form>
</body>
</html>
