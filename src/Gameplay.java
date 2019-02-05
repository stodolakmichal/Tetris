package Tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private boolean play = true;
    private int score = 0;

    private int delay = 5;
    private Timer timer;

    Random random = new Random();

    private int blockposX = random.nextInt(700);
    private int blockposY = 1;
    private int blockYdir = 1;

    public Gameplay(){

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){
        //background
        g.setColor(Color.black);
        g.fillRect(1,1,700,600);

        g.setColor(Color.red);
        g.fillRect(blockposX, blockposY, 30, 70);

        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(play) {
            blockposY += blockYdir;

            if (blockposY > 495) {

                blockposX = random.nextInt(700);
                blockposY = 1;
            }


        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            blockposX+=20;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            blockposX-=20;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
