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

            Free Passes : <form:input type="number" path="freePasses" />
            <form:errors path="freePasses" cssClass="error" />
            <br><br>

            Postal Code : <form:input type="text" path="postalCode" />
            <form:errors path="postalCode" cssClass="error" />
            <br><br>

            Course Code : <form:input type="text" path="courseCode" />
            <form:errors path="courseCode" cssClass="error" />
            <br><br>

            Email : <form:input type="text" path="email" />
            <form:errors path="email" cssClass="error" />
            <br><br>

            <input type="submit" value="Process" />
        </form:form>
    </body>
</html>