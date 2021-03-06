import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ElegantPoint {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner a = new Scanner(new File("input20.txt"));
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		int numPoints = Integer.parseInt(a.nextLine());
		ArrayList<CollinearPoint> points = new ArrayList<CollinearPoint>(numPoints);
		CollinearPoint origin = new CollinearPoint(0,0);
		for(int i = 0; i < numPoints; i++){
			points.add(new CollinearPoint(a.nextInt(), a.nextInt()));
		}
		a.close();
		Collections.sort(points);
		Collections.reverse(points);
		while(points.size() > 0){
			CollinearPoint curr = points.remove(0);
			Collections.sort(points, curr.SLOPE_ORDER);
			for(int i = 0; i < points.size()-2; i++){
				if(CollinearPoint.areCollinear(curr, points.get(i), points.get(i+1), points.get(i+2))){
					drawCollinears(curr, points.get(i), points.get(i+1), points.get(i+2));
				}
			}
		}
		
	
	}
	public static void drawCollinears(CollinearPoint a,CollinearPoint b, CollinearPoint c, CollinearPoint d){
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(.001);
		a.drawTo(b);
		b.drawTo(c);
		c.drawTo(d);
		StdDraw.setPenRadius(.02);
		StdDraw.setPenColor(new Color(140, 30, 130));
		a.draw();
		b.draw();
		c.draw();
		d.draw();
	}
	public static void drawCollinears(CollinearPoint a,CollinearPoint b, CollinearPoint c){
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(.001);
		a.drawTo(b);
		b.drawTo(c);
		StdDraw.setPenRadius(.02);
		StdDraw.setPenColor(new Color(140, 30, 130));
		a.draw();
		b.draw();
		c.draw();
	}
}
