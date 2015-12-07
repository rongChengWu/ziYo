<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/WEB-INF/tags/tree.tld" prefix="nodeTag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>梓瑶兽药</title>
</head>
<style type="text/css"> 
body { margin:0px; background:#337ABB url("/ziYo/images/top_bg.gif"); font-size:12px;}
div { margin:0px; padding:0px; height:58px;}
.system_logo { width:200px; float:left; text-align:left;}
/*- Menu Tabs 6--------------------------- */
a{ font-size:12px;}
#tabs {
  float:right;
   height:58px;
  width:auto;
  overflow:auto;
  line-height:normal;
  }
#tabs ul {
  margin:0;
  padding:27px 10px 0 0px !important;
  *padding:27px 10px 0 0px !important;
  padding:27px 10px 0 0px;
  list-style:none;
  }
#tabs li {
  display:inline;
  margin:0;
  padding:0;
  }
#tabs a {
  float:left;
  background:url("/ziYo/images/tableft.gif") no-repeat left top;
  margin:0;
  padding:0 0 0 4px;
  text-decoration:none;
  }
#tabs a span {
  float:left;
  display:block;
  background:url("/ziYo/images/tabright.gif") no-repeat right top;
  padding:8px 8px 6px 6px;
  color:#E9F4FF;
  }
/* Commented Backslash Hack hides rule from IE5-Mac \*/
#tabs a span {float:none;}
/* End IE5-Mac hack */
#tabs a:hover span {
  color:#fff;
  }
#tabs a:hover {
  background-position:0% -42px;
  }
#tabs a:hover span {
  background-position:100% -42px;
  color:#222;
  }
#tabs a.current {background-position:0% -42px;} 
#tabs .current span{  background-position:100% -42px;
  color:#222;}
.menu{ background:url(/ziYo/images/adminlogo.png) no-repeat left top;}
</style>
<script language="javascript" src="/ziYo/js/tree.js"></script>
<body>
 <div>
<div id="tabs">
  		<ul>
  			<nodeTag:TopTag/>
		</ul>
</div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr height="32">
	  <td background="/ziYo/images/bg2.gif"width="33" style="padding-left:10px;"><img src="/ziYo/images/arrow.gif" alt="" align="absmiddle" /></td>
	  <td  background="/ziYo/images/bg2.gif"><span style="float:left"><font color='red'>${userLogin.userName}</font>欢迎来到这里</span><span style="color:#c00; font-weight:bold; float:left;width:300px;" id="announce"></span></td>
	  <td  align="right" background="/ziYo/images/bg2.gif" style="text-align:right; color: #135294; padding-right:12px;"> 
	  <span style="color:#000">您好<font color='red'>${userLogin.userName}</font>,欢迎登录! </span>
	  </td>
  </tr>
</table>
</body>
</html>