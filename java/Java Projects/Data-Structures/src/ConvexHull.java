import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class ConvexHull {

	private static ArrayList<Point> p;
	private static ArrayList<Point> Hull;
	public static ArrayList hull(ArrayList<Point> P)
	{
		p = P;
		findAnchor();
		sortAngles();
		hullPoints();


		return Hull;
	}
	
	private static double greaterAngle(Point Start, Point p1, Point p2)
	{
		/*
		 * Main piece of the program. This is how I check the angles of all the points for
		 * both sorting and for..Convex-ing? 
		 * 
		 * I assume that if given two points and an origin, we can create 2 lines with differing
		 * angles. This method creates a comparable. If Point 2 is greater than Point 1, the
		 * number will be negative. If they are equal angles, they will equal 0 and if Point 1
		 * is greater than Point 2, then Point 2 is the smaller angle.
		 * 
		 * The formula is derived from Vectors (x1)*(y2)-(x2)*(y1) 
		 * (Formula obtained from Wikipedia)
		 * of course we have to account for the Origin which is Start, which gives us this:
		 */
		double Vector1 = (p1.x - Start.x)*(p2.y - Start.y);
		double Vector2 = (p2.x - Start.x)*(p1.y - Start.y);
		 return Vector1 - Vector2;
	}
	private static void findAnchor()
	{
		//Finding the Starting point by going through the array..
		for(int i = 1; i < p.size(); i++)
		{
			Point StartPoint = p.get(0);
			if(p.get(i).y > StartPoint.y)
			{
				StartPoint = p.get(i);
				p.set(i, p.get(0));
				p.set(0, StartPoint);
			}
			// If their y's are the same, check which x is farther to the right.
			// If it is the new point, swap out.
			if(p.get(i).y == StartPoint.y && p.get(i).x > StartPoint.x )
			{
				StartPoint = p.get(i);
				p.set(i, p.get(0));
				p.set(0, StartPoint);
			}

		}
	}
	private static void sortAngles()
	{

		for(int i = 1; i < p.size(); i++)
		{
			Point SmallestAngle = p.get(i);
			int min = i;
			
			for(int j = i+1; j < p.size(); j++)
			{
				if(greaterAngle(p.get(0), SmallestAngle, p.get(j)) > 0 )
				{ 
					SmallestAngle = p.get(j);
					min = j;
				}
			}
			p.set(min, p.get(i));
			p.set(i, SmallestAngle);
		}

	}
	private static void hullPoints()
	{
		//Made the Hull ArrayList act like a stack. Then checked all the angles.
	int i = 2;
	Hull = new ArrayList();
	Hull.add(p.get(0));
	Hull.add(p.get(1));
	Point CheckTop;
	Point CheckSec;
	while(i < p.size())
		{
		CheckTop = Hull.get(Hull.size()-1);
		CheckSec = Hull.get(Hull.size()-2);
		if(greaterAngle(CheckSec,CheckTop,p.get(i)) <= 0)
		{
			Hull.add(p.get(i));
			i++;
		}
		else
		{
			Hull.remove(Hull.size()-1);
		}	
	}

	}
}
