package com.company;

import javax.swing.*;

public class mainFrame extends JFrame {
    private MainPanel mainPanel;
    private ImageIcon getBackGround;
    private JLabel newlabel;

    public mainFrame(){
        getBackGround = new ImageIcon(getClass().getResource("/img/MainMenu.png"));
        newlabel = new JLabel(getBackGround);
        this.add(newlabel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(320,127,600,400);
        this.setResizable(false);
        this.setVisible(true);
        this.mainPanel = new MainPanel(this);
        this.getContentPane().add(mainPanel);
    }
}
