import Tetris.Gameplay;

import javax.swing.*;

public class main {


    private static Tetris.Gameplay Gameplay;

    public static void main(String[] args) {

        JFrame obj = new JFrame();
        Gameplay = new Tetris.Gameplay();
        obj.setBounds(10,10,700,600);
        obj.setTitle("Tetris");
        obj.setResizable(false);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(Gameplay);
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);

    }
}