package org.ttair.proccess.impl;

import java.util.Random;

import org.ttair.TTAirEvent;
import org.ttair.proccess.architecture.ANodeRecognizer;

public class RecognizerFaceIMPL extends ANodeRecognizer{
	
	private static final long serialVersionUID = -4437545352605531794L;
	private TTAirEvent evt = null;
	private Random r = new Random(10L);
	
	public static final String[] EventCod= {"EVTFaceRecognized"};

	
	@Override
	public synchronized TTAirEvent toExecute() {
		
		
		try {
			Thread.sleep(r.nextInt(100));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (evt==null) {
			evt = new TTAirEvent(this);
			try {
				evt.setCOD(RecognizerFaceIMPL.EventCod[0]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			
			evt = null;
		}
		return evt;
	}

}
