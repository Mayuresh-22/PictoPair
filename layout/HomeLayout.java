package layout;

import external.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import interfaces.*;

public class HomeLayout implements ScreenStructure {
    JPanel HomePanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()),
            menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 40)),
            loadingPanel = new JPanel(new GridBagLayout());

    JLabel bg;
    JLayeredPane layeredPane = new JLayeredPane();
    JButton play, settings, quite, yes, no, musicOptionButton, gridOptionButton;
    JFrame app;
    ImageIcon musicOn, musicOff, def;
    HomeLayout thisLayout;
    MusicPlayerThread musicPlayer;
    

    public HomeLayout(JFrame app, MusicPlayerThread musicPlayer) {
        this.app = app;
        this.musicPlayer = musicPlayer;

        createLayeredPane();

        createBgPanel("assets/images/Homescreen-bg.png");

        // menu panel
        // music on/off button
        musicOn = new ImageIcon(
                new ImageIcon("assets/images/sound-on.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        musicOff = new ImageIcon(
                new ImageIcon("assets/images/sound-off.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        def = musicOn;

        createMenuPanel();

        createLoadingPanel();

        // Adding to layeredPane
        layeredPane.add(menuPanel, BorderLayout.CENTER);
        layeredPane.add(bgPanel);

        // Adding to HomePanel
        HomePanel.add(layeredPane);
        HomePanel.setOpaque(true);
    }

   

    public void getthisLayout(HomeLayout thisLayout) {
        this.thisLayout = thisLayout;
    }

    public JPanel getHomePanel() {
        return HomePanel;
    }

    @Override
    public void createLayeredPane() {
        // layered pane
        layeredPane.setSize(ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        layeredPane.setBackground(Color.GRAY);
        layeredPane.setOpaque(true);
    }

    @Override
    public void createBgPanel(String imagePath) {
        // bgPanel
        bg = new JLabel(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(ScreenStructure.WIDTH,
                ScreenStructure.HEIGHT, Image.SCALE_SMOOTH)));

        bgPanel.setBounds(0, 0, ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        bgPanel.setOpaque(true);
        bgPanel.add(bg);
    }

    public void createMenuPanel() {
        play = createButton(play, "PLAY", new Color(77, 0, 206, 255), 0, 0, 500, 100, 40);
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Loading animation
                layeredPane.remove(menuPanel);
                layeredPane.add(loadingPanel, BorderLayout.CENTER);
                layeredPane.revalidate();
                layeredPane.repaint();

                //Remove LoadingPanel after 5 seconds 
                Timer timer = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Play GameLayout
                        GameLayout gameLayout = new GameLayout(app);
                        app.remove(thisLayout.getHomePanel());
                        app.add(gameLayout.getGamePanel(), BorderLayout.CENTER);
                        app.revalidate();
                        app.repaint();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });

        settings = createButton(settings, "SETTINGS", new Color(77, 0, 206, 255), 0, 0, 500, 100, 40);
        settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Settings DialogBox
                DialogBox.createSettingsBox();
            }
        });

        quite = createButton(quite, "QUIT", new Color(77, 0, 206, 255), 0, 0, 500, 100, 40);
        quite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Quit DialogBox
                createQuitBox();
            }
        });

        // Adding to menuPanel with flow layout
        menuPanel.add(play);
        menuPanel.add(settings);
        menuPanel.add(quite);

        menuPanel.setBounds((ScreenStructure.WIDTH / 2) - 250, (ScreenStructure.HEIGHT / 2) - 250, 500, 500);
        menuPanel.setBackground(new Color(131, 0, 255, 255));
        menuPanel.setOpaque(true);
        menuPanel.setBorder(new TextBubbleBorder(new Color(131, 0, 255, 255), 10, 70, 0));
    }

    public void createLoadingPanel() {
        // logoPanel
        JLabel loadingAnim = new JLabel(new ImageIcon("assets/images/loading.gif"));
        loadingPanel.setBounds((ScreenStructure.WIDTH / 2) - 200, (ScreenStructure.HEIGHT / 2) - 200, 300, 300);
        loadingPanel.setOpaque(true);
        loadingPanel.add(loadingAnim);
    }

    public JButton createButton(JButton button, String text, Color bg, int x, int y, int width, int height,
            int fontSize) {
        button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(bg);
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, fontSize));

        return button;
    }
}