<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language=javascript src="/ziYo/js/tree.js"></script>
<style>
.hidden_bar{cursor:pointer;width:100%;height:100%;padding-top:2px;background :#C2D5F9;BORDER: #646c94 1px solid;}
</style>
<script type="text/javascript">


function show(){

if(getBrowserName() == "IE") {

window.parent.main.cols="0,240,*";

}
else { //suppot FF & Opera

parent.document.getElementById('main').cols="0,200,*";

} 
   //parent.document.getElementById('main').cols=="0,20%,*";//适合FF与IE
 //window.parent.main.cols="0,20%,*";
}

</script></head>
<body leftmargin="0" topmargin="0">
   <div class="hidden_bar" align="center" onClick="show()" title="打开" >
     <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
       <tr>
         <td align="center" valign="middle">
           <img src="/ziYo/images/ftree.gif">
         </td>
       </tr>
     </table>
   </div>
</body>
</html>