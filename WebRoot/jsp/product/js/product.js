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
	document.productForm.action="/ziYo/productAction/add";
	document.productForm.submit();
}

function checkFromSubmitUpdate(){
	document.productForm.action="/ziYo/productAction/update";
	document.productForm.submit();
}