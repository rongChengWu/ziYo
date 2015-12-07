function checkFromSubmit(){
	alert("进入");
	if(!checkEmpty(Q('city'))){
		alert("请输入地市");
		Q('city').focus();
		return false;
	}
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
	if(!checkEmpty(Q('day')) && !checkInNum(Q('day'))){
		alert("请输入日如：27");
		Q('day').focus();
		return false;
	}
	if(!checkEmpty(Q('addres'))){
		alert("请输入市（县区）");
		Q('addres').focus();
		return false;
	}
	if(!checkEmpty(Q('alertName'))){
		alert("请输入预警警报名称");
		Q('alertName').focus();
		return false;
	}
	if(!checkEmpty(Q('arrangeTime'))){
		alert("请输入发布时间");
		Q('arrangeTime').focus();
		return false;
	}
	if(!checkEmpty(Q('liveTime'))){
		alert("请输入实况出现时间");
		Q('liveTime').focus();
		return false;
	}
	if(!checkEmpty(Q('alertAdvance'))){
		alert("请输入预警提前量 ");
		Q('alertAdvance').focus();
		return false;
	}
	if(!checkEmpty(Q('datumIssue')) && !checkInNum(Q('datumIssue'))){
		alert("请输入决策服务材料（期数）");
		Q('datumIssue').focus();
		return false;
	}
	if(!checkEmpty(Q('interviewCount')) && !checkInNum(Q('interviewCount'))){
		alert("请输入媒体（电话、电台）等采访次数");
		Q('interviewCount').focus();
		return false;
	}
	if(!checkEmpty(Q('pcc')) && !checkInNum(Q('pcc'))){
		alert("请输入新闻发布会（次）");
		Q('pcc').focus();
		return false;
	}
	if(!checkEmpty(Q('prc')) && !checkInNum(Q('prc'))){
		alert("请输入提供新闻稿件（篇数）");
		Q('prc').focus();
		return false;
	}
	if(!checkEmpty(Q('survey'))){
		alert("请输入预报概况");
		Q('survey').focus();
		return false;
	}
	document.alertServeForm.action="/sshFrame/alertServeAction/add";
	document.alertServeForm.submit();
}