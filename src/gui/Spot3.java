import javax.swing.*;
import java.awt.*;

public class Spot3 {
    //координаты пложения игрока на панели
    private double x;//координаты х героя
    private double y;//координаты y героя
    private double h;//высота объекта
    private double w;//ширина объекта
    private int speed;//скорость перемещения игрока

    //передаем картинку героя
    Image img1 = new ImageIcon("image/dragonbig.png").getImage();//загрузка картинки


    public Spot3() {
        //начальные координаты героя
        x = 1020;
        y = 550;
        //размеры картинки героя
        w = 142;
        h = 229;
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

    //обновления
    public void update () {

    }
    //отрисовка героя
    public void draw (Graphics2D g){//прорисовка в графикc2д
        g.drawImage(img1, (int) x, (int) y, null);

    }
}

