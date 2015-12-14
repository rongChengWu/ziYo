<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" media="all" href="/ziYo/js/select2/dist/css/select2.min.css">
<link href="/ziYo/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/ziYo/js/jquery.min.js"></script>
<script type="text/javascript" src="/ziYo/js/select2/dist/js/select2.min.js"></script>
<script type="text/javascript" src="/ziYo/js/public.js"></script>
<script type="text/javascript" src="/ziYo/jsp/order/js/order.js"></script>
<script type="text/javascript" src="/ziYo/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
.input1{width: 300px;}
.botn{margin:0; padding:0;border:0;  width:60px;height:25px; background:url(/ziYo/images/anniu.jpg) no-repeat 0 0; margin-right:10px;}
.botn a{ width:60px; height:25px; line-height:25px; display:block; text-align:center; color:#fff; text-decoration:none;}
.botn a:hover{ color:#000; text-decoration:none;}
.tableInput{ color:#000; text-decoration:none;}
</style>
</head>
<body>
<div class="main_title">
 <table width="100%" cellspacing="0" cellpadding="2" bordercolor="#9fd9e8" border="1" bgcolor="#d0e6f1" bordercolordark="#EDF2FA">
  <tr>
    <td background="/ziYo/images/htgl_04.gif">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr> 
              <td > <b> &nbsp;&nbsp;&gt;&gt;销售单录入</b> </td>
            </tr>
        </table>
    </td>
  </tr>
</table>
</div>
<form name="orderForm" method="post">
<div class="main-data">
    <table width="100%" cellspacing="0" cellpadding="2" bordercolor="#9fd9e8" border="1" bgcolor="#d0e6f1" bordercolordark="#EDF2FA">
        <tbody>
            <tr class="formtitletr">
                <td colspan="4" bgcolor="#81BDDA"><b>销售单基本信息：</b></td>
            </tr>
            <tr class="formtitletr">
                <td class="formtitle">
                   销售单编号(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" name="order.xsdbh"/>
                </td>
                <td class="formtitle">
                    制单人(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" value="${userLogin.userName}"  name="zdr" readonly="readonly"/>
                </td>
            </tr>
                <tr class="formtitletr">
                <td class="formtitle">
                   本单客户(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                     <select class="js-example-data-array" name="order.tc_id" ></select>
                </td>
                <td class="formtitle">
                    本单负责人(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1"   name="order.fzr"/>
                </td>
            </tr>
            <tr class="formtitle">
                <td class="formtitle">
                  制单日期(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input  name="order.to_date" readonly="readonly" class="Wdate editbox input1" type="text"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
                </td>
                <td class="formtitle">
                    本单总价(<font color="red">必填</font>)：
                </td>
                  <td class="formcontent">
                    <input  readonly="readonly"   class="input1" type="text" name="order.bdzj" />
                </td>
            </tr>
               <tr class="formtitletr">
                <td class="formtitle">
                   本单状态(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" name="order.type"/>
                </td>
                <td class="formtitle">
                </td>
                <td class="formcontent">
                </td>
            </tr>
            <tr class="formtitle">
                <td class="formtitle">
                    备注（可不填）：
                </td>
                <td class="formcontent" colspan="3">
                    <textarea  cols="40" rows="8" id="tpaService" name="order.bz"></textarea>
                </td>
            </tr>
                <tr class="formtitle">
                <td colspan="3" bgcolor="#81BDDA"><b>销售单详情:</b> </td>
                 <td  align="right" bgcolor="#81BDDA"  style="text-align:right; padding-right:12px;"> 
                     <span style="color:#000"><input type="button" class="botn" onclick="addProduct()"  value="添加产品"  /></span>
                </td>
            </tr>
            <tr class="formtitle">
             <td colspan="4">
              <div class="list">
                        <table width="100%" border="1" bordercolor="#9FD9E8"
                            cellpadding="2" cellspacing="0" bordercolordark="#EDF2FA"
                            bgcolor="#D0E6F1" id="orderMxTable">
                            <tr>
                             <td width="50" align="center" bgcolor="#D0E6F1">
                                    <strong>序号</strong>
                                </td>
                                <td width="150" align="center" bgcolor="#D0E6F1">
                                    <strong>产品</strong>
                                </td>
                                 <td width="85" align="center" bgcolor="#D0E6F1">
                                    <strong>出货对应库存</strong>
                                </td>
                                  <td width="85" align="center" bgcolor="#D0E6F1">
                                    <strong>数量</strong>
                                </td>
                                <td width="85" align="center" bgcolor="#D0E6F1">
                                    <strong>单价</strong>
                                </td>
                                <td width="85" align="center" bgcolor="#D0E6F1">
                                    <strong>金额</strong>
                                    </td>
                                 </td>
                                <td width="170" align="center" bgcolor="#D0E6F1">
                                    <strong>备注</strong>
                                </td>
                                 <td width="70" align="center" bgcolor="#D0E6F1">
                                    <strong>操作</strong>
                                </td>
                            </tr>
                                
                        </table>
                        </div>
                        </td>
            </tr>
              <tr>
                <td colspan="4"  class="formcontent" align="center" >
                    <input type="button" class="botn" onclick="checkFromSubmitAdd();"  value="提交"  />
                </td>
            </tr>
        </tbody>
    </table>
</div>
</form>

</body>
</html>