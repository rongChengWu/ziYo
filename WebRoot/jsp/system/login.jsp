<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/ziYo/css/login.css" rel="stylesheet" type="text/css" />
<title>业务网后台管理系统</title>
</head>
<body>
  <div id="top">
<div class="logo_2"><img src="/ziYo/images/login/logo-2.png" width="291" height="96" /></div>
</div>
<div id="content">
	<div class="login">
    	<div class="login_1">
        <div class="login_2">
<form action="/ziYo/systemAction/userLogin" method="post" enctype="multipart/form-data">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="35">&nbsp;</td>
    <td width="300"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td colspan="3"><table width="300" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="50" height="26" align="right">用户名：</td>
            <td colspan="2" align="right"><input name="users.userAccount" type="text" class="input1" id="username" /></td>
            <td width="88" rowspan="2" align="right"><label>
             <input type="image" id="imageField" src="/ziYo/images/login/05.jpg" />
            </label></td>
          </tr>
          <tr>
            <td height="26" align="right">密&nbsp;&nbsp;码：</td>
            <td height="26" colspan="2" align="right"><input name="users.userPwd" type="password" class="input1" id="password" /></td>
          </tr>
          
        </table></td>
      </tr>
      <tr>
        <td height="15" colspan="3"></td>
      </tr>
      <tr>
        <td colspan="3" align="center" valign="middle"><span class="hui"></span></td>
      </tr>
    </table></td>
    <td width="40">&nbsp;</td>
  </tr>
</table>

        </form>

        </div>
        </div>
    </div>
</div>
	
</body>
</html>