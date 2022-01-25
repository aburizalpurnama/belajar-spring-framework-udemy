<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html>
    <head>
    <title>List of Customer</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    </head>
    <body>

        <div id="wrapper">
            <div id="header">
                <h2>Welcome To Company Home Page</h2>
            </div>
        </div>
        <hr>
        <div style="clear; both;"></div>
        <p>
            User Logged in : <security:authentication property="principal.username" /><br>
            Role : <security:authentication property="principal.authorities" />
        </p>
        <hr>
        <div style="clear; both;"></div>

        <form:form action="${pageContext.request.contextPath}/logout" method="POST">

            <input type="submit" value="Logout"/>

        </form:form>

    </body>
</html>