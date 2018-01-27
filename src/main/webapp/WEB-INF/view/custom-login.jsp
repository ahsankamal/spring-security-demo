<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
<title>Spring Security</title>
</head>

<body>
    <h3>Custom Login</h3>
    <!--form:form automagically add csrf hidden field-->
    <form:form action="${pageContext.request.contextPath}/authenticateUserCredentials" method="POST">

          <c:if test="${param.logout!=null}">
            <i> you have been logged out</i>
          </c:if>

          <c:if test="${param.error!=null}">
            <i> wrong username/password</i>
          </c:if>
         <p> Username: <input type="text" name="username"></p>
         <p> Password: <input type="password" name="password"></p>
         <input type="submit" value="login"/>
    </form:form>
</body>

</html>