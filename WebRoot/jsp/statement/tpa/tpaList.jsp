<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/sshFrame/css/main.css" rel="stylesheet" type="text/css" />
<title>业务网系统管理平台</title>
</head>
<body>

 <div class="list">
						<strong>工单查询</strong>
							<form action="/sshFrame/provinceAlertAction/list" method="post" >
							<table width="100%" border="1" bordercolor="#9FD9E8" cellpadding="2" cellspacing="0" bordercolordark="#EDF2FA" bgcolor="#D0E6F1">
							<tr>
								<td width="80" align="right" bgcolor="#D0E6F1">
									<strong>填报年份：</strong>
								</td>
								<td width="60" bgcolor="#F4F2F2">
									<input type="text" id="" value="${provinceAlert.year}" name="provinceAlert.year"/>
								</td>
								<td width="80" align="right" bgcolor="#D0E6F1">
									<strong>填报月：</strong>
								</td>
								<td width="60" bgcolor="#F4F2F2">
									<input type="text"  id="" value="${provinceAlert.month}" name="provinceAlert.month"/>
								</td>
								<td width="80" align="right" bgcolor="#D0E6F1">
									<strong>填报人：</strong>
								</td>
								<td width="60" bgcolor="#F4F2F2">
									<input type="text"  id="" value="${provinceAlert.writeName}" name="provinceAlert.writeName"/>
								</td>
								<td bgcolor="#F4F2F2">
									<input type="submit"  value=" 查  询 "/>
								</td>
							</tr>
								
						</table>
					</form>
					</div>



	<div class="list">
						<strong>省预警发布信息月度统计列表 </strong>
						<table width="100%" border="1" bordercolor="#9FD9E8"
							cellpadding="2" cellspacing="0" bordercolordark="#EDF2FA"
							bgcolor="#D0E6F1">
							<tr>
								<td width="30" align="center" bgcolor="#D0E6F1">
									<strong>序号</strong>
								</td>
								<td width="55" align="center" bgcolor="#D0E6F1">
									<strong>短信发布数</strong>
								</td>
								<td width="60" height="28" align="center" bgcolor="#D0E6F1">
									<strong>短信接收人次数</strong>
								</td>
								<td width="70" align="center" bgcolor="#D0E6F1">
									<strong>省级微博粉丝数</strong>
								</td>
								<td width="50" align="center" bgcolor="#D0E6F1">
									<strong>省级微信粉丝数</strong>
								</td>
								<td width="45" align="center" bgcolor="#D0E6F1">
									<strong>填报年份</strong>
								</td>
								<td width="70" align="center" bgcolor="#D0E6F1">
									<strong>填报月份</strong>
								</td>
								<td height="28" align="center" bgcolor="#D0E6F1">
									<strong>填报人</strong>
								</td>
								<td height="28" align="center" bgcolor="#D0E6F1">
									<strong>联系方式</strong>
								</td>
								<td height="28" align="center" bgcolor="#D0E6F1">
									<strong>录入人</strong>
								</td>
								<td height="28" align="center" bgcolor="#D0E6F1">
									<strong>录入时间</strong>
								</td>
								<td height="28" align="center" bgcolor="#D0E6F1">
									<strong>操作</strong>
								</td>
							</tr>
							
							<c:if test="${listPa==null}">
							<tr>
								<td colspan="12">没有符合条件的数据!</td>
							</tr>
							</c:if>
							
							<%int si=1;%>
							<c:forEach var="pa" items="${listPa}" >
								<tr bgcolor="#E7F2F8" onMouseOver="this.bgColor='#FFFFFF';" onMouseOut="this.bgColor='#E7F2F8';">
									<td align="center">
									<%=si++%>
									</td>
									
									<td align="center">
										<a href="#">
											${pa.sendSms}
										</a>
									</td>
									<td align="center">
										${pa.receiveSms}
									</td>
									<td align="center">
										${pa.weiboNum}
									</td>
									<td align="center">
										${pa.weixinNum}
									</td>
									<td align="center">
										${pa.year}
									</td>
									<td align="center">
										${pa.month}
									</td>
									<td align="center">
										${pa.writeName}
									</td>
									<td align="center">
										${pa.phone}
									</td>
								   <td align="center">
										${pa.user.username}
									</td>
									<td align="center">
										${pa.writeDate}
									</td>
									<td align="center">
										<a href="/sshFrame/provinceAlertAction/detail?id=${pa.id}">查看</a>
									</td>
								</tr>
							</c:forEach >
						</table>
						</div>
</body>
</html>