package panels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import listeners.PanelListener;
import mecanics.GameMaster;
import mecanics.Screen;
import resorsece.PanelAPI;

public class GamePanel extends BasePanel
{
	private static final long serialVersionUID = 1L;
	private static final int NUMBER_OF_MAPS_IN_EACH_TYPE = 3;

	public static PanelAPI panelApi;

    // TODO - figure out the map types from the background folders
	private final String[] backgroundPath =
	{ "grass1" , "grass2" , "grass3" , "graund1" , "graund2" , "graund3" };

    private BufferedImage[][] background;

	public GamePanel(Screen screen)
	{
		super(screen);
		
		panelApi = new PanelAPI(this);

		PanelListener pl = new PanelListener();
		addMouseListener(pl);
		addKeyListener(pl);
		
		makeBackground();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i = 0; i < background.length; i++)
		{
			for(int j = 0; j < background[i].length; j++)
			{
				g.drawImage(background[i][j] , i * 150 , j * 150 , null);
			}
		}
	}

	private void makeBackground()
	{
        BufferedImage[] backgroundImages = new BufferedImage[NUMBER_OF_MAPS_IN_EACH_TYPE];
		for(int i = 0; i < backgroundImages.length; i++)
		{
			try
			{
				backgroundImages[i] = ImageIO.read(new File("img\\" + backgroundPath[(GameMaster.api.getMap() * NUMBER_OF_MAPS_IN_EACH_TYPE) + i] + ".png"));
			}
			catch(IOException e)
			{
				System.err.println("cant read image");
			}
		}

		background = new BufferedImage[getSize().width / 150 + 1][getSize().height / 150 + 1];
		Random r = new Random();
		for(int i = 0; i < background.length; i++)
		{
			for(int j = 0; j < background[i].length; j++)
			{
				background[i][j] = backgroundImages[r.nextInt(backgroundImages.length)];
			}
		}
	}
}
