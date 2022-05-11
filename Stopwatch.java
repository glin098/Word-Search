package wordSearch.view;

import java.awt.event.*;
import javax.swing.*;

public class Stopwatch extends JPanel// implements ActionListener
{
    JLabel timeLabel;
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    
    Timer timer = new Timer(1000, new ActionListener()
    { 
        public void actionPerformed(ActionEvent e){
        elapsedTime += 1000;
        minutes = (elapsedTime/60000) % 60;
        seconds = (elapsedTime/1000) % 60;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        timeLabel.setText(minutes_string+":"+seconds_string);
        }
    });

    public Stopwatch()
    {
		timeLabel = new JLabel();
        timeLabel.setText(minutes_string+":"+seconds_string);
        timeLabel.setBounds(100,100,200,100);
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        this.add(timeLabel);
    }
    
    public void start()
    {
        started = true;
        timer.start();
    }
    
    public void stop()
    {
        started = false;
        timer.stop();
    }
    
    public void reset()
    {
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        timeLabel.setText(minutes_string+":"+seconds_string);
    }
    
    public String getTime()
    {
        return (this.minutes_string + this.seconds_string);
    }
}
