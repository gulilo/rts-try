package panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import mecanics.GameMaster;
import mecanics.Screen;

public class OptionMenuPanel extends BasePanel
{
	private static final long serialVersionUID = 1L;

	private JButton back;

	public OptionMenuPanel(Screen screen)
	{
		super(screen);

		init();
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.red);
		g.drawString("bla" , 2 , 50);
	}

	private void init()
	{
		back = new JButton("back");
		back.setSize(100 , 50);
		back.setLocation(getSize().width - back.getSize().width - 3 , getSize().height - back.getSize().height - 3);
		back.setFocusable(false);
		back.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				GameMaster.api.mainManu();
			}
		});
		add(back);
	}
}
