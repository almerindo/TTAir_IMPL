package org.ttair.proccess.impl;

import org.ttair.proccess.architecture.ARecognizerKinectHandPoint;

import com.primesense.nite.JointType;

public class RecognizerMoveLeftHandUPDown extends ARecognizerKinectHandPoint{


	private static final long serialVersionUID = -3035753811827969161L;



	public RecognizerMoveLeftHandUPDown() {
		this.setJointType(JointType.LEFT_HAND);
		this.setJointTypeReference(JointType.LEFT_ELBOW);
		this.setPath(this.getClass().getCanonicalName());
	}



	@Override
	public boolean toTest() throws Exception { //Se a mão subir mais que o cotovelo
		return (this.getHandPos().getY() > this.getReferencePos().getY());
	}
	
	

	
	

}
