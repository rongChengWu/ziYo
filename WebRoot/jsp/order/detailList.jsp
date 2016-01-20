<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/ziYo/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/ziYo/js/My97DatePicker/WdatePicker.js"></script>
<title>梓瑶兽药</title>
</head>
<body>
  <div class="list">
                        <strong>销售单明细</strong>
                            <form action="/ziYo/alertServeAction/list"  method="post" >
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
                        <strong>销售单明细列表 </strong>
                        <table width="100%" border="1" bordercolor="#9FD9E8"
                            cellpadding="2" cellspacing="0" bordercolordark="#EDF2FA"
                            bgcolor="#D0E6F1">
                            <tr>
                                <td width="30" align="center" bgcolor="#D0E6F1">
                                    <strong>序号</strong>
                                </td>
                                <td width="150" align="center" bgcolor="#D0E6F1">
                                    <strong>制单日期</strong>
                                </td>
                                  <td width="90" align="center" bgcolor="#D0E6F1">
                                    <strong>客户名称</strong>
                                </td>
                                <td width="150" align="center" bgcolor="#D0E6F1">
                                    <strong>业务员</strong>
                                </td>
                                <td width="90" align="center" bgcolor="#D0E6F1">
                                    <strong>区域</strong>
                                </td>
                                   <td width="90" align="center" bgcolor="#D0E6F1">
                                    <strong>厂家</strong>
                                </td>
                                    <td width="90" align="center" bgcolor="#D0E6F1">
                                    <strong>属性</strong>
                                    </td>
                                 <td width="150" align="center" bgcolor="#D0E6F1">
                                    <strong>产品名称</strong>
                                </td>
                                <td width="150" align="center" bgcolor="#D0E6F1">
                                    <strong>规格</strong>
                                </td>
                                  <td width="90" align="center" bgcolor="#D0E6F1">
                                    <strong>数量</strong>
                                </td>
                                <td width="90" align="center" bgcolor="#D0E6F1">
                                    <strong>单价</strong>
                                </td>
                                  <td width="150" align="center" bgcolor="#D0E6F1">
                                    <strong>金额</strong>
                                </td>
                                <td width="150" align="center" bgcolor="#D0E6F1">
                                    <strong>生产批号</strong>
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
                                            ${ass.order.to_date}
                                    </td>
                                    <td align="center">
                                         ${ass.order.customer.khmc}
                                    </td>
                                    <td align="center">
                                        ${ass.order.customer.ywy}
                                    </td>
                                     <td align="center">
                                         ${ass.order.customer.qy}
                                    </td>
                                     <td align="center">
                                        ${ass.rkdmx.product.suppliers.gysmc}
                                    </td>
                                     <td align="center">
                                      ${ass.rkdmx.product.suppliers.sx}
                                    </td>
                                    <td align="center">
                                         ${ass.rkdmx.product.cpmc}
                                    </td>
                                    <td align="center">
                                        ${ass.rkdmx.product.cpgg}
                                    </td>
                                    <td align="center">
                                        ${ass.num}
                                    </td>
                                    <td align="center">
                                        ${ass.dj}
                                    </td>
                                    <td align="center">
                                       ${ass.je}
                                    </td>
                                      <td align="center">
                                        ${ass.rkdmx.scph}
                                    </td>
                                </tr>
                            </c:forEach >
                        </table>
                        </div>
</body>
</html>