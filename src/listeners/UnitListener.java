package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mecanics.GameMaster;
import panels.GamePanel;
import parameters.Unit;

public class UnitListener implements MouseListener , KeyListener
{
	private Unit unit;

	public UnitListener(Unit unit)
	{
		this.unit = unit;
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
			if(!GamePanel.panelApi.isCtrl())
			{
				GameMaster.api.deselectAllUnits();
			}
			if(!unit.isSelected())
			{
				unit.requestFocusInWindow();
			}
			else
			{
				GamePanel.panelApi.returnFocus();
			}
			unit.setSelected(!unit.isSelected());
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
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_ESCAPE:
			{
				GameMaster.api.deselectAllUnits();
				GamePanel.panelApi.returnFocus();
				break;
			}
			case KeyEvent.VK_CONTROL:
			{
				GamePanel.panelApi.setCtrl(true);
				break;
			}
		}
		e.consume();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_CONTROL)
		{
			GamePanel.panelApi.setCtrl(false);
		}
		e.consume();
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		e.consume();
	}
}
