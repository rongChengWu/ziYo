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
        	${cityAlert.year}
        </td>
        <td class="formtitle">填报月份：</td>
        <td class="formcontent">
        	${cityAlert.month}
        </td>
      </tr>
       <tr class="formtitletr" >
        <td class="formtitle">填报人：</td>
        <td class="formcontent">
        	${cityAlert.writeName}
        </td>
        <td class="formtitle">联系方式：</td>
        <td class="formcontent">
        	${cityAlert.phone}
        </td>
      </tr>
       <tr class="formtitletr" >
        <td class="formtitle">录入人：</td>
        <td class="formcontent">
        	${cityAlert.user.username}
        </td>
        <td class="formtitle">录入日期：</td>
        <td class="formcontent">
        	${cityAlert.entryTime}
        </td>
      </tr>
	 <tr><td colspan="4" bgcolor="#81BDDA">预警信息资料</td></tr>     	
        <tr class="formtitletr">
        <td class="formtitle">短信用户数量：</td>
        <td class="formcontent">
        	${cityAlert.smsUser}
        </td>
       <td class="formtitle">决策短信条数</td>
        <td class="formcontent">
			${cityAlert.smsUserNum}
		</td>
      </tr>
      
      <tr class="formtitletr">
        <td class="formtitle">决策短信发布条次数 ：</td>
        <td class="formcontent">
        	${cityAlert.smsUserCount}
        </td>
		<td class="formtitle">短信发布数：</td>
        <td class="formcontent">
			${cityAlert.sendSms}
		</td>
      </tr>
       <tr class="formtitletr">
        <td class="formtitle">短信接收人次数 ：</td>
        <td class="formcontent" colspan="3">
        	${cityAlert.receiveSms}
        </td>
      </tr>
     <tr class="formtitletr">
        <td class="formtitle" >市级微博粉丝数：</td>
       	<td class="formcontent">
       		${cityAlert.weiboNum}
       	</td>
       	
        <td class="formtitle">市级微信粉丝数：</td>
        <td class="formcontent">
			${cityAlert.weixinNum}
		</td>
    </tr>
      <tr class="formtitletr">
        <td class="formtitle" rowspan="2">服务亮点：</td>
       	<td class="formcontent" rowspan="2">
       		${cityAlert.tpaService}
       	</td>
    </tr>
  </table>
</div>


</body>
</html>