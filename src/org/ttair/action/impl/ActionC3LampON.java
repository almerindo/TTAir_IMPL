package org.ttair.action.impl;

import org.ttair.action.architecture.ANodeAction;
import org.ttair.dataaccess.TTAirSerial;

public class ActionC3LampON extends ANodeAction{

	String com = "COM5";
	
	private static final long serialVersionUID = 614192068807953508L;



	@Override
	public Object toExecute(Object param) {
		TTAirSerial serial = TTAirSerial.getInstance();
		serial.writeData(3);
		return null;
	}

}
