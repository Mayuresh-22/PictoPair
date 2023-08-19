import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import Layout.*;

class App {
    JFrame app = new JFrame("PictoPair - Memory Game");
    LoadingLayout loadingLayout = new LoadingLayout();
    HomeLayout homeLayout = new HomeLayout();

    App(){
        appConfig();
        app.add(loadingLayout.getLoadingPanel(), BorderLayout.CENTER);

        // Remove LoadingPanel after 5 seconds
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.remove(loadingLayout.getLoadingPanel());
                app.add(homeLayout.getHomePanel(), BorderLayout.CENTER);
                app.revalidate();
                app.repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();
        
        app.setVisible(true);
    }

    // app configuration
    public void appConfig(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setMinimumSize(screenSize);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setLayout(new BorderLayout(100, 100));
        app.setIconImage(new ImageIcon("assets/card-back.png").getImage());
    }

}


class PictoPair {
    public static void main(String[] args) {
        new App();
    }
}
