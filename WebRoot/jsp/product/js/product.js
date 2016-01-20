$(function () {
	$.ajaxSetup({async:false});
	var jsonDate;
	$.ajax({
		type:"post",
		url:"/ziYo/suppliersAction/getSelect2Suppliers",
		dataType:'text',
		success:function(json){
			jsonDate=eval("(" + json+")");
		}
	});	
	
	$(".js-example-data-array").select2({
		  data: jsonDate
		});
		 
	$(".js-example-data-array-selected").select2({
		  data: jsonDate
		});
	$.ajaxSetup({async:true});
});

function checkFromSubmitAdd(){
	if(!checkUserPush()){
		return;
	}
	document.productForm.action="/ziYo/productAction/add";
	document.productForm.submit();
}

function checkFromSubmitUpdate(){
	if(!checkUserPush()){
		return;
	}
	document.productForm.action="/ziYo/productAction/update";
	document.productForm.submit();
}

function checkUserPush(){
	if(!checkEmptyByValue($("input[name='product.cpbm']").val())){
		alert("产品编码不能为空！");
		$("input[name='product.cpbm']").focus();
		return false;
	}
	if(!checkEmptyByValue($("input[name='product.cpmc']").val())){
		alert("产品名称不能为空！");
		$("input[name='product.cpmc']").focus();
		return false;
	}
	if(!checkEmptyByValue($("input[name='product.cpgg']").val())){
		alert("产品规格不能为空！");
		$("input[name='product.cpgg']").focus();
		return false;
	}
	if(!checkEmptyByValue($("select[name='product.cplx']").val())){
		alert("请选择产品类型");
		$("select[name='product.cplx']").focus();
		return false;
	}
	if(!checkEmptyByValue($("select[name='product.tsid']").val())){
		alert("请选择供应商！");
		$("select[name='product.tsid']").focus();
		return false;
	}
	if(!checkEmptyByValue($("input[name='product.dw']").val())){
		alert("产品单位不能为空！");
		$("input[name='product.dw']").focus();
		return false;
	}
	return true;
}