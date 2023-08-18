import java.awt.*;
import javax.swing.*;

class App {
    JFrame app = new JFrame("PictoPair - Memory Game");

    App(){
        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setLayout(null);
        app.add(new LoadingLayout().getLoadingPanel());
        app.setVisible(true);
    }
}


class PictoPair {
    public static void main(String[] args) {
        new App();
    }
}