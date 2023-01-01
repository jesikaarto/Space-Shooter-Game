package com.company;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
public class SelB extends jalan {
    private int dx;
    private int dy;
    private List<Antibody> missiles;

    public SelB(int x, int y) {
        super(x, y);
        initCraft();
    }

    private void initCraft() {
        missiles = new ArrayList<>();
        loadImage("src/img/selB.png");
        getImageDimensions();
    }
    public void move(){
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
    public List<Antibody> getMissiles(){
        return missiles;

    }
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode == e.VK_LEFT){
            //mengatur maksimal objek gerak
            dx = -5;
        }
        if(keyCode == e.VK_RIGHT){
            dx = 5;
        }
        if(keyCode == e.VK_UP){
            dy = -5;
        }
        if(keyCode == e.VK_DOWN){
            dy = 5;
        }
        if(keyCode == e.VK_SPACE){
            fire();
        }

    }





    public void fire(){

        missiles.add(new Antibody(x + width, y + height/2));
    }

    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode == e.VK_LEFT){
            //mengatur maksimal objek gerak
            dx = 0;
        }
        if(keyCode == e.VK_RIGHT){
            dx = 0;
        }
        if(keyCode == e.VK_UP){
            dy = 0;
        }
        if(keyCode == e.VK_DOWN){
            dy = 0;
        }
    }
}
