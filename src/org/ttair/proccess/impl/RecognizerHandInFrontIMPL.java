package org.ttair.proccess.impl;

import java.util.Random;

import org.ttair.TTAirEvent;
import org.ttair.proccess.architecture.ANodeRecognizer;



public class RecognizerHandInFrontIMPL extends ANodeRecognizer{
	
	private static final long serialVersionUID = 6301540085924292855L;
	private TTAirEvent evt = null;
	private Random r = new Random(10L);


	
	public static final String[] EventCod= {"EVTHandInFront"};
	
	
	@Override
	public synchronized TTAirEvent toExecute() {
		
		try {
			Thread.sleep(r.nextInt(500));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (evt==null) {
			evt = new TTAirEvent(this);
			try {
				evt.setCOD(RecognizerHandInFrontIMPL.EventCod[0]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			
			evt = null;
		}
		return evt;
	}

}
