package Tetris;


import java.awt.*;
import java.time.Year;

public class Blocks {

    public void pionowy(Graphics g, int X, int Y) {
        g.setColor(Color.RED);
        g.fillRect(X, Y, 30, 30);
        g.fillRect(X, Y + 30, 30, 30);
        g.fillRect(X, Y + 60, 30, 30);
        g.fillRect(X, Y + 90,30,30);
        g.setColor(Color.white);
        g.drawRect(X, Y, 30, 30);
        g.drawRect(X, Y + 30, 30, 30);
        g.drawRect(X, Y + 60, 30, 30);
        g.drawRect(X, Y + 90, 30, 30);
    }

    public void krzeslo(Graphics g, int X, int Y){
        g.setColor(Color.RED);
        g.fillRect(X, Y, 30,30);
        g.fillRect(X, Y+30,30,30);
        g.fillRect(X+30, Y+30, 30, 30);
        g.fillRect(X+30, Y+60, 30, 30);
        g.setColor(Color.WHITE);
        g.drawRect(X, Y, 30,30);
        g.drawRect(X, Y+30,30,30);
        g.drawRect(X+30, Y+30, 30, 30);
        g.drawRect(X+30, Y+60, 30, 30);
    }

    public void kwadrat(Graphics g, int X, int Y){
        g.setColor(Color.RED);
        g.fillRect(X, Y, 30, 30);
        g.fillRect(X+30, Y, 30, 30);
        g.fillRect(X+30, Y+30, 30, 30);
        g.fillRect(X, Y+30, 30, 30);
        g.setColor(Color.WHITE);
        g.drawRect(X, Y, 30, 30);
        g.drawRect(X+30, Y, 30, 30);
        g.drawRect(X+30, Y+30, 30, 30);
        g.drawRect(X, Y+30, 30, 30);
    }

    public void literaT(Graphics g, int X, int Y){
        g.setColor(Color.RED);
        g.fillRect(X, Y, 30, 30);
        g.fillRect(X +30, Y, 30, 30);
        g.fillRect(X+60, Y, 30, 30);
        g.fillRect(X+30, Y+30, 30, 30);
        g.setColor(Color.WHITE);
        g.drawRect(X, Y, 30, 30);
        g.drawRect(X +30, Y, 30, 30);
        g.drawRect(X+ 60, Y, 30, 30);
        g.drawRect(X+ 30, Y+30, 30, 30);
    }

    public void literaL(Graphics g, int X, int Y){
        g.setColor(Color.RED);
        g.fillRect(X, Y, 30, 30);
        g.fillRect(X, Y+30, 30, 30);
        g.fillRect(X, Y+60, 30, 30);
        g.fillRect(X+30, Y+60, 30, 30);
        g.setColor(Color.WHITE);
        g.drawRect(X, Y, 30, 30);
        g.drawRect(X, Y+30, 30, 30);
        g.drawRect(X, Y+60, 30, 30);
        g.drawRect(X+30, Y+60, 30, 30);
    }
}
