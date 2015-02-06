package org.ttair.proccess.impl;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Random;

import org.ttair.TTAirEvent;
import org.ttair.proccess.architecture.ANodeRecognizer;

public class RecognizerMousePositionIMPL extends ANodeRecognizer{
	
	private static final long serialVersionUID = 2409174055459002250L;
	private TTAirEvent evt = null;
	Point p = null;
	private Random r = new Random(10L);

	
	private static final int LEFT = -10;
	private static final int RIGHT = 10;
	private static final int MIDDLE = 0;
	private static final int UP = 100;
	private static final int DOWN = -100;
	private static final int LEFT_UP = 90;
	private static final int LEFT_DOWN = -110;
	private static final int RIGHT_UP = 110;
	private static final int RIGHT_DOWN = -90;
	
	//#############################################	
	//######  90  ####  100 ####  110  ############
	//###### -10  ####   0  ####  10   ############
	//###### -110 #### -100 #### -90  #############
	//#############################################
	
	public static final String[] EventCod= {"EVTMousePositionScreenLEFT", //0
											"EVTMousePositionScreenRIGHT", //1
											"EVTMousePositionScreenUP",//2
											"EVTMousePositionScreenDOWN",//3
											"EVTMousePositionScreenLEFT_UP",//4
											"EVTMousePositionScreenLEFT_DOWN",//5
											"EVTMousePositionScreenRIGHT_UP",//6
											"EVTMousePositionScreenRIGHT_DOWN",//7
											"EVTMousePositionScreenMIDDLE"};//8
	



	private static final DisplayMode dm = getResolution();

	
	private Point getPosition(){
		return MouseInfo.getPointerInfo().getLocation();
	}
	
	private int testPos() {
		Point p = this.getPosition();
		if (this.isLog()){
			//LoggerManager.log(Level.INFO, "Coordenadas do Mouse: " + p.getX() + " - " + p.getY());
		}
		return testPosW(p, dm) + testPosH(p, dm);
	}
	
	private int testPosW(Point p, DisplayMode dm){
		
		int w = dm.getWidth();
		
		double meioW = (w / 2);
		
		if (p.getX() == meioW)  {
			return  RecognizerMousePositionIMPL.MIDDLE;
		}else if (p.getX() < meioW){
			return RecognizerMousePositionIMPL.LEFT;
		}else {
			return  RecognizerMousePositionIMPL.RIGHT;
		}
		
	}
	
	private int testPosH(Point p, DisplayMode dm){
		int h = dm.getHeight();
		
		double meioH = (h / 2);
	
		if (p.getY() == meioH)  {
			return  RecognizerMousePositionIMPL.MIDDLE;
		}else if (p.getY() > meioH){
			return RecognizerMousePositionIMPL.DOWN;
		}else {
			return  RecognizerMousePositionIMPL.UP;
		}

		
	}
	
	
	private static DisplayMode getResolution(){
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		return gd.getDisplayMode();
	}
	
	@Override
	public  TTAirEvent toExecute() {
		try {
			Thread.sleep(r.nextInt(10));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (evt==null) {
			evt = new TTAirEvent(this);
			synchronized (evt) {
				try {
					
					
					switch (this.testPos()) {
					case RecognizerMousePositionIMPL.LEFT:
						evt.setCOD(RecognizerMousePositionIMPL.EventCod[0]);
						evt.setParam(RecognizerMousePositionIMPL.EventCod[0]);
						break;
					case RecognizerMousePositionIMPL.RIGHT:
						evt.setCOD(RecognizerMousePositionIMPL.EventCod[1]);
						evt.setParam(RecognizerMousePositionIMPL.EventCod[1]);
						break;
					case RecognizerMousePositionIMPL.UP:
						evt.setCOD(RecognizerMousePositionIMPL.EventCod[2]);
						evt.setParam(RecognizerMousePositionIMPL.EventCod[2]);
						break;
					case RecognizerMousePositionIMPL.DOWN:
						evt.setCOD(RecognizerMousePositionIMPL.EventCod[3]);
						evt.setParam(RecognizerMousePositionIMPL.EventCod[3]);
						break;
					case RecognizerMousePositionIMPL.LEFT_UP:
						evt.setCOD(RecognizerMousePositionIMPL.EventCod[4]);
						evt.setParam(RecognizerMousePositionIMPL.EventCod[4]);
						break;
					case RecognizerMousePositionIMPL.LEFT_DOWN:
						evt.setCOD(RecognizerMousePositionIMPL.EventCod[5]);
						evt.setParam(RecognizerMousePositionIMPL.EventCod[5]);
						break;
					case RecognizerMousePositionIMPL.RIGHT_UP:
						evt.setCOD(RecognizerMousePositionIMPL.EventCod[6]);
						evt.setParam(RecognizerMousePositionIMPL.EventCod[6]);
						break;
					case RecognizerMousePositionIMPL.RIGHT_DOWN:
						evt.setCOD(RecognizerMousePositionIMPL.EventCod[7]);
						evt.setParam(RecognizerMousePositionIMPL.EventCod[7]);
						break;
					default:
						evt = null;
						break;
					}
					
					
					
				} catch (Exception e) {
					
					return null;
				}
			}
			
		}else {
			
			evt = null;
		}
		return evt;
	}

}
