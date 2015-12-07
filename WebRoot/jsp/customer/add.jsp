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
<script type="text/javascript" src="/ziYo/jsp/rkd/js/rkd.js"></script>
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
              <td > <b> &nbsp;&nbsp;&gt;&gt;客户资料录入</b> </td>
            </tr>
        </table>
    </td>
  </tr>
</table>
</div>
<form name="rkdForm" method="post">
<div class="main-data">
    <table width="100%" cellspacing="0" cellpadding="2" bordercolor="#9fd9e8" border="1" bgcolor="#d0e6f1" bordercolordark="#EDF2FA">
        <tbody>
            <tr class="formtitletr">
                <td colspan="4" bgcolor="#81BDDA"><b>客户基本信息：</b></td>
            </tr>
            <tr class="formtitletr">
                <td class="formtitle">
                   客户编号(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" id="year" name="customer.khbh"/>
                </td>
                <td class="formtitle">
                    客户名称(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" name="customer.khmc" />
                </td>
            </tr>
            <tr class="formtitle">
                <td class="formtitle">
                 联系人(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" name="customer.lxr" />
                </td>
                <td class="formtitle">
                    联系电话(<font color="red">必填</font>)：
                </td>
                  <td class="formcontent">
                    <input  class="input1" type="text" name="customer.lxrdh"  />
                </td>
            </tr>
               <tr class="formtitle">
                <td class="formtitle">
                 地址(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                   <input  class="input1" type="text" name="customer.dz"  />
                </td>
                <td class="formtitle">
                   所属区域(<font color="red">必填</font>)：
                </td>
                  <td class="formcontent">
                    <input  class="input1" type="text" name="customer.qy"  />
                </td>
            </tr>
               <tr class="formtitle">
                <td class="formtitle">
                 业务员(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                   <input  class="input1" type="text" name="customer.ywy"  />
                </td>
                <td class="formtitle">
                   客户简称(<font color="red">必填</font>)：
                </td>
                  <td class="formcontent">
                     <input  class="input1" type="text" name="customer.jc"  />
                </td>
            </tr>
                        <tr class="formtitle">
                <td class="formtitle">
                 发货方式(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input  class="input1" type="text" name="customer.fhfs"  />
                </td>
                <td class="formtitle">
                   回款方式(<font color="red">必填</font>)：
                </td>
                  <td class="formcontent">
                     <input  class="input1" type="text" name="customer.hkfs"  />
                </td>
            </tr>
            <tr class="formtitle">
                <td class="formtitle">
                    备注（可不填）：
                </td>
                <td class="formcontent" colspan="3">
                    <textarea  cols="40" rows="8" id="tpaService" name="customer.bz" ></textarea>
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