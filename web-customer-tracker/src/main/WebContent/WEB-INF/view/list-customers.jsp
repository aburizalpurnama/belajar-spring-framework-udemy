<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
                <h2>CRM Customer Relationship Manager</h2>
            </div>
        </div>

        <div id="container">
            <div id="content">

                <!-- add add customer button here -->
                <input type="button" value="Add Customer"
                       onclick="window.location.href='showFormForAdd'; return false;"
                       class="add-button"
                />

                <!-- add search form -->
                <form:form action="search" method="GET">
                    Search Customer: <input type="text" name="theSearchName"/>

                    <input type="submit" value="Search" class="add-button"/>
                </form:form>

                <div style="clear; both;"></div>

                <!-- add html table here-->
                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>

                    <!-- loop over and print data customers-->
                    <c:forEach var="customer" items="${customers}">

                        <!-- construct an "update" link with customer id -->
                        <c:url var="updateLink" value="/customer/showFormForUpdate">
                            <c:param name="customerId" value="${customer.id}" />
                        </c:url>

                        <!-- construc an "delete" link with customer id -->
                        <c:url var="deleteLink" value="/customer/deleteCustomer">
                            <c:param name="customerId" value="${customer.id}" />
                        </c:url>

                        <tr>
                            <td>${customer.firstName}</td>
                            <td>${customer.lastName}</td>
                            <td>${customer.email}</td>
                            <td>
                                <!-- display the update link -->
                                <a href="${updateLink}">Update</a> |

                                <!-- display the delete link -->
                                <a href="${deleteLink}"
                                    onclick="if (!(confirm('Are you sure want to delete this customer ?'))) return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>

    </body>
</html>