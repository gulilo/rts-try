package parameters;

import java.awt.Point;

public class Line
{
	private double m , n;

	public Line(Point Location , Point target)
	{
		m = (Location.y - target.y) / (Location.x - target.x);
		n = Location.x * m - Location.y;
		System.out.println(m+"  "+n);
	}

	public int next(int x)
	{
		//System.out.println("2");
		return (int)(m * x + n);
	}
}
