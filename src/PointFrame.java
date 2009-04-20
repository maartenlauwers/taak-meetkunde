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

	    
	    pointGenerator = new PointGenerator();
	    //pointGenerator.sameXPoints(200, 80, 500);
	    //pointGenerator.sameYPoints(200, 500, 50);
	    //pointGenerator.NWDiagonal(200, 500, 500);
	    //pointGenerator.NEDiagonal(200, 500, 500);
	    //pointGenerator.rectangle(500, 500, 20, 20);	    
		algoritme1 = new Algoritme1(pointGenerator.getPointList());
		algoritme2 = new Algoritme2(pointGenerator.getPointList());
		
		
		
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
	    	   	    	   
	    pointPanel = new PointPanel(pointGenerator.getPointList(), 800, 540);
        frame.getContentPane().add("Center", pointPanel);               
        
        frame.pack();
        frame.setSize(new Dimension(800,600));
        frame.setVisible(true);

	    
	}		 	 

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnSluiten)) {
			System.exit(0);
		} 
		
		if(e.getSource().equals(btnReset)) {
			pointGenerator = new PointGenerator();
			algoritme1 = new Algoritme1(pointGenerator.getPointList());			
			algoritme2 = new Algoritme2(pointGenerator.getPointList());
			pointPanel.setPointList(pointGenerator.getPointList());
		}
		
		if(e.getSource().equals(btnAlgoritme1)) {
			algoritme1.berekenKortstePuntenPaar();		
			List<Point> list = algoritme1.getKortstePuntenPaar();				

			pointPanel.showKortstePuntenPaar(list);
		}
		
		if(e.getSource().equals(btnAlgoritme2)) {			
			algoritme2.berekenKortstePuntenPaar();
			List<Point> list = algoritme2.getKortstePuntenPaar();			
		
			pointPanel.showKortstePuntenPaar(list);
		}
	}
	
}