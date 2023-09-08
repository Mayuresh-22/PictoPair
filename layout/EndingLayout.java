package layout;

import external.*;
import javax.swing.*;
import constants.Constants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import interfaces.*;


public class EndingLayout implements ScreenStructure {
    JPanel EndingPanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()),
    menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 20)),
    loadingPanel = new JPanel(new GridBagLayout());
    JLabel bg;
    JLayeredPane layeredPane = new JLayeredPane();
    JButton play, settings, quite, yes, no, home;
    JFrame app;
    EndingLayout thisLayout;
    int matches, turns;

    public EndingLayout(JFrame app) {
        this.app = app;
        createLayeredPane();

        createBgPanel("assets/images/EndingScreen-bg.png");

        // menu panel
        createMenuPanel();

        createLoadingPanel();

        // Adding to layeredPane
        layeredPane.add(menuPanel, BorderLayout.CENTER);
        layeredPane.add(bgPanel);

        // Adding to EndingPanel
        EndingPanel.add(layeredPane);
        EndingPanel.setOpaque(true);
    }

    public void getthisLayout(EndingLayout thisLayout, int matches, int turns) {
        this.thisLayout = thisLayout;
        this.matches = matches;
        this.turns = turns;
    }

    public JPanel getEndingPanel() {
        return EndingPanel;
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

        Font headingFont = new Font(Constants.FONT_FAMILY, Font.BOLD, 45);
        JLabel headingLabel = new JLabel("GAME OVER");
        headingLabel.setFont(headingFont);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setVerticalAlignment(JLabel.CENTER);
        headingLabel.setHorizontalAlignment(JLabel.CENTER);

        Font scoreFont = new Font(Constants.FONT_FAMILY, Font.BOLD, 25);
        JLabel scoreLabel = new JLabel(
                "You matched " + GameLayout.matches + " Cards in " + (30 - GameLayout.turns) + " Turns !");
        scoreLabel.setFont(scoreFont);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setVerticalAlignment(JLabel.CENTER);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
        buttonsPanel.setBackground(null);
        buttonsPanel.setOpaque(false);

        play = createButton(play, "PLAY AGAIN", 0, 0, 200, 50, 20);
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Loading animation
                layeredPane.remove(menuPanel);
                layeredPane.add(loadingPanel, BorderLayout.CENTER);
                layeredPane.revalidate();
                layeredPane.repaint();

                // Remove LoadingPanel after 5 seconds
                Timer timer = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Play GameLayout
                        GameLayout gameLayout = new GameLayout(app);
                        GameLayout.matches = 0;
                        GameLayout.turns = 30;
                        app.remove(EndingLayout.this.getEndingPanel());
                        app.add(gameLayout.getGamePanel(), BorderLayout.CENTER);
                        app.revalidate();
                        app.repaint();
                    }
                });
                timer.setRepeats(false);
                timer.start();

            }
        });

        home = createButton(home, "HOME", 0, 0, 200, 50, 20);
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Loading animation
                layeredPane.remove(menuPanel);
                layeredPane.add(loadingPanel, BorderLayout.CENTER);
                layeredPane.revalidate();
                layeredPane.repaint();

                // Remove LoadingPanel after 5 seconds
                Timer timer = new Timer(1500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Play GameLayout
                        HomeLayout homeLayout = new HomeLayout(app, HomeLayout.musicPlayer);
                        app.remove(EndingLayout.this.getEndingPanel());
                        app.add(homeLayout.getHomePanel(), BorderLayout.CENTER);
                        app.revalidate();
                        app.repaint();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });

        quite = createButton(quite, "QUIT", 0, 0, 200, 50, 20);
        quite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Quit DialogBox
                createDialogBox();
            }
        });

        buttonsPanel.add(play);
        buttonsPanel.add(home);
        buttonsPanel.add(quite);

        // Adding to menuPanel with flow layout
        menuPanel.add(headingLabel);
        menuPanel.add(scoreLabel);
        menuPanel.add(buttonsPanel);

        menuPanel.setBounds((ScreenStructure.WIDTH / 2) - 350, (ScreenStructure.HEIGHT / 2) - 150, 700, 300);
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

    public JButton createButton(JButton button, String text, int x, int y, int width, int height, int fontSize) {
        button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(Constants.COLOR_BUTTON);
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font(Constants.FONT_FAMILY, Font.BOLD, fontSize));

        return button;
    }

    // Dialog Box for Quit function
    public void createDialogBox() {
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
        message.setFont(new Font(Constants.FONT_FAMILY, Font.BOLD, 30));
        message.setForeground(Constants.COLOR_PRIMARY);
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);

        JButton yes = new JButton();
        yes = createButton(yes, "YES", 0, 0, 200, 100, 30);
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
        no = createButton(no, "NO", 0, 0, 200, 100, 30);
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
        buttonPanel.setBackground(null);
        buttonPanel.setOpaque(true);

        dialog.add(message, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

}