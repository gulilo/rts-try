package listeners;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mecanics.GameMaster;
import parameters.Node;
import parameters.Unit;

public class PanelListener implements MouseListener , KeyListener
{

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
		switch (e.getButton())
		{
			case MouseEvent.BUTTON3:
			{
				Point last = null;
				for(Node<Unit> cur = GameMaster.api.getTeam()[0].getUnits().getHead(); cur != null; cur = cur.getNext())
				{
					if(cur.getInfo().isSelected())
					{
						if(last == null)
						{
							cur.getInfo().setTarget(new Point(e.getX() , e.getY()));
							last = new Point(cur.getInfo().getTarget().x , cur.getInfo().getTarget().y);
						}
						else
						{
							last = new Point(last.x - 20 - cur.getInfo().getSize().width , last.y);
							cur.getInfo().setTarget(last);
						}
					}
				}
				break;
			}
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
				GameMaster.api.mainManu();
				break;
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
