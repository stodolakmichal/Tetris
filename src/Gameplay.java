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

    private int delay = 1;
    private Timer timer;

    Random random = new Random();

    private int blockposX = 400;
    private int blockposY = 0;
    private int blockYdir = 4;
    private int blockCount = 0;
    private int[] blockposX2 = new int[1000];
    private int[] blockposY2 = new int[1000];

    private int num =0;

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

        Rysuj(g, num);

        num = random.nextInt(1)+1;

        RandomBlock(g, num);

//        g.setColor(Color.red);
//        g.fillRect(blockposX, blockposY, 30, 30);

        g.dispose();

    }
    public void Rysuj(Graphics g, int num)
    {
        for(int i=0; i<blockCount; i++) {
            if (num == 1 || num == 2) {
                g.setColor(Color.red);
                g.fillRect(blockposX2[i], blockposY2[i], 30, 30);
                g.fillRect(blockposX2[i], blockposY2[i] + 30, 30, 30);
            }
        }
    }

    public void RandomBlock(Graphics g, int number)
    {
        if(number == 1)
        {
            g.setColor(Color.RED);
            g.fillRect(blockposX,blockposY,30,30);
            g.fillRect(blockposX,blockposY+30,30,30);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(play) {
            blockposY += blockYdir;
            if(num==1 || num==2) {
                if (blockposY > 506) {
                    blockposX2[blockCount] = blockposX;
                    blockposY2[blockCount] = blockposY;
                    blockposX = 400;
                    blockposY = 0;
                    blockCount++;
                }
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
            blockposX+=30;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            blockposX-=30;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            blockYdir=4;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            blockYdir=4;
        }

    }

}
