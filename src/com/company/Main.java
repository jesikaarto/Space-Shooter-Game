package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            mainFrame mf = new mainFrame();
            mf.setVisible(true);
        });
    }
}