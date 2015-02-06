package org.ttair.action.impl;

import org.ttair.action.architecture.ANodeAction;

public class ActionImpl extends ANodeAction{


	private static final long serialVersionUID = 2604903804543556100L;

	
	@Override
	public Object toExecute(Object param){
		System.out.println("Executar: " + this.getName() +" [ " + param +" ] ");
		return null;
	}



	

}
