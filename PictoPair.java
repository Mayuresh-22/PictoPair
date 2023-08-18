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

        new ActionListener() {
            Timer timer = new Timer(1000, new ActionListener() {
                int i = 0;
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(i == 3){
                        timer.stop();
                    }
                    i++;
                }
            });
            {
                timer.start();
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                app.remove(loadingLayout.getLoadingPanel());
                app.add(new HomeLayout().getHomePanel(), BorderLayout.CENTER);
                app.revalidate();
                app.repaint();
            }
        }.actionPerformed(null);
        app.setVisible(true);
    }
}


class PictoPair {
    public static void main(String[] args) throws InterruptedException {
        new App();
    }
}