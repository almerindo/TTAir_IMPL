package org.ttair.proccess.impl;

import org.ttair.proccess.architecture.ARecognizerKinectHandPoint;

import com.primesense.nite.JointType;

public class RecognizerMoveRightHandRightLeft extends ARecognizerKinectHandPoint{

	
	private static final long serialVersionUID = 6312929031345607720L;



	public RecognizerMoveRightHandRightLeft() {
		this.setJointType(JointType.RIGHT_HAND);
		this.setJointTypeReference(JointType.RIGHT_ELBOW);
		this.setPath(this.getClass().getCanonicalName());
	}



	@Override
	public boolean toTest() throws Exception {
		
		return (this.getHandPos().getX() < this.getReferencePos().getX());
	}
	
	

	
	

}
