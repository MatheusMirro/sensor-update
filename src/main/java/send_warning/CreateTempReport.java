package send_warning;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import sensor_types.SensorType;

import java.io.BufferedWriter;

public class CreateTempReport {
	public void sendReport(long id, String name, SensorType sensorType, int temperature, String warningMessage)
			throws Exception {

		File myReport = new File("WarningTempReport.txt");
		Long idWriter = id;
		String nameWriter = name;
		SensorType sensorTypeWriter = sensorType;
		int temperatureWriter = temperature;
		String message = warningMessage;

//		if (myReport.exists() && myReport.getName().equalsIgnoreCase("WarningReport.txt")) {
//			throw new Exception("File already exists!");
//		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(myReport))) {
			String temperatureReport = String.format("ID: %d\nName: %s\nType: %s\nTemperature: %d°C\nMessage: %s",
					idWriter, nameWriter, sensorTypeWriter.name(), temperatureWriter, message);

			writer.write(temperatureReport);

			System.out.println("Text successfully written to " + myReport);
		} catch (IOException e) {
			System.err.println("An error occurred while writing to the file: " + e.getMessage());
		}
	}
}