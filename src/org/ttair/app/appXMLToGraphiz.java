package org.ttair.app;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.ttair.util.TTAirXmlToGraphviz;

public class appXMLToGraphiz {

	public static void main(String[] args){

		TTAirXmlToGraphviz xml2g = new TTAirXmlToGraphviz();
		try {

			//Image img = xml2g.shortViewBCImgByXMLFile("./conf/BehaviorConf.xml"); 
			
			Image img = xml2g.fullViewImgByXMLFile("./conf/BehaviorTTAirHouse.xml");
			//Image img = xml2g.shortViewBCImgByXMLFile("./BehaviorConf05.xml");
			ImageIcon icon=new ImageIcon(img);
			JFrame frame=new JFrame();
			frame.setLayout(new FlowLayout());
			frame.setSize(icon.getIconWidth()+20,icon.getIconHeight()+50);
			JLabel lbl=new JLabel();
			lbl.setIcon(icon);
			frame.add(lbl);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
