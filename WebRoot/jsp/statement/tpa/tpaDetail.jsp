<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>业务网后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link href="/sshFrame/css/main.css" rel="stylesheet" type="text/css" />
<style  type="text/css">
#Layer1 {
	position:absolute;
	z-index:1;
	left: 906px;
	width: 80px;
	visibility: visible;
}
.style1 {color: #0000FF}
.style2 {color: #00F0F2}
.style3 {color: #F080F2}
.STYLE8 {font-size: 14px;
	font-weight: bold;
}
.STYLE9 {color: #FFFFFF}
.STYLE11 {color: #FFFFFF; font-weight: bold; }
.NowVisited{color:red;}
</style>
</head>
<body>
<div class="main_title">
 <table width="100%" cellspacing="0" cellpadding="2" bordercolor="#9fd9e8" border="1" bgcolor="#d0e6f1" bordercolordark="#EDF2FA">
  <tr> 
    <td background="/sshFrame/images/htgl_04.gif">
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	        <tr> 
	          <td width="120"  > <b> &nbsp;&nbsp;&gt;&gt;详情</b> </td>
	        </tr>
      	</table>
    </td>
  </tr>
</table>
</div>

<div class="list">
	<table width="100%" cellspacing="0" cellpadding="2" bordercolor="#9fd9e8" border="1" bgcolor="#d0e6f1" bordercolordark="#EDF2FA">
     <tr><td colspan="4" bgcolor="#81BDDA">基本信息</td></tr>
       <tr class="formtitletr" >
        <td class="formtitle">填报年份：</td>
        <td class="formcontent">
        	${provinceAlert.year}
        </td>
        <td class="formtitle">填报月份：</td>
        <td class="formcontent">
        	${provinceAlert.month}
        </td>
      </tr>
       <tr class="formtitletr" >
        <td class="formtitle">填报人：</td>
        <td class="formcontent">
        	${provinceAlert.writeName}
        </td>
        <td class="formtitle">联系方式：</td>
        <td class="formcontent">
        	${provinceAlert.phone}
        </td>
      </tr>
       <tr class="formtitletr" >
        <td class="formtitle">录入人：</td>
        <td class="formcontent">
        	${provinceAlert.user.username}
        </td>
        <td class="formtitle">录入日期：</td>
        <td class="formcontent">
        	${provinceAlert.entryTime}
        </td>
      </tr>
	 <tr><td colspan="4" bgcolor="#81BDDA">预警信息资料</td></tr>     	
      
      <tr class="formtitletr">
		<td class="formtitle">短信发布数：</td>
        <td class="formcontent">
			${provinceAlert.sendSms}
		</td>
		 <td class="formtitle">短信接收人次数 ：</td>
        <td class="formcontent" colspan="3">
        	${provinceAlert.receiveSms}
        </td>
      </tr>
     <tr class="formtitletr">
        <td class="formtitle" >省级微博粉丝数：</td>
       	<td class="formcontent">
       		${provinceAlert.weiboNum}
       	</td>
       	
        <td class="formtitle">省级微信粉丝数：</td>
        <td class="formcontent">
			${provinceAlert.weixinNum}
		</td>
    </tr>
      <tr class="formtitletr">
        <td class="formtitle" rowspan="2">服务亮点：</td>
       	<td class="formcontent" rowspan="2">
       		${provinceAlert.tpaService}
       	</td>
    </tr>
  </table>
</div>


</body>
</html>