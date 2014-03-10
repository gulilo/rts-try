package mecanics;

import java.awt.Dimension;
import java.awt.Point;

import panels.GamePanel;
import panels.MainManuPanel;
import panels.OptionMenuPanel;
import resorsece.GameAPI;

public class GameMaster
{
	public static GameAPI api;
	private Screen screen;
	
	private Core core;

	public GameMaster()
	{
		api = new GameAPI(this);
		screen = new Screen(new Point(), new Dimension());
		core = null;
		openMainMenu();
	}

	public void openOptionMenu()
	{
		if(screen.isOpen())
		{
			screen.close();
		}
		if(core != null)
		{
			core.close();
			core = null;
		}
		screen = new Screen(new Point(100 , 100) , new Dimension(500 , 250));
		screen.setContentPane(new OptionMenuPanel(screen));
		screen.open();
	}

	public void openMainMenu()
	{
		if(screen.isOpen())
		{
			screen.close();
		}
		if(core != null)
		{
			core.close();
			core = null;
		}
		screen = new Screen(new Point(100 , 100) , new Dimension(500 , 250));
		screen.setContentPane(new MainManuPanel(screen));
		screen.open();
	}

	public void startGame(int map, int teams)
	{
		if(screen.isOpen())
		{
			screen.close();
		}
		screen = new Screen(new Point() , api.getFullScreenResulation());
		screen.setContentPane(new GamePanel(screen));
		screen.open();
		api.createTeams(teams);
		core = new Core(screen);
		new Thread(core).start();
		core.start();
	}

	public void close()
	{
		screen.close();
		System.exit(0);
	}
}
