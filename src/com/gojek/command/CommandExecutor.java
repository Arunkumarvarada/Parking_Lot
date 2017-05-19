package com.gojek.command;

import java.lang.reflect.Method;
import java.util.HashMap;

import com.gojek.parkingsol.ParkingSlotManagement;

public class CommandExecutor {
	public HashMap<String, Method> commandsMap;

	public CommandExecutor() {
		commandsMap = new HashMap<String, Method>();
		try {
			populateCommandsHashMap();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	private void populateCommandsHashMap() throws NoSuchMethodException {
		commandsMap.put("create_parking_lot", ParkingSlotManagement.class.getMethod("createParkingSlots", String.class));
		commandsMap.put("destroy", ParkingSlotManagement.class.getMethod("destroyParkingSlot", String.class));
		commandsMap.put("Park", ParkingSlotManagement.class.getMethod("createParkingSlots", String.class));
		commandsMap.put("leave", ParkingSlotManagement.class.getMethod("leave", String.class));
		commandsMap.put("status", ParkingSlotManagement.class.getMethod("getStatus", String.class));
		commandsMap.put("registration_numbers_for_cars_with_colour", ParkingSlotManagement.class.getMethod("createParkingSlots", String.class));
		commandsMap.put("slot_numbers_for_cars_with_colour", ParkingSlotManagement.class.getMethod("createParkingSlots", String.class));
		commandsMap.put("slot_number_for_registration_number", ParkingSlotManagement.class.getMethod("getParkingSlotsBasedonColor", String.class));
	}
}
