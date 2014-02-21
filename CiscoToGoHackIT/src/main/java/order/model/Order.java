package order.model;


public class Order {

	public int orderId;
	public String userCEC;
	public String itemID;
	public String buildingID;
	public int ammount;
	public String status;
	
	public Order(){}
	
	public Order(int orderId, String userCEC, String itemID,
			String buildingID, int ammount, String status) {
		this.orderId = orderId;
		this.userCEC = userCEC;
		this.itemID = itemID;
		this.buildingID = buildingID;
		this.ammount = ammount;
		this.status = status;
	}
	

	public int getOrderId() {
		return orderId;
	}
	
	public String getUserCEC() {
		return userCEC;
	}
	
	public String getItemID() {
		return itemID;
	}
	
	public String getBuildingID() {
		return buildingID;
	}
	
	public int getAmmount() {
		return ammount;
	}
	 
	public String getStatus() {
		return status;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setUserCEC(String userCEC) {
		this.userCEC = userCEC;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public void setBuildingID(String buildingID) {
		this.buildingID = buildingID;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
