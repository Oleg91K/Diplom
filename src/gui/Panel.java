package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Panel extends JPanel implements ActionListener {
//делаем размер панели для игры соответственно размеру экрана
    public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
//для отслеживание событий мышки(координаты)
    public static int mouseX;
    public static int mouseY;
 //ссылки на объект класса
    private BufferedImage image;
    private Graphics2D g;
//аудио
    public static Audio a_menu;
    //cсылка на обьект Героя
    public static ArrayList<Bullet> bullets;
    public static ArrayList<Spot1> skeleton;




    Timer mainTimer = new Timer(30,this);//таймер для actionPerfomed для повторения метода
    //пока запущена игра
    Back back = new Back();
    static Player player = new Player();
    Spot1 spot1 = new Spot1(1,1);
    Spot2 spot2 = new Spot2();
    Spot3 spot3 = new Spot3();
    Menue menue = new Menue();
    Hud hud = new Hud();



    public Panel() {//конструкто класса для таймера
        super();
        setFocusable(true);
        requestFocus();
        mainTimer.start();
        image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);//создаем объект буффера для хранения картинок
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);//разглаживание текстур

        addMouseListener( new Listeners());// добавляем обработчик событий клик мышь
        addKeyListener( new Listeners());// добавляем обработчик событий клава
        addMouseMotionListener(new Listeners());//добавляем обработчик событий перемещение мышь

        a_menu = new Audio("image/menu.wav",0.68);
        skeleton = new ArrayList<Spot1>();
        bullets = new ArrayList<Bullet>();


    }
    public enum STATES{MENUE,PLAY}
    public static STATES state = STATES.MENUE;
    @Override
    public void actionPerformed(ActionEvent e) {//все что будет вызвано в этом методе будут отображено в окне
        if (state.equals(STATES.MENUE)) {
            back.draw(g);//отобразить фон
            menue.draw(g);//отобразить меню
          // a_menu.sound();//звук
            // a_menu.setVolume();//громкость
            menue.moveButt(menue.butt1);
            menue.moveButt(menue.butt2);
            menue.moveButt(menue.butt3);
            menue.moveButt(menue.butt4);
            gameDraw();//прорисовать панель
        }
        if (state.equals(STATES.PLAY)) {
            gameUpdate();//для того чтобы видеть все изменения на панеле
            gameRender();
            gameDraw();
        }
    }

        //метод для рисования объектов
        public void gameRender() {
        back.draw(g);
        player.draw(g);
        spot1.draw(g);
        spot2.draw(g);
        spot3.draw(g);
        hud.draw(g);

        hud.actionButton(hud.button1);
        hud.actionButton(hud.button2);
        hud.actionButton(hud.button3);
        hud.actionButton(hud.button4);
        hud.actionButton(hud.button5);

        for(int i =0;i < bullets.size();i++){
        bullets.get(i).draw(g);
        boolean remove = bullets.get(i).remove();
        if(remove){
            bullets.remove(i);
            i--;
            }
        }
           for(int i = 0; i<skeleton.size(); i++) {
              skeleton.get(i).draw(g);// рисуем текущего врага
            }


        }
        //все методы update отдельных объектов
        public void gameUpdate(){
        player.update();
        for (int i = 0;i < bullets.size();i++){
            bullets.get(i).update();
            spot1.update();
        }

        }
        //метод для прорисовки картинки на панеле
        private void gameDraw() {
            Graphics g2 = this.getGraphics();//переопределние метода графикс2д на графикс
            g2.drawImage(image,0,0,null);//рисование
            g2.dispose();//сборщик мусора

        }


}


