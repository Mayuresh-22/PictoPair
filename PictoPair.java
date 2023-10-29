import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.*;
import external.*;


class App {
    public JFrame app = new JFrame("PictoPair - Memory Game");
    LoadingLayout loadingLayout = new LoadingLayout();
    MusicPlayerThread soundEffect = new MusicPlayerThread();
    MusicPlayerThread musicPlayer = new MusicPlayerThread();
    HomeLayout homeLayout = new HomeLayout(app, musicPlayer);
    App(){
        appConfig();
        app.add(loadingLayout.getLoadingPanel(), BorderLayout.CENTER);
        soundEffect.filePath = "assets/sounds/intro.wav";
        soundEffect.loop = false;
        soundEffect.start();
        // Remove LoadingPanel after 5 seconds
        Timer timer = new Timer(4900, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.remove(loadingLayout.getLoadingPanel());
                app.add(homeLayout.getHomePanel(), BorderLayout.CENTER);
                homeLayout.getthisLayout(homeLayout);
                app.revalidate();
                app.repaint();
                musicPlayer.filePath = "assets/sounds/bgm.wav";
                musicPlayer.loop = true;
                musicPlayer.start();
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
        app.setIconImage(new ImageIcon("assets/images/card-back.png").getImage());

         // Add a key listener to the JFrame
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Not needed, but required by the KeyListener interface
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Check if the "Escape" key was pressed (key code 27)
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    // Minimize the JFrame
                    frame.setState(Frame.ICONIFIED);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not needed, but required by the KeyListener interface
            }
        });
        
        // Ensure the JFrame can receive key events by requesting focus
        frame.requestFocusInWindow();
    }
}

public class PictoPair {
    public static App mainApp;
    public static void main(String[] args) {
       mainApp = new App();
       
    }
}