<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/sshFrame/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/sshFrame/js/public.js"></script>
<script type="text/javascript" src="/sshFrame/jsp/statement/js/tpa.js"></script>
<script type="text/javascript" src="/sshFrame/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
.input1{width: 300px;}
.botn{margin:0; padding:0;border:0;  width:60px;height:25px; background:url(/sshFrame/images/anniu.jpg) no-repeat 0 0; margin-right:10px;}
.botn a{ width:60px; height:25px; line-height:25px; display:block; text-align:center; color:#fff; text-decoration:none;}
.botn a:hover{ color:#000; text-decoration:none;}
</style>
</head>
<body>
<div class="main_title">
 <table width="100%" cellspacing="0" cellpadding="2" bordercolor="#9fd9e8" border="1" bgcolor="#d0e6f1" bordercolordark="#EDF2FA">
  <tr>
    <td background="/sshFrame/images/htgl_04.gif">
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	        <tr> 
	          <td > <b> &nbsp;&nbsp;&gt;&gt;省预警发布信息月度统计添加</b> </td>
	        </tr>
      	</table>
    </td>
  </tr>
</table>
</div>
<form action="/sshFrame/provinceAlertAction/add" name="provinceAlert" method="post">
<div class="main-data">
	<table width="100%" cellspacing="0" cellpadding="2" bordercolor="#9fd9e8" border="1" bgcolor="#d0e6f1" bordercolordark="#EDF2FA">
		<tbody>
			<tr class="formtitletr">
	      		<td colspan="4" bgcolor="#81BDDA"><b>预警信息基本信息：</b></td>
	        </tr>
	        <tr class="formtitletr">
				<td class="formtitle">
					填报年份(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
				    <input type="text" class="input1" value="2014" id="year" name="provinceAlert.year"/>
				</td>
				<td class="formtitle">
					填报月份(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="month"  name="provinceAlert.month"/>
				</td>
			</tr>
			<tr class="formtitle">
				<td class="formtitle">
					填报人(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="writeName" value="${userLogin.username}" name="provinceAlert.writeName"/>
				</td>
				<td class="formtitle">
					联系方式(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="phone" value="${userLogin.userphone}" name="provinceAlert.phone"/>
				</td>
			</tr>
			<tr class="formtitle">
	      		<td colspan="4" bgcolor="#81BDDA"><b>预警信息资料:</b></td>
	        </tr>
			<tr class="formtitle">
				<td class="formtitle">
					短信发布数(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="sendSms" name="provinceAlert.sendSms"/>
				</td>
				<td colspan="2" class="formtitletr">*全省预警（含预警信号、应急和决策）短信发布条数（条）</td>
			</tr>
			<tr class="formtitle">
				<td class="formtitle">
					短信接收人次数(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="receiveSms"  name="provinceAlert.receiveSms"/>
				</td>
				<td colspan="2" class="formtitletr">*全省接收预警短信人次数（次）</td>
			</tr>
			<tr class="formtitle">
				<td class="formtitle">
					省级微博粉丝数(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="weiboNum"  name="provinceAlert.weiboNum"/>
				</td>
				<td class="formtitle">
					省级微信粉丝数(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="weixinNum"  name="provinceAlert.weixinNum"/>
				</td>
			</tr>
			<tr class="formtitle">
				<td class="formtitle">
					服务亮点（可不填）：
				</td>
				<td class="formcontent" colspan="3">
					<textarea  cols="40" rows="8" id="tpaService" name="provinceAlert.tpaService"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4"  class="formcontent" align="center" >
					<input type="button" class="botn" onclick="checkFromSubmit()"  value="提交"  />
				</td>
			</tr>
		</tbody>
	</table>
</div>
</form>

</body>
</html>