
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact List</title>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container">
            <div class="page-header">
                <h3>Welcome to the administration portal</h3>
            </div>
            <div class="row">
                <div class="col-md-6">
                    
                    <h4>You must login to continue</h4>
                    
                </div>
                <div class="col-md-6">
                    <form class="form-horizontal signin" role="form" method="post" action="j_spring_security_check">
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">Username</label>
                            <div class="col-sm-10">
                                <input id="username_or_email" name="j_username" type="text" class="form-control" placeholder="username"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2">Password</label>
                            <div class="col-sm-10">
                                <input id="password" name="j_password" type="password" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input name="commit" type="submit" value="Sign In" class="btn btn-primary">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>



        <!-- #3 - just puts focus in the username field when page loads -->
        <script type="text/javascript">
            document.getElementById('username').focus();
        </script>
    </body>
</html>

