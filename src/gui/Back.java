package gui;

import javax.swing.*;
import java.awt.*;

public class Back {//задний фон игровой панели
    Image img = new ImageIcon("image/fonfinal.png").getImage();//загрузка картинки фон игры
    Image imgmenue = new ImageIcon("image/fonb.jpg").getImage();//загрузка картинки фон меню

    public void draw(Graphics2D g){//прорисовка в графикc2д
            g.drawImage(img, (int) 0, (int) 0, null);
            g.drawImage(imgmenue,(int) 0, (int) 0, null);
            if(Panel.state.equals(Panel.STATES.MENUE)) g.drawImage(imgmenue,(int)0,(int)0,null);////отрисовываем
            if(Panel.state.equals(Panel.STATES.PLAY)) g.drawImage(img,(int)0,(int)0,null);////отрисовываем элемент в координатах


    }

}