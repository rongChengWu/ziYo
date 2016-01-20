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