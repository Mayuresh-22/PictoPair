import java.awt.*;
import javax.swing.*;
import Layout.*;

class App {
    JFrame app = new JFrame("PictoPair - Memory Game");
    JPanel appPane = new JPanel(new BorderLayout());
    LoadingLayout loadingPanel = new LoadingLayout();

    App(){
        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLayout(new BorderLayout());
        // creating panel
        appPane.add(loadingPanel.getLoadingPanel())
        app.add(loadingPanel.getLoadingPanel(), BorderLayout.CENTER);
        app.setVisible(true);
    }
}


class PictoPair {
    public static void main(String[] args) {
        new App();
    }
}