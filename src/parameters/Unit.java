package parameters;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import listeners.UnitListener;
import mecanics.Animation;
import mecanics.GameMaster;
import resorsece.PanelAPI;

public abstract class Unit extends JPanel
{
	private static final long serialVersionUID = 1L;

	protected Team team;
	protected boolean selected;
	protected Animation anime;

    protected int speed;
    protected Point target;

	public Unit(int team , Point location , Dimension size , int speed , String[] paths)
	{
		this.setOpaque(false);
		this.setLocation(location);
		this.setSize(size);

		this.team = GameMaster.api.getTeam()[team];
		this.speed = speed;
		selected = false;
		target = null;

		anime = new Animation(loadImages(paths));

		UnitListener ul = new UnitListener(this);
		this.addKeyListener(ul);
		this.addMouseListener(ul);
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3));
		try
		{
			g2.drawImage(anime.getCurrentImage() , 0 , 0 , null);
		}
		catch(Exception e)
		{
			g2.setColor(new Color(200 , 80 , 80));
			g2.fillRect(0 , 0 , getSize().width , getSize().height);
		}
		if(selected)
		{
			g2.setColor(Color.blue);
			g2.drawRect(0 , 0 , getSize().width - 1 , getSize().height - 1);
		}
	}

	//not working
	public boolean contains(Unit unit)
	{
		return this.getLocation().distance(unit.getLocation()) <= this.getLocation().distance(new Point(this.getLocation().x , this.getLocation().y + this.getSize().height)) || this.getLocation().distance(unit.getLocation()) <= this.getLocation().distance(new Point(this.getLocation().x + this.getSize().width , this.getLocation().y)) || this.getLocation().distance(unit.getLocation()) <= unit.getLocation().distance(new Point(unit.getLocation().x , unit.getLocation().y + unit.getSize().height)) || this.getLocation().distance(unit.getLocation()) <= unit.getLocation().distance(new Point(unit.getLocation().x + unit.getSize().width , unit.getLocation().y));
	}

	public void move()
	{
        if (this.target == null) {
            return;
        }

        this.anime.start();

        Point currentLocation = this.getLocation();
        double dx = this.target.getX() - currentLocation.getX();
        double dy = this.target.getY() - currentLocation.getY();
        double totalDistance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

        Point nextStep = new Point();

        if (totalDistance <= speed) {
            nextStep.setLocation(target);
            this.anime.stop();
            target = null;
        }
        else {
            double yx = Math.abs(dy / dx);
            double alpha = Math.atan(yx);
            double sinAlpha = Math.sin(alpha);

            double xy = Math.abs(dx / dy);
            double beta = Math.atan(xy);
            double sinBeta = Math.sin(beta);

            int nextX = (int) (Math.round(sinBeta * speed) * Math.signum(dx));
            int nextY = (int) (Math.round(sinAlpha * speed) * Math.signum(dy));
            nextStep.setLocation(currentLocation.getX() + nextX, currentLocation.getY() + nextY);
        }

        setLocation(nextStep);
	}

	private Image[] loadImages(String[] paths)
	{
		Image[] im = new Image[paths.length];
		for(int i = 0; i < paths.length; i++)
		{
			try
			{
				Image image = ImageIO.read(new File("img\\"+paths[i]+".png"));
				image = PanelAPI.changeColor(image , Color.WHITE , PanelAPI.TRANSPARENCY);
				image = PanelAPI.changeColor(image , new Color(200 , 200 , 200) , team.getColor());

				im[i] = image;
			}
			catch(Exception e)
			{
				System.err.println("unit - loadImages - cant load image");
			}
		}
		return im;
	}

	public boolean isSelected()
	{
		return selected;
	}

	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}

	public Point getTarget()
	{
		return target;
	}

	public void setTarget(Point target)
{
    this.target = target;
}
}
