package org.ttair.proccess.impl;

import org.ttair.TTAirEvent;
import org.ttair.dataaccess.TTAirSerial;
import org.ttair.proccess.architecture.ANodeRecognizer;

public class RecognizerSensorLight extends ANodeRecognizer{

	public static final String[] EventCod= {"EVTClaro","EVTEscuro", "EVTMeioClaro" };


	private static final long serialVersionUID = 191590946290319384L;
	private TTAirSerial serial = TTAirSerial.getInstance();


	@Override
	public TTAirEvent toExecute() {
		TTAirEvent evt = null;

		serial.writeData(100);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String data = serial.readLastData().toUpperCase();
		String cod = null;
		String param = null;

		switch (data) {
		case "CLARO;":
			cod = RecognizerMousePositionIMPL.EventCod[0];
			param = cod;
			break;

		case "MEDIO;":
			cod = RecognizerMousePositionIMPL.EventCod[1];
			param = cod;
			break;

		case "ESCURO;":
			cod = RecognizerMousePositionIMPL.EventCod[2];
			param = cod;
			break;
		default:
			break;
		}

		if (cod!=null){
			evt = new TTAirEvent(this);
			try {
				evt.setCOD(cod);
				evt.setID("EVT"+evt.toString());
				evt.setParam(param);
				System.out.println(data);
			} catch (Exception e) {
				evt = null;
			}
		}

		
		return evt;
	}

}
