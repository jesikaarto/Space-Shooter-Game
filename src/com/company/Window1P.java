package com.company;
import javax.swing.*;

public class Window1P extends JFrame {
    public Window1P(){
        initUI();

    }


    private void initUI(){
        add(new model1p(this));
        setResizable(false);
        pack();

        setTitle("Imun Shooter");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
