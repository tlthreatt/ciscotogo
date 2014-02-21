//Bind keypress event to textbox

$(document).ready(function(){
	
	
	$.ajax({
		type: "POST",
		url: "getOrderTable/",
		success: function(response){
			var obj = $.parseJSON(response);
			console.log(obj);
			$('#orderId').html(obj.orderId);
			$('#fullName').html(obj.userCEC);
			$('#cec').html(obj.userCEC);
			$('#buildingID').html(obj.buildingID);
			$('#menuItem').html(obj.itemID);
			$('#price').html(obj.ammount);
			$('#status').html(obj.status);
		}
		
	});
	//$('.completeBox').prop('disabled',true);
	$('.completeBox').keypress(function(event){
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if(keycode == '13'){
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
		
		
	});
});