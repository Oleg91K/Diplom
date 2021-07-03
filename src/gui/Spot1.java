package gui;

import units.Hero;

import javax.swing.*;
import java.awt.*;

public class Spot1 {
    //координаты пложения игрока на панели
    private double x;//координаты х героя
    private double y;//координаты y героя
    private double h;//высота объекта
    private double w;//ширина объекта
    private int r;
    private int type;
    private int rank;
    private double speed;
    private double dx;
    private double dy;

    private int atack;//величина урона
    private int armor;//защита
    private int hp;//здоровье
    private int mp;//мана

    public Spot1(int type) {
        this.type = type;
    }

//переменные разрешающие передвижения игрока
   // public static boolean attack;


    //передаем картинку героя
    Image img1 = new ImageIcon("image/skeletonbig.png").getImage();//загрузка картинки


    public Spot1(int type,int rank) {
        //начальные координаты героя
        x = 1200;
        y = 425;
        //размеры картинки героя
        w = 142;
        h = 229;
        atack = 100;
        armor = 800;
        hp = 1000;
        mp = 400;
        this.type = type;
        this.rank = rank;
        switch (type){
            case(1):switch (rank){
                case (1):
                x= 1200;
                y=425;
                speed =1;
                hp=1000;
                double angle = Math.toRadians(Math.random()*360);
                dx=Math.sin(angle)*speed;
                dy=Math.cos(angle)*speed;
            }
        }

    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getH() {
        return h;
    }

    public double getW() {
        return w;
    }

    public int getAtack() {
        return atack;
    }

    public int getArmor() {
        return armor;
    }


    public int getMp() {
        return mp;
    }
    public void hit(){
        hp--;
    }
    public boolean remove(){
        if(hp<=0){
            return true;
        }
        return false;
    }

    //обновляет
    public void update () {
        x +=dx;
        y +=dy;
        if(x<100 && dx<0) dx = -dx;
        if(x>Panel.WIDTH+100 && dx>0)dx = -dx;
        if(y<-150 && dy<0) dy = -dy;
        if(y>Panel.HEIGHT+150 && dy>0)dy = -dy;

    }
    //отрисовка героя
    public void draw (Graphics2D g){//прорисовка в графикc2д
        g.drawImage(img1, (int) x, (int) y, null);


    }
}

