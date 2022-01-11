<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
    <title>Student Form</title>
    </head>

    <body>
        <form:form action="processForm" modelAttribute="student">

            <%-- Path value is refference to name of field on class --%>

            First name : <form:input path="firstName"/>

            <br><br>

            Last name : <form:input path="lastName"/>

            <br><br>

            Select Country : <form:select path="country">
                <%-- populate the item options from properties file --%>
                <form:options items="${countryOptions}" />

                <%-- populate the item options with some List object described on Java file
                <form:options items="${student.countryOptions}" />
                --%>

                <%-- Populate the item options manualy
                <form:option value="Brazil" label="Brazil" />
                <form:option value="Indonesia" label="Indonesia" />
                <form:option value="Malaysia" label="Malaysia" />
                <form:option value="Singapura" label="Singapura" />
                <form:option value="Thailand" label="Thailand" />
                --%>

            </form:select>

            <br><br>
            Favorite Language :
            <form:radiobuttons path="favoriteLanguage" items="${student.favLanguageOptions}" />

            <br><br>
            Experienced OS :
            <form:checkboxes path="operatingSystems" items="${operatingSystems}" />

            <br><br>
            <input type="submit" value="submit"/>


        </form:form>
    </body>
</html>