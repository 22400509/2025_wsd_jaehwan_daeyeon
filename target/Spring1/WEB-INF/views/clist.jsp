<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img src="./img/dog.png" width="300" />
<h1>${msg}</h1>
    <c:forEach var="name" items="${classlist}" varStatus="status">
        <p>${status.count} : ${name}</p>
    </c:forEach>
</body>
</html>