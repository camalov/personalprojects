<%--
    Document   : details
    Created on : 13.May.2022, 16:09:27
    Author     : PC
--%>

<%@page import="com.company.dao.repository.UserRepository" %>
<%@page import="com.company.entity.User" %>
<%@page import="com.company.main.Context" %>
<%@ page import="com.company.dao.repository.UserRepositoryCustomImpl" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Details</title>
</head>
<body>
<%
    UserRepository userDao = ;
    User user = userDao.getById(1);
%>

<div>
    <form action="UserController" method="POST">
        <%--@declare id="adress"--%><%--@declare id="phone"--%><%--@declare id="email"--%><%--@declare id="birthate"--%>
        <input type="hidden" name="id" value="<%=user.getId()%>"/>
        <label for="adress">adress : </label>
        <input type="text" name="adress" value="<%=user.getAdress()%>"/>

        <br/>
        <label for="phone">phone : </label>
        <input type="text" name="phone" value="<%=user.getPhone()%>"/>

        <br/>
        <label for="email">email : </label>
        <input type="text" name="email" value="<%=user.getEmail()%>"/>

        <br/>
        <label for="birthate">birthdate : </label>
        <input type="text" name="birthate" value="<%=user.getBirthdate()%>"/>

        <input type="submit" name="submit" value="save">
    </form>
</div>
</body>
</html>
