package pegPuz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PegPuzBoardApp implements ActionListener{
	PegPuzGameModel model;
	PegPuzBoardViewer view;
	PegPuzBoardController ctrl;
	
	JButton ng;
	
	public PegPuzBoardApp() {
		model = new PegPuzGameModel();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createAndShowGUI(); 
			}
		});
	}
		
	public static void createAndShowGUI(){
		JFrame frame = new JFrame("PegPuz App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cont = frame.getContentPane();
		PegPuzBoardApp app = new PegPuzBoardApp();
		app.buildGUI(cont);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void buildGUI(Container cont){
		view = new PegPuzBoardViewer(model);
		ctrl = new PegPuzBoardController(model, view);
		view.addMouseListener(ctrl);
		view.buildGUI();
		
		cont.add(view, BorderLayout.CENTER);
		
		ng = new JButton("New Game");
		ng.addActionListener(this);
		cont.add(ng, BorderLayout.SOUTH);
		
		view.updateGUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ng)
			ctrl.newGameClicked();
			
	}
}
