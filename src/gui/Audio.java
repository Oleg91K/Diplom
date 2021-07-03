package gui;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {
    private String track;//адреса трека(файл)
    private Clip clip = null;//ссылка на объект клипа
    private FloatControl volumeC = null;//контроллер громкости
    private double wt;//уровень громкости

    public Audio(String track, double wt) {
        this.track = track;
        this.wt = wt;
    }

    public void sound() {
        File f = new File(this.track);//передаем звуковой файл в переменную f
        //поток для записи и считывания
        AudioInputStream tr = null;//объект потока
        try {
            tr = AudioSystem.getAudioInputStream(f);//получаем стрим(нужного файла)
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();//получаем реализацию клипа
            clip.open(tr);//загружаем звуковой поток в Clip
            //Контроллер громкости
            volumeC = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            clip.setFramePosition(0);//устаналиваем указатель на старт
            clip.start();//воспроизведение
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //уровень громкости
    public void setVolume(){
        if(wt<0) wt = 0;
        if(wt>1) wt =1;
        float min = volumeC.getMinimum();
        float max = volumeC.getMaximum();
        volumeC.setValue((max - min)*(float)wt+min);
    }
}
