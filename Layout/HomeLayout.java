package layout;

import external.*;
import javax.swing.*;
import java.awt.*;
import interfaces.*;

public class HomeLayout implements ScreenStructure {
    JPanel HomePanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), menuPanel = new JPanel(new FlowLayout(0));
    JLabel bg;
    JLayeredPane layeredPane = new JLayeredPane();

    public HomeLayout(){
        createLayeredPane();

        createBgPanel("assets/Homescreen-bg.png");

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
        layeredPane.setBackground(Color.gray);
        layeredPane.setOpaque(true);
    }

    @Override
    public void createBgPanel(String imagePath){
        // SCALLED bg
        
        // bgPanel
        bg = new JLabel(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(ScreenStructure.WIDTH, ScreenStructure.HEIGHT, Image.SCALE_SMOOTH)));

        bgPanel.setBounds(0, 0, ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        bgPanel.setOpaque(true);
        bgPanel.add(bg);
    }

    public void createMenuPanel(){
        menuPanel.setBounds((ScreenStructure.WIDTH/2)-250, (ScreenStructure.HEIGHT/2)-250, 500, 500);
        menuPanel.setBackground(new Color(131,0,255,255));
        menuPanel.setOpaque(true);
        menuPanel.setBorder(new TextBubbleBorder(new Color(131,0,255,255), 10, 70, 0));
    }
}