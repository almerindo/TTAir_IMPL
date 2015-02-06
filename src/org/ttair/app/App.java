package org.ttair.app;

import org.ttair.app.ui.TTAirFrameLoad;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TTAirFrameLoad frame = new TTAirFrameLoad();
		//Behavior bh = frame.getBehavior();
		//bh.setLog(true);
		

		frame.setVisible(true);
		try {
		//		bh.start();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
