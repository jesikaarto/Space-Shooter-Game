package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainPanel extends JPanel implements ActionListener {

    private JButton levels[];
    private String levelName[];
    private mainFrame parentWindow;


    public void initAlien() {
        this.loadImage("src/img/pilihan.png");
        this.getImageDimensions();
    }

    private void getImageDimensions() {
    }

    private void loadImage(String s) {
    }

    public MainPanel (mainFrame mainWindow){
        this.setBackground(Color.cyan);
        this.setLayout(null);
        this.levels= new JButton[2];
        this.levelName = new String[]{"Multi Player","Single Player"};
        this.parentWindow= mainWindow;
        this.configurelevelButtons();

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("Arial Black", Font.BOLD,30));
        g2.drawString("SPACE SHOOTER VIRUS",95,35);
        g2.setColor(new Color(138,43,226));
        g2.setFont(new Font("Courier New",Font.BOLD,15));
        g2.drawString("Dunia sudah tidak aman saatnya beraksi!!!",110,70);
    }

    private void configurelevelButtons()
    {
        for (int i = 0; i< levels.length; i++){
            levels[i] = new JButton((levelName[i]));
            levels[i].addActionListener(this);
            levels[i].setBackground(Color.black);
            levels[i].setForeground(Color.white);
            levels[i].setBounds(300,170 + i * 50, 130,40);
            this.add(levels[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == levels[0]){
            Window nw = new Window();
            nw.setVisible(true);
            parentWindow.dispose();
        } else if (obj == levels[1]) {
            Window1P nw = new Window1P();
            nw.setVisible(true);
            parentWindow.dispose();
        }
    }
}
