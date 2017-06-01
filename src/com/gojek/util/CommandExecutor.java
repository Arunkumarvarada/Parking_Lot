package com.gojek.util;

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
		commandsMap.put("park", ParkingSlotManagement.class.getMethod("park", String.class, String.class));
		commandsMap.put("leave", ParkingSlotManagement.class.getMethod("leave", String.class));
		commandsMap.put("status", ParkingSlotManagement.class.getMethod("getStatus"));
		commandsMap.put("registration_numbers_for_cars_with_colour",
				ParkingSlotManagement.class.getMethod("getRegistrationNumbersFromColor", String.class));
		commandsMap.put("slot_numbers_for_cars_with_colour",
				ParkingSlotManagement.class.getMethod("getSlotNumbersFromColor", String.class));
		commandsMap.put("slot_number_for_registration_number",
				ParkingSlotManagement.class.getMethod("getSlotNumberFromRegNo", String.class));
	}
}
