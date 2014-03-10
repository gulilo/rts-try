package parameters;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import listeners.BuildingListener;
import resorsece.PanelAPI;

public class Building extends JPanel
{
	private static final long serialVersionUID = 1L;

	public static final Dimension BUILDING_SIZE = new Dimension(200 , 200);

	private boolean selected;
	private Team team;
	private Image image;

	public Building(Point location , Dimension size , String path, Team team) throws IOException
	{
		this.setLocation(location);
		this.setSize(size);
		this.setOpaque(false);

		this.selected = false;
		this.team = team; 
		
		BuildingListener bl = new BuildingListener(this);
		this.addMouseListener(bl);
		this.addKeyListener(bl);

		try
		{
			System.out.println();
			Image im = ImageIO.read(new File("img\\" + path + ".png"));
			im = PanelAPI.changeColor(im, new Color(200,200,200), team.getColor());
			im =PanelAPI.changeColor(im , Color.WHITE , PanelAPI.TRANSPARENCY);
			image = im;
			
		}
		catch(IOException e)
		{
			System.err.println("cant load image");
		}
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		g2.setStroke(new BasicStroke(3));

		try
		{
			g2.drawImage(image , 0 , 0 , null);
		}
		catch(Exception e)
		{
			g2.setColor(Color.green);
			g2.fillRect(0 , 0 , getSize().width , getSize().height);
		}
		if(selected)
		{
			g2.setColor(Color.blue);
			g2.drawRect(0 , 0 , getSize().width , getSize().height);
		}
	}

	public boolean isSelected()
	{
		return selected;
	}

	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}
}
