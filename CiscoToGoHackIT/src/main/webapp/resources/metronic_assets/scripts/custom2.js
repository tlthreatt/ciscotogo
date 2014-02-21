//Bind keypress event to textbox
			$('#someTextBox').keypress(function(event){
				var keycode = (event.keyCode ? event.keyCode : event.which);
				if(keycode == '13'){
					alert('The order is complete');	
				}
				//Stop the event from propogation to other handlers
				//If this line will be removed, then keypress event handler attached 
				//at document level will also be triggered
				event.stopPropagation();
			});