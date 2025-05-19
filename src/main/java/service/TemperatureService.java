package service;

import messages.WarningMessage;
import model.SensorTempModel;
import model.SensorHumidityModel;
import send_warning.CreateTempReport;
import send_warning.CreateHumidityReport;
import sensor_types.SensorType;

public class TemperatureService {
	public void createTempSensor() throws Exception {
		SensorTempModel sensor = new SensorTempModel(1, "Ambient Temperature", SensorType.TEMPERATURE,
				(int) (Math.random() * 100));
		sensor.checkTemperature(new WarningMessage(), new CreateTempReport());
		System.out.println(sensor);
	}

	public void createHumiditySensor() throws Exception {
		SensorHumidityModel sensor = new SensorHumidityModel(2, "Humidity Sensor", SensorType.HUMIDITY,
				(int) (Math.random() * 100));
		sensor.checkHumidity(new WarningMessage(), new CreateHumidityReport());
		System.out.println(sensor);
	}
}