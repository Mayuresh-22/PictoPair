import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import Layout.*;

class App {
    JFrame app = new JFrame("PictoPair - Memory Game");
    LoadingLayout loadingLayout = new LoadingLayout();
    HomeLayout homeLayout = new HomeLayout();

    App(){
        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setLayout(new BorderLayout(100, 100));

        app.add(loadingLayout.getLoadingPanel(), BorderLayout.CENTER);

        // Remove LoadingPanel after 5 seconds
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.remove(loadingLayout.getLoadingPanel());
                app.revalidate();
                app.repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();
        
        app.setVisible(true);
    }
}


class PictoPair {
    public static void main(String[] args) {
        new App();
    }
}