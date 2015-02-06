package org.ttair.app.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import org.ttair.behavior.architecture.Behavior;

public class TTAirFrameLoad extends JFrame{
	private static final long serialVersionUID = 6045110376866753908L;
	private JTextArea jtaXMLEditor = new JTextArea();
	private JFileChooser fileChooser = new JFileChooser();
	private JToolBar toolBar = new JToolBar();

	
	private File dir = new File("./");
	
	private String newPathFile = "./BehaviorConf05.xml";
	private String pathFile = null;
	
	private Behavior bh = null;
	
	
	public TTAirFrameLoad(){
		this.initialize();
	}
	
	public Behavior getBehavior(){
		return this.bh;
	}
	private void initialize() {
		this.fileChooser.setCurrentDirectory (dir);
		
		TTAirExtensionFileFilter fileFilter = new TTAirExtensionFileFilter("TTAirXML ", new String[] { "XML"});
	    this.fileChooser.setFileFilter(fileFilter);

		this.setBounds(0, 0, 300, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
				
		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = fileChooser.showOpenDialog(null);
			    if (returnVal == JFileChooser.APPROVE_OPTION) {
			        File file = fileChooser.getSelectedFile();
			        newPathFile = file.getAbsolutePath();
			        System.out.println(newPathFile);
			        try {
			          // What to do with the file, e.g. display it in a TextArea
			        	Reader r = new FileReader(file.getAbsoluteFile());
			        	jtaXMLEditor.read(r, "");
			        	//jtaXMLEditor.read( new FileReader( file.getAbsolutePath() ), null );
			        } catch (IOException ex) {
			          System.out.println("problem accessing file"+file.getAbsolutePath());
			        }
			    } else {
			        System.out.println("File access cancelled by user.");
			    }
				
			}
		});
		mnFile.add(mntmLoad);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnTTAir = new JMenu("TTAir");
		menuBar.add(mnTTAir);

		JMenuItem mntmRUN = new JMenuItem("RUN");
		mntmRUN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pathFile == null && newPathFile!=null){
					pathFile = newPathFile;
					bh = new Behavior(pathFile);
				}
				
				if (!newPathFile.equals(pathFile)) {
					if (bh!=null) {
						try {
							bh.shutdow();
						} catch (Exception e1) {
							System.out.println("Problema ao parar o Behavior");
						}
						pathFile = newPathFile;
					}
					bh = new Behavior(pathFile);
					
				}
				
				try {
					if (bh!=null) {
						bh.start();
						bh.setLog(true);
					}
				} catch (Exception e1) {
					//e1.printStackTrace();
				}

			}
		});
		mnTTAir.add(mntmRUN);

		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		
		JButton btFirst = new JButton("<< First");
		btFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (bh!=null){
						bh.firstBehaviorChain();
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		toolBar.add(btFirst);
		
		JButton btBack = new JButton("< Back ");
		btBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (bh!=null){
						bh.backBehaviorChain();
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		toolBar.add(btBack);
		
		JButton btNext = new JButton("Next >");
		btNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (bh!=null){
						bh.nextBehaviorChain();
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		toolBar.add(btNext);
		
		JButton btLast = new JButton("Last >>");
		btLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (bh!=null){
						bh.lastBehaviorChain();
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		toolBar.add(btLast);
		
		
		JButton btStart = new JButton("START");
		btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (bh!=null){
						bh.start();
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		toolBar.add(btStart);
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		jtaXMLEditor.setLineWrap(true);
		jtaXMLEditor.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(jtaXMLEditor);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		
	}

}
