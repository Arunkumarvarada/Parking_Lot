package com.gojek.parkingsol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class ParkingSlotManagementImpl implements ParkingSlotManagement {
	private int MAXSIZE = 0;
	private TreeMap<String, Car> parkinglot;
	private ArrayList<Integer> parkingSlotsList;
	private HashMap<String, ArrayList<String>> colorWiseCarsList;

	public void getStatus() {
	}

	public void getRegistrationNumbersFromColor(String color) {

	}

	public void getSlotNumbersFromColor(String color) {

	}

	public void destroyParkingLot() {
		parkinglot=null;
		parkingSlotsList=null;
		colorWiseCarsList=null;
		System.out.println("Destroyed the paring slot");
	}

	public void createParkingSlots() {

	}

	public void delteParkingSlots() {

	}

	public void leave(String slotNo) {

	}

	public void getParkingSlotsBasedonColor(String color) {

	}

	public void getSlotNumberFromRegNo(String regNo) {
		
	}

	public void createParkingLot(String lotCount){
		
	}
}
