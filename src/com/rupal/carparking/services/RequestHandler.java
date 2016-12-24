package com.rupal.carparking.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import com.rupal.carparking.car.Car;

public class RequestHandler {

	CarParkingManager carParkingManager;

	public RequestHandler() {
		System.out.println("################################################################");
		System.out.println("################# WELCOME TO CAR PARKING SYSTEM ################");
		System.out.println("################################################################");
	}

	public static void main(String[] args) {
		RequestHandler requestHandler = new RequestHandler();
		Scanner sc = new Scanner(System.in);
		String line = null;
		String[] commandTokens = null;
		while (true) {
			if (sc.hasNext()) {
				line = sc.nextLine();
				if (line.equals(Commands.EXIT.getCommand())) {
					return;
				} else if(line.contains(".txt") ){
					String inputfileName = line.substring(0, line.indexOf(".")) +".txt";
					String outputfileName=null;
					if(line.contains(">")){
						outputfileName = (line.substring(line.indexOf(">")+1, line.length())).trim();
					}
					requestHandler.fileParser(inputfileName, outputfileName);
				}else {
					commandTokens = line.split(" ");
					System.out.println(requestHandler.handleRequest(commandTokens));
				}
			}
		}

	}

	private String handleRequest(String[] commandTokens) {
		String result=null;
		try {
			
//			System.out.println(commandTokens[0]);
			if (commandTokens[0].equalsIgnoreCase(Commands.CREATE_PARKING_LOT.getCommand())) {
				int size = Integer.valueOf(commandTokens[1]);
				carParkingManager = new CarParkingManager(size);
				result="Created a parking lot with " + size + " slots";
			} else if (commandTokens[0].equalsIgnoreCase(Commands.STATUS.getCommand())) {
				 result = carParkingManager.status();
			} else if (commandTokens[0].equalsIgnoreCase(Commands.PARK.getCommand())) {
				String registrationNumber = commandTokens[1];
				String color = commandTokens[2];
				 Car car = new Car(registrationNumber, color);
				result = carParkingManager.vehicalEntry(car);
			} else if (commandTokens[0].equalsIgnoreCase(Commands.LEAVE.getCommand())) {
				int slotIndex = Integer.valueOf(commandTokens[1]);
				result = carParkingManager.vehicalExit(slotIndex);
			} else if (commandTokens[0].equalsIgnoreCase(Commands.SLOT_NUMBER_FOR_REGITRATION_NUMBER.getCommand())) {
				result = Integer.toString((carParkingManager.getParkedSlotNumber(commandTokens[1])));
			} else if (commandTokens[0].equalsIgnoreCase(Commands.SLOT_NUMBERS_FOR_CARS_WITH_COLOURS.getCommand())) {
				result = carParkingManager.printCarSlotWithColour(commandTokens[1]);
			} else if (commandTokens[0]
					.equalsIgnoreCase(Commands.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR.getCommand())) {
				result = carParkingManager.printRegistrationNumberWithColour(commandTokens[1]);
			} else {
				result = ("Invalid Command..");
			}
			
		} catch (Exception ex) {
			result =ex.getMessage();	
		}
		
		return result;
	}

	public void fileParser(String inputFile, String outPutFile) {
		try {
//			FileReader fr = new FileReader(file);
			Stream<String> strStream = Files.lines(Paths.get(inputFile));
			StringBuilder  sb = new StringBuilder();
			if(outPutFile!=null){
					strStream.forEach(str -> sb.append(handleRequest(str.split(" "))+"\n"));
					try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outPutFile))) 
					{
					    writer.write(sb.toString());
					}
			}else{
				strStream.forEach(str -> System.out.println(handleRequest(str.split(" "))));
			}
			
			strStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
//	private void writeResult(String result,BufferedWriter bw){
//		try {
//		if(bw==null)
//			System.out.println(result);
//		else{
//			try(bw){
//			bw.write(result);
//			bw.newLine();
//			}
//		}
//			
//		} catch (IOException e) {
//				// TODO Auto-generated catch block
// e.printStackTrace();
	// }
	// }
}
