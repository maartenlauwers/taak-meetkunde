import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Lost het 'kortste punten paar' probleem op met het naïeve algoritme O(N²).
 * 
 * @author Maarten lauwers
 *
 */
public class Algoritme1 {

	private List<Point> pointList;
	
	private Point p1;
	private Point p2;
	private double delta; 
	private long startTime;
	private long endTime;
	
	public Algoritme1(List<Point> points) {
		this.pointList = points;
		this.p1 = null;
		this.p2 = null;
		this.delta = 1000000;
	}
	
	public void berekenKortstePuntenPaar() {

		startTime = System.currentTimeMillis();

		delta = 1000000;
		for(int i=0; i<pointList.size(); i++) {
			for(int j=i+1; j<pointList.size();j++) {
				double d = berekenAfstand((Point)pointList.get(i), (Point)pointList.get(j));
				if(d < delta) {
					delta = d;
					p1 = (Point)pointList.get(i);
					p2 = (Point)pointList.get(j);
				}
			}
		}			
		
		endTime = System.currentTimeMillis();
	}
	
	public long getTimePassed() {
		long timePassed = endTime - startTime;
		return timePassed;
		//System.out.println("Algoritme 1: Time passed: " + timePassed + " (" + pointList.size() + " points)");
	}
	
	public void printKPP() {
		System.out.println("Punt 1: " + p1.getX() + ", " + p1.getY());
		System.out.println("Punt 2: " + p2.getX() + ", " + p2.getY());
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
}
