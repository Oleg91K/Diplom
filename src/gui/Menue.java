package gui;

import javax.swing.*;
import java.awt.*;

public class Menue {

    public static boolean click = false;//клик мышкой в режиме меню

    ButtMenue butt1 = new ButtMenue(60,400,180,200,"image/but.png","Играть");
    ButtMenue butt2 = new ButtMenue(60,530,140,200,"image/but.png","Сохранить игру");
    ButtMenue butt3 = new ButtMenue(60,650,140,200,"image/but.png","Загрузить игру");
    ButtMenue butt4 = new ButtMenue(60,770,180,200,"image/but.png","Выход");

    public void draw(Graphics2D g){
        butt1.draw(g);
        butt2.draw(g);
        butt3.draw(g);
        butt4.draw(g);
    }
    //попадание курсора на кнопку меню
    void moveButt(Menue.ButtMenue e){
        if(Panel.mouseX > e.getX() && Panel.mouseX < e.getX() + e.getW() && Panel.mouseY > e.getY() && Panel.mouseY < e.getY() + e.getH()){
            e.s = "image/but2.png";
            if(e.equals(butt1)) {
                e.f = "Start";
                if (Menue.click) {
                    Panel.state = Panel.STATES.PLAY;//переход в игру
                    Menue.click = false;
                }
            }
            if(e.equals(butt2)){e.f = "Save game";}
            if(e.equals(butt3)){e.f = "Load game";}
            if(e.equals(butt4)) {
                e.f = "Exit";
                if (Menue.click) {
                    System.exit(0);
                }
            }
        }else{
            e.s = "image/but.png";
            if(e.equals(butt1)){e.f = "Играть";}
            if(e.equals(butt2)){e.f = "Сохранить игру";}
            if(e.equals(butt3)){e.f = "Загрузить игру";}
            if(e.equals(butt4)){e.f = "Выйти";}
        }
    }

    class ButtMenue {
        //начальные координаты и размер объекта
        private double x;
        private double y;
        private double w;//ширина объекта
        private double h;//высота объекта
        public Color color1;//цвет
        public String f;//надпись над кнопкой
        public String s;//строка адреса картинки

        public ButtMenue(double x, double y, double w, double h, String s, String f) {
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
