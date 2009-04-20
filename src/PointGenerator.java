import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointGenerator {

	private List<Point> pointList;
	private Random random;
	private int amount;
	private int maxX;
	private int maxY;
	
	public PointGenerator() {
		
	}
	
	public void randomPoints(int amount, int maxX, int maxY) {
		random = new Random();
		pointList = new ArrayList<Point>();
		
		for(int i=0; i<amount; i++) {
			int x = random.nextInt(maxX);
			int y = random.nextInt(maxY);
			
			pointList.add(new Point(x, y));							
		}
	}
	
	public void sameXPoints(int amount, int x, int maxY) {
		random = new Random();
		pointList = new ArrayList<Point>();
		
		for(int i=0; i<amount; i++) {			
			int y = random.nextInt(maxY);
			
			pointList.add(new Point(x, y));							
		}
	}
	
	public void sameYPoints(int amount, int maxX, int y) {
		random = new Random();
		pointList = new ArrayList<Point>();
		
		for(int i=0; i<amount; i++) {			
			int x = random.nextInt(maxX);
			
			pointList.add(new Point(x, y));							
		}
	}
	
	public void NWDiagonal(int amount, int maxX, int maxY) {
		int distance = maxX/amount;
		
		random = new Random();
		pointList = new ArrayList<Point>();
		
		pointList.add(new Point(1, 1));
		
		int oldX = 1;
		int oldY = 1;
		
		for(int i=1; i<amount; i++) {			
			int x = oldX + distance;
			int y = oldY + distance;
			
			oldX = x;
			oldY = y;
			
			pointList.add(new Point(x, y));							
		}
	}
	
	public void NEDiagonal(int amount, int maxX, int maxY) {
		int distance = maxX/amount;
		
		random = new Random();
		pointList = new ArrayList<Point>();
		
		pointList.add(new Point(1, maxY));
		
		int oldX = 1;
		int oldY = maxY;
		
		for(int i=1; i<amount; i++) {			
			int x = oldX + distance;
			int y = oldY - distance;
			
			oldX = x;
			oldY = y;
			
			pointList.add(new Point(x, y));							
		}
	}
	
	public void rectangle(int maxX, int maxY, int amountWidth, int amountHeight) {	
		
		random = new Random();
		pointList = new ArrayList<Point>();
		
		int distanceX = maxX/amountWidth;
		int distanceY = maxY/amountHeight;
		
		for(int i=0; i<amountWidth; i++) {
			for(int j=0; j<amountHeight; j++) {
				pointList.add(new Point(i*distanceX, j*distanceY));
			}
		}		
	}	
	
	public List<Point> getPointList() {
		List<Point> newList = new ArrayList<Point>();
		for(Point p : pointList) {
			newList.add(p);
		}
		return newList;
	}

	public void printPointList() {
		for(Point p : pointList) {
			System.out.println("X: " + p.getX() + ", Y: " + p.getY());
		}
	}
	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

}
