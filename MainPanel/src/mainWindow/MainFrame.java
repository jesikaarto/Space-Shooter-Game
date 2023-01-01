package mainWindow;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	private MainPanel mainPanel;
	
	public MainFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		this.setBounds(320,127,600,400);
		this.setResizable(false);
		this.setVisible(true);
		
		this.mainPanel = new MainPanel(this);
		this.getContentPane().add(mainPanel);	
	}
}
