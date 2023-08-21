package layout;

import external.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaces.*;

public class HomeLayout implements ScreenStructure{
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
        play = createButton(play, "PLAY", 0, 0, 500, 100, 40);
        play.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });

        settings = createButton(settings, "Settings", 0, 0, 500, 100, 40);
        settings.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });

        quite = createButton(quite, "Quite", 0, 0, 500, 100, 40);
        quite.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        // Adding to menuPanel with flow layout
        menuPanel.add(play);
        menuPanel.add(settings);
        menuPanel.add(quite);

        menuPanel.setBounds((ScreenStructure.WIDTH/2)-250, (ScreenStructure.HEIGHT/2)-250, 500, 500);
        menuPanel.setBackground(new Color(131,0,255,255));
        menuPanel.setOpaque(true);
        menuPanel.setBorder(new TextBubbleBorder(new Color(131,0,255,255), 10, 70, 0));
    }

    public JButton createButton(JButton button, String text, int x, int y, int width, int height, int fontSize){
        button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(new Color(77,0,206,255));
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, fontSize));

        return button;
    }
}