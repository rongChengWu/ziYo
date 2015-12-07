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
              <td > <b> &nbsp;&nbsp;&gt;&gt;供应商修改</b> </td>
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
                <td colspan="4" bgcolor="#81BDDA"><b>供应商基本信息：</b></td>
            </tr>
            <tr class="formtitletr">
                <td class="formtitle">
                    供应商编号(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" id="year" value="${suppliers.gysbh}" name="suppliers.gysbh"/>
                </td>
                <td class="formtitle">
                    供应商名称(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" id="month" value="${suppliers.gysmc}"  name="suppliers.gysmc"/>
                </td>
            </tr>
            <tr class="formtitle">
                <td class="formtitle">
                   联系人(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" id="writeName" value="${suppliers.lxr}" name="suppliers.lxr"/>
                </td>
                <td class="formtitle">
                    联系电话(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" id="phone" value="${suppliers.lxdh}"  name="suppliers.lxdh"/>
                </td>
            </tr>
             <tr class="formtitle">
                <td class="formtitle">
                   地址(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" id="writeName" value="${suppliers.dz}" name="suppliers.dz"/>
                </td>
                <td class="formtitle">
                    属性(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" id="phone" value="${suppliers.sx}"  name="suppliers.sx"/>
                </td>
            </tr>
            <tr class="formtitle">
                <td class="formtitle">
                    备注（可不填）：
                </td>
                <td class="formcontent" colspan="3">
                    <textarea  cols="40" rows="8" id="tpaService" name="suppliers.bz">${suppliers.bz}</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="formcontent" align="center" >
                    <input type="button" class="botn" onclick="checkFromSubmitUpdate()"  value="提交"  />
                </td>
            </tr>
        </tbody>
    </table>
</div>
 <input type="hidden"  value="${suppliers.id}"  name="suppliers.id"/>
</form>

</body>
</html>