<%-- 
    Document   : user
    Created on : 12.May.2022, 14:34:09
    Author     : PC
--%>

<%@page import="com.company.entity.Country" %>
<%@page import="com.company.entity.User" %>
<%@page import="com.company.resume.util.CountryRequestUtil" %>
<%@page import="java.util.List" %>
<%@ page import="com.company.entity.EmploymentHistory" %>
<%@ page import="com.company.resume.util.EmploymentHistoryRequestUtil" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
    <title>User Detail</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
    List<Country> countries = CountryRequestUtil.getAll();
    List<EmploymentHistory> employmentHistoryList = EmploymentHistoryRequestUtil.getAllByUserId(user.getId());
%>

<div class="mycontainer">
    <div class="row d-flex justify-content-center">
        <div class="col-md-4 col-sm-6 col-xs-6">
            <form action="userdetail" method="POST">
                <%--@declare id="name"--%><%--@declare id="surname"--%>
                <%--@declare id="adress"--%><%--@declare id="phone"--%>
                <%--@declare id="email"--%>
                <input type="hidden" name="id" value="<%=user.getId()%>"/>
                <input type="hidden" name="action" value="update"/>

                    <% if(employmentHistoryList.size() > 0) {%>
                <input type="hidden" name="employmentHistoryId"
                       value="<%=employmentHistoryList.get(0).getId()%>"/>
                    <%}%>

                <div class="form-group">
                    <label for="name">name : </label>
                    <input class="form-control" type="text" name="name" value="<%=user.getName()%>"/>
                </div>

                <div class="form-group">
                    <label for="surname">surname : </label>
                    <input class="form-control" type="text" name="surname" value="<%=user.getSurname()%>"/>
                </div>

                <div class="form-group">
                    <label for="adress">adress : </label>
                    <input class="form-control" type="text" name="adress" value="<%=user.getAdress()%>"/>
                </div>

                <div class="form-group">
                    <label for="phone">phone : </label>
                    <input class="form-control" type="text" name="phone" value="<%=user.getPhone()%>"/>
                </div>

                <div class="form-group">
                    <label for="floatingProfilDescriptionTextarea">Profile Description : </label>
                    <textarea rows="5" style="height: 100%;" class="form-control" placeholder="Leave a comment here"
                              name="profileDesc"
                              id="floatingProfilDescriptionTextarea"><%=user.getProfileDesc()%></textarea>
                </div>

                <div class="form-group">
                    <label for="email">email : </label>
                    <input class="form-control" type="text" name="email" value="<%=user.getEmail()%>"/>
                </div>
                    
                <div class="form-group">
                    <%--@declare id="birthdate"--%>
                    <label for="birthdate">birthdate : </label>
                    <input class="form-control" type="date" name="birthdate" value="<%=user.getBirthdate()%>"/>

                </div>

                <div>
                    <%--@declare id="birthplace"--%>
                    <label for="birthplace">birthplace : </label>
                    <select class="form-select form-select" name="birthplace" aria-label="birthplace">

                        <% for (Country country : countries) { %>

                        <option
                                <% if (country.getId() == user.getBirthplace().getId()) { %>
                                selected
                                <% } %>
                                value="<%=country.getId()%>"><%=country.getName()%>
                        </option>

                        <% } %>

                    </select>
                </div>

                <div>
                    <%--@declare id="nationality"--%>
                    <label for="nationality">nationality : </label>
                    <select class="form-select form-select" name="nationality" aria-label="nationality">

                        <% for (Country country : countries) { %>

                        <option
                                <% if (country.getId() == user.getNationality().getId()) { %>
                                selected
                                <% } %>
                                value="<%=country.getId()%>"><%=country.getNationality()%>
                        </option>

                        <% } %>

                    </select>
                </div>

                    <%
                        StringBuilder sb = new StringBuilder();

                        for (EmploymentHistory eh : employmentHistoryList) {
                            sb.append(eh.getJobDescription());
                        }
                    %>

                <div class="form-group">
                    <label for="floatingEmploymentHistoryTextarea">Employment History : </label>
                    <textarea rows="5" style="height: 100%;" class="form-control" placeholder="Leave a comment here"
                              name="employmentHistory"
                              id="floatingEmploymentHistoryTextarea"
                    ><%=sb%></textarea>
                </div>

                <div class="form-group">
                    <%--@declare id="nationality"--%>
                    <%--@declare id="skills"--%>
                    <label for="skills">skills : </label>
                    <a href="userskilldetail.jsp" target="_blank">
                        <button style="width: 100%" type="button" class="btn btn-secondary">
                            <i class="fa-solid fa-marker"></i>
                        </button>
                    </a>
                    <!--
                <select class="form-select form-select" aria-label="skills" multiple>
                    <option selected>Open this select menu</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
                -->
                </div>

                <div align="right">
                    <input class="btn btn-primary" type="submit" name="submit" value="save">
                </div>
        </div>
    </div>
</div>

</body>
</html>
