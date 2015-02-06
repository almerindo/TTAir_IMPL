package org.ttair.proccess.impl;


import org.ttair.proccess.architecture.ARecognizerKinectHandPoint;

import com.primesense.nite.JointType;

public class RecognizerRightHandDown extends ARecognizerKinectHandPoint{


	private static final long serialVersionUID = -2440599851284724711L;

	public RecognizerRightHandDown() {
		this.setJointType(JointType.RIGHT_HAND);
		this.setJointTypeReference(JointType.NECK);
		this.setPath(this.getClass().getCanonicalName());
	}

	@Override
	public boolean toTest() throws Exception {
		return (this.getHandPos().getY() > this.getReferencePos().getY());
	}
	

	
	

}
