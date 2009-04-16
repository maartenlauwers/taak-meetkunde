import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Lost het 'kortste punten paar' probleem op met de tweede variant van het doorlooplijnalgoritme.
 * 
 * @author Maarten lauwers
 *
 */
public class Algoritme2 {

	private List<Point> pointList;
	
	private Point p1;
	private Point p2;
	private double delta; 
	
	public Algoritme2(List<Point> points) {
		this.pointList = points;
		this.p1 = null;
		this.p2 = null;
		this.delta = 1000000;
	}
	
	public void berekenKortstePuntenPaar() {
		long startTime = System.currentTimeMillis();
		System.out.println("Start time: " + startTime);
		
		// Sorteer de punten naar stijgende X-coördinaat
		List<Point> sortedPointList = new ArrayList<Point>();
		sortedPointList = sortPoints(pointList);
		
		int j = 0;
		Point p = null;
		Point q = null;
		delta = 1000000;
		for(int i=1; i<sortedPointList.size(); i++) {
			p = sortedPointList.get(i);
			j = i - 1;
			while (j > 0 && ((Point)sortedPointList.get(j)).getX() > (p.getX() - delta)) {
				q = (Point)sortedPointList.get(j);
				
				if(q.getY() < (p.getY() + delta) && q.getY() > (p.getY() - delta)) {
					double d = berekenAfstand(p, q);
					
					if(d < delta) {
						delta = d;
						p1 = p;
						p2 = q;
					}
				}
				
				j = j - 1;
			}
		}			

		
		long endTime = System.currentTimeMillis();
		System.out.println("End time: " + endTime);
		long timePassed = endTime - startTime;
		System.out.println("Time: " + timePassed);
		
		System.out.println("Delta: " + delta);
		System.out.println("Punt 1: " + p1.getX() + ", " + p1.getY());
		System.out.println("Punt 2: " + p2.getX() + ", " + p2.getY());
		
		pointList = sortedPointList;
	}
	
	public List<Point> getKortstePuntenPaar() {
		List<Point> list = new ArrayList<Point>();
		list.add(p1);
		list.add(p2);
		return list;
	}
	
	public double berekenAfstand(Point p1, Point p2) {
		double x_square = (p1.getX() - p2.getX()) * (p1.getX() - p2.getX());
		double y_square = (p1.getY() - p2.getY()) * (p1.getY() - p2.getY());
		
		return Math.sqrt(x_square + y_square);
	}
	
	public List<Point> sortPoints(List<Point> list) {
		
		List<Point> newList = new ArrayList<Point>();
		
		while(list.size() > 0) {
			Point smallestPoint = getSmallestXPoint(list);
			list.remove(smallestPoint);
			newList.add(smallestPoint);	
		}
		
		return newList;
	}
	
	public Point getSmallestXPoint(List<Point> list) {
		double x = 1000000;
		Point smallestPoint = null;
		
		for(Point p : list) {
			if (p.getX() < x) {
				x = p.getX();
				smallestPoint = p;
			}
		}
		
		return smallestPoint;
	}
}
