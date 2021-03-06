<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/ziYo/css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" media="all" href="/ziYo/js/select2/dist/css/select2.min.css"/>
 <link rel="stylesheet" type="text/css" href="/ziYo/js/jPaginate/css/style.css" media="screen"/>
<script type="text/javascript" src="/ziYo/js/jquery.min.js"></script>
<script type="text/javascript" src="/ziYo/js/select2/dist/js/select2.min.js"></script>
<script type="text/javascript" src="/ziYo/js/public.js"></script>
<script type="text/javascript" src="/ziYo/jsp/product/js/product.js"></script>
<script type="text/javascript" src="/ziYo/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/ziYo/js/jPaginate/jquery.paginate.js"></script>
<title>梓瑶生物</title>
</head>
<body>
  <div class="list">
                        <strong>产品查询</strong>
                            <form action="/ziYo/productAction/list"  method="post"  name="productListForm">
                            <table width="100%" border="1" bordercolor="#9FD9E8" cellpadding="2" cellspacing="0" bordercolordark="#EDF2FA" bgcolor="#D0E6F1">
                            <tr>
                                
                                <td width="80" align="right" bgcolor="#D0E6F1">
                                    <strong>产品名称：</strong>
                                </td>
                                <td width="60" bgcolor="#F4F2F2">
                                    <input type="text" id="" value="${product.cpmc}" name="product.cpmc"/>
                                </td>
                                <td width="80" align="right" bgcolor="#D0E6F1">
                                    <strong>产品规格：</strong>
                                </td>
                                <td width="60" bgcolor="#F4F2F2">
                                    <input type="text"  id="" value="${product.cpgg}" name="product.cpgg"/>
                                </td>
                                <td width="80" align="right" bgcolor="#D0E6F1">
                                    <strong>供应商：</strong>
                                </td>
                                <td width="80" bgcolor="#F4F2F2">
                                      <select class="js-example-data-array" name="product.tsid">
                                        <option value="" selected="selected">查询所有</option>
                                      </select>
                                </td>
                                   <td width="80" align="right" bgcolor="#D0E6F1">
                                    <strong>产品类型：</strong>
                                </td>
                                <td width="80" bgcolor="#F4F2F2">
                                    <input type="text" id="" value="${product.cplx}" name="product.cplx"/>
                                </td>
                                <td bgcolor="#F4F2F2">
                                    <input type="submit"  value=" 查  询 "/>
                                </td>
                            </tr>
                        </table>
                        <!-- page start -->
                        <input type="hidden" name="pageBean.pageStart" value="${pageBean.pageStart}">
                        <!-- page end -->
                    </form>
                    </div>
                    
                    
    <div class="list">
                        <strong>产品列表 </strong>
                        <table width="100%" border="1" bordercolor="#9FD9E8"
                            cellpadding="2" cellspacing="0" bordercolordark="#EDF2FA"
                            bgcolor="#D0E6F1">
                            <tr>
                                <td width="30" align="center" bgcolor="#D0E6F1">
                                    <strong>序号</strong>
                                </td>
                                <td width="150" align="center" bgcolor="#D0E6F1">
                                    <strong>产品编码</strong>
                                </td>
                                <td width="150" align="center" bgcolor="#D0E6F1">
                                    <strong>产品名称</strong>
                                </td>
                                <td width="90" align="center" bgcolor="#D0E6F1">
                                    <strong>产品规格</strong>
                                </td>
                                <td width="80" align="center" bgcolor="#D0E6F1">
                                    <strong>产品类型</strong>
                                </td>
                                <td width="85" align="center" bgcolor="#D0E6F1">
                                    <strong>供应商</strong>
                                </td>
                                 <td width="85" align="center" bgcolor="#D0E6F1">
                                    <strong>单位</strong>
                                </td>
                                  <td width="150" align="center" bgcolor="#D0E6F1">
                                    <strong>备注</strong>
                                </td>
                                <td width="150" height="28" align="center" bgcolor="#D0E6F1">
                                    <strong>最后修改人员</strong>
                                </td>
                                <td width="150" align="center" bgcolor="#D0E6F1">
                                    <strong>最后修改时间</strong>
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
                                            ${ass.cpbm}
                                    </td>
                                    <td align="center">
                                        ${ass.cpmc}
                                    </td>
                                    <td align="center">
                                        ${ass.cpgg}
                                    </td>
                                    <td align="center">
                                    <c:if test="${ass.cplx==1}">国产</c:if>
                                     <c:if test="${ass.cplx==2}">进口</c:if>
                                    </td>
                                    <td align="center">
                                        ${ass.suppliers.gysmc}
                                    </td>
                                      <td align="center">
                                        ${ass.dw}
                                    </td>
                                    <td align="center">
                                        ${ass.bz}
                                    </td>
                                    <td align="center">
                                        ${ass.users.userName}
                                    </td>
                                    <td align="center">
                                        ${ass.lastTime}
                                    </td>
                                    <td align="center">
                                        <a href="/ziYo/productAction/getById?id=${ass.id}&returnType=update">修改</a>
                                    </td>
                                </tr>
                            </c:forEach >
                        </table>
                        </div>
                        
                 <div id="pageDiv">                   
                         </div> 
                         
                <script type="text/javascript">
                $("#pageDiv").paginate({
                    count       : ${pageBean.pageCount},
                    start       : ${pageBean.pageStart},
                    display     : ${pageBean.pageDisplay},
                    border                  : false,
                    text_color              : '#888',
                    background_color        : '#EEE',   
                    text_hover_color        : 'black',
                    background_hover_color  : '#CFCFCF',
                    mouse                   : 'press',
                    onChange                : function(page){
                        $("input[name='pageBean.pageStart']").val(page);
                        document.queryListForm.submit();
                                              }
                });
                </script>
</body>
</html>