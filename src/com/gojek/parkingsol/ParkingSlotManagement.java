package com.gojek.parkingsol;

public interface ParkingSlotManagement {
	
	public void getStatus();
	
	public void createParkingSlots();
	
	public void delteParkingSlots();
	
	public void park();
	
	public void getParkingSlotsBasedonColor(String color);
	

}
