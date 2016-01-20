/***
****	功能说明：公共JS 可以把一些公用的JS写在些类上
**** by wu
***/
	
/** 
 * @param obj 要验证的属性对象
 * @param type （1、整数 2、正整数 3、负整数
 * 4、浮点数 5、正浮点数 6、负浮点数）
 */
function checkNumHelp(obj,type){
	var re =  "";
	var mes = "";
	if(type != null && type == "1"){
		re =  /^-?\d+$/;
		mes = "整数";	
	}else if(type != null && type == "2"){
		re = /^\\d+$/;
		mes = "正整数";	
	}else if(type != null && type == "3"){
		re = /^((-\\d+)|(0+))$/;
		mes = "负整数";	
	}else if(type != null && type == "4"){
		re = /^[-\+]?\d+(\.\d+)?$/;
		mes = "浮点数";	
	}else if(type != null && type == "5"){
		re = /^\\d+(\\.\\d+)?$/;
		mes = "正浮点数";	
	}else if(type != null && type == "5"){
		re = /^((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$/;
		mes = "负浮点数";	
	}

	if(obj.value != null && obj.value != ""){
		if(re.test(obj.value))
		  	return true;
		 else
		 	alert("请输入"+mes+"类型的数字！");
		 	obj.value=0;
		 	obj.focus();
		  	return false;
	}else{
		return true;
	}
}
/***
**email 验证
**/
function checkemail(object){
	var pattern = /^[a-zA-Z0-9_-]+@{1}[a-zA-Z0-9]+[.]{1}[a-zA-Z]+[.]?[a-zA-Z]*$/;
	var strvalue=object.value.Trim();
	if (strvalue.length==0){
		return true;
	}
	if(strvalue.match(pattern)==null){
		object.value="";
		object.focus();
		return false;
	}else{
		return true;
	}
} 

function checkTelOrPhone(obj){
	if(isTel(obj.value.Trim())||isMobel(obj.value.Trim())){
		 return true; 
	}else{
		return false;
	}
	
}
function isTel(value){
	 return (/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/.test(value.Trim()));
}
function isMobel(value)   
{   
	if(/^13\d{9}$/g.test(value.Trim())||(/^15[0-35-9]\d{8}$/g.test(value.Trim()))||   
	(/^18[05-9]\d{8}$/g.test(value.Trim()))){     
	            return true;   
	}else{   
	            return false;   
	}   
}
//验证是否是数字 如果不是自动清空
function checkcountTxt(obj){
	if(obj.value.length==1){
		obj.value=obj.value.replace(/[^0-9]/g,'')
	}else{
		obj.value=obj.value.replace(/\D/g,'')
	}
	if(obj.value.length==1){
		obj.value=obj.value.replace(/[^0-9]/g,'')
	}else{
		obj.value=obj.value.replace(/\D/g,'')
	}
}

//获取对象
function Q(id){
	return document.getElementById(id);
}

//去空格
String.prototype.Trim = function() { 
	var m = this.match(/^\s*(\S+(\s+\S+)*)\s*$/); 
	return (m == null) ? "" : m[1]; 
}
//输入数量
function checkInNum(obj){
	 var re =/^[1-9]+[0-9]*]*$/;  
	 //判断字符串是否为数字      /^\+?[1-9][0-9]*$/
//判断正整数 /^[1-9]+[0-9]*]*$/      
 if (!re.test(obj.value.Trim())){   
	 obj.value=1;
    return false;    
 }else{
	 return true;
 }
 
}
//check empty
function checkEmpty(obj){
		var val=obj.value.Trim();
		if(val==""){
			return false;
		}else{
			return true;
		}
	}

function checkEmptyByValue(obj){
	var val=obj.Trim();
	if(val==""){
		return false;
	}else{
		return true;
	}
}

 
function empty(v){ 
switch (typeof v){ 
case 'undefined' : return true; 
case 'string' : if(v.length == 0) return true; break; 
case 'boolean' : if(!v) return true; break; 
case 'number' : if(0 === v) return true; break; 
case 'object' : 
if(null === v) return true; 
if(undefined !== v.length && v.length==0) return true; 
for(var k in v){return false;} return true; 
break; 
} 
return false; 
}