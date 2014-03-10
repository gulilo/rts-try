package mecanics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;

public class Screen extends JFrame
{
	private static final long serialVersionUID = 1L;

	private boolean open;
	private GraphicsDevice[] devices;
	private DisplayMode[] displayModes;
	private int curDevice , curDisplayMode;

	public Screen(Point location , Dimension size)
	{
		super();
		
		open = false;

		curDevice = curDisplayMode = 0;

		devices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
		displayModes = getGoodDisplayModes(devices[curDevice].getDisplayModes());

		setSize(size);
		setLocation(location);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
	}

	public void open()
	{
		open = true;
		this.setVisible(true);
	}

	public void close()
	{
		open = false;
		this.setVisible(false);
		this.dispose();
	}

	public boolean isOpen()
	{
		return open;
	}

	private DisplayMode[] getGoodDisplayModes(DisplayMode[] dm)
	{
		DisplayMode[] temp = new DisplayMode[dm.length];
		int index = 0;
		for(int i = 0; i < dm.length; i++)
		{
			if(dm[i].getRefreshRate() == 60 && dm[i].getBitDepth() == 32 && dm[i].getWidth() % 16 == 0 && dm[i].getHeight() % 8 == 0)
			{
				temp[index] = dm[i];
				index++;
			}
		}
		DisplayMode[] best = new DisplayMode[index];
		for(int i = 0; i < index; i++)
		{
			best[i] = temp[i];
		}
		return best;
	}

	public void setFullScreen()
	{
		if(devices[curDevice].isDisplayChangeSupported())
		{
			System.out.println("3");
			devices[curDevice].setFullScreenWindow(this);
			devices[curDevice].setDisplayMode(displayModes[curDisplayMode]);
		}
	}
}
