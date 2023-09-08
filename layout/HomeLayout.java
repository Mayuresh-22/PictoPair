package layout;

import constants.Constants;
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
    ImageIcon musicOn, musicOff;
    HomeLayout thisLayout;
    public static MusicPlayerThread musicPlayer;
    

    public HomeLayout(JFrame app, MusicPlayerThread musicPlayer) {
        this.app = app;
        HomeLayout.musicPlayer = musicPlayer;

        createLayeredPane();

        createBgPanel("assets/images/Homescreen-bg.png");

        // menu panel
        // music on/off button
        musicOn = new ImageIcon(
                new ImageIcon("assets/images/sound-on.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        musicOff = new ImageIcon(
                new ImageIcon("assets/images/sound-off.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

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
        play = createButton(play, "PLAY", Constants.COLOR_BUTTON, 0, 0, 500, 100, 40);
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
                        app.remove(getHomePanel());
                        app.add(gameLayout.getGamePanel(), BorderLayout.CENTER);
                        app.revalidate();
                        app.repaint();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });

        settings = createButton(settings, "SETTINGS", Constants.COLOR_BUTTON, 0, 0, 500, 100, 40);
        settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Settings DialogBox
                createSettingsBox();
            }
        });

        quite = createButton(quite, "QUIT", Constants.COLOR_BUTTON, 0, 0, 500, 100, 40);
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
        menuPanel.setBackground(Constants.COLOR_PRIMARY);
        menuPanel.setOpaque(true);
        menuPanel.setBorder(new TextBubbleBorder(Constants.COLOR_PRIMARY, 10, 70, 0));
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

    // Settings Box Function
    public void createSettingsBox() {
        layeredPane.remove(menuPanel);
        layeredPane.revalidate();
        layeredPane.repaint();

        // Settings Box
        JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(800, 500);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout());
        dialog.setUndecorated(true);
        dialog.setBackground(Constants.COLOR_PRIMARY);
        dialog.getRootPane().setBorder(new TextBubbleBorder(Constants.COLOR_PRIMARY, 4, 70, 0));

        JLabel message = new JLabel("SETTINGS");
        message.setFont(new Font("Arial", Font.BOLD, 30));
        message.setForeground(Constants.COLOR_PRIMARY);
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);

        // Setting Options Panel
        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 70, 15));
        JPanel gridOptionPanel = new JPanel(new FlowLayout());
        JPanel musicOptionPanel = new JPanel(new FlowLayout());

        JLabel gridOptionLabel = new JLabel("Grid Size: ");
        gridOptionLabel.setFont(new Font("Arial", Font.BOLD, 25));
        gridOptionLabel.setForeground(Color.WHITE);
        gridOptionLabel.setHorizontalAlignment(JLabel.CENTER);
        gridOptionLabel.setVerticalAlignment(JLabel.CENTER);

        JLabel musicOptionLabel = new JLabel("Music: ");
        musicOptionLabel.setFont(new Font("Arial", Font.BOLD, 25));
        musicOptionLabel.setForeground(Color.WHITE);
        musicOptionLabel.setHorizontalAlignment(JLabel.CENTER);
        musicOptionLabel.setVerticalAlignment(JLabel.CENTER);

        // grid size button
        gridOptionButton = createButton(gridOptionButton, "3x3", Constants.COLOR_BUTTON, 0, 0, 200, 100, 20);

        // music on/off button
        musicOptionButton = createButton(musicOptionButton, "", null, 0, 0, 200, 100, 20);
        musicOptionButton.setIcon(Constants.defaultMusicIcon);
        musicOptionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (musicOptionButton.getIcon().equals(musicOn)) {
                    musicOptionButton.setIcon(musicOff);
                    Constants.defaultMusicIcon = musicOff;
                    synchronized (musicPlayer) {
                        try {
                            musicPlayer.stopMusic();
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                } else {
                    musicOptionButton.setIcon(musicOn);
                    Constants.defaultMusicIcon = musicOn;
                    synchronized (musicPlayer) {
                        musicPlayer.startMusic();
                    }
                }
            }
        });

        gridOptionPanel.add(gridOptionLabel);
        gridOptionPanel.add(gridOptionButton);
        gridOptionPanel.setBackground(Constants.COLOR_PRIMARY);

        musicOptionPanel.add(musicOptionLabel);
        musicOptionPanel.add(musicOptionButton);
        musicOptionPanel.setBackground(Constants.COLOR_PRIMARY);

        optionsPanel.add(gridOptionPanel);
        optionsPanel.add(musicOptionPanel);
        optionsPanel.setBackground(Constants.COLOR_PRIMARY);

        JButton back = new JButton();
        back = createButton(back, "BACK", Constants.COLOR_BUTTON, 0, 0, 200, 100, 20);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                menuPanel.setBorder(new TextBubbleBorder(Constants.COLOR_PRIMARY, 10, 70, 0));
                layeredPane.remove(bgPanel);
                layeredPane.add(menuPanel);
                layeredPane.add(bgPanel);
                layeredPane.repaint();
                layeredPane.revalidate();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
        buttonPanel.add(back);
        buttonPanel.setBackground(Constants.COLOR_PRIMARY);
        buttonPanel.setOpaque(true);

        dialog.add(message, BorderLayout.NORTH);
        dialog.add(optionsPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    // Dialog Box for Quit function
    public void createQuitBox() {
        layeredPane.remove(menuPanel);
        layeredPane.repaint();

        // dialog box to ask confirmation to quit
        JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(500, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout());
        dialog.setUndecorated(true);
        dialog.getRootPane().setBorder(new TextBubbleBorder(Constants.COLOR_PRIMARY, 4, 20, 0));

        JLabel message = new JLabel("Are you sure you want to quit?");
        message.setFont(new Font("Arial", Font.BOLD, 30));
        message.setForeground(Constants.COLOR_PRIMARY);
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);

        JButton yes = new JButton();
        yes = createButton(yes, "YES", Constants.COLOR_BUTTON, 0, 0, 200, 100, 20);
        yes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.setText("Thank you for playing! Exiting...");
                Timer t = new Timer(1500, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                t.setRepeats(false);
                t.start();
            }
        });

        JButton no = new JButton();
        no = createButton(no, "NO", Constants.COLOR_BUTTON, 0, 0, 200, 100, 20);
        no.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                menuPanel.setBorder(new TextBubbleBorder(Constants.COLOR_PRIMARY, 10, 70, 0));
                layeredPane.remove(bgPanel);
                layeredPane.add(menuPanel);
                layeredPane.add(bgPanel);
                layeredPane.repaint();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
        buttonPanel.add(yes);
        buttonPanel.add(no);
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setOpaque(true);

        dialog.add(message, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
}