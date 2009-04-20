
public class Tester {

	private PointGenerator pointGenerator;
	private Algoritme1 algoritme1;
	private Algoritme2 algoritme2;
	
	public Tester() {
		pointGenerator = new PointGenerator();
	}
	
	public void runRandomPointsTest() {
		System.out.println("");
		System.out.println("Algoritme 1");
		System.out.println("");
		
		for(int i=1; i<=100; i++) {
			pointGenerator.randomPoints(i*100, 1000, 1000);
			
			algoritme1 = new Algoritme1(pointGenerator.getPointList());
			algoritme1.berekenKortstePuntenPaar();
			System.out.println("Ms: " + algoritme1.getTimePassed());

		}
		
		System.out.println("");
		System.out.println("Algoritme 2");
		System.out.println("");
		
		for(int j=1; j<=100; j++) {
			pointGenerator.randomPoints(j*100, 1000, 1000);
			
			algoritme2 = new Algoritme2(pointGenerator.getPointList());
			algoritme2.berekenKortstePuntenPaar();
			System.out.println("Ms: " + algoritme2.getTimePassed());
		}
	}
	
	public void runSameXPointsTest() {
		// Run 100 tests
		
		System.out.println("");
		System.out.println("Algoritme 1");
		System.out.println("");
		
		for(int i=1; i<=100; i++) {			
			pointGenerator.sameXPoints(i*100, 50, 1000);
			
			algoritme1 = new Algoritme1(pointGenerator.getPointList());
			algoritme1.berekenKortstePuntenPaar();
			System.out.println("Ms: " + algoritme1.getTimePassed());

		}
		
		System.out.println("");
		System.out.println("Algoritme 2");
		System.out.println("");
		
		for(int j=1; j<=100; j++) {
			pointGenerator.sameXPoints(j*100, 50, 1000);			
			
			algoritme2 = new Algoritme2(pointGenerator.getPointList());
			algoritme2.berekenKortstePuntenPaar();
			System.out.println("Ms: " + algoritme2.getTimePassed());
		}
	}
	
	public void runSameYPointsTest() {
		// Run 100 tests
		
		System.out.println("");
		System.out.println("Algoritme 1");
		System.out.println("");
		
		for(int i=1; i<=100; i++) {			
			pointGenerator.sameYPoints(i*100, 50, 1000);
			
			algoritme1 = new Algoritme1(pointGenerator.getPointList());
			algoritme1.berekenKortstePuntenPaar();
			System.out.println("Ms: " + algoritme1.getTimePassed());

		}
		
		System.out.println("");
		System.out.println("Algoritme 2");
		System.out.println("");
		
		for(int j=1; j<=100; j++) {
			pointGenerator.sameYPoints(j*100, 50, 1000);			
			
			algoritme2 = new Algoritme2(pointGenerator.getPointList());
			algoritme2.berekenKortstePuntenPaar();
			System.out.println("Ms: " + algoritme2.getTimePassed());
		}
	}
	
	public void runNEDiagonalPointsTest() {
		// Run 100 tests
		
		System.out.println("");
		System.out.println("Algoritme 1");
		System.out.println("");
		
		for(int i=1; i<=100; i++) {			
			pointGenerator.NEDiagonal(i*100, 1000, 1000);
			
			algoritme1 = new Algoritme1(pointGenerator.getPointList());
			algoritme1.berekenKortstePuntenPaar();
			System.out.println("Ms: " + algoritme1.getTimePassed());

		}
		
		System.out.println("");
		System.out.println("Algoritme 2");
		System.out.println("");
		
		for(int j=1; j<=100; j++) {
			pointGenerator.NEDiagonal(j*100, 1000, 1000);		
			
			algoritme2 = new Algoritme2(pointGenerator.getPointList());
			algoritme2.berekenKortstePuntenPaar();
			System.out.println("Ms: " + algoritme2.getTimePassed());
		}
	}
}
