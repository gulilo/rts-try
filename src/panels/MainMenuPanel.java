package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import mecanics.GameMaster;
import mecanics.Screen;

public class MainMenuPanel extends BasePanel
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("FieldCanBeLocal")
    private JButton grass , ground, option , exit;

	public MainMenuPanel(Screen screen)
	{
		super(screen);
		
		init();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.setFont(new Font("ariel" , Font.BOLD , 30));
		g.setColor(Color.CYAN);
		g.drawString("Choose a map:", 40, 50);
	}

	private void init()
	{
		grass = new JButton("Grass");
		grass.setSize(100, 50);
		grass.setLocation(300, 30);
		grass.setFocusable(false);
		grass.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				GameMaster.api.startGame(0, 1);
			}
		});
		add(grass);

		ground = new JButton("Graund");
		ground.setSize(100, 50);
		ground.setLocation(300, 100);
		ground.setFocusable(false);
		ground.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameMaster.api.startGame(1, 1);
            }
        });
		add(ground);

		option = new JButton("Option");
		option.setSize(100, 50);
		option.setLocation(3, getSize().height - option.getSize().height - 3);
		option.setFocusable(false);
		option.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				GameMaster.api.optionManu();
			}
		});
		add(option);

		exit = new JButton("Exit");
		exit.setSize(100, 50);
		exit.setLocation(getSize().width - exit.getSize().width - 3, getSize().height - exit.getSize().height - 3);
		exit.setFocusable(false);
		exit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				GameMaster.api.close();
			}
		});
		add(exit);
	}
}
