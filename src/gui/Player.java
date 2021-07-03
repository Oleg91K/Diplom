package gui;

import javax.swing.*;
import java.awt.*;

public class Player {
    //координаты пложения игрока на панели
    private double x;//координаты х героя
    private double y;//координаты y героя
    private double h;//высота объекта
    private double w;//ширина объекта
    private int speed;//скорость перемещения игрока

    //переменные разрешающие передвижения игрока
    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;
    public static boolean isFiring;
    //передаем картинку героя
    Image img = new ImageIcon("image/knightbig.png").getImage();//загрузка картинки



    public Player() {
        //начальные координаты героя
        x = 250;
        y = 430;
        //размеры картинки героя
        w = 142;
        h = 229;
        speed = 5;//скорость перемещния героя
        //начальные значения клавиш
        up = false;
        down = false;
        left = false;
        right = false;
        isFiring = false;
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

    //определяет законы движения героя
    public void update () {
        if (up && y > 20) {
            y -= speed;
        }
        if (down && y < Panel.HEIGHT - h) {
            y += speed;
        }
        if (left && x > 0) {
            x -= speed;
        }
        if (right && x < Panel.WIDTH - w) {
            x += speed;
        }
        if (isFiring) {
            Panel.bullets.add(new Bullet());
        }

    }
    //отрисовка героя
    public void draw (Graphics2D g){//прорисовка в графикc2д
        g.drawImage(img, (int) x, (int) y, null);

    }
}

