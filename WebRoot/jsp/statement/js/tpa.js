function checkFromSubmit(){
	
	if(!checkEmpty(Q('year')) && !checkInNum(Q('year'))){
		alert("请输入年份如：2012");
		Q('year').focus();
		return false;
	}
	if(!checkEmpty(Q('month')) && !checkInNum(Q('month'))){
		alert("请输入年份如：11");
		Q('month').focus();
		return false;
	}
	if(!checkEmpty(Q('writeName'))){
		alert("请填报人");
		Q('writeName').focus();
		return false;
	}
	
	if(!checkEmpty(Q('phone'))||!checkTelOrPhone(Q('phone'))){
		alert("请输入正确的联系方式");
		Q('phone').focus();
		return false;
	}
	
	if(!checkEmpty(Q('sendSms')) && !checkInNum(Q('sendSms'))){
		alert("请输入短信发布数");
		Q('sendSms').focus();
		return false;
	}
	if(!checkEmpty(Q('receiveSms')) && !checkInNum(Q('receiveSms'))){
		alert("请输入短信接收人次数");
		Q('receiveSms').focus();
		return false;
	}
	if(!checkEmpty(Q('weiboNum')) && !checkInNum(Q('weiboNum'))){
		alert("请输入省级微博粉丝数");
		Q('weiboNum').focus();
		return false;
	}
	if(!checkEmpty(Q('weixinNum')) && !checkInNum(Q('weixinNum'))){
		alert("请输入省级微信粉丝数");
		Q('weixinNum').focus();
		return false;
	}
	document.provinceAlert.action="/sshFrame/provinceAlertAction/add";
	document.provinceAlert.submit();
}