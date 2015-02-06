package org.ttair.app;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import org.ttair.behavior.architecture.Behavior;
import org.ttair.presentation.LayerSkeletonBone;
import org.ttair.presentation.architecture.ALayer;
import org.ttair.presentation.architecture.EBone;
import org.ttair.presentation.architecture.ELayers;
import org.ttair.presentation.architecture.LayerManager;

import com.primesense.nite.NiTE;




public class appTTAirFromXML {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			


		String pathFile = "./conf/BehaviorConf10.xml";
		//String pathFile = "./conf/BehaviorConf07.xml";

		final Behavior bh = new Behavior(pathFile);
		try{
		if (bh.firstBehaviorChain()){
			//bh.setLog(true);
			bh.start();
			
			bh.nextBehaviorChain();
			bh.start();
			//bh.backBehaviorChain();
			//bh.start();
			//bh.stop();
		}else{
			System.out.println("Não foi possível ir para a primeira BC");
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
			
		//ALayer layer  =  LayerManager.createLayer(ELayers.USER);
		ALayer layer2  =  LayerManager.createLayer(ELayers.TTAIR_SKELETON);
		LayerSkeletonBone ske = (LayerSkeletonBone) layer2;
		ske.setVisible(true);
		ske.setVisibleBoneByID(EBone.ALL);
		//ske.setVisibleBoneByID(EBone.LEFT_FOREARM);
		//ALayer layer  =  LayerManager.createLayer( ELayers.DEPTH);
		
		final JFrame frame = new  JFrame("Teste");
		
		//LayerSkeleton skl = (LayerSkeleton) layer;
		
		frame.add(layer2);
		frame.setSize(640,480);
		frame.setVisible(true);
		
		//Quando o JFrame for fechado, liberar os recursos
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowListener() {
			
           	@Override
			public void windowOpened(WindowEvent e) {
								
			}

			@Override
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
                frame.dispose();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				try {
					bh.shutdow();
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally {
					NiTE.shutdown();
					System.exit(0);
				}
			}

			@Override
			public void windowIconified(WindowEvent e) {
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}
        });
		
		
		try {
			//Thread.sleep(10000);
		

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
