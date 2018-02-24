<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<html>
<head>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>

<body>
<nav class="light-blue lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">Authorize</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="register.html">Register</a></li>
        </ul>

        <ul id="nav-mobile" class="side-nav">
            <li><a href="register.html">Register</a></li>
        </ul>
        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
</nav>
<div class="container">
    <div class="section">
        <div class="row">
            <form id="queryForm" >
                <div class="row">
                    <div class="input-field col s6">
                        <input name="login" id="login" type="text"/>
                        <label for="login">Login</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="password" id="password" type="password"/>
                        <label for="password">Password</label>
                    </div>
                </div>
                <div class="row center-align">
                    <input class="btn waves-effect waves-light" type="submit" name="action"/>
                </div>
            </form>
        </div>
    </div>
    <div class="divider"></div>
    <div class="section">
        <div class="row">
            <div class="input-field col s12">
                <textarea id="output" class="materialize-textarea"></textarea>
                <label for="output">Generated</label>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript">
    $(document).ready( function () {
        $("#queryForm").submit(function (e) {
                e.preventDefault();
                $.post("/auth/gettoken/",$("#queryForm").serialize(),
                    function (data) {
                        $("#output").text(data.toString());
                    });
            }
        );
    });
</script>
</body>
</html>