import java.awt.*;
import javax.swing.*;

class App {
    JFrame app = new JFrame("PictoPair - Memory Game");

    App(){
        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(500, 500);
        layeredPane.setOpaque(true);
        layeredPane.setBackground(Color.red);

        JLabel bg = new JLabel();
        bg.setBounds(100, 100, 100, 100);
        bg.setBackground(Color.black);
        bg.setOpaque(true);
        layeredPane.add(bg);

        app.add(layeredPane);
        app.setVisible(true);
    }
}


class PictoPair {
    public static void main(String[] args) {
        new App();
    }
}