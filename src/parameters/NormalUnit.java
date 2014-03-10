package parameters;

import java.awt.Dimension;
import java.awt.Point;

public class NormalUnit extends Unit
{
	private static final long serialVersionUID = 1L;

	private final static int NORMAL_UNIT_SPEED = 10;
	private final static String[] paths =
	{ "normal1" , "normal2" };

	public NormalUnit(Point location)
	{
		super(0,location , new Dimension(50 , 50) , NORMAL_UNIT_SPEED , paths);
	}

	@Override
	public String toString()
	{
		return "NormalUnit [x=" + getX() + ", y=" + getY() + ", width=" + getWidth() + ", height=" + getHeight() + "]";
	}
}
