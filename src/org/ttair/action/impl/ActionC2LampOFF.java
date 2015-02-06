package org.ttair.action.impl;

import org.ttair.action.architecture.ANodeAction;
import org.ttair.dataaccess.TTAirSerial;

public class ActionC2LampOFF extends ANodeAction{
	
	private static final long serialVersionUID = 614192068807953508L;
	TTAirSerial serial = null;
	
    public ActionC2LampOFF() {
    	serial = TTAirSerial.getInstance();
	}

	@Override
	public Object toExecute(Object param) {
	
		serial.writeData(2);
		return null;
	}
	
	public static void main(String[] args) {
		ActionC2LampOFF  a = new ActionC2LampOFF ();
		a.toExecute(null);
	}

}
