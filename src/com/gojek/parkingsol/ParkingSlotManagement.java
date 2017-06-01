package com.gojek.parkingsol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import com.gojek.parkingsol.exception.InvalidInputException;

public class ParkingSlotManagement {
	private int MAXSIZE = 0;
	private ArrayList<Integer> parkingSlotsList;
	private LinkedHashMap<String, Car> parkinglot;// map1
	private LinkedHashMap<String, String> colorWithRegNO;// map2
	private LinkedHashMap<String, ArrayList<String>> colorWiseCarsList;// map3

	public void createParkingSlots(String slotCount) throws InvalidInputException {
		try {
			this.MAXSIZE = Integer.parseInt(slotCount);
		} catch (Exception e) {
			System.out.println("Invalid Slot Count");
		}
		this.parkingSlotsList = new ArrayList<Integer>() {};
		for (int i=1; i<= this.MAXSIZE; i++) {
			parkingSlotsList.add(i);
        }
		this.parkinglot = new LinkedHashMap<String, Car>();
		this.colorWithRegNO = new LinkedHashMap<String, String>();
		this.colorWiseCarsList = new LinkedHashMap<String, ArrayList<String>>();
		System.out.println("Created parking Slot with " + slotCount + " slots");
		System.out.println(this.parkinglot.isEmpty());
	}

	public void destroyParkingSlot() {
		parkinglot = null;
		parkingSlotsList = null;
		colorWithRegNO = null;
		colorWiseCarsList = null;
		System.out.println("Destroyed the paring slot");
	}

	public void park(String regNo, String color) {
		 if (this.MAXSIZE == 0) {
	            System.out.println("Sorry, parking lot is not created");
	            System.out.println();
	        } else if (this.parkinglot.size() == this.MAXSIZE) {
	            System.out.println("Sorry, parking lot is full");
	            System.out.println();
	        } else {
	            Collections.sort(parkingSlotsList);
	            String slot = parkingSlotsList.get(0).toString();
	            Car car = new Car(regNo, color);
	            this.parkinglot.put(slot, car);
	            this.colorWithRegNO.put(regNo, slot);
	            if (this.colorWiseCarsList.containsKey(color)) {
	                ArrayList<String> regNoList = this.colorWiseCarsList.get(color);
	                this.colorWiseCarsList.remove(color);
	                regNoList.add(regNo);
	                this.colorWiseCarsList.put(color, regNoList);
	            } else {
	                ArrayList<String> regNoList = new ArrayList<String>();
	                regNoList.add(regNo);
	                this.colorWiseCarsList.put(color, regNoList);
	            }
	            System.out.println("Allocated slot number: " + slot);
	            System.out.println();
	            parkingSlotsList.remove(0);
	        }
	}

	public void leave(String slotNo) {
		if (this.MAXSIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			System.out.println();
		} else if (this.parkinglot.size() > 0) {
			Car carToLeave = this.parkinglot.get(slotNo);
			if (carToLeave != null) {
				this.parkinglot.remove(slotNo);
				this.colorWithRegNO.remove(carToLeave.regNo);
				ArrayList<String> regNoList = this.colorWiseCarsList.get(carToLeave.color);
				if (regNoList.contains(carToLeave.regNo)) {
					regNoList.remove(carToLeave.regNo);
				}
				// Add the Lot No. back to available slot list.
				this.parkingSlotsList.add(Integer.parseInt(slotNo));
				System.out.println("Slot number " + slotNo + " is free");
				System.out.println();
			} else {
				System.out.println("Slot number " + slotNo + " is already empty");
				System.out.println();
			}
		} else {
			System.out.println("Parking lot is empty");
			System.out.println();
		}
	}

	public void getStatus() {
		if (this.MAXSIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			System.out.println();
		} else if (this.parkinglot.size() > 0) {
			// Print the current status.
			System.out.println("Slot No.\tRegistration No.\tColor");
			Car car;
			for (int i = 1; i <= this.MAXSIZE; i++) {
				String key = Integer.toString(i);
				if (this.parkinglot.containsKey(key)) {
					car = this.parkinglot.get(key);
					System.out.println(i + "\t" + car.regNo + "\t" + car.color);
				}
			}
			System.out.println();
		} else {
			System.out.println("Parking lot is empty");
			System.out.println();
		}
	}

	public void getRegistrationNumbersFromColor(String color) {
		if (this.MAXSIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			System.out.println();
		} else if (this.colorWiseCarsList.containsKey(color)) {
			ArrayList<String> regNoList = this.colorWiseCarsList.get(color);
			System.out.println();
			for (int i = 0; i < regNoList.size(); i++) {
				if (!(i == regNoList.size() - 1)) {
					System.out.print(regNoList.get(i) + ",");
				} else {
					System.out.print(regNoList.get(i));
				}
			}
		} else {
			System.out.println("Not found");
			System.out.println();
		}
	}

	public void getSlotNumbersFromColor(String color) {
		if (this.MAXSIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			System.out.println();
		} else if (this.colorWiseCarsList.containsKey(color)) {
			ArrayList<String> regNoList = this.colorWiseCarsList.get(color);
			ArrayList<Integer> slotList = new ArrayList<Integer>();
			System.out.println();
			for (int i = 0; i < regNoList.size(); i++) {
				slotList.add(Integer.valueOf(this.colorWithRegNO.get(regNoList.get(i))));
			}
			Collections.sort(slotList);
			for (int j = 0; j < slotList.size(); j++) {
				if (!(j == slotList.size() - 1)) {
					System.out.print(slotList.get(j) + ",");
				} else {
					System.out.print(slotList.get(j));
				}
			}
			System.out.println();
		} else {
			System.out.println("Not found");
			System.out.println();
		}
	}

	public void getSlotNumberFromRegNo(String regNo) {
		if (this.MAXSIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			System.out.println();
		} else if (this.colorWithRegNO.containsKey(regNo)) {
			System.out.println(this.colorWithRegNO.get(regNo));
		} else {
			System.out.println("Not found");
			System.out.println();
		}
	}

	public static void main(String[] args) throws InvalidInputException {
		ParkingSlotManagement parking= new ParkingSlotManagement();
		parking.createParkingSlots("6");
		parking.park("KA-01-HH-1234", "White");
		parking.getStatus();
	}
}
