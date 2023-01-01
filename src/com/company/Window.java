package com.company;
import javax.swing.*;

public class Window extends JFrame {
    public Window(){
        initUI();

    }


    private void initUI(){
        add(new model(this));
        setResizable(false);
        pack();

        setTitle("Imun Shooter");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
