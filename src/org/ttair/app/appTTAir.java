package org.ttair.app;

import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.ttair.TTAirEvent;
import org.ttair.action.ActionControl;
import org.ttair.action.architecture.ANodeAction;
import org.ttair.action.impl.ActionImpl;
import org.ttair.behavior.BehaviorChainControl;
import org.ttair.behavior.BehaviorFrameControl;
import org.ttair.behavior.ExpectancyControl;
import org.ttair.behavior.architecture.BehaviorChain;
import org.ttair.behavior.architecture.BehaviorFrame;
import org.ttair.behavior.architecture.Expectancy;
import org.ttair.proccess.RecognizerControl;
import org.ttair.proccess.architecture.ANodeRecognizer;
import org.ttair.proccess.impl.RecognizerFaceIMPL;
import org.ttair.proccess.impl.RecognizerHandInFrontIMPL;
import org.ttair.proccess.impl.RecognizerMousePositionIMPL;
import org.ttair.util.ParserTTAirToXML;
import org.ttair.util.TTAirXmlToGraphviz;

public class appTTAir {

	
	public static ANodeRecognizer createRecognizer(String cod, String label, String desc,  boolean log){

		ANodeRecognizer rec = null;
		switch (cod) {
		case "101": {
			try {
				rec = new RecognizerHandInFrontIMPL();


			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		break;
		case "102":{
			rec = new RecognizerFaceIMPL();
		}
		break;
		case "103":{
			rec = new RecognizerMousePositionIMPL();
		}
		break;

		default:

			break;
		}

		rec.setID(cod);
		rec.setName(label);
		rec.setDesc(desc);
		rec.setLog(log);

		return rec;
	}

	public static ANodeAction createAction(String ID, String label){
		ActionImpl act = new ActionImpl();	
		try {
			act.setName(label);
			act.setID(ID);
			act.setPath(act.getClass().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return act;
	}

	public static void main(String[] args) {
		boolean logar = true;

		RecognizerControl recControl = RecognizerControl.getINSTANCE();
		//recControl.setLog(logar);
		ActionControl actControl = ActionControl.getINSTANCE();



		//Reconhecedores
		ANodeRecognizer recognizer01 = appTTAir.createRecognizer("101", "Hands together in front","reconhece Maos à frente", logar);
		ANodeRecognizer recognizer02 = appTTAir.createRecognizer("102", "Face de Usuário", "reconhece face do usuário", logar);
		ANodeRecognizer recognizer03 = appTTAir.createRecognizer("103", "Mouse Position", "Reconhece Posicao do Mouse", logar);
		
		//Actions
		ANodeAction act01 = appTTAir.createAction("201", "ENVIAR IR POWER");
		ANodeAction act02= appTTAir.createAction("202", "SEND SIGN IR OK");
		ANodeAction act03 = appTTAir.createAction("203", "SEND SIGN IR CH+");
		ANodeAction act04 = appTTAir.createAction("204", "SEND SIGN IR CH-");

		try {
			actControl.add(act01);
			actControl.add(act02);
			actControl.add(act03);
			actControl.add(act04);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			//Barramento de Recognizers
			recControl.add(recognizer01);	
			recControl.add(recognizer02);
			recControl.add(recognizer03);
		} catch (Exception e) {
			e.printStackTrace();
		}



		//***************  Comportamento ***************//
		//Behavior chain
		BehaviorChain bc = new BehaviorChain();
		bc.setID("BC001");

		//Expectancy
		Expectancy e1 = new Expectancy();
		e1.setName("Exp01");
		e1.setID("Exp01");
		Expectancy e2 = new Expectancy();
		e2.setName("Exp02");
		e2.setID("Exp02");

		Expectancy e3 = new Expectancy();
		e3.setName("ExpFINAL");
		e3.setID("ExpFINAL");

		ExpectancyControl expControl = ExpectancyControl.getINSTANCE();
		try {
			expControl.add(e1);
			expControl.add(e2);
			expControl.add(e3);
		} catch (Exception e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		

		try {
			//Behavior Frame
			List<ANodeAction> listActionBF01 = new ArrayList<ANodeAction>();
			listActionBF01.add(act01);
			listActionBF01.add(act02);
			TTAirEvent evt = new TTAirEvent(recognizer01);
			evt.setID("EVTBF01");
			evt.setCOD(RecognizerHandInFrontIMPL.EventCod[0]);
			BehaviorFrame bf01 = new BehaviorFrame(evt,listActionBF01);
			bf01.setID("BF01");

			
			List<ANodeAction> listActionBF02 = new ArrayList<ANodeAction>();
			listActionBF02.add(act03);
			listActionBF02.add(act04);
			TTAirEvent evt2 = new TTAirEvent(recognizer02);
			evt2.setID("EVTBF02");
			evt2.setCOD(RecognizerFaceIMPL.EventCod[0]);
			BehaviorFrame bf02 = new BehaviorFrame(evt2,listActionBF02);
			bf02.setID("BF02");
			
			List<ANodeAction> listActionBF03 = new ArrayList<ANodeAction>();
			listActionBF03.add(act01);
			listActionBF03.add(act02);
			TTAirEvent evt3 = new TTAirEvent(recognizer03);
			evt3.setID("EVTBF03");
			evt3.setCOD(RecognizerMousePositionIMPL.EventCod[4]);
			BehaviorFrame bf03 = new BehaviorFrame(evt3,listActionBF03);
			bf03.setID("BF03");
			
			
			List<ANodeAction> listActionBF04 = new ArrayList<ANodeAction>();
			listActionBF04.add(act03);
			listActionBF04.add(act04);
			TTAirEvent evt4 = new TTAirEvent(recognizer03);
			evt4.setID("EVTBF04");
			evt4.setCOD(RecognizerMousePositionIMPL.EventCod[6]);
			BehaviorFrame bf04 = new BehaviorFrame(evt4,listActionBF04);
			bf04.setID("BF04");
			
			//
			BehaviorFrameControl bfControl = BehaviorFrameControl.getINSTANCE();
			bfControl.add(bf01);
			bfControl.add(bf02);
			bfControl.add(bf03);
			bfControl.add(bf04);
			
			//Nivel de Expectativa 01
			e1.addBehaviorFrame(bf01);
			//e1.assignBF_ExpectancyTarget(bf01, e2);
			//Nivel de Expectativa 02
			e2.addBehaviorFrame(bf02);
			//e2.assignBF_ExpectancyTarget(bf02, e3);
			
			e3.addBehaviorFrame(bf03);
			//e3.assignBF_ExpectancyTarget(bf03, e1);
			
			e3.addBehaviorFrame(bf04);
			//e3.assignBF_ExpectancyTarget(bf04, e2);
			
			

			System.out.println("FIM");
			bc.add(e1);
			bc.assignBF_ExpectancyTarget(e1, bf01, e2);
			bc.add(e2);
			bc.assignBF_ExpectancyTarget(e2, bf02, e3);
			bc.add(e3);
			bc.assignBF_ExpectancyTarget(e3, bf03, e1);
			bc.assignBF_ExpectancyTarget(e3, bf04, e2);
			
			
			
			BehaviorChainControl bcControl = BehaviorChainControl.getINSTANCE();
			bcControl.add(bc);
			
			ParserTTAirToXML parser = new ParserTTAirToXML();
			System.out.println(parser.getXML());
			
			
			TTAirXmlToGraphviz xml2g = new TTAirXmlToGraphviz();
			//Image img = xml2g.shortViewBCImgByXML(parser.getXML());
			//Image img = xml2g.shortViewBussImgByXML(parser.getXML());
			Image img = xml2g.fullViewImgByXML(parser.getXML());
			ImageIcon icon=new ImageIcon(img);
			JFrame frame=new JFrame();
			frame.setLayout(new FlowLayout());
			frame.setSize(icon.getIconWidth()+20,icon.getIconHeight()+50);
			JLabel lbl=new JLabel();
			lbl.setIcon(icon);
			frame.add(lbl);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			bcControl.setLog(logar);
			bcControl.first();//Seta a primeira...
			bcControl.init(true);			


			//while (true) {
			//	Thread.sleep(12);
			//}
/*			Thread.sleep(1000);
			bc.setStart(false);
			Thread.sleep(2000);
			System.out.println("FIM");*/

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//bc.setStart(false);
		}

	}
}
