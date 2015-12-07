<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/sshFrame/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/sshFrame/js/public.js"></script>
<script type="text/javascript" src="/sshFrame/js/jquery.min.js"></script>
<script type="text/javascript" src="/sshFrame/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/sshFrame/jsp/statement/js/tas.js"></script>
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
	          <td > <b> &nbsp;&nbsp;&gt;&gt;市预警发布信息月度统计添加</b> </td>
	        </tr>
      	</table>
    </td>
  </tr>
</table>
</div>
<form method="post" name="alertServeForm">
<div class="main-data">
	<table width="100%" cellspacing="0" cellpadding="2" bordercolor="#9fd9e8" border="1" bgcolor="#d0e6f1" bordercolordark="#EDF2FA">
		<tbody>
			<tr class="formtitletr">
	      		<td colspan="4" bgcolor="#81BDDA"><b>市灾害过程期间预报服务情况基本信息：</b></td>
	        </tr>
	        <tr class="formtitletr">
				<td class="formtitle">
					填报地市(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
				    <input type="text" class="input1" id="city" name="alertServe.city"/>
				</td>
				<td class="formtitle">
					填报年份(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="year"  name="alertServe.year"/>
				</td>
			</tr>
			<tr class="formtitle">
				<td class="formtitle">
					填报月(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="month"  name="alertServe.month"/>
				</td>
				<td class="formtitle">
					填报日(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="day"  name="alertServe.day"/>
				</td>
			</tr>
			<tr class="formtitle">
	      		<td colspan="4" bgcolor="#81BDDA"><b>受灾严重地区预警信号发布情况（无则不填）:</b></td>
	        </tr>
	        	<tr class="formtitle">
				<td class="formtitle">
					市（区、县）(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="addres"  name="alertServe.addres"/>
				</td>
				<td class="formtitle">
					预警警报名称(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="alertName"  name="alertServe.alertName"/>
				</td>
			</tr>
	        <tr class="formtitle">
				<td class="formtitle">
					发布时间 (<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="arrangeTime"  name="alertServe.releaseTime" readonly="readonly" style="width: 224px;"/>
					<img onClick="WdatePicker({el:$dp.$('arrangeTime'),dateFmt:'yyyy-M-d H:mm'})" src="/sshFrame/js/My97DatePicker/skin/datePicker.gif" width="24" height="30" align="absmiddle" />
				</td>
				<td class="formtitle">
					实况出现时间(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="liveTime" value="${userLogin.userphone}" name="alertServe.liveTime" readonly="readonly" style="width: 224px;"/>
					<img onClick="WdatePicker({el:$dp.$('liveTime'),dateFmt:'yyyy-M-d H:mm'})" src="/sshFrame/js/My97DatePicker/skin/datePicker.gif" width="24" height="30" align="absmiddle" />
				</td>
			</tr>
			<tr class="formtitle">
				<td class="formtitle">
					预警提前量 (<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="alertAdvance"  name="alertServe.alertAdvance"/>
				</td>
				<td colspan="2" class="formtitletr">
				</td>
			</tr>
			<tr class="formtitle">
	      		<td colspan="4" bgcolor="#81BDDA"><b>服务详情:</b></td>
	        </tr>
	        <tr class="formtitle">
				<td class="formtitle">
					决策服务材料（期数）(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="datumIssue"  name="alertServe.datumIssue"/>
				</td>
				<td class="formtitle">
					媒体（电话、电台）等采访次数 (<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="interviewCount"  name="alertServe.interviewCount"/>
				</td>
			</tr>
			<tr class="formtitle">
				<td class="formtitle">
					新闻发布会（次）(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="pcc"  name="alertServe.pcc"/>
				</td>
				<td class="formtitle">
					提供新闻稿件（篇数）(<font color="red">必填</font>)：
				</td>
				<td class="formcontent">
					<input type="text" class="input1" id="prc"  name="alertServe.prc"/>
				</td>
			</tr>
			<tr class="formtitle">
				<td class="formtitle">
					预报概况(<font color="red">必填</font>)：
				</td>
				<td class="formcontent" colspan="3">
					<textarea  cols="100" rows="8" id="survey" name="alertServe.survey"></textarea>
				</td>
			</tr>
			<tr class="formtitle">
				<td class="formtitle">
					应急服务亮点或新举措（附上联系当地移动或联通发送的应急短信内容）：
				</td>
				<td class="formcontent" colspan="3">
					<textarea  cols="100" rows="8" id="tasService" name="alertServe.tasService"></textarea>
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