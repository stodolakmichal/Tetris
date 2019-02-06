package Tetris;

import Tetris.Blocks;

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

    private int delay = 3;
    private Timer timer;

    Random random = new Random();
    Blocks blocks = new Blocks();

    private int blockposX = 400;
    private int blockposY = 0;
    private int blockYdir = 1;
    private int blockCount = 0;
    private int[] blockposX2 = new int[1000];
    private int[] blockposY2 = new int[1000];
    int flag = 0;
    int x=0;
    private int[] counter = new int [1000];
    private int[] hiredblockposX = new int[1000];
    private int[] hiredblockposY = new int[1000];

    private int[][] position = new int [1000][1000];

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

        if(flag == 0)
        {
            num = random.nextInt(5) + 1;
            counter[x] = num;
            x++;
            flag = 1;
        }

        Rysuj(g, num);

        RandomBlock(g, num);

//        g.setColor(Color.red);
//        g.fillRect(blockposX, blockposY, 30, 30);

        g.dispose();

    }
    public void Rysuj(Graphics g, int num)
    {
        for(int i=0; i<blockCount; i++) {
            if (counter[i] ==1) {
                blocks.pionowy(g, blockposX2[i], blockposY2[i]);
            }

            if (counter[i] == 2) {
                blocks.krzeslo(g, blockposX2[i], blockposY2[i]);
            }

            if (counter[i] == 3){
                blocks.kwadrat(g, blockposX2[i], blockposY2[i]);
            }

            if (counter[i] == 4) {
                blocks.literaT(g, blockposX2[i], blockposY2[i]);
            }

            if(counter[i] == 5){
                blocks.literaL(g, blockposX2[i], blockposY2[i]);
            }
        }
    }



    public void RandomBlock(Graphics g, int number) //
    {
        if(number == 1)
        {
            blocks.pionowy(g, blockposX, blockposY);
        }

        if(number == 2)
        {
            blocks.krzeslo(g, blockposX, blockposY);
        }

        if(number == 3)
        {
            blocks.kwadrat(g, blockposX, blockposY);
        }

        if(number == 4)
        {
            blocks.literaT(g, blockposX, blockposY);
        }

        if(number == 5)
        {
            blocks.literaL(g, blockposX, blockposY);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (play) {
            blockposY += blockYdir;
            for(int i=0; i<blockCount+1; i++)
                {
                if (num == 1 && (blockposY > 446 || blockposX2[i]==blockposX || blockposY2[i] == blockposY)){
                        Rysowanie_koncowe();

                }

                if (num == 2 || num == 5 && (blockposX2[i]==blockposX || blockposY2[i] == blockposY || blockposY > 476)) {
                        Rysowanie_koncowe();
                    }


                if(num==3 || num==4 && (blockposY > 506 || blockposX2[i]==blockposX || blockposY2[i] == blockposY)) {
                        Rysowanie_koncowe();
                }
            }

        }
            repaint();
    }

    private void Rysowanie_koncowe() {
        blockposX2[blockCount] = blockposX;
        blockposY2[blockCount] = blockposY;
        blockposX = 400;
        blockposY = 0;
        blockCount++;
        flag = 0;
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
            blockYdir=1;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            blockYdir=1;
        }

    }

}
