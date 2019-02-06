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

    private int[][] posX = new int[1000][4];
    private int[][] posY = new int[1000][4];

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
            num = random.nextInt(1) + 1;
            counter[x] = num;
            x++;
            flag = 1;
        }


        RandomBlock(g, num);
        Rysuj(g, num);

//        g.setColor(Color.red);
//        g.fillRect(blockposX, blockposY, 30, 30);

        g.dispose();

    }
    //Rysowanie położonych klocków
    void Rysuj(Graphics g, int num)
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


// Losowanie i początkowe rysowanie klocków
    public void RandomBlock(Graphics g, int number)
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
            for(int i=0; i<1000; i++)
            {
                for(int j=0; j<4; j++) {
                    if (num == 1 && (blockposY > 446 || blockposY == posY[i][j])){
                        Rysowanie_koncowe();
                        Zapisywanie_polozenia();
                    }

                    if ((num == 2 || num == 5) && blockposY > 476) {
                        Rysowanie_koncowe();
                    }

                    if ((num == 3 || num == 4) && blockposY > 506) {
                        Rysowanie_koncowe();
                    }
                }
            }

        }
            repaint();
    }

// Odnawianie początkowego klocka
    private void Rysowanie_koncowe() {
        blockposX2[blockCount] = blockposX;
        blockposY2[blockCount] = blockposY;
        blockposX = 400;
        blockposY = 0;
        blockCount++;
        flag = 0;
    }

    int count = 0;

    private void Zapisywanie_polozenia(){

        if(num==1) {
            posX[count][0] = blockposX;
            posY[count][0] = blockposY;
            posX[count][1] = blockposX;
            posY[count][1] = blockposY+30;
            posX[count][2] = blockposX;
            posY[count][2] = blockposY+60;
            posX[count][3] = blockposX;
            posY[count][3] = blockposY+90;
        }
        count++;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            blockposX+=30;
            if(blockposX>630)
            {
                blockposX=630;
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            blockposX-=30;
            if(blockposX<0)
            {
                blockposX=0;
            }
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
