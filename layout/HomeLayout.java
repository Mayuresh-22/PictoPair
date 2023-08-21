package layout;

import external.*;
import javax.swing.*;
import java.awt.*;
import interfaces.*;

public class HomeLayout implements ScreenStructure {
    JPanel HomePanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), menuPanel = new JPanel();
    JLabel bg;
    JLayeredPane layeredPane = new JLayeredPane();
    JButton play, settings, quite;

    public HomeLayout(){
        createLayeredPane();

        createBgPanel("assets/images/Homescreen-bg.png");

        // menu panel
        createMenuPanel();

        // Adding to layeredPane
        layeredPane.add(menuPanel, BorderLayout.CENTER);
        layeredPane.add(bgPanel);

        // Adding to HomePanel
        HomePanel.add(layeredPane);
        HomePanel.setOpaque(true);
    }

    public JPanel getHomePanel() {
        return HomePanel;
    }

    @Override
    public void createLayeredPane(){
        // layered pane
        layeredPane.setSize(ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        layeredPane.setBackground(Color.GRAY);
        layeredPane.setOpaque(true);
    }

    @Override
    public void createBgPanel(String imagePath){
        // bgPanel
        bg = new JLabel(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(ScreenStructure.WIDTH, ScreenStructure.HEIGHT, Image.SCALE_SMOOTH)));

        bgPanel.setBounds(0, 0, ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        bgPanel.setOpaque(true);
        bgPanel.add(bg);
    }

    public void createMenuPanel(){
        // create buttons
        play = new JButton("Play");
        settings = new JButton("Settings");
        quite = new JButton("Quite");

        // play button
        play.setBounds((ScreenStructure.WIDTH/2)-100, (ScreenStructure.HEIGHT/2)-100, 200, 50);
        play.setBackground(new Color(131,0,255,255));
        play.setOpaque(true);
        play.setBorderPainted(false);
        play.setFocusPainted(false);
        play.setForeground(Color.WHITE);
        // play.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         playActionPerformed(evt);
        //     }
        // });

        // settings button
        settings.setBounds((ScreenStructure.WIDTH/2)-100, (ScreenStructure.HEIGHT/2)-25, 200, 50);
        settings.setBackground(new Color(131,0,255,255));
        settings.setOpaque(true);
        settings.setBorderPainted(false);
        settings.setFocusPainted(false);
        settings.setForeground(Color.WHITE);


        // quite button
        quite.setBounds((ScreenStructure.WIDTH/2)-100, (ScreenStructure.HEIGHT/2)+50, 200, 50);
        quite.setBackground(new Color(131,0,255,255));
        quite.setOpaque(true);
        quite.setBorderPainted(false);
        quite.setFocusPainted(false);
        quite.setForeground(Color.WHITE);
        quite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        // Adding to menuPanel
        menuPanel.add(play);
        menuPanel.add(settings);
        menuPanel.add(quite);

        menuPanel.setBounds((ScreenStructure.WIDTH/2)-250, (ScreenStructure.HEIGHT/2)-250, 500, 500);
        menuPanel.setBackground(new Color(131,0,255,255));
        menuPanel.setOpaque(true);
        menuPanel.setBorder(new TextBubbleBorder(new Color(131,0,255,255), 10, 70, 0));
    }
}