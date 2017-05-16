package com.gojek.command;

import java.lang.reflect.Method;
import java.util.HashMap;

import com.gojek.parkingsol.ParkingSlotManagementImpl;

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
		commandsMap.put("Create", ParkingSlotManagementImpl.class.getMethod("createParkingSlots", String.class));
//		commandsMap.put("Destroy", value);
//		commandsMap.put("Create", value);
//		commandsMap.put("Create", value);
//		commandsMap.put("Create", value);
//		commandsMap.put("Create", value);
//		commandsMap.put("Create", value);
	}
}
