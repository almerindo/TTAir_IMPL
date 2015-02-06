package org.ttair.proccess.impl;

import org.ttair.proccess.architecture.ARecognizerKinectHandPoint;

import com.primesense.nite.JointType;

public class RecognizerMoveLeftHandRightLeft extends ARecognizerKinectHandPoint{


	private static final long serialVersionUID = -5282465685440764L;



	public RecognizerMoveLeftHandRightLeft() {
		this.setJointType(JointType.LEFT_HAND);
		this.setJointTypeReference(JointType.LEFT_ELBOW);
		this.setPath(this.getClass().getCanonicalName());
	}



	@Override
	public boolean toTest() throws Exception {
		
		return (this.getHandPos().getX() < this.getReferencePos().getX());
	}
	
	

	
	

}
