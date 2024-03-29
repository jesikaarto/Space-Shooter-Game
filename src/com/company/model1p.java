package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;


public class model1p extends JPanel implements ActionListener {
    private Timer time;
    Window1P MainWindow1;

    private SelB Spaceship;
    private List<Bakteri> aliens;
    private boolean inGame;
    private final int imun_x = 40, imun_y=60, width = 600, height = 300, delay  = 50;
    int score = 0;
    String formattedDateTime;
    private final int[][]pos = {
            {1380, 29},{1500,59}, {1380, 89},
            {1280,109},{1080,139},{1200,239},
            {1190,259},{1080,50},{1300,150},
            {1150,209},{1060,45},{1300,70},
            {1230,159},{1090,80},{1035,60},
            {1040,59},{1190,30},{1222,200},
            {1000,259},{1260,50},{1133,90},
            {1070,220},{1110,20},{1176,180},
            {1020,128},{1150,170},{1000,30},
            {1040,59},{1190,30},{1222,200},
            {1000,259},{1260,50},{1133,90},
            {1070,220},{1110,20},{1176,180},
            {1020,128},{1150,170},{1000,30},
            {1040,59},{1190,30},{1222,200},
            {1000,279},{1260,50},{1133,90},
            {1070,240},{1110,20},{1176,180},
            {1020,138},{1150,170},{1000,30},
            {1040,55},{1190,30},{1222,200},
            {1000,269},{1260,50},{1133,90},
            {1070,263},{1110,20},{1176,180},
            {1020,16},{1150,170},{1000,30},
            {1040,57},{1190,30},{1222,200},
            {1000,229},{1260,50},{1133,90},
            {1070,250},{1110,20},{1176,180},
            {1020,128},{1150,170},{1000,30},
    };
    public model1p(Window1P MainWindow){
        this.MainWindow1 =MainWindow;
        initBoard();
    }



    private void initBoard(){
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        inGame = true;
        score = 0;


        setPreferredSize(new Dimension(width, height));
        Spaceship = new SelB(imun_x, imun_y);
        initAliens();
        time = new Timer(delay,this);
        time.start();
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Format LocalDateTime to String
        formattedDateTime = date.format(dateTimeFormatter);
    }
    public void initAliens(){
        aliens = new ArrayList<>();

        for(int[]p : pos){
            aliens.add(new Bakteri(p[0], p[1]));
        }

    }
    public int getScore(){
        return score;
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(inGame){
            drawObjects(g);
        }
        else{
            if(aliens.size() == 0){
                drawWin(g);
            }
            else{
                drawGameOver(g);
            }
        }
        Toolkit.getDefaultToolkit().sync();
    }
    private void drawObjects(Graphics g){
        if(Spaceship.isVisible()){
            g.drawImage(Spaceship.getImage(),Spaceship.getX(), Spaceship.getY(),this);
        }
        List<Antibody>ms = Spaceship.getMissiles();
        for(Antibody missile : ms){
            if(missile.isVisible()){
                g.drawImage(missile.getImage(), missile.getX(), missile.getY(),this);
            }
        }



        for (Bakteri alien : aliens){
            if(alien.isVisible()){
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(),50,50, this);
            }
        }
        g.setColor(Color.WHITE);
        g.drawString("bakteri left: "+aliens.size(), 5, 15);
        g.drawString("Score : " + score, 525, 275);
    }
    public void drawGameOver(Graphics g){
        String msg = "You Lose";
        String skorAngka = "Score anda : "+ score;
        String msg2 ="press enter to start again";
        Font small = new Font("Bernard MT Condensed",Font.BOLD,20);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.WHITE);
        g.setFont(small);
        g.drawString(msg, (width - fm.stringWidth(msg))/2, height/2);
        g.drawString(skorAngka,(width- fm.stringWidth(skorAngka))/2, height/3);
        g.drawString(msg2,(width- fm.stringWidth(msg2))/2, height/4);
    }
    public void drawWin(Graphics g){
        String msg = "You Win";
        String skorAngka = "Score anda : "+ score;
        String msg2 ="press enter to start again";
        Font small = new Font("Bernard MT Condensed",Font.BOLD,20);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.WHITE);
        g.setFont(small);
        g.drawString(msg, (width - fm.stringWidth(msg))/2, height/2);
        g.drawString(skorAngka,(width- fm.stringWidth(skorAngka))/2, height/3);
        g.drawString(msg2,(width- fm.stringWidth(msg2))/2, height/4);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inGame();

        updateShip();
        updateMisil1();
        updateAliens();

        checkCollisions();
        repaint();
    }
    private void inGame(){
        if(!inGame){
            time.stop();

            DB scores = new DB("SINGLE PLAYER",score, formattedDateTime);
            DBConn conn = new DBConn();
            conn.save(scores);
            conn.getAll();


        }
    }
    private void updateShip(){
        if(Spaceship.isVisible()){
            Spaceship.move();

        }
    }
    private void updateMisil1(){
        List<Antibody> ms = Spaceship.getMissiles();
        for (int i = 0; i < ms.size();i++){
            Antibody m = ms.get(i);

            if (m.isVisible()){
                m.move();
            }
            else {
                ms.remove(i);
            }
        }
    }

    private void updateAliens(){
        if(aliens.isEmpty()){
            inGame = false;
            return;
        }
        for (int i = 0; i < aliens.size();i++){
            Bakteri a = aliens.get(i);
            if(a.isVisible()){
                if(score>=500 && score <5000){
                    a.move2();
                } else if (score >=5000) {
                    a.move3();
                } else{
                    a.move();
                }
            }
            else{
                aliens.remove(i);
            }
        }
    }
    public void checkCollisions(){
        Rectangle r3 = Spaceship.getBounds();
        for (Bakteri alien : aliens){
            Rectangle r2 = alien.getBounds();
            if(r3.intersects(r2)){
                Spaceship.setVisible(false);
                alien.setVisible(false);
                inGame = false;
            }
        }
        List<Antibody> ms = Spaceship.getMissiles();
        for (Antibody m : ms){
            Rectangle r1 = m.getBounds();
            for(Bakteri alien : aliens){
                Rectangle r2 = alien.getBounds();
                if(r1.intersects(r2)){
                    m.setVisible(false);
                    alien.Explosion();
                    java.util.Timer time = new java.util.Timer();
                    time.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            alien.setVisible(false);
                        }
                    },250);//lama ledakan 1 detik
                    score = score + 50;
                    checkScore();
                }
            }
        }
    }

    private class TAdapter extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent e) {

            int keyCode = e.getKeyCode();
            if(keyCode == e.VK_ENTER){
                //mengatur maksimal objek gerak
                if(!inGame){
                    mainFrame mf = new mainFrame();
                    mf.setVisible(true);
                    MainWindow1.setVisible(false);



                }
            }
            Spaceship.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if(keyCode == e.VK_H){
                if(!inGame){
                    inGame = true;
                }
            }
            Spaceship.keyPressed(e);
        }
    }

    private void checkScore(){
        if(score==500000){
            inGame = false;
        }
    }




}
