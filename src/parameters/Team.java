package parameters;

import java.awt.Color;
import java.awt.Point;
import java.io.IOException;

import panels.GamePanel;

public class Team
{
	private Color color;
	private List<Unit> units;
	private List<Building> buildings;

	public Team(Color color)
	{
		this.color = color;
		units = new List<Unit>();
		buildings = new List<Building>();
		
		createBuilding(new Point(100,100));
	}

	public void createUnit(Point location , int i)
	{
		if(i == 1)
		{
			Unit temp = new NormalUnit(location);
			if(!GamePanel.panelApi.near(temp))
			{
				GamePanel.panelApi.addToPanel(temp);
				units.add(temp);
			}
		}
		else if(i == 2)
		{
			Unit temp = new SuperUnit(location);
			if(!GamePanel.panelApi.near(temp))
			{
				GamePanel.panelApi.addToPanel(temp);
				units.add(temp);
			}
		}
	}

	public void createBuilding(Point location)
	{
		Building temp = null;
		try
		{
			temp = new Building(location , Building.BUILDING_SIZE , "building2", this);
		}
		catch(IOException e)
		{
			System.err.println("cant load building image");
			e.printStackTrace();
		}
		GamePanel.panelApi.addToPanel(temp);
		buildings.add(temp);
	}

	public List<Unit> getUnits()
	{
		return units;
	}

	public List<Building> getBuildings()
	{
		return buildings;
	}

	public Color getColor()
	{
		return color;
	}
}
