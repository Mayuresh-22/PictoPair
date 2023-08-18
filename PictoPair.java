import java.awt.*;
import javax.swing.*;
import Layout.*;

class App {
    JFrame app = new JFrame("PictoPair - Memory Game");
    LoadingLayout loadingPanel = new LoadingLayout();

    App(){
        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(loadingPanel.getLoadingPanel());
    }
}


class PictoPair {
    public static void main(String[] args) {
        
    }
}