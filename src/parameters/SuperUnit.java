package parameters;

import java.awt.Dimension;
import java.awt.Point;

public class SuperUnit extends Unit
{
	private static final long serialVersionUID = 1L;

	private final static int SUPER_UNIT_SPEED = 15;
	private final static String[] paths =
	{ "super1" , "super2" };

	public SuperUnit(Point location)
	{
		super(0,location , new Dimension(100 , 100) , SUPER_UNIT_SPEED, paths);
	}

	@Override
	public String toString()
	{
		return "SuperUnit [x=" + getX() + ", y=" + getY() + ", width=" + getWidth() + ", height=" + getHeight() + "]";
	}

}
