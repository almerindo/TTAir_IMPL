package org.ttair.app;

import javax.swing.JFrame;

import org.ttair.presentation.LayerSkeletonBone;
import org.ttair.presentation.architecture.ALayer;
import org.ttair.presentation.architecture.EBone;
import org.ttair.presentation.architecture.ELayers;
import org.ttair.presentation.architecture.LayerManager;


public class TTAirAppCarmine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//JLayeredPane lp = new JLayeredPane();
		/*
		ALayer layer =  LayerManager.createLayer(ELayers.TTAIR_USER_EFECT_COLOR);
		layer.setName("User");
		layer.setVisible(true);
		*/
		
		/*ALayer layer =  LayerManager.createLayer(ELayers.TTAIR_DEPTH);
		layer.setName("DEPTH");
		layer.setVisible(true);*/

		ALayer layer2 =  LayerManager.createLayer(ELayers.TTAIR_IR);
		layer2.setName("DEPTH");
		layer2.setVisible(true);
		/*
		LayerSkeletonBone layer = (LayerSkeletonBone) LayerManager.createLayer(ELayers.TTAIR_SKELETON);;
		layer.setVisible(true);
		layer.setVisibleBoneByID(EBone.LEFT_FOREARM);
		layer.setVisibleBoneByID(EBone.LEFT_ARM);
		layer.setVisibleBoneByID(EBone.LEFT_CLAVICLE);
		layer.setVisibleBoneByID(EBone.LEFT_FEMORAL);
		layer.setVisibleBoneByID(EBone.LEFT_RIBS);
		layer.setVisibleBoneByID(EBone.LEFT_SHIN);
		layer.setVisibleBoneByID(EBone.LEFT_WAIST);
		*/
		/*layer.setVisibleBoneByID(EBone.RIGHT_FOREARM);
		layer.setVisibleBoneByID(EBone.RIGHT_ARM);
		layer.setVisibleBoneByID(EBone.RIGHT_CLAVICLE);
		layer.setVisibleBoneByID(EBone.RIGHT_FEMORAL);
		layer.setVisibleBoneByID(EBone.RIGHT_RIBS);
		layer.setVisibleBoneByID(EBone.RIGHT_SHIN);
		layer.setVisibleBoneByID(EBone.RIGHT_WAIST);*/
		//layer.setVisibleBoneByID(EBone.RIGHT_FOREARM);
		//layer.setVisibleBoneByID(EBone.RIGHT_ARM);
		
		/*ALayer userDepth =   LayerManager.createLayer(ELayers.TTAIR_USER_DEPTH);
		userDepth.setVisible(true);
		
		ALayer userUnicolor =   LayerManager.createLayer(ELayers.TTAIR_USER_UNICOLOR);
		userUnicolor.setVisible(true);
		
		ALayer userRGB =  LayerManager.createLayer(ELayers.TTAIR_USER_RGB);
		userRGB.setVisible(true);		
		*/
		
		//LayerSkeletonBone skel = (LayerSkeletonBone)LayerManager.createLayer(ELayers.TTAIR_SKELETON);
		//skel.setVisibleBoneByID(EBone.ALL);
		
		//ALayer userUnicolor =   LayerManager.createLayer(ELayers.TTAIR_USER_UNICOLOR);
		//userUnicolor.setVisible(true);
	
		//lp.addLayer(userUnicolor);
		
		System.out.println(LayerManager.getQtdLayers());
		
		JFrame frameRGB = new  JFrame("RGB");	
		//frameRGB.add(layer);
		frameRGB.setBounds(0,0,300,240); 
		frameRGB.setVisible(true);
		frameRGB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JFrame frameDEPTH = new  JFrame("DEPTH");	
		frameDEPTH.add(layer2);
		frameDEPTH.setVisible(true);
		frameDEPTH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDEPTH.setBounds(300,0,300,240); 

		
		
		JFrame frameUserRGB = new  JFrame("USER RGB");	
		//frameUserRGB.add(userRGB);
		frameUserRGB.setVisible(true);
		frameUserRGB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameUserRGB.setBounds(600,0,300,240);
		
		
		JFrame frameUserDEPTH = new  JFrame("USER DEPTH");	
		//frameUserDEPTH.add(userDepth);
		frameUserDEPTH.setVisible(true);
		frameUserDEPTH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameUserDEPTH.setBounds(900,0,300,240);
		
		JFrame frameUserUNICOLOR = new  JFrame("USER UNICOLOR");	
		//frameUserUNICOLOR.add(userUnicolor);
		frameUserUNICOLOR.setVisible(true);
		frameUserUNICOLOR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameUserUNICOLOR.setBounds(1200,0,300,240);
		
		
		JFrame frameSkeleton = new  JFrame("SKELETON");	
		//frameSkeleton.add(skel);
		frameSkeleton.setVisible(true);
		frameSkeleton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSkeleton.setBounds(1500,0,300,240);
		
		try {
			Thread.sleep(3000);
			//lp.moveToFront(layer);
			Thread.sleep(3000);
			//lp.moveToFront(depth);
			Thread.sleep(3000);
			//lp.moveToFront(rgb);
			//lp.nextLayer();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//lImg.setImage("./images/TTAirHouse_C3_VENTILADOR.png");
		
		
		//NiTE.shutdown();

	}

}
