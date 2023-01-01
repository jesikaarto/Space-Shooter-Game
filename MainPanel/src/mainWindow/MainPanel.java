package mainWindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JComponent;
import board.GameBoardFrame;


public class MainPanel extends JPanel implements ActionListener{
	private JRadioButton levels[];
	private String leveling[];
	private MainFrame parentWindow;
	
	public MainPanel(MainFrame mainWindow) {
		this.setBackground(Color.BLUE);
		this.setLayout(null);
		this.levels = new JRadioButton[3];
		this.leveling = new String[] {"Easy", "Normal", "Hard"};
		this.parentWindow = mainWindow;
		this.configureLevelButtons();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.black);
		g2.setFont(new Font ("Arial Black", Font.BOLD, 45));
		g2.drawString("Snake Game", 135, 85);
		g2.setColor(new Color(138,43,226));
		g2.setFont(new Font("Courier New", Font.BOLD, 30));
		g2.drawString("LET'S TRY", 180, 120);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		
		if(obj == levels[0]) {
			new GameBoardFrame (1);
			parentWindow.setVisible(false);
			parentWindow.dispose();
		}
		else if(obj == levels[1]) {
			new GameBoardFrame (2);
			parentWindow.setVisible(false);
			parentWindow.dispose();
		}
		else if(obj == levels[2]) {
			new GameBoardFrame (3);
			parentWindow.setVisible(false);
			parentWindow.dispose();
		}
	}
	
	private void configureLevelButtons() {
		for (int i = 0; i< levels.length; i++) {
			levels[i] = new JRadioButton(leveling[i]);
			levels[i].addActionListener(this);
			levels[i].setBackground(new Color(230,230,250));
			levels[i].setBounds(260,200 + i*50,80,30);
			this.add(levels[i]);
		}
	}
}
