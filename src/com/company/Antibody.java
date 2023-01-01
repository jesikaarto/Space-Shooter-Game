package com.company;

public class Antibody extends jalan{
    private final int BOARD_WIDTH = 750;
    private final int MISSILE_SPEED = 6;
    public Antibody(int x, int y){
        super(x,y);
        initMissile();
    }

    private void initMissile(){
        loadImage("src/img/antibody1.png");
        getImageDimensions();

    }
    public void move(){
        x += MISSILE_SPEED;
        if (x> BOARD_WIDTH){
            visible = (false);
        }
        if(x<= 0)
            visible=false;
        if(x >= 550)
            visible=false;


    }
}
