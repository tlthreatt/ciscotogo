//Bind keypress event to textbox

	function ready_button(button, orderId) {
		$(button).prop('disabled', true);
		$(button).html('Ready');
		var dat = {json:JSON.stringify({id:orderId})};
		//alert("dat = " + JSON.stringify(dat));
		console.log(dat);
		//alert($("#rfid_" + orderId).text);
		$("#rfid_" + orderId).html("<div id='rfid_"  + orderId + "'>" + "<input class='completeBox tb5' type='text' size='10' onkeypress='complete_text(this," + orderId + ");' />" + "</div>");
		
		$.ajax({
			type: "POST",
			url: "orderReady/",
			data:dat,
			success: function(){
				
			}
			
		});
	}

	function complete_text(txt, orderId) {
		$(txt).prop('disabled', true);
		var dat = {json:JSON.stringify({id:orderId})};
		//alert("dat = " + JSON.stringify(dat));
		$('#btn_' + orderId).html("<div id='btn_"  + obj[ob].id + "'>" + "Complete" + "</div>");
		console.log(dat);
		$.ajax({
			type: "POST",
			url: "orderComplete/",
			data:dat,
			success: function(){
				
			}
			
		});
	}
	
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
				$('#orderId').append("<div>" + obj[ob].id + "</div>");
				$('#fullName').append("<div>" + "Taylor Threatt" + "</div>");
				$('#cec').append("<div>" + "tathreat" + "</div>");
				$('#buildingID').append("<div>" + "Bldg J" + "</div>");
				//orderItems
				//var orderItemName = obj[ob].orderItems[0].item.name;
				//alert(obj[ob].orderItems[0].item.name);
				var menuItemString = "<div>";
				for (var i = 0; i < obj[ob].orderItems.length; i++) {
					//alert(JSON.stringify(obj[ob].orderItems[i]));
					menuItemString += obj[ob].orderItems[i].item.name + "<br />";
				}
				menuItemString = menuItemString.substring(0, menuItemString.length - 6);
				menuItemString += "</div>";
				//alert("str = " + menuItemString);
				$('#menuItem').append(menuItemString);
				$('#price').append("<div>" + obj[ob].amount + "</div>");
				if (obj[ob].status == "Pending") { //"<div>" + obj[ob].status + "</div>"
					$('#readyButton').append("<div id='btn_"  + obj[ob].id + "'>" + "<button id='1status' type='button' class='readyButton' onclick='ready_button(this," +obj[ob].id + ");'></button>" + "</div>");
					//$('#completeBox').append("<div>" + "<input class='completeBox tb5' type='text' size='10'  onkeypress='complete_text(this," + obj[ob].id + ");' />" + "</div>"); // onkeypress='complete_text(this," + obj[ob].id + ")
					$('#completeBox').append("<div id='rfid_"  + obj[ob].id + "'>" + " " + "</div");
				} else if (obj[ob].status == "Ready") {
					$('#readyButton').append("<div id='btn_"  + obj[ob].id + "'>" + "Ready" + "</div>");
					$('#completeBox').append("<div id='rfid_"  + obj[ob].id + "'>" + "<input class='completeBox tb5' type='text' size='10' onkeypress='complete_text(this," + obj[ob].id + ");' />" + "</div>"); // onkeypress='complete_text(this," + obj[ob].id + ")
				} else if (obj[ob].status == "Complete") {
					$('#readyButton').append("<div id='btn_"  + obj[ob].id + "'>" + "Complete" + "</div>");
					$('#completeBox').append("<div id='rfid_"  + obj[ob].id + "'>" + "Complete" + "</div>");
				}
				
				
			}
			
			//alert("fin");
		}
		
	});
	
	
	//$('.completeBox').prop('disabled',true);
	/*
	$('.completeBox').keypress(function(event){
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if(keycode == '13'){
			var dat = {json:JSON.stringify({id:orderId})};
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
	*/
	

	

	
	$('.readyButton').click(function(){
		$(this).prop('disabled',true);
		$(this).html('Ready');
		//alert(obj[0].id);
		var dat = {json:JSON.stringify({id:orderId})};
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