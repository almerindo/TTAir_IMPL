package org.ttair.proccess.impl;

import org.ttair.proccess.architecture.ARecognizerKinectHandPoint;

import com.primesense.nite.JointType;

public class RecognizerMoveLeftHandDownUP extends ARecognizerKinectHandPoint{


	private static final long serialVersionUID = 6264778902062789576L;



	public RecognizerMoveLeftHandDownUP() {
		this.setJointType(JointType.LEFT_HAND);
		this.setJointTypeReference(JointType.LEFT_ELBOW);
		this.setPath(this.getClass().getCanonicalName());
	}



	@Override
	public boolean toTest() throws Exception { //Se a mão subir mais que o cotovelo
		return (this.getHandPos().getY() <= this.getReferencePos().getY());
	}
	
	

	
	

}
