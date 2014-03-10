package resorsece;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import mecanics.GameMaster;
import parameters.Building;
import parameters.Node;
import parameters.Team;
import parameters.Unit;

public class GameAPI
{
	private final Color[] TEAM_COLOR = {Color.BLUE,Color.RED,Color.YELLOW,Color.GREEN};
	
	private GameMaster gm;
	private Team[] team;
	private int map;

	public GameAPI(GameMaster gm)
	{
		this.gm = gm;
	}

	public Dimension getFullScreenResulation()
	{
		return Toolkit.getDefaultToolkit().getScreenSize();
	}

	public void close()
	{
		gm.close();
	}

	public void deselectAllUnits()
	{
		for(Node<Unit> cur = team[0].getUnits().getHead(); cur != null; cur = cur.getNext())
		{
			cur.getInfo().setSelected(false);
		}
		for(Node<Building> cur = team[0].getBuildings().getHead(); cur != null; cur = cur.getNext())
		{
			cur.getInfo().setSelected(false);
		}
	}
	
	public void startGame(int map, int teams)
	{
		this.map = map;
		gm.startGame(map,teams);
	}
	
	public void createTeams(int teams)
	{
		team = new Team[teams];
		for(int i = 0;i<teams;i++)
		{
			team[i] = new Team(TEAM_COLOR[i]);
		}
	}
	
	public void optionManu()
	{
		gm.openOptionMenu();
	}
	
	public void mainManu()
	{
		gm.openMainMenu();
	}

	public int getMap()
	{
		return map;
	}

	public void setMap(int map)
	{
		this.map = map;
	}

	public Team[] getTeam()
	{
		return team;
	}
}
