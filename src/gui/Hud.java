package gui;

import javax.swing.*;
import java.awt.*;

public class Hud {
    public static boolean click = false;//клик мышкой в режиме меню

    Hud.ButtHud button1 = new Hud.ButtHud(300, 835, 120, -30, "image/orange.png", "Атака");
    Hud.ButtHud button2 = new Hud.ButtHud(600, 835, 120, -30, "image/orange.png", "Жизнь");
    Hud.ButtHud button3 = new Hud.ButtHud(300, 930, 300, -15, "image/orange.png", "Cпециальные атаки");
    Hud.ButtHud button4 = new Hud.ButtHud(450, 930, 180, -15, "image/orange.png", "");
    Hud.ButtHud button5 = new Hud.ButtHud(600, 930, 180, -15, "image/orange.png", "");


    public void draw(Graphics2D g) {
        button1.draw(g);
        button2.draw(g);
        button3.draw(g);
        button4.draw(g);
        button5.draw(g);


    }

    //попадание курсора на кнопки в игре
    void actionButton(Hud.ButtHud e) {
        if (Panel.mouseX > e.getX() && Panel.mouseX < e.getX() + e.getW() && Panel.mouseY > e.getY() && Panel.mouseY < e.getY() + e.getH()) {
            e.s = "image/orange.png";
            if (e.equals(button1)) { e.f = "Attack";}
            if (e.equals(button2)) { e.f = "Restore HP";}
            if (e.equals(button3)) { e.f = "Special Attack";}
            if (e.equals(button4)) { }
            if (e.equals(button5)) { }
        } else {
            e.s = "image/orange.png";
            if (e.equals(button1)) { e.f = "Атака"; }
            if (e.equals(button2)) { e.f = "Жизнь"; }
            if (e.equals(button3)) { e.f = "Специальные атаки";}
            if (e.equals(button4)) { e.f = ""; }
            if(e.equals(button5))   {e.f = "";}
        }
    }


    class ButtHud {
        //начальные координаты и размер объекта
        private double x;
        private double y;
        private double w;//ширина объекта
        private double h;//высота объекта
        public Color color1;//цвет
        public String f;//надпись над кнопкой
        public String s;//строка адреса картинки

        public ButtHud(double x, double y, double w, double h, String s, String f) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.f = f;
            this.s = s;
            this.color1 = Color.WHITE;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getW() {
            return w;
        }

        public double getH() {
            return h;
        }

        public void draw(Graphics2D g) {
            g.drawImage( new ImageIcon(s).getImage(), (int)x,(int) y, null);//отрисовываем элемент в координатах
            g.setColor(color1);//задаем цвет объекту Соlor
            Font font = new Font("Arial",Font.ITALIC,25);//Создём объект класса фонт (передаем в конструктор параметры)
            g.setFont(font);//устанвливаем наш шрифт

            long length = (int) g.getFontMetrics().getStringBounds(f,g).getWidth();// длина надписи в пиксилях
            g.drawString(f,(int)(x+w/2) - (int)(length / 5),(int)y+(int)(h/ 3)*2);// рисуем строчку в це
        }
    }
}

