<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
	</head>
	<body>
		<h1>Current Orders</h1>
		<table>
			<tr>
				<th>Order ID</th>
				<th>CEC</th>
				<th>Item ID</th>
				<th>Building ID</th>
				<th>Amount</th>
				<th>Status</th>
			</tr>
			<tr>
				<td>1</td>
				<td>eyaklin</td>
				<td>1</td>
				<td>1</td>
				<td>6.95</td>
				<td></td>
			</tr>
		</table>
		
		
		<label>TextBox Area: </label>
		<input id="someTextBox" type="text" size="40" />
		<script type="text/javascript">
			//Bind keypress event to textbox
			$('#someTextBox').keypress(function(event){
				var keycode = (event.keyCode ? event.keyCode : event.which);
				if(keycode == '13'){
					alert('You pressed a "enter" key in textbox');	
				}
				//Stop the event from propogation to other handlers
				//If this line will be removed, then keypress event handler attached 
				//at document level will also be triggered
				event.stopPropagation();
			});
			
			//Bind keypress event to document
			$(document).keypress(function(event){
				var keycode = (event.keyCode ? event.keyCode : event.which);
				if(keycode == '13'){
					alert('The order is complete');	
				}
			});
		</script>
	</body>
</html>