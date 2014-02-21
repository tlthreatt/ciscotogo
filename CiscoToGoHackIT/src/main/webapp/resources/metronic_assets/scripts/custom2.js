//Bind keypress event to textbox

$(document).ready(function(){
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
		var statusCell = $(this).closest('td');
		
		var completeBox = $(this).closest('text');
		statusCell.empty();
		statusCell.html('Ready');
		console.log(completeBox);
		completeBox.disabled = false;
	});
});