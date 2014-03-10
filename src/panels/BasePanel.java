package panels;

import javax.swing.JPanel;

import mecanics.Screen;

public class BasePanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	public BasePanel(Screen screen)
	{
		super();

		setSize(screen.getSize());
		setLocation(0 , 0);
		setLayout(null);
		setBackground(screen.getBackground());
		setFocusable(true);
	}
}
