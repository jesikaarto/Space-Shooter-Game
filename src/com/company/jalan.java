package com.company;

import javax.swing.*;
import java.awt.*;

public class jalan {
    protected int x, y , width, height;
    protected boolean visible;
    protected Image image;

    public jalan(int x, int y){
        this.x = x;
        this.y = y;
        visible=true;
    }
    protected void getImageDimensions(){
        width = image.getWidth(null);
        height = image.getHeight(null);
    }
    protected void loadImage(String gambar){
        ImageIcon ii = new ImageIcon(gambar);
        image = ii.getImage();
    }
    protected Image getImage(){

        return image;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public boolean isVisible(){
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public Rectangle getBounds(){
        return new Rectangle(x, y, width,height);
    }
}
