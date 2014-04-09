//Bind keypress event to textbox

$(document).ready(function(){
	
	var current_employee;
	
	$.ajax({
		type : "POST",
		url : "getEmployeeDetails/",
		async : false,
		success : function(response) {
			//alert("promise.responeText == " + JSON.stringify(response));
			current_employee = response;
			//current_employee = JSON.parseJSON(response);
			
		}
	});
	
	var obj;
	//alert("before getordetable  " + JSON.stringify(current_employee));
	$.ajax({
		type: "POST",
		url: "getOrderTable/",
		data : {json:JSON.stringify(current_employee)},
		success: function(response){
			// ** change this to accomodate set of orders wtf?
			//obj = $.parseJSON(response);
			//alert("WTF3");
			obj = response;
			//alert("obj == " + obj)
			//alert("respone = " + obj);
			//alert("obj = " + JSON.stringify(obj));
			//alert("obj[0] = " + JSON.stringify(obj[0]));
			//alert("obj[0].orderItems = " + JSON.stringify(obj[0].orderItems));
			console.log(JSON.stringify(obj));
			for (var ob = 0; ob < obj.length; ob++) {
				//alert("ob == " + JSON.stringify(obj[ob]));
				$('#orderId').html(obj[ob].id);
				$('#fullName').html("Taylor Threatt");
				$('#cec').html("tathreat");
				$('#buildingID').html("Bldg J");
				//orderItems
				var orderItemName = obj[ob].orderItems[0].item.name;
				$('#menuItem').html(obj[ob].orderItems[0].item.name);
				$('#price').html(obj[ob].amount);
				$('#status').html(obj[ob].status);
			}
			
			//alert("fin");
		}
		
	});
	//$('.completeBox').prop('disabled',true);
	$('.completeBox').keypress(function(event){
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if(keycode == '13'){
			var dat =  "req="+obj.orderId+"/"+obj.userCEC+"/"+obj.itemID+"/"+obj.buildingID+"/"+obj.ammount+"/Complete";
			dat=dat.replace(/\s/g,"%20");
			console.log(dat);
			$.ajax({
				type: "POST",
				url: "orderComplete/",
				data:dat,
				success: function(){
					
				}
				
			});
			
			alert('The order is complete');	
		}
		//Stop the event from propogation to other handlers
		//If this line will be removed, then keypress event handler attached 
		//at document level will also be triggered
		event.stopPropagation();
	});
	
	$('.readyButton').click(function(){
		$(this).prop('disabled',true);
		$(this).html('Ready');
		//alert(obj[0].id);
		var dat = {json:JSON.stringify({id:obj[0].id})};
		//alert("dat = " + JSON.stringify(dat));
		console.log(dat);
		$.ajax({
			type: "POST",
			url: "orderReady/",
			data:dat,
			success: function(){
				
			}
			
		});
	});
});