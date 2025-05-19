package com.mirro.sensormonitor.sensor_monitor;

import monitoring_service.MonitoringSystem;

public class Main {
	public static void main(String[] args) throws Exception {
		MonitoringSystem monitoring = new MonitoringSystem();
		monitoring.monitoringSystemTemperature();
	}
}