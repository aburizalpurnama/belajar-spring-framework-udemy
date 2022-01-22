<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="com.rizal.springdemo.crm.util.SortUtil" %>

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

                <!-- construc a sort link for firstName -->
                <c:url var="sortLinkFirstName" value="/customer/list">
                    <c:param name="sort" value="<%= Integer.toString(SortUtil.FIRST_NAME) %>" />
                </c:url>

                <!-- construc a sort link for lastName -->
                <c:url var="sortLinkLastName" value="/customer/list">
                    <c:param name="sort" value="<%= Integer.toString(SortUtil.LAST_NAME) %>" />
                </c:url>

                <!-- construc a sort link for firstName -->
                <c:url var="sortLinkEmail" value="/customer/list">
                    <c:param name="sort" value="<%= Integer.toString(SortUtil.EMAIL) %>" />
                </c:url>

                <!-- add html table here-->
                <table>
                    <tr>
                        <th><a href="${sortLinkFirstName}">First Name</a></th>
                        <th><a href="${sortLinkLastName}">Last Name</a></th>
                        <th><a href="${sortLinkEmail}">Email</a></th>
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