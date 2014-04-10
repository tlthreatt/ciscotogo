/**
Custom module for you to write your own javascript functions
**/
var Custom = function () {
	
	
	
	function createRatingForm(location) {
		/*
		$('#ratingInfoTileContents').append('<div style="float:left; width:300px;"><h1 style="line-height:60px">Recent Ratings </h1><h1 style="line-height:60px">of '+ location.name + '</h1></div>');
		
		dat = {json:JSON.stringify({location_id:location.id})};
		alert("dat == " + dat);
		
		$.ajax({
			type: "POST",
			url: "getRatings/",
			data : dat,
			success: function(response){
				obj = $.parseJSON(response);
				alert("ratings == " + JSON.stringify(obj));
				$("#ratingLoadImage").fadeOut();   
			}
		});
		*/
	}
	
	//gets the contact info for the contact info file
	
	function createOrderForm(name, categories){
		
		$('#foodInfoTileContents').append('<div style="float:left; width:300px;"><h1 style="line-height:60px">Choose a Meal</h1><h1 style="line-height:60px">From '+ name + '</h1></div>');
		$('#foodInfoTileContents').append('<div id="mealRadioButtons" style="float:left; width:200px;"></div>');
		
		categories.forEach(function(category){
			//alert("categoreies = " + JSON.stringify(category));
			$('#mealRadioButtons').append('<h3 style="line-height:50px">' + category.name + '</h3>');
			console.log(category.items);
			//alert("items = " + JSON.stringify(category.items))
			category.items.forEach(function(item){
				
				var html_string = '<input type="checkbox" name="item" value="' + item.id + '">';
				html_string += '<label style="font-size:16px">' + item.name + "  " + '</label>';
				html_string += '<label style="font-size:16px">' + "---$" + item.listPrice + '</label><br>';
				
				$('#mealRadioButtons').append(html_string);
			});
		});
		$('#foodInfoTileContents').append(
				'<div style="float:left;">'+
					'<button id="confirmButton" type="button" style="color:#000; width:100px">Confirm</button>'+
					'<button id="cancelButton" type="button" style="color:#000; width:100px">Cancel</button>'+
				'</div>');
		
	}
	
	function fillUserTile(customer){
		//alert("customer == " + JSON.stringify(customer));
		
		$('#contactTileContents').append(
				'<h1 style="padding-bottom:20px;">Hi, ' + customer.firstName + '</h1>' +
				//'<h4 style="padding-bottom:20px;"> Favorite Food: ' + user.favFood + '</h4>'+
				//'<h4 style="padding-bottom:20px;"> Favorite Location: ' + user.favLocation + '</h4>'+
				
				'<h4 id="customer_balance"> Balance: ' + customer.balance + '</h4>'	
		);
		
	}
	
	function fillOrderTile(orders){
		$('#orderTileContents').html(
			'<h1 style="padding-bottom:20px;"> Orders </h1>'
		);
		if (orders.length == 0) {
			$('#orderTileContents').append('<h5 style="padding-bottom:20px;">You have no current Orders</h5>');
		} else {
			orders.forEach(function(order){
				console.log(order);
				$('#orderTileContents').append(
					'<h5 style="padding-bottom:20px;"> Order #' + order.id + ': ' + order.status + '</h5>'
				);
			});
		}
		var obj;
		/*
		$.ajax({
			type: "POST",
			url: "getOrderTable/",
			success: function(response){
				obj = $.parseJSON(response);
				$('#orderTileContents').append(
					'<h5 style="padding-bottom:20px;" id="dbOrder"> Order #' + obj.orderId + ': ' + obj.status + '</h5>'
				);
			}
		});
		*/
		
		
		
	}
	
	function fillBuildingTiles(locationList){
		var tileColor;
		//alert("locationList == " + JSON.stringify(locationList));
		locationList.forEach(function(location,index){
			var tileColor;
			switch(index % 4){
			case 0:
				tileColor = "bg-dark";
				break;
			case 1:
				tileColor = "bg-blue";
				break;
			case 2:
				tileColor = "bg-purple";
				break;
			case 3:
				tileColor = "bg-green";
				break;
			}
			//alert('location.name == ' + location.name);
			var locationAddress = location.locationAddress;
			var locationHours = location.locationHours;
			/*
			var breakfastStart = locationHours.breakfastStart;
			var breakfastEnd = locationHours.breakfastEnd;
			var lunchStart = locationHours.lunchStart;
			var lunchEnd = locationHours.lunchEnd;
			*/
			$(".buildingTiles").find('ul').append(
					'<li>'+
					'<div class="tileContainer">'+
						'<div class="tileCard">'+
							'<div class="tile '+ tileColor +' frontFlip faceFlip">' +
								'<div id="testTile" class="tile-body">'+
									'<h4 class="buildingTileTitle" style="line-height:22px;">'+location.name+'</h4>'+
									'<div class="tile-object">'+
									    '<h3 id='+index+ ' class="menuLink" style="padding-bottom:100px;padding-left:15px;">Click for menu</h3>'+
										'<div class="infoFlip">'+
											'<i class="fa fa-info-circle clickFlip"></i>'+
										'</div>'+
									'</div>'+					
								'</div>'+
							'</div>'+
							'<div class="tile '+ tileColor +' backFlip faceFlip">' +
								'<div class="tile-body">'+
									'<div class="closeFlip">'+
										'<i class="fa fa-times clickFlip"></i>'+
									'</div>'+
									'<div>'+
										'<p>'+locationAddress.street+',<br />' + locationAddress.city + ', ' + locationAddress.state + ' ' + locationAddress.zip + '<br /> ' + locationAddress.country + '</p>'+
										'<p>Breakfast from ' + locationHours.breakfastStart + ' to ' + locationHours.breakfastEnd + '</p>' +
										'<p>Lunch from ' + locationHours.lunchStart + ' to ' + locationHours.lunchEnd + '</p>' +
									'</div>'+
								'</div>'+
							'</div>'+
						'</div>'+
					'</div>'+
				'</li>'
				);
			
			//Fill in front of tile
			$('.buildingTiles .frontFlip').each(function(index) {
				var tileObject = $(this);
				tileObject.find('.tile-body').fadeIn();
				tileObject.find('.tile-object').fadeIn();        				
			});
			
			//Fill in back of tile
			$('.buildingTiles .backFlip').each(function(index) {
				var tileObject = $(this);
				tileObject.find('.tile-body').fadeIn();
				tileObject.find('.tile-object').fadeIn();        				
			});
		});
	}
	
	/*
	 * Customer CEC is hard coded to taylor's. Make sure this is updated with LDAP information.
	 */
	
	var current_customer; // = {customer_cec:"tathreat", customer_balance:20.00};
	//alert ("current_customer == " + JSON.stringify(current_customer));
	
	
	
    // public functions
    return {
    	
    	
        //main function
        init: function () {     
           
        },
                
        getFoodData: function(){
        	//GET FOOD INFO
        	var CustomerDetails = {
        			getCustomerDetails: function() {
            			//alert("trying ajax to getCustomerDetails/");
            			var promise = $.ajax({
            				url: 'getCustomerDetails/',
            				type:"POST",
            				async:false
            				
            			});
            			///alert("promise.responseText == " + JSON.stringify(promise.responseText));
            			///alert("promise == " + JSON.stringify(promise));
            			///current_customer = promise;
            			//alert("WTF" + JSON.stringify(promise));
            			//alert("WTF" + promise.responseText);
            			return promise.responseText;
            		}
            	};
        	
        	var FoodDetails = {
        		getFoodDetails: function() {
        			//alert("trying ajax to getFoodDetails/ " + JSON.stringify(current_customer));
        			var promise = $.ajax({
        				url: 'getFoodDetails/',
        				type:"POST",
        				data:{json:JSON.stringify(current_customer)}
        				
        			});
        			//alert("foodDetails promise.resp = " + promise.responseText);
        			//alert("foodDetails promise.resp = " + JSON.stringify(promise));
        			return promise;
        			//alert("food details promise == " + JSON.stringify(promise));
        		}
        	};
        	
        	var OrderDetails = {
            		getOrderDetails: function() {
            			//alert("trying ajax to getOrderDetails/ " + JSON.stringify(current_customer));
            			var promise = $.ajax({
            				url: 'getOrderDetails/',
            				type:"POST",
            				data:{json:JSON.stringify(current_customer)}
            			});
            			
            			return promise;
            			//alert("orderdetails promise == " + JSON.stringify(promise));
            		}
            	};
        	
        	$('#pageLoadImage').fadeIn();
        	/*
        	$.when(CustomerDetails.getCustomerDetails())
        	.then(function(customerResults) {
        		alert("whenthen " + JSON.stringify(customerResults));
        		current_customer = customerResults;
        	*/
        	//synchronous ajax returns a json string not a json object
        	current_customer = jQuery.parseJSON(CustomerDetails.getCustomerDetails());
        	//alert("asynch " + JSON.stringify(current_customer));
        	
        	$.when(FoodDetails.getFoodDetails(), OrderDetails.getOrderDetails())
        	.then(function(foodResults, orderResults) {
        		
        		//alert("hi");
        		
        		var location_id;
        		
        		//alert("toString() = " + JSON.stringify(foodResults));
        		//foodResults[0] is actual list
        		//alert("[0] = " + JSON.stringify(foodResults[0]));
        		//alert("[0][0] = " + JSON.stringify(foodResults[0][0]));
        		
        		//alert("orderResults == " + JSON.stringify(orderResults));
        		
        		//alert("foodResuls = " + JSON.stringify(foodResults));
        		//alert("foodResults[0] = " + JSON.stringify(foodResults[0]));
        		
        		console.log(foodResults[0]);
        		console.log(orderResults[0]);
    			$("#pageLoadImage").fadeOut();    			
    			$('.title-section').fadeIn();

    			//populate contact tile
    			$('#contactTile').fadeIn();
    			
    			//populate big blue tile
    			$('#foodInfoTile').fadeIn(); 
    			
    			//populate rating tile
    			$('#ratingInfoTile').fadeIn();
    			
    			fillUserTile(orderResults[0]);
    			
    			fillOrderTile(orderResults[0].orders);
    			
    			
    			//populate top tiles
    			fillBuildingTiles(foodResults[0]);
    			//initialize bxslider
				$('.bxslider').show();
	            $('.bxslider').bxSlider({
	                minSlides: 1,
	                maxSlides: 2,
	                slideWidth: 227,
	                slideMargin: 10,
	                moveSlides: 1,
	                responsive: true,
	                infiniteLoop: false,
	                hideControlOnEnd: true
	            });
	            
	            //click event for tile flipping
	            $('.clickFlip').on('click', function() {    	            	
	        	    $(this).closest('.tileContainer').toggleClass('active');
	        	});

	            $('.menuLink').click(function(){ 
	            	//this can be the location_id?
	            	var index = parseInt($(this).attr('id'));
	            	location_id = foodResults[0][index].id;
	            	//alert("location_id == " + location_id);
	            	console.log($(this).attr('id'));
	            	//alert("index == " + index);
	            	$('#foodInfoTileContents').empty();
	            	$('#ratingInfoTileContents').empty();
	            	//alert("foodResults[0][index].categories = " + foodResults[0][index].categories);
	            	//alert("foodResults[0][index].name = " + foodResults[0][index].name);
	            	//createOrderForm(foodResults[0].locations[index].buildingName, foodResults[0].locations[index].dailyMenus[0].menuCategories);
	            	createOrderForm(foodResults[0][index].name, foodResults[0][index].categories);
	            	$('#cancelButton').click(function(){
	            		$('#foodInfoTileContents').empty();
	            	});
	            	
	            	
	            	createRatingForm(foodResults[0][index]);
	            	
	            	
	            	//Review confirm button
	            	
	            	
	            	// Order confirm button
	            	$('#confirmButton').click(function(){
	            		var isChecked = false;
	            		var items = [];
	            		// this needs to be set when the onchange from user clicking a location
	            		//var location_id = foodResults[0][0].id;
            			var customer_cec = "tathreat";
            			var item;
            			var total_amount = 0.0;
	            		$('input:checkbox:checked').each(function(){
	            			isChecked = true;
	            			console.log($(this).val());
	            			//dat = "req=1/tathreat/"+ $(this).val()+"/"+foodResults[0][0].locations[index].buildingName+"/6/Pending";
	            			var item_id = $(this).val();
	            			var item_price;
	            			//alert("location_id = " + location_id);
	            			//categoryLoop: // this is to break out of the loop once an item matches
	            			foodResults[0][0].categories.forEach(function (c) { 
	            				
	            				
	            				
	            				//item = c.items.filter (function (i) {
	            				     c.items.forEach(function (i) {
	            					//alert("!item = " + JSON.stringify(i));
	            					//alert("i.id = " + i.id + " item_id = " + item_id);
	            					//return i.id == item_id});//.map(function(i){return i});
	            					if (i.id == item_id) {
	            						item = i;
	            						//break categoryLoop;
	            						//alert("match");
	            					}
	            				})
	            			});
	            			//alert("item == " + JSON.stringify(item));
	            			//alert("item[0] == " + JSON.stringify(item[0]));
	            			//alert("item price == " + item[0].listPrice);
	            			//alert("item == " + JSON.stringify(item));
	            			//items.push({id:item_id, list_price:item[0].listPrice});
	            			items.push({id:item_id, list_price:item.listPrice});
	            			//total_amount += item[0].listPrice;
	            			total_amount += item.listPrice;
	            			//alert("total amount = " + total_amount)
	            			
	            		});
	            		
	            		
	            		
	            		if(!isChecked){
	            			alert('Did not choose a meal!');
	            			return;
	            		}
	            		if (total_amount > current_customer.balance) {
	            			alert('Your balance of $' + current_customer.balance + ' is less than $' + total_amount + '.');
	            			return;
	            		}
	            		var new_customer_balance = current_customer.balance - total_amount;
	            		current_customer.balance = new_customer_balance;
	            		//alert("new customer balance == " + new_customer_balance);
	            		$('#customer_balance').text("Balance: " + new_customer_balance);
            			var dat = {items : items, customer_cec:customer_cec, new_customer_balance:new_customer_balance, location_id:location_id, total_amount:total_amount};
            			dat = {json:JSON.stringify(dat)};
            			//alert(dat);
            			$.ajax({
            				type: "POST",
            				url: "createOrder/",
            				data: dat,
            				success:function(){
            					//alert('Order Created');
            					$('#dbOrder').html('Order #1: Pending');
            					$('#foodInfoTileContents').empty();
            					
            					$.when(OrderDetails.getOrderDetails())
            	        		.then(function(orderResults) { 
            	        			//alert( "orderResults = " + JSON.stringify(orderResults));
            	        			// for some reason its not a list this time, no [0]
            	        			fillOrderTile(orderResults.orders);
            	        		});
            				}
            			});
	            		
	            	});
	            });
	            
	            
        	});
        	
       // }); // when customer details then
        	
        	
        },
        
       

    };

}();
