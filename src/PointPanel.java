import javax.swing.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class PointPanel extends JPanel {	
	
	private List<Point> pointList;
	private List<Point> kortstePuntenPaar;	
	
	public PointPanel(List<Point> pointList, int width, int height) {
		super.setLayout(null);
		super.setBounds(0, 0, width, height);
			
		this.kortstePuntenPaar = new ArrayList<Point>();
		this.pointList = pointList;
	}
	
	public void setPointList(List<Point> newPointList) {		
		this.pointList = new ArrayList<Point>();
		for(Point p : newPointList) {
			this.pointList.add(p);
		}		
		paintComponent(super.getGraphics());
	}
	
	public int getPointListSize() {
		return pointList.size();
	}
	
	public void showKortstePuntenPaar(List<Point> list) {
		this.kortstePuntenPaar = list;		
		paintComponent(super.getGraphics());
	}
	
	public void paintComponent(Graphics g) {
		clear(g);
		Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);	    

	    g.setColor(Color.white);
	    g.fillRect(0, 0, getWidth(), getHeight());	    	   	    
	    for(Point p : pointList) {
	    
	    	g2.setColor(Color.RED);
	        for(Point kortstePunt : kortstePuntenPaar) {
	        	if (p.equals(kortstePunt)) {	        		
	        		g2.setColor(Color.GREEN);	        		
	        	}
	        }	        	
	        	
	        g2.fillOval((int)p.getX(), (int)p.getY(), 4, 4);
	    }                   	        
	}
	
	protected void clear(Graphics g) {
	    super.paintComponent(g);	    
	}

	
}
