package com.gojek.parkingsol;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import com.gojek.parkingsol.exception.InvalidInputException;

public class ParkingSlotManagementImpl implements ParkingSlotManagement {
	private int MAXSIZE = 0;
	private ArrayList<Integer> parkingSlotsList;
	private TreeMap<String, Car> parkinglot;// map1
	private LinkedHashMap<String, String> colorWithRegNO;// map2
	private LinkedHashMap<String, ArrayList<String>> colorWiseCarsList;// map3

	public void createParkingSlots(String slotCount) throws InvalidInputException {
		try{
			this.MAXSIZE= Integer.parseInt(slotCount);
		}catch (Exception e) {
			System.out.println("Invalid Slot Count");
		}
		if(this.MAXSIZE<0){
			throw new InvalidInputException("slot Number should be either greater zero");
		}
		this.parkinglot= new TreeMap<String,Car>();
		this.colorWithRegNO= new LinkedHashMap<String, String>();
		this.colorWiseCarsList= new LinkedHashMap<String, ArrayList<String>>();
		
	}

	public void getStatus() {
		if (MAXSIZE == 0) {
			System.out.println("System is not ");
		}
	}

	public void getRegistrationNumbersFromColor(String color) {

	}

	public void getSlotNumbersFromColor(String color) {

	}

	public void destroyParkingLot() {
		parkinglot = null;
		parkingSlotsList = null;
		colorWiseCarsList = null;
		System.out.println("Destroyed the paring slot");
	}

	public void delteParkingSlots() {

	}

	public void leave(String slotNo) {

	}

	public void getParkingSlotsBasedonColor(String color) {

	}

	public void getSlotNumberFromRegNo(String regNo) {

	}

	public void createParkingLot(String lotCount) {

	}
}
