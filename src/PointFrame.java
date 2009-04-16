import javax.swing.*;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class PointFrame implements ActionListener {

	private JFrame frame;		
	private PointPanel pointPanel;
	private JButton btnSluiten;
	private JButton btnReset;
	private JButton btnAlgoritme1;
	private JButton btnAlgoritme2;
	
	private PointGenerator pointGenerator;
	private Algoritme1 algoritme1;
	private Algoritme2 algoritme2;
	
	
	public PointFrame() {		
		
		String title = "Maarten Lauwers - Schakeljaar Master in de Toegepaste Informatica - Taak meetkunde deel 2";
		
	    frame = new JFrame(title);
	    
	    frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	    
	    pointGenerator = new PointGenerator(10, 640, 400);
		algoritme1 = new Algoritme1(pointGenerator.getPointList());
		algoritme2 = new Algoritme2(pointGenerator.getPointList());
		
		
		 // Create the menu bar
		/*
	    JMenuBar menuBar = new JMenuBar();
	    
	    // Create the menus
	    // File menu
	    JMenu file = new JMenu("Bestand");
	    menuBar.add(file);
	    JMenuItem logout = new JMenuItem("Logout");
	    JMenuItem close = new JMenuItem("Sluiten");
	    logout.addActionListener(this);
	    close.addActionListener(this);
	    file.add(logout);
	    file.add(close);
	    */
		
	    JPanel menuPanel = new JPanel();
	    
	    btnSluiten = new JButton("Sluiten");
	    btnSluiten.addActionListener(this);
	    menuPanel.add(btnSluiten);
	    
	    btnReset = new JButton("Reset");
	    btnReset.addActionListener(this);
	    menuPanel.add(btnReset);
	    
	    btnAlgoritme1 = new JButton("O(N²)");
	    btnAlgoritme1.addActionListener(this);
	    menuPanel.add(btnAlgoritme1);
	    
	    btnAlgoritme2 = new JButton("Doorlooplijnalgoritme (variant 2)");
	    btnAlgoritme2.addActionListener(this);
	    menuPanel.add(btnAlgoritme2);
	    	    
	    frame.getContentPane().add("North", menuPanel);
	    	   	    	   
	    pointPanel = new PointPanel(pointGenerator.getPointList(), 640, 400);
        frame.getContentPane().add("Center", pointPanel);               
        
        frame.pack();
        frame.setSize(new Dimension(640,480));
        frame.setVisible(true);

	    
	}		 	 

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnSluiten)) {
			System.exit(0);
		} 
		
		if(e.getSource().equals(btnReset)) {
			pointGenerator = new PointGenerator(20, pointPanel.getWidth() - 5, pointPanel.getHeight() - 5);
			algoritme1 = new Algoritme1(pointGenerator.getPointList());			
			algoritme2 = new Algoritme2(pointGenerator.getPointList());
			pointPanel.setPointList(pointGenerator.getPointList());
		}
		
		if(e.getSource().equals(btnAlgoritme1)) {
			algoritme1.berekenKortstePuntenPaar();		
			List<Point> list = algoritme1.getKortstePuntenPaar();	
			System.out.println("List inspection a1");
			for(Point p : list) {
				System.out.println("Punt x: " + p.getX() + ", y: " + p.getY());
			}
			pointPanel.showKortstePuntenPaar(list);
		}
		
		if(e.getSource().equals(btnAlgoritme2)) {
			System.out.println("List inspection a2");
			System.out.println("Point list size: " + pointPanel.getPointListSize());
			algoritme2.berekenKortstePuntenPaar();
			List<Point> list = algoritme2.getKortstePuntenPaar();			
		
			
			for(Point p : list) {
				System.out.println("Punt x: " + p.getX() + ", y: " + p.getY());
			}
			System.out.println("Point list size: " + pointPanel.getPointListSize());
			pointPanel.showKortstePuntenPaar(list);
		}
	}
	
}