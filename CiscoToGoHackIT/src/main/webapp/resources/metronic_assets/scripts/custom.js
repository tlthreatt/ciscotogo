/**
Custom module for you to write your own javascript functions
**/
var Custom = function () {
	
	//gets the contact info for the contact info file
	
	function createOrderForm(name, categories){
		$('#foodInfoTileContents').append('<div style="float:left; width:150px;"><h5>Choose a Meal</h5><h5>From '+ name + '</div>');
		$('#foodInfoTileContents').append('<div id="mealRadioButtons" style="float:left; width:200px;"></div>');
		
		categories.forEach(function(c){
			$('#mealRadioButtons').append('<h5>' + c.name + '</h5>');
			console.log(c.menuItems);
			c.menuItems.forEach(function(m){
				$('#mealRadioButtons').append('<input type="radio" name="item" value = "'+m.itemID + '">' +m.itemID + '<br>');
			});
		});
		$('#foodInfoTileContents').append(
				'<div style="float:left;">'+
					'<button id="confirmButton" type="button" style="color:#000">Confirm</button>'+
					'<button id="cancelButton" type="button" style="color:#000">Cancel</button>'+
				'</div>');
		
	}
	
	function fillUserTile(user){
		$('#contactTileContents').append(
				'<h1 style="padding-bottom:20px;">Hi, ' + user.firstName + '</h1>'+
				'<h4 style="padding-bottom:20px;"> Favorite Food: ' + user.favFood + '</h4>'+
				'<h4 style="padding-bottom:20px;"> Favorite Location: ' + user.favLocation + '</h4>'+
				'<h4> Balance: ' + user.balance + '</h4>'		
		);
		
	}
	
	function fillOrderTile(orders){
		$('#orderTileContents').append(
			'<h1 style="padding-bottom:20px;"> Orders </h1>'
		);
		orders.forEach(function(order){
			console.log(order);
			$('#orderTileContents').append(
				'<h5 style="padding-bottom:20px;"> Order #' + order.orderID + ': ' + order.status + '</h5>'
			);
		});
		var obj;
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
		
		
		
	}
	
	function fillBuildingTiles(locationList){
		var tileColor;
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
			$(".buildingTiles").find('ul').append(
					'<li>'+
					'<div class="tileContainer">'+
						'<div class="tileCard">'+
							'<div class="tile '+ tileColor +' frontFlip faceFlip">' +
								'<div id="testTile" class="tile-body">'+
									'<h4 class="buildingTileTitle" style="line-height:22px;">'+location.buildingName+'</h4>'+
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
										'<p>'+location.buildingAddress+'</p>'+
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
	
	
    // public functions
    return {

        //main function
        init: function () {     
           
        },
                
        getFoodData: function(){
        	//GET FOOD INFO
        	var FoodDetails = {
        		getFoodDetails: function() {
        			var promise = $.ajax({
        				url: 'getFoodDetails/'
        			});
        			
        			return promise;
        		}
        	};
        	
        	var OrderDetails = {
            		getOrderDetails: function() {
            			var promise = $.ajax({
            				url: 'getOrderDetails/'
            			});
            			
            			return promise;
            		}
            	};
        	
        	$('#pageLoadImage').fadeIn();
        	$.when(FoodDetails.getFoodDetails(), OrderDetails.getOrderDetails())
        	.then(function(foodResults, orderResults) {
        		
        		console.log(foodResults[0]);
        		console.log(orderResults[0]);
    			$("#pageLoadImage").fadeOut();    			
    			$('.title-section').fadeIn();

    			//populate contact tile
    			$('#contactTile').fadeIn();
    			
    			//populate big blue tile
    			$('#foodInfoTile').fadeIn(); 
    			
    			fillUserTile(orderResults[0].orders[0].user);
    			
    			fillOrderTile(orderResults[0].orders);
    			
    			
    			//populate top tiles
    			fillBuildingTiles(foodResults[0].locations);
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
	            	var index = parseInt($(this).attr('id'));
	            	console.log($(this).attr('id'));
	            	$('#foodInfoTileContents').empty();
	            	createOrderForm(foodResults[0].locations[index].buildingName, foodResults[0].locations[index].dailyMenus[0].menuCategories);
	            		
	            	$('#cancelButton').click(function(){
	            		$('#foodInfoTileContents').empty();
	            	});
	            	
	            	$('#confirmButton').click(function(){
	            		var isChecked = false;
	            		$('input:radio:checked').each(function(){
	            			isChecked = true;
	            			console.log($(this).val());
	            			dat = "req=1/tathreat/"+ $(this).val()+"/"+foodResults[0].locations[index].buildingName+"/6/Pending";
	            			$.ajax({
	            				type: "POST",
	            				url: "createOrder/",
	            				data: dat,
	            				success:function(){
	            					alert('Order Created');
	            					$('#dbOrder').html('Order #1: Pending');
	            					$('#foodInfoTileContents').empty();
	            				}
	            			});
	            			
	            		})
	            		if(!isChecked){
	            			alert('Did not choose a meal!');
	            		}
	            		
	            	});
	            });
	            
	            
        	});
        	
        	
        },
        
       

    };

}();
