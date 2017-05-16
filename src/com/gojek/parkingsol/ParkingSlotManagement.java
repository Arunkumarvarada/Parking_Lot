package com.gojek.parkingsol;

public interface ParkingSlotManagement {

	public void getStatus();

	public void getRegistrationNumbersFromColor(String color);

	public void getSlotNumbersFromColor(String color);

	public void destroyParkingSlot();

	public void createParkingSlots();

	public void delteParkingSlots();

	public void leave(String slotNo);

	public void getParkingSlotsBasedonColor(String color);

	public void getSlotNumberFromRegNo(String regNo);

	public void createParkingLot(String lotCount);

}
