package org.ttair.proccess.impl;

import org.ttair.proccess.architecture.ARecognizerKinectHandPoint;

import com.primesense.nite.JointType;

public class RecognizerMoveRightHandUPDown extends ARecognizerKinectHandPoint{

	




	/**
	 * 
	 */
	private static final long serialVersionUID = -5568260286917088693L;



	public RecognizerMoveRightHandUPDown() {
		this.setJointType(JointType.RIGHT_HAND);
		this.setJointTypeReference(JointType.RIGHT_ELBOW);
		this.setPath(this.getClass().getCanonicalName());
	}



	@Override
	public boolean toTest() throws Exception { //Se a mão subir mais que o cotovelo
		return (this.getHandPos().getY() > this.getReferencePos().getY());
	}
	
	

	
	

}
