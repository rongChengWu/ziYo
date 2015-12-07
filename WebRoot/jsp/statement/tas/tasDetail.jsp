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
        <td class="formtitle">填报地市：</td>
        <td class="formcontent">
        	${alertServe.city}
        </td>
        <td class="formtitle">填报年、月、日份：</td>
        <td class="formcontent">
        	${alertServe.year}年${alertServe.month}月${alertServe.day}日
        </td>
      </tr>
       <tr class="formtitletr" >
        <td class="formtitle">录入人：</td>
        <td class="formcontent">
        	${alertServe.user.username}
        </td>
        <td class="formtitle">录入日期：</td>
        <td class="formcontent">
        	${alertServe.entryTime}
        </td>
      </tr>
	 <tr><td colspan="4" bgcolor="#81BDDA">受灾严重地区预警信号发布情况</td></tr>     	
        <tr class="formtitletr">
        <td class="formtitle">市（区、县）：</td>
        <td class="formcontent">
        	${alertServe.addres}
        </td>
       <td class="formtitle">预警警报名称</td>
        <td class="formcontent">
			${alertServe.alertName}
		</td>
      </tr>
      
      <tr class="formtitletr">
        <td class="formtitle">发布时间 ：</td>
        <td class="formcontent">
        	${alertServe.releaseTime}
        </td>
		<td class="formtitle">实况出现时间：</td>
        <td class="formcontent">
			${alertServe.liveTime}
		</td>
      </tr>
       <tr class="formtitletr">
        <td class="formtitle">预警提前量 ：</td>
        <td class="formcontent" colspan="3">
        	${alertServe.alertAdvance}
        </td>
      </tr>
      <tr>
	      <td colspan="4" bgcolor="#81BDDA"><b>服务详情:</b></td>
	   </tr>
     <tr class="formtitletr">
        <td class="formtitle" >决策服务材料（期数）：</td>
       	<td class="formcontent">
       		${alertServe.datumIssue}
       	</td>
       	
        <td class="formtitle">媒体（电话、电台）等采访次数：</td>
        <td class="formcontent">
			${alertServe.interviewCount}
		</td>
    </tr>
     <tr class="formtitletr">
        <td class="formtitle" >新闻发布会（次）：</td>
       	<td class="formcontent">
       		${alertServe.pcc}
       	</td>
       	
        <td class="formtitle">提供新闻稿件（篇数）：</td>
        <td class="formcontent">
			${alertServe.prc}
		</td>
    </tr>
      <tr class="formtitletr">
        <td class="formtitle" rowspan="2">预报概况：</td>
       	<td class="formcontent" rowspan="2">
       		${alertServe.survey}
       	</td>
        <td class="formtitle" rowspan="2">应急服务亮点或新举措（附上联系当地移动或联通发送的应急短信内容）：</td>
       	<td class="formcontent" rowspan="2">
       		${alertServe.tasService}
       	</td>
    </tr>
  </table>
</div>


</body>
</html>