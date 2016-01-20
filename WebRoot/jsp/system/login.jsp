<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>梓瑶兽药管理系统</title>
<link href="/ziYo/js/metro/css/metro.css" rel="stylesheet">
    <link href="/ziYo/js/metro/css/metro-icons.css" rel="stylesheet">
    <link href="/ziYo/js/metro/css/metro-responsive.css" rel="stylesheet">

  <script type="text/javascript" src="/ziYo/js/jquery.min.js"></script>
    <script src="/ziYo/js/metro/js/metro.js"></script>   
    
     <style>
        .login-form {
            width: 25rem;
            height: 18.75rem;
            position: fixed;
            top: 50%;
            margin-top: -9.375rem;
            left: 50%;
            margin-left: -12.5rem;
            background-color: #ffffff;
            opacity: 0;
            -webkit-transform: scale(.8);
            transform: scale(.8);
        }
    </style>
    <script>
        $(function(){
            var form = $(".login-form");
            form.css({
                opacity: 1,
                "-webkit-transform": "scale(1)",
                "transform": "scale(1)",
                "-webkit-transition": ".5s",
                "transition": ".5s"
            });
        });
    </script>
</head>
<body class="bg-darkTeal">
 <div class="login-form padding20 block-shadow">
        <form action="/ziYo/systemAction/userLogin" method="post" >
            <h1 class="text-light">梓瑶生物</h1>
            <hr class="thin"/>
            <br />
            <div class="input-control text full-size" data-role="input">
                <label for="user_login">账号:</label>
                <input type="text" name="users.userAccount" id="user_login">
                <button class="button helper-button clear"><span class="mif-cross"></span></button>
            </div>
            <br />
            <br />
            <div class="input-control password full-size" data-role="input">
                <label for="user_password">密码:</label>
                <input type="password" name="users.userPwd" id="user_password">
                <button class="button helper-button reveal"><span class="mif-looks"></span></button>
            </div>
            <br />
            <br />
            <div class="form-actions">
                <button type="submit" class="button primary">登录</button>
            </div>
        </form>
    </div>
	
</body>
</html>