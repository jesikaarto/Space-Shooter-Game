package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main(){
        initUI();
    }
    private void initUI(){
        add(new model());
        setResizable(false);
        pack();

        setTitle("Imun Shooter");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
	// write your code here
        EventQueue.invokeLater(() -> {
            Main ex = new Main();
            ex.setVisible(true);
        });
    }
}
