package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import messages.WarningMessage;
import send_warning.CreateHumidityReport;
import sensor_types.SensorType;

@Getter
@AllArgsConstructor
@ToString

public class SensorHumidityModel {

	private long id;
	private String name;
	private SensorType type;
	private int humidity;

	public void checkHumidity(WarningMessage warningHumidityMessage, CreateHumidityReport createHumidityReport)
			throws Exception {

		if (humidity > 65) {
			createHumidityReport.sendReport(id, name, type, humidity, warningHumidityMessage.humiditySensor());
		}
	}
}
