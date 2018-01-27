<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
<title>Spring Security</title>
</head>

<body>
    <p>This is spring security</p>

    <form:form action="${pageContext.request.contextPath}/logout" method="POST">


             <input type="submit" value="logout"/>
        </form:form>
</body>

</html>