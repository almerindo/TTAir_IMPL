package org.ttair.app;


import org.ttair.action.impl.ActionC2LampOFF;
import org.ttair.action.impl.ActionC2LampON;
import org.ttair.action.impl.ActionC3LampOFF;
import org.ttair.action.impl.ActionC3LampON;
import org.ttair.dataaccess.TTAirSerial;
import org.ttair.proccess.impl.RecognizerSensorLight;

public class AppSerial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TTAirSerial.setPort("COM5");
		TTAirSerial serial = TTAirSerial.getInstance();
		
		
		ActionC2LampON c2LampON = new ActionC2LampON();
		c2LampON.toExecute(null);
		ActionC3LampON c3LampON = new ActionC3LampON();
		c3LampON.toExecute(null);
		
		ActionC2LampOFF c2LampOFF = new ActionC2LampOFF();
		c2LampOFF.toExecute(null);
		ActionC3LampOFF c3LampOFF = new ActionC3LampOFF();
		c3LampOFF.toExecute(null);
		
		RecognizerSensorLight rs = new RecognizerSensorLight();
		rs.start(true);
		Thread t = new Thread(rs);
		t.start();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		rs.start(false);
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("COM FECHADA");
		serial.close();
		t.interrupt();
	}

}
