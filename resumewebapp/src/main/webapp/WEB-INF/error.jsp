<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 17.05.2022
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Why are you here ?</title>
</head>
<body>
<center>
    <%
        out.print(request.getParameter("msg"));
    %>
</center>
</body>
</html>
