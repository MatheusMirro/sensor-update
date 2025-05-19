package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import messages.WarningMessage;
import send_warning.CreateTempReport;
import sensor_types.SensorType;

@Getter
@AllArgsConstructor
@ToString
public class SensorTempModel {

	private long id;
	private String name;
	private SensorType type;
	private int temperature;

	public void checkTemperature(WarningMessage warningTempMessage, CreateTempReport createTempReport) throws Exception {
		if (temperature > 65) {
			createTempReport.sendReport(id, name, type, temperature, warningTempMessage.hotMessage());
		}
	}
}