package monitoring_service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import service.TemperatureService;

public class MonitoringSystem {

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	TemperatureService tempService = new TemperatureService();
	TemperatureService humidityService = new TemperatureService();

	public void monitoringSystemTemperature() {
		Runnable beeper = () -> {
			try {
				tempService.createTempSensor();
				humidityService.createHumiditySensor();
			} catch (Exception e) {
				System.out.print("Deu ruim aqui!");
				e.printStackTrace();
			}
		};
		ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 2, 2, TimeUnit.SECONDS);
		Runnable canceller = () -> beeperHandle.cancel(false);
		scheduler.schedule(canceller, 1, TimeUnit.HOURS);
	}
}
