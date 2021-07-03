package gui;

import javax.swing.*;
import java.awt.*;

public class Window {
    public static void main(String[] args) {
        JFrame game = new JFrame("Rise of Abyss");//Создаем окно с название игры
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//чтобы окно можно было закрыть(при клике)
        game.setLocation(0,0);//делаем размер экрана по умолчанию
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//присваиваем ,что окно будет
        //по размеру экрана
        game.setSize(screenSize);
       // game.setContentPane(new JPanel());//добавляем панель на фрейм
        Panel panel = new Panel();// создаём объект панель
        game.setContentPane(panel); // перенос в фрейм панели с gui.Panel
        panel.mainTimer.start();// запуск Таймера


        game.setVisible(true);//чтобы окно было видимо
    }

}
