package gui;

import java.awt.*;

public class Bullet {
    private double x;
    private double y;
    private int r;
    private Color color;
    private int speed;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Bullet(){
        //x = Panel.player.getX();
        //y = Panel.player.getY();
        x = 350;
        y = 660;
        r = 10;
        color = Color.ORANGE;
        speed = 10;
    }
    public boolean remove(){
        if(y<0){
            return true;
        }
        return false;
    }
    public void update(){
        x+=speed;

    }
    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval((int)x,(int)y,r,2*r);
    }

}
