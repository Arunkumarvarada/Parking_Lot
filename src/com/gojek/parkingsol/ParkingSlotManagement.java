package com.gojek.parkingsol;

public interface ParkingSlotManagement {

	public void getStatus();

	public void getRegistrationNumbersFromColor(String color);

	public void getSlotNumbersFromColor(String color);

	public void destroyParkingLot();

	public void leave(String slotNo);

	public void getParkingSlotsBasedonColor(String color);

	public void getSlotNumberFromRegNo(String regNo);

	public void createParkingLot(String lotCount);

}
