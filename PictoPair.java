import java.awt.*;
import javax.swing.*;
import Layout.*;

class App {
    JFrame app = new JFrame("PictoPair - Memory Game");

    App(){
        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(500, 500);
        layeredPane.setBackground(Color.gray);
        layeredPane.setOpaque(true);

        app.add(layeredPane);
        app.setVisible(true);
    }
}


class PictoPair {
    public static void main(String[] args) {
        new App();
    }
}