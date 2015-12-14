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
	$.ajaxSetup({async:false});
	var customerJson;
	$.ajax({
		type:"post",
		url:"/ziYo/customerAction/getCustomerBySelect2",
		dataType:'text',
		success:function(json){
			customerJson=eval("(" + json+")");
		}
	});	
	$("select[name='order.tc_id']").select2({
		  data: customerJson
		});
	$.ajaxSetup({async:true});
});

function changeCP(cpId,proNum){
	$("select[name='kc_"+proNum+"']").empty();
	var kcJson;
	$.ajaxSetup({async:false});
	$.ajax({
		type:"post",
		url:"/ziYo/rkdmxAction/getKcBySelect2",
		dataType:'text',
		data: {tp_id:cpId.value},
		success:function(json){
			kcJson=eval("(" + json+")");
		}
	});	
	$("select[name='kc_"+proNum+"']").select2({
		  data: kcJson
		});
	$.ajaxSetup({async:true});
}

function formatRepo (repo) {
    if (repo.loading) return repo.text;

    var markup = '<div class="clearfix">' +
    '<div class="col-sm-1">' +
    '<img src="' + repo.owner.avatar_url + '" style="max-width: 100%" />' +
    '</div>' +
    '<div clas="col-sm-10">' +
    '<div class="clearfix">' +
    '<div class="col-sm-6">' + repo.full_name + '</div>' +
    '<div class="col-sm-3"><i class="fa fa-code-fork"></i> ' + repo.forks_count + '</div>' +
    '<div class="col-sm-2"><i class="fa fa-star"></i> ' + repo.stargazers_count + '</div>' +
    '</div>';

    if (repo.description) {
      markup += '<div>' + repo.description + '</div>';
    }

    markup += '</div></div>';

    return markup;
  }

  function formatRepoSelection (repo) {
    return repo.full_name || repo.text;
  }
  
function checkFromSubmitAdd(){
	sumBdje();
	document.orderForm.action="/ziYo/orderAction/add";
	document.orderForm.submit();
}

function checkFromSubmitUpdate(){
	sumBdje();
	document.orderForm.action="/ziYo/orderAction/update";
	document.orderForm.submit();
}

var mxxh=0;
function addProduct(){
	mxxh+=1;
	var ordermxTable=document.getElementById("orderMxTable");
	  var rowsNum = ordermxTable.rows.length;  //获取当前行数
	   var myNewRow = ordermxTable.insertRow(rowsNum);//插入新行
	   myNewRow.id="mxtr"+mxxh;
	   myNewRow.innerHTML=""+getRkdmxHtml(mxxh);
	
//	$("#ordermxTable").html($("#ordermxTable").html()+getRkdmxHtml(mxxh));
	$.ajaxSetup({async:false});
	$("select[name='tpid_"+mxxh+"']").select2({
		  data: jsonDate
		});
	$.ajaxSetup({async:true});
}

function delMx(trid){
	$("#"+trid).remove();
	sumBdje();
}

function sumBdje(){
	var sumBdje=0;
	for (var i = 1; i <=mxxh; i++) {
		var sumJe=0;
		if($("input[name='sl"+i+"']").val()!="" && $("input[name='dj"+i+"']").val()!=""&& !empty($("input[name='sl"+i+"']").val())&&!empty($("input[name='dj"+i+"']").val())){
			sumJe=eval($("input[name='sl"+i+"']").val() * $("input[name='dj"+i+"']").val());
			$("input[name='je"+i+"']").val(sumJe.toFixed(2));
			sumBdje=eval(sumBdje+sumJe);
		}
	}
	$("input[name='order.bdzj']").val(sumBdje.toFixed(2));
	
}

function getRkdmxHtml(productNum){
	var strHtml="<tr bgcolor='#E7F2F8' onMouseOver='this.bgColor=\'#FFFFFF\';' onMouseOut='this.bgColor=\'#E7F2F8\';' id='mxtr"+productNum+"'>" +
			"<td align='center'><input type='text' value='"+productNum+"' style='width:10px;border:0px;'  name='mxxh' readonly='readonly' /></td>" +
			"<td align='center'>" +"<select class='js-example-data-array' name='tpid_"+productNum+"'  id='pro"+productNum+"'  onchange=\"changeCP(this,"+productNum+");\"></select></td>" +
			"<td align='center'>" +"<select class='js-example-data-array' name='kc_"+productNum+"'  id='kc"+productNum+"'></select></td>" +
			"<td align='center'><input type='text' style='width:100%;'   value='' name='sl"+productNum+"'/></td>" +
			"<td align='center'><input type='text' style='width:100%;'   value='' name='dj"+productNum+"' onblur='sumBdje();'/></td>" +
			"<td align='center'><input type='text' style='width:100%;' disabled=\"disabled\"   value='' name='je"+productNum+"'/></td>" +
			"<td align='center'><input type='text' style='width:100%;'   value='' name='bz"+productNum+"'/></td>" +
			"<td align='center'><a href='javascript:void(0)' onclick=\"delMx('mxtr"+productNum+"')\">删除产品</a></td>" +
			"</tr>";
			return strHtml;
}