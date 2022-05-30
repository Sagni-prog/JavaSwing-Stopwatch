package com.Sagni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener {
    JFrame f = new JFrame("STOPWATCH");
    JButton startBtn = new JButton("START");
    JButton stopBtn = new JButton("STOP");
    JButton resetBtn = new JButton("RESET");
    JLabel label = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    int milliseconds = 0;
    boolean started = false;
    String second_string = String.format("%02d",seconds);
    String minute_string = String.format("%02d",minutes);
    String hour_string = String.format("%02d",hours);
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            elapsedTime+=1000;

            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/ 60000) % 60;
            seconds = (elapsedTime/1000) % 60;
          //  milliseconds = elapsedTime % 1000;

            String second_string = String.format("%02d",seconds);
            String minute_string = String.format("%02d",minutes);
            String hour_string = String.format("%02d",hours);
            String milliseconds_string = String.format("%02d",milliseconds);
            label.setText(hour_string + ":" + minute_string + ":" + second_string);


        }
    });

    public Stopwatch(){


        label.setText(hour_string + ":" + minute_string + ":" + second_string);
        label.setBounds(100,100,200,100);
        label.setFont(new Font("Verdena",Font.PLAIN,35));
        label.setBorder(BorderFactory.createBevelBorder(1));
        label.setOpaque(true);
        label.setForeground(Color.green);
        label.setBackground(new Color(0, 0, 0));
        label.setHorizontalAlignment(JTextField.CENTER);

        startBtn.setBounds(100,200,100,50);
        startBtn.setFont(new Font("v",Font.BOLD,20));
        startBtn.setForeground(Color.green);
        //startBtn.setBackground(Color.DARK_GRAY);
        startBtn.setFocusable(false);
        startBtn.addActionListener(this);



        resetBtn.setBounds(200,200,100,50);
        resetBtn.setFont(new Font("V",Font.BOLD,20));
        resetBtn.setFocusable(false);
        resetBtn.setForeground(new Color(0,255,0));
        resetBtn.addActionListener(this);

        f.add(startBtn);
        f.add(resetBtn);
        f.add(label);
        f.setBackground(new Color(0x090919));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(420,420);
        f.setLayout(null);
        f.setResizable(false);
        f.setLocationRelativeTo(null);

        f.setVisible(true);

    }
    public void start(){
        timer.start();

    }

    public void stop(){
        timer.stop();

    }

    public void reset(){
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        String second_string = String.format("%02d",seconds);
        String minute_string = String.format("%02d",minutes);
        String hour_string = String.format("%02d",hours);
        label.setText(hour_string + ":" + minute_string + ":" + second_string);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == startBtn) {
            if (started == false) {
                started = true;
                startBtn.setText("STOP");
                start();

            } else {
                started = false;
                startBtn.setText("STAT");
                stop();

            }
        }
             if(e.getSource() == resetBtn){
                 started = false;
                 startBtn.setText("START");
                 reset();


             }




    }
}
