package board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import mainWindow.MainFrame;

public class GameBoardFrame extends JFrame implements ActionListener{
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem newGameMenuItem;
	private JMenuItem exitGameMenuItem;
	private GameBoardPanel boardPanel;
	
	public GameBoardFrame (int level) {
		this.setTitle("IMUN BATTLE");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100,5,1100,700);
		this.setResizable(false);
		this.setVisible(true);
		this.boardPanel = new GameBoardPanel(level);
		this.getContentPane().add(this.boardPanel);
		this.menu = new JMenu("Menu");
		this.newGameMenuItem = new JMenuItem ("New Game");
		this.exitGameMenuItem = new JMenuItem ("EXIT");
		this.menu.add(newGameMenuItem);
		this.menu.add(exitGameMenuItem);
		this.menuBar = new JMenuBar();
		this.menuBar.add(menu);
		this.setJMenuBar(menuBar);
		this.newGameMenuItem.addActionListener(this);
		this.exitGameMenuItem.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		
		if (source == this.newGameMenuItem) {
			this.setVisible(false);
			this.dispose();
		}
		else if (source == exitGameMenuItem) {
			System.exit(0);
		}
	}
}
