package layout;

import external.*;
import javax.swing.*;
import java.awt.*;
import interfaces.*;

public class HomeLayout implements ScreenStructure {
    JPanel HomePanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,50, 40));
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
        // create buttons one below other with background color 77,0,206,255 and text color white
        // with internal padding 10px and external padding 70px, bigger buttons

        // play button
        play = new JButton("Play");
        play.setBounds(0, 0, 500, 100);
        play.setBackground(new Color(77,0,206,255));
        play.setOpaque(true);
        play.setBorderPainted(false);
        play.setFocusPainted(false);
        play.setForeground(Color.WHITE);
        play.setFont(new Font("Arial", Font.BOLD, 40));
        
        // settings button
        settings = new JButton("Settings");
        settings.setBounds(0, 50, 500, 100);
        settings.setBackground(new Color(77,0,206,255));
        settings.setOpaque(true);
        settings.setBorderPainted(false);
        settings.setFocusPainted(false);
        settings.setForeground(Color.WHITE);
        settings.setFont(new Font("Arial", Font.BOLD, 40));

        // quit button
        quite = new JButton("Quit");
        quite.setBounds(0, 100, 500, 100);
        quite.setBackground(new Color(77,0,206,255));
        quite.setOpaque(true);
        quite.setBorderPainted(false);
        quite.setFocusPainted(false);
        quite.setForeground(Color.WHITE);

        quite.setFont(new Font("Arial", Font.BOLD, 40));

        // Adding to menuPanel with flow layout
        menuPanel.add(play);
        menuPanel.add(settings);
        menuPanel.add(quite);

        menuPanel.setBounds((ScreenStructure.WIDTH/2)-250, (ScreenStructure.HEIGHT/2)-250, 500, 500);
        menuPanel.setBackground(new Color(131,0,255,255));
        menuPanel.setOpaque(true);
        menuPanel.setBorder(new TextBubbleBorder(new Color(131,0,255,255), 10, 70, 0));
    }
}