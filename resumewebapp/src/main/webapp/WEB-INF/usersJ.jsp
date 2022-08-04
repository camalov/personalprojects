<%-- 
    Document   : user
    Created on : 12.May.2022, 14:34:09
    Author     : PC
--%>

<%@page import="com.company.entity.User" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
    <script src="assets/js/users.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
            crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <title>JSP Page</title>
</head>
<body>
<%
    /*
    UserDaoInter userDao = Context.instanceUserDao();
    User user = userDao.getById(1);
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String nationalityIdStr = request.getParameter("nId");
    Integer nationalityId = null;

    if (nationalityIdStr != null && !nationalityIdStr.trim().isEmpty()) {
        nationalityId = Integer.parseInt(nationalityIdStr);
    }

    List<User> userList = userDao.getAll(name, surname, nationalityId);
     */
    List<User> userList = (List<User>) request.getAttribute("userList");
//    User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
//    out.println("Wellcome " + loggedInUser.getName());
%>

<div class="mycontainer container">
    <div class="row">
        <div class="col-4">
            <form action="users" method="GET">
                <%--@declare id="name"--%><%--@declare id="surname"--%>
                <div class="form-group">
                    <label for="name">name : </label>
                    <input class="form-control" type="text" name="name" value=""/>
                </div>

                <div class="form-group">
                    <label for="surname">surname : </label>
                    <input class="form-control" type="text" name="surname" value=""/>
                </div>

                <input class="btn btn-primary" style="margin-top: 5px" type="submit" name="search" value="Search">
            </form>
        </div>
    </div>
    <hr/>

    <div>

        <div align="right">
            <button class="btn btn-primary">Add</button>
        </div>

        <table class="table">
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Nationality</th>
                <th></th>
            </tr>

            <% for (User u : userList) {%>

            <tr>
                <td><%=u.getName()%>
                </td>
                <td><%=u.getSurname()%>
                </td>
                <td><%=u.getNationality().getName() == null ? "N/A" : u.getNationality().getName()%>
                </td>

                <td style="width: 5px">
                    <form action="userdetail" method="GET">
                        <input type="hidden" name="id" value="<%=u.getId()%>">
                        <input type="hidden" name="action" value="info">
                        <button class="btn btn-info" type="submit" name="action" value="info">
                            <i class="fa-solid fa-info"></i>
                        </button>
                    </form>
                </td>

                <td style="width: 5px">
                    <form action="userdetail" method="GET">
                        <input type="hidden" name="id" value="<%=u.getId()%>">
                        <input type="hidden" name="action" value="update">
                        <button class="btn btn-secondary" type="submit" name="action" value="update">
                            <i class="fa-solid fa-marker"></i>
                        </button>
                    </form>
                </td>

                <td style="width: 5px">
                    <form action="userdetail" method="POST">
                        <input type="hidden" name="id" value="<%=u.getId()%>">
                        <input type="hidden" name="action" value="delete">
                        <button class="btn btn-danger" name="action" value="delete" type="button" data-toggle="modal"
                                data-target="#deleteModal" onclick="setIdForDelete(<%=u.getId()%>)">
                            <i class="fa-solid fa-trash-can"></i>
                        </button>
                    </form>
                </td>
            </tr>

            <% } %>
        </table>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModal"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button class="btn" type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                Are you sure ?
            </div>

            <div class="modal-footer">
                <form action="userdetail" method="POST">
                    <input type="hidden" name="id" value="" id="idForDelete">
                    <input type="hidden" name="action" value="delete">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button name="action" value="delete" type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>

        </div>
    </div>
</div>

</body>
</html>
