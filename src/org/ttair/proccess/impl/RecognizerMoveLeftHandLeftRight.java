package org.ttair.proccess.impl;

import org.ttair.proccess.architecture.ARecognizerKinectHandPoint;

import com.primesense.nite.JointType;

public class RecognizerMoveLeftHandLeftRight extends ARecognizerKinectHandPoint{




	/**
	 * 
	 */
	private static final long serialVersionUID = -1256276016644723208L;



	public RecognizerMoveLeftHandLeftRight() {
		this.setJointType(JointType.LEFT_HAND);
		this.setJointTypeReference(JointType.LEFT_ELBOW);
		this.setPath(this.getClass().getCanonicalName());
	}



	@Override
	public boolean toTest() throws Exception {
		
		return (this.getHandPos().getX() >= this.getReferencePos().getX());
	}
	
	

	
	

}
