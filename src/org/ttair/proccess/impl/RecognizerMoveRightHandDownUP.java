package org.ttair.proccess.impl;

import org.ttair.proccess.architecture.ARecognizerKinectHandPoint;

import com.primesense.nite.JointType;

public class RecognizerMoveRightHandDownUP extends ARecognizerKinectHandPoint{

	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8303590406253748666L;



	public RecognizerMoveRightHandDownUP() {
		this.setJointType(JointType.RIGHT_HAND);
		this.setJointTypeReference(JointType.RIGHT_ELBOW);
		this.setPath(this.getClass().getCanonicalName());
	}



	@Override
	public boolean toTest() throws Exception { //Se a mão subir mais que o cotovelo
		return (this.getHandPos().getY() <= this.getReferencePos().getY());
	}
	
	

	
	

}
