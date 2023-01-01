package com.company;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SelT extends jalan {
    private int dx;
    private int dy;
    private List<Antibody> missiles;
    public void move2(){
        x += dx;
        y += dy;

        if(x<= 0)
            x = 0;
        if(x >= 550)
            x = 550;
        if(y <= 0)
            y = 0;
        if(y >= 255)
            y = 255;
    }
    public SelT(int x, int y) {
        super(x, y);
        initCraft();
    }

    private void initCraft() {
        missiles = new ArrayList<>();
        loadImage("src/img/selT.png");
        getImageDimensions();
    }
    public void move(){
        x += dx;
        y += dy;
        if (x < 1){
            y = 1;
        }
    }
    public List<Antibody> getMissiles(){
        return missiles;

    }
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode == e.VK_A){
            //mengatur maksimal objek gerak
            dx = -5;
        }
        if(keyCode == e.VK_D){
            dx = 5;
        }
        if(keyCode == e.VK_W){
            dy = -5;
        }
        if(keyCode == e.VK_S){
            dy = 5;
        }
        if(keyCode == e.VK_E){
            fire();
        }

    }

    public void fire(){

        missiles.add(new Antibody(x + width, y + height/2));
    }

    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode == e.VK_A){
            //mengatur maksimal objek gerak
            dx = 0;
        }
        if(keyCode == e.VK_D){
            dx = 0;
        }
        if(keyCode == e.VK_W){
            dy = 0;
        }
        if(keyCode == e.VK_S){
            dy = 0;
        }
    }
}
