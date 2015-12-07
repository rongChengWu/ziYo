<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/sshFrame/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/sshFrame/js/My97DatePicker/WdatePicker.js"></script>
<title>业务网系统管理平台</title>
</head>
<body>
  <div class="list">
						<strong>工单查询</strong>
							<form action="/sshFrame/alertServeAction/list"  method="post" >
							<table width="100%" border="1" bordercolor="#9FD9E8" cellpadding="2" cellspacing="0" bordercolordark="#EDF2FA" bgcolor="#D0E6F1">
							<tr>
								
								<td width="80" align="right" bgcolor="#D0E6F1">
									<strong>填报年份：</strong>
								</td>
								<td width="60" bgcolor="#F4F2F2">
									<input type="text" id="" value="${alertServe.year}" name="alertServe.year"/>
								</td>
								<td width="80" align="right" bgcolor="#D0E6F1">
									<strong>填报月：</strong>
								</td>
								<td width="60" bgcolor="#F4F2F2">
									<input type="text"  id="" value="${alertServe.month}" name="alertServe.month"/>
								</td>
								<td width="80" align="right" bgcolor="#D0E6F1">
									<strong>填报地市：</strong>
								</td>
								<td width="80" bgcolor="#F4F2F2">
									<input type="text" id="" value="${alertServe.city}" name="alertServe.city"/>
								</td>
								<td bgcolor="#F4F2F2">
									<input type="submit"  value=" 查  询 "/>
								</td>
							</tr>
								
						</table>
					</form>
					</div>
					
					
	<div class="list">
						<strong>市预警发布信息月度统计列表 </strong>
						<table width="100%" border="1" bordercolor="#9FD9E8"
							cellpadding="2" cellspacing="0" bordercolordark="#EDF2FA"
							bgcolor="#D0E6F1">
							<tr>
								<td width="30" align="center" bgcolor="#D0E6F1">
									<strong>序号</strong>
								</td>
								<td width="55" align="center" bgcolor="#D0E6F1">
									<strong>预报服务地市</strong>
								</td>
								<td width="85" align="center" bgcolor="#D0E6F1">
									<strong>预报服务年、月、日</strong>
								</td>
								<td width="70" align="center" bgcolor="#D0E6F1">
									<strong>市（区、县）</strong>
								</td>
								<td width="55" align="center" bgcolor="#D0E6F1">
									<strong>预警警报名称</strong>
								</td>
								<td width="85" align="center" bgcolor="#D0E6F1">
									<strong>发布时间</strong>
								</td>
								<td width="60" height="28" align="center" bgcolor="#D0E6F1">
									<strong>实况出现时间</strong>
								</td>
								<td width="70" align="center" bgcolor="#D0E6F1">
									<strong>决策服务材料（期数）</strong>
								</td>
								<td width="70" align="center" bgcolor="#D0E6F1">
									<strong>媒体等采访次数</strong>
								</td>
								<td width="50" align="center" bgcolor="#D0E6F1">
									<strong>新闻发布会（次）</strong>
								</td>
								<td width="75" align="center" bgcolor="#D0E6F1">
									<strong>提供新闻稿件（篇数）</strong>
								</td>
								<td height="28" align="center" bgcolor="#D0E6F1">
									<strong>录入人</strong>
								</td>
								<td height="28" align="center" bgcolor="#D0E6F1">
									<strong>操作</strong>
								</td>
							</tr>
							
							<c:if test="${listAss==null}">
							<tr>
								<td colspan="12">没有符合条件的数据!</td>
							</tr>
							</c:if>
							
							<%int si=1;%>
							<c:forEach var="ass" items="${listAss}" >
								<tr bgcolor="#E7F2F8" onMouseOver="this.bgColor='#FFFFFF';" onMouseOut="this.bgColor='#E7F2F8';">
									<td align="center">
									<%=si++%>
									</td>
									<td align="center">
											${ass.city}
									</td>
									<td align="center">
										${ass.year}年${ass.month}月${ass.day}日
									</td>
									<td align="center">
										${ass.addres}
									</td>
									<td align="center">
											${ass.alertName}
									</td>
									<td align="center">
										${ass.releaseTime}
									</td>
									<td align="center">
										${ass.liveTime}
									</td>
									<td align="center">
										${ass.datumIssue}
									</td>
									<td align="center">
										${ass.interviewCount}
									</td>
									<td align="center">
										${ass.pcc}
									</td>
									<td align="center">
										${ass.prc}
									</td>
									<td align="center">
										${ass.user.username}
									</td>
									<td align="center">
										<a href="/sshFrame/alertServeAction/detail?id=${ass.id}">查看</a>
									</td>
								</tr>
							</c:forEach >
						</table>
						</div>
</body>
</html>