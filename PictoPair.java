import java.awt.*;
import java.awt.event.*;

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

        // Timer timer = new Timer(5000, new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         app.remove(loadingLayout.getLoadingPanel());
        //     }
        // });
        // timer.setRepeats(false);
        // timer.start();
    }
}


class PictoPair {
    public static void main(String[] args) throws InterruptedException {
        new App();
    }
}