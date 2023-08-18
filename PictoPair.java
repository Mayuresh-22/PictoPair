import java.awt.*;
import javax.swing.*;
import Layout.*;

class App {
    JFrame app = new JFrame("PictoPair - Memory Game");

    App() throws InterruptedException{
        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setLayout(new BorderLayout(100, 100));

        LoadingLayout loadingLayout = new LoadingLayout();
        app.add(loadingLayout.getLoadingPanel(), BorderLayout.CENTER);

        Thread.sleep(5000);
        app.remove(loadingLayout.getLoadingPanel());
        app.setVisible(true);
    }
}


class PictoPair {
    public static void main(String[] args) {
        new App();
    }
}