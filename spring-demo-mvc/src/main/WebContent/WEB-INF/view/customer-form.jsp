<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Customer form</title>
        <style>
            .error {color:red}
        </style>
    </head>
    <body>
        Please fill up the form, Asterisk (*) means required
        <br><br>
        <form:form action="processForm" modelAttribute="customer">
            First Name : <form:input path="firstName" />
            <br><br>
            LastName*: <form:input path="lastName" />
            <form:errors path="lastName" cssClass="error" />
            <br><br>

            <input type="submit" value="Process" />
        </form:form>
    </body>
</html>