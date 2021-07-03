package gui;

import java.awt.event.*;

//для контроля событий и перемещния мышки
public class Listeners implements MouseListener, KeyListener, MouseMotionListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }
    //проверка нажатой клавиши
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();//получаем код нажатой клавиши
        if (key == KeyEvent.VK_W){
            Player.up = true;
        }
        if(key == KeyEvent.VK_S){
            Player.down = true;
        }
        if( key == KeyEvent.VK_A){
            Player.left = true;
        }
        if(key == KeyEvent.VK_D){
            Player.right = true;
        }
        if(key == KeyEvent.VK_ESCAPE){//если мы нажимаем кнопку ESCAPE то мы переходим из игры в меню
            if(Panel.state == Panel.STATES.PLAY)Panel.state = Panel.STATES.MENUE;
        }
        if(key == KeyEvent.VK_1){
            Player.isFiring = true;
        }
    }
    //проверка отжатой клавиши
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();//получаем код нажатой клавиши
        if (key == KeyEvent.VK_W) {
            Player.up = false;
        }
        if (key == KeyEvent.VK_S) {
            Player.down = false;
        }
        if (key == KeyEvent.VK_A) {
            Player.left = false;
        }
        if (key == KeyEvent.VK_D) {
            Player.right = false;
        }
        if(key == KeyEvent.VK_1){
            Player.isFiring = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {

            if (Panel.state == Panel.STATES.MENUE) {
                Menue.click = true;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {

            if (Panel.state == Panel.STATES.MENUE) {
                Menue.click = false;
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
    //перемещение мышки по панели
    @Override
    public void mouseMoved(MouseEvent e) {
        Panel.mouseX = e.getX();//получить координату х при перемещение мыши
        Panel.mouseY = e.getY();//получить координату y при перемещение мыщи

    }
}
