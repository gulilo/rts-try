package resorsece;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

import mecanics.GameMaster;
import panels.GamePanel;
import parameters.Node;
import parameters.Unit;

public class PanelAPI
{
	public static final Color TRANSPARENCY = new Color(0 , 0 , 0 , 1);
	private GamePanel panel;
	private boolean ctrl;
	private int map;

	public PanelAPI(GamePanel panel)
	{
		this.panel = panel;
		ctrl = false;
	}
	
	public void addToPanel(Component c)
	{
		panel.add(c);
	}

	public void returnFocus()
	{
		panel.requestFocusInWindow();
	}

	public boolean isCtrl()
	{
		return ctrl;
	}

	public void setCtrl(boolean ctrl)
	{
		this.ctrl = ctrl;
	}

	public boolean near(Unit unit)
	{
		for(Node<Unit> current = GameMaster.api.getTeam()[0].getUnits().getHead(); current != null; current = current.getNext())
		{
			if(current.getInfo().contains(unit))
			{
				return true;
			}
		}
		return false;
	}

	public static Image changeColor(Image image , final Color from , final Color to)
	{
		ImageFilter filter = new RGBImageFilter()
		{
			@Override
			public int filterRGB(int x , int y , int rgb)
			{
				if(rgb == from.getRGB())
				{
					return to.getRGB();
				}
				return rgb;
			}
		};
		ImageProducer ip = new FilteredImageSource(image.getSource() , filter);
		return Toolkit.getDefaultToolkit().createImage(ip);
	}

	public void setMap(int map)
	{
		this.map = map;
	}

	public int getMap()
	{
		return map;
	}
}
