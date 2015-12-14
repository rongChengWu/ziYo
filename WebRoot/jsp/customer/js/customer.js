var jsonDate;
$(function () {
	$.ajax({
		type:"post",
		url:"/ziYo/productAction/getSelect2Products",
		dataType:'text',
		success:function(json){
			jsonDate=eval("(" + json+")");
		}
	});	
});

function changeCP(cpId,proNum){
	alert(proNum);
	alert(cpId.value);
	alert($(cpId).find("option:selected").text());
}
  
function checkFromSubmitAdd(){
	document.customerForm.action="/ziYo/customerAction/add";
	document.customerForm.submit();
}

function checkFromSubmitUpdate(){
	document.customerForm.action="/ziYo/customerAction/update";
	document.customerForm.submit();
}


