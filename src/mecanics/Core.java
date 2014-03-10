package mecanics;

import parameters.Node;
import parameters.Unit;

public class Core implements Runnable
{
	private Screen screen;
	private boolean run;

	public Core(Screen screen)
	{
		run = false;
		this.screen = screen;
	}

	public void run()
	{
		while(run)
		{
			gameLoop();
			render();
			try
			{
				Thread.sleep(60);
			}
			catch(InterruptedException e)
			{
				System.err.println("cant sleep, not tired");
			}
		}
	}

	private void gameLoop()
	{
		for(Node<Unit> cur = GameMaster.api.getTeam()[0].getUnits().getHead(); cur != null; cur = cur.getNext())
		{
			cur.getInfo().move();
		}
	}
	
	private void render()
	{
		screen.revalidate();
		screen.repaint();
	}

	public void start()
	{
		run = true;
	}
	
	public void close()
	{
		run = false;
	}
}
