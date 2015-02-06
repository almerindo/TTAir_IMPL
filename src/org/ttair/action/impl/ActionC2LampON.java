package org.ttair.action.impl;

import org.ttair.action.architecture.ANodeAction;
import org.ttair.dataaccess.TTAirSerial;

public class ActionC2LampON extends ANodeAction{
	TTAirSerial serial = null;
	String com = "COM5";
	
	public ActionC2LampON() {
		serial= TTAirSerial.getInstance();

	}
	
	private static final long serialVersionUID = 614192068807953508L;



	@Override
	public Object toExecute(Object param) {
		serial.writeData(1);
		return null;
	}

}
