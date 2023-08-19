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
        // bgPanel
        bg = new JLabel(new ImageIcon(imagePath));
        bgPanel.setBounds(0, 0, ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        bgPanel.setOpaque(true);
        bgPanel.add(bg);
    }

    public void menuPanel(){
        menuPanel.setBounds((ScreenStructure.WIDTH/2)-200, (ScreenStructure.HEIGHT/2)-200, 400, 400);
        menuPanel.setBackground(Color.gray);
        menuPanel.setOpaque(true);
        menuPanel.setBorder(new TextBubbleBorder(Color.WHITE, 2, 0, 0));
    }
}