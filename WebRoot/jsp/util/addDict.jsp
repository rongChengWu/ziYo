<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/ziYo/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/ziYo/js/public.js"></script>
<script type="text/javascript" src="/ziYo/jsp/suppliers/js/suppliers.js"></script>
<script type="text/javascript" src="/ziYo/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
.input1{width: 300px;}
.botn{margin:0; padding:0;border:0;  width:60px;height:25px; background:url(/ziYo/images/anniu.jpg) no-repeat 0 0; margin-right:10px;}
.botn a{ width:60px; height:25px; line-height:25px; display:block; text-align:center; color:#fff; text-decoration:none;}
.botn a:hover{ color:#000; text-decoration:none;}
</style>
</head>
<body>
<div class="main_title">
 <table width="100%" cellspacing="0" cellpadding="2" bordercolor="#9fd9e8" border="1" bgcolor="#d0e6f1" bordercolordark="#EDF2FA">
  <tr>
    <td background="/ziYo/images/htgl_04.gif">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr> 
              <td > <b> &nbsp;&nbsp;&gt;&gt;字典管理</b> </td>
            </tr>
        </table>
    </td>
  </tr>
</table>
</div>
<form name="suppliersForm" method="post">
<div class="main-data">
    <table width="100%" cellspacing="0" cellpadding="2" bordercolor="#9fd9e8" border="1" bgcolor="#d0e6f1" bordercolordark="#EDF2FA">
        <tbody>
            <tr class="formtitletr">
                <td colspan="4" bgcolor="#81BDDA"><b>字典信息：</b></td>
            </tr>
            <tr class="formtitletr">
                <td class="formtitle">
                    字典编号(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" id="year" name="suppliers.gysbh"/>
                </td>
                <td class="formtitle">
                    字典名称(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" id="month"  name="suppliers.gysmc"/>
                </td>
            </tr>
             <tr class="formtitle">
                <td colspan="3" bgcolor="#81BDDA"><b>字典选项:</b> </td>
                 <td  align="right" bgcolor="#81BDDA"  style="text-align:right; padding-right:12px;"> 
                     <span style="color:#000"><input type="button" class="botn" onclick="addProduct()"  value="添加"  /></span>
                </td>
            </tr>
            <tr class="formtitle">
             <td colspan="4">
              <div class="list">
                        <table width="100%" border="1" bordercolor="#9FD9E8"
                            cellpadding="2" cellspacing="0" bordercolordark="#EDF2FA"
                            bgcolor="#D0E6F1" id="rkdmxTable">
                            <tr>
                             <td width="50" align="center" bgcolor="#D0E6F1">
                                    <strong>序号</strong>
                                </td>
                                <td width="150" align="center" bgcolor="#D0E6F1">
                                    <strong>名称</strong>
                                </td>
                                <td width="50" align="center" bgcolor="#D0E6F1">
                                    <strong>值</strong>
                                </td>
                                <td width="50" align="center" bgcolor="#D0E6F1">
                                    <strong>产品类型</strong>
                                </td>
                                <td width="20" align="center" bgcolor="#D0E6F1">
                                    <strong>单位</strong>
                                </td>
                                  <td width="20" align="center" bgcolor="#D0E6F1">
                                    <strong>数量</strong>
                                </td>
                                <td width="20" height="28" align="center" bgcolor="#D0E6F1">
                                    <strong>单价</strong>
                                </td>
                                <td width="50" align="center" bgcolor="#D0E6F1">
                                    <strong>金额</strong>
                                </td>
                                  <td width="70" align="center" bgcolor="#D0E6F1">
                                    <strong>有效期</strong>
                                </td>
                                 <td width="80" align="center" bgcolor="#D0E6F1">
                                    <strong>生产批号</strong>
                                </td>
                                 <td width="70" align="center" bgcolor="#D0E6F1">
                                    <strong>生产日期</strong>
                                </td>
                                 <td width="70" align="center" bgcolor="#D0E6F1">
                                    <strong>供应商</strong>
                                </td>
                                <td height="70" align="center" bgcolor="#D0E6F1">
                                    <strong>备注</strong>
                                </td>
                                 <td height="70" align="center" bgcolor="#D0E6F1">
                                    <strong>操作</strong>
                                </td>
                            </tr>
                                
                        </table>
                        </div>
                        </td>
            </tr>
            <tr>
                <td colspan="4"  class="formcontent" align="center" >
                    <input type="button" class="botn" onclick="checkFromSubmitAdd()"  value="提交"  />
                </td>
            </tr>
        </tbody>
    </table>
</div>
</form>

</body>
</html>