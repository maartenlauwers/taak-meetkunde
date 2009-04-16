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
	
	public PointGenerator(int amount, int maxX, int maxY) {
		random = new Random();
		pointList = new ArrayList<Point>();
		
		for(int i=0; i<amount; i++) {
			int x = random.nextInt(maxX);
			int y = random.nextInt(maxY);
			
			pointList.add(new Point(x, y));		
			
			System.out.println("Punt " + i + ":" + x + ", " + y);
		}
	}
	
	public List<Point> getPointList() {
		List<Point> newList = new ArrayList<Point>();
		for(Point p : pointList) {
			newList.add(p);
		}
		return newList;
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
