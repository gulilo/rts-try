package listeners;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mecanics.GameMaster;
import panels.GamePanel;
import parameters.Building;

public class BuildingListener implements KeyListener , MouseListener
{

	private Building building;

	public BuildingListener(Building building)
	{
		this.building = building;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		e.consume();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		e.consume();
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		e.consume();
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			GameMaster.api.deselectAllUnits();
			if(!building.isSelected())
			{
				building.requestFocusInWindow();
			}
			else
			{
				GamePanel.panelApi.returnFocus();
			}
			building.setSelected(!building.isSelected());
		}
		e.consume();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		e.consume();
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if(building.isSelected())
		{
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_1:
				{
					GameMaster.api.getTeam()[0].createUnit(new Point(building.getLocation().x + building.getSize().width + 40 , building.getLocation().y + building.getSize().height) , 1);
					break;
				}
				case KeyEvent.VK_2:
				{
					GameMaster.api.getTeam()[0].createUnit(new Point(building.getLocation().x + building.getSize().width + 40 , building.getLocation().y + building.getSize().height) , 2);
					break;
				}
				case KeyEvent.VK_ESCAPE:
				{
					building.setSelected(false);
					GamePanel.panelApi.returnFocus();
					break;
				}
			}
		}
		e.consume();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		e.consume();
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		e.consume();
	}
}
