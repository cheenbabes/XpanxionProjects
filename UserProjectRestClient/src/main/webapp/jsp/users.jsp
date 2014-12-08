<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UserController</title>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">

                    <h2>Users</h2>

                    <table class="table table-hover" id="user-list">
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr> 

                    </table>                    
                    <br>
                    
                    <div class="row">
                        <div class="col-md-3 form-group" id="add-div">
                            Username: <input id="add-username" type="text" class="form-control"><br>
                            Password: <input id="add-password" type="password" class="form-control"><br>
                            <input id="addButton" type="submit" value="Add New User" class="btn btn-primary">
                        </div>
                        
                        <div class="col-md-3 form-group" id="edit-div">
                            Username: <input id="edit-username" type="text" class="form-control" disabled/><br>
                            Password: <input id="edit-password" type="text" class="form-control"/><br>
                            <input id="edit-id" type="hidden"/>
                            <input id="editButton" type="submit" value="Edit" class="btn btn-default">
                        </div>
                    </div>


                    <a href="index" class="btn btn-default"> < Home</a>

                </div>
            </div>



        </div>
        <script src="js/jquery-1.11.1.js" type="text/javascript"></script>
        <script src="js/User.js" type="text/javascript"></script>

    </body>
</html>
