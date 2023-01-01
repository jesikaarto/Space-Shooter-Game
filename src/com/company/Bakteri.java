package com.company;

public class Bakteri extends jalan{
    private final int INITIAL_X = 1000;
    private model command;
    public Bakteri(int x,int y){
        super(x,y);
        initAlien();
    }
    public void initAlien(){
        loadImage("src/img/virus3.png");
        getImageDimensions();

    }
    public void Explosion(){
        loadImage("src/img/explosion.png");
        getImageDimensions();


    }
    public void move(){
        if(x < 0){
            x = INITIAL_X;
        }
        x -= 3;
    }
    public void move2(){
        if (x < 0){
            x = INITIAL_X;
        }
        x -= 5;
    }

}
