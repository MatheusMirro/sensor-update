package send_warning;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import sensor_types.SensorType;

public class CreateHumidityReport {
	public void sendReport(long id, String name, SensorType sensorType, int humidity, String warningMessage)
			throws Exception {
		File myReport = new File("WarningHumidityReport.txt");

		Long idWriter = id;
		String nameWriter = name;
		SensorType sensorTypeWriter = sensorType;
		int sensorHumidity = humidity;
		String message = warningMessage;

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(myReport))) {
			String temperatureReport = String.format("ID: %d\nName: %s\nType: %s\nHumidity: %d°C\nMessage: %s",
					idWriter, nameWriter, sensorTypeWriter.name(), sensorHumidity, message);

			writer.write(temperatureReport);

			System.out.println("Text successfully written to " + myReport);
		} catch (IOException e) {
			System.err.println("An error occurred while writing to the file: " + e.getMessage());
		}

	}
}
