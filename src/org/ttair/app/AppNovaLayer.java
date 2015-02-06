package org.ttair.app;

import javax.swing.JFrame;


import org.ttair.presentation.architecture.ALayer;
import org.ttair.presentation.architecture.ELayers;
import org.ttair.presentation.architecture.LayerManager;


public class AppNovaLayer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	        
		JFrame frame = new  JFrame("Teste");
		
		
		ALayer layer =  LayerManager.createLayer(ELayers.TTAIR_USER_RGB);
		layer.setLabel("TTAir RGB");
		layer.setVisible(true);
		/*
		ALayer layer2 =  LayerManager.createLayer(ELayers.TTAIRUSER);
		layer2.setLabel("TTAir Depth");
		layer2.setVisible(true);
	*/
		/*ALayer layer3 = LayerManager.createLayer(ELayers.TTAIRIR);
		layer3.setLabel("TTAir Infra Red");
		layer3.setVisible(true);
		 */
		
		
		
		
		
		frame.add(layer);
		frame.setSize(800,600);
		frame.setVisible(true);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
		
		System.out.println("Close Devices");
		//DeviceManager.closeDevices();
		

	}

}
