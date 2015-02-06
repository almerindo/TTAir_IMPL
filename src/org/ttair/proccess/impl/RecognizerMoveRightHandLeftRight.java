package org.ttair.proccess.impl;

import org.ttair.proccess.architecture.ARecognizerKinectHandPoint;

import com.primesense.nite.JointType;

public class RecognizerMoveRightHandLeftRight extends ARecognizerKinectHandPoint{

	
	private static final long serialVersionUID = -5429011082496130826L;



	public RecognizerMoveRightHandLeftRight() {
		this.setJointType(JointType.RIGHT_HAND);
		this.setJointTypeReference(JointType.RIGHT_ELBOW);
		this.setPath(this.getClass().getCanonicalName());
	}



	@Override
	public boolean toTest() throws Exception {
		
		return (this.getHandPos().getX() >= this.getReferencePos().getX());
	}
	
	

	
	

}
