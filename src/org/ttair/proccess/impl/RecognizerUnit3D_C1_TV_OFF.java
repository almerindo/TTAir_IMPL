package org.ttair.proccess.impl;



import org.ttair.proccess.architecture.ARecognizerSocketCMD;

public class RecognizerUnit3D_C1_TV_OFF extends ARecognizerSocketCMD{

	private static final long serialVersionUID = -6642930901404024654L;
	
	@Override
	public boolean toTest() {
		if ("C2_TV_OFF".equalsIgnoreCase(this.getCurrentCmd())) {
			return true;
		}
		
		return false;
	}
	
	
}
