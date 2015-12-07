<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tags/tree.tld" prefix="nodeTag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>梓瑶兽药</title>
<script type="text/javascript" src="/ziYo/js/tree.js"></script>
<style>
*{ margin:0px; padding:0px;}
body {
	background-attachment:fixed;
	background-position:top left;
	margin-left: 0px;
	margin-top: 0px;
	margin-bottom: 0px;
}
body,td,th {
	font-family: Arial, Helvetica, sans-serif,"宋体";
	font-size: 9pt;
}
.tree_body{height:100%;border-right:black 1px solid;}
.tree_header{cursor:pointer;width:99%;height:18;padding-top:2px;background :#b8c4f4;BORDER: #646c94 1px solid;}
.tree_div{padding-left:5px;}
.dtree {
 font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;
 font-size: 11px;
 color: #666;
 white-space: nowrap;
}
.dtree img {
 border: 0px;
 vertical-align: middle;
}
.dtree a {
 color: #333;
 text-decoration: none;
}
.dtree a.node, .dtree a.nodeSel {
 white-space: nowrap;
 padding: 1px 2px 1px 2px;
}
.dtree a.node:hover, .dtree a.nodeSel:hover {
 color: #333;
 text-decoration: underline;
}
.dtree a.nodeSel {
 background-color: #c0d2ec;
}
.dtree .clip {
 overflow: hidden;
}
</style>
<script type="text/javascript">
function hiddenTreeNode(){
		if(getBrowserName() == "IE") {
		
		window.parent.main.cols="15,0,*";
		
		}
		else { //suppot FF & Opera
		
		parent.document.getElementById('main').cols="15,0,*";

} 

 //parent.document.getElementById('main').cols="15,0,*";
 //window.parent.main.cols="15,0,*";
}
</script>
</head>
<body leftmargin="0" class="tree_body" topmargin="0" rightmargin="20">
<div class="tree_header" align="center">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
	  	<tr><td width="80%">
	     <div width="100%" align="center">
			   梓瑶兽药管理系统
	     </div>
	     </td>
	     <td width="20%">
	     <div title="关闭" onclick="hiddenTreeNode()" align="right" width="100%">
	       |←
	     </div>
	     </td>
	    </tr>
	  </table>
</div>
   <%
    String fanodeid = request.getParameter("fanodeid");
    %>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr><td></td></tr>
	  <tr><td>
	    <div class="tree_div" id="divRender">
	    <nodeTag:TreeTag fanodeid="<%=fanodeid %>"/>    
	    </div>
	  </td>
	  </tr>
	  
  </table>
  </body>
</html>