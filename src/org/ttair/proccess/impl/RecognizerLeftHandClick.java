package org.ttair.proccess.impl;

import javax.vecmath.Point3d;

import org.ttair.proccess.architecture.ARecognizerKinectHandPoint;

import com.primesense.nite.JointType;

public class RecognizerLeftHandClick extends ARecognizerKinectHandPoint{


	private static final long serialVersionUID = -4219132837276910607L;

	public RecognizerLeftHandClick() {
		this.setJointType(JointType.LEFT_HAND);
		this.setJointTypeReference(JointType.LEFT_ELBOW);
		this.setJointTypeReference2(JointType.LEFT_SHOULDER);
		
		this.setPath(this.getClass().getCanonicalName());
	}



	@Override
	public boolean toTest() throws Exception { //Se a mão subir mais que o cotovelo
		Point3d phand3d = new Point3d();
		phand3d.set(this.getHandJoint().getPosition().getX(),
				this.getHandJoint().getPosition().getY(),
				this.getHandJoint().getPosition().getZ());
		Point3d pelbow3d = new Point3d();
		pelbow3d.set(this.getReferenceJoint().getPosition().getX(), 
				this.getReferenceJoint().getPosition().getY(),
				this.getReferenceJoint().getPosition().getZ());
		
		Point3d pshoulder3d = new Point3d();
		pshoulder3d.set(this.getReferenceJoint2().getPosition().getX(), 
				this.getReferenceJoint2().getPosition().getY(),
				this.getReferenceJoint2().getPosition().getZ());
		
		double d1 = phand3d.distance(pelbow3d); //Distancia da mão até o cotovelo
		double d2 = phand3d.distance(pshoulder3d); //Distancia da mao até ombro
		double d3 = d1*2; //Braco esticado
		double dlimite = d3 - (d3*20)/100; //limite 80% do braço esticado
		
		return (d2>=dlimite); // Se passar 80% do braço esticado.
	}
	


	
	

}
