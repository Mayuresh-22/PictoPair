package layout;

import javax.swing.*;
import java.awt.*;
import interfaces.*;

public class HomeLayout implement ScreenStructure {
    JPanel HomePanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), menuPanel = new JPanel(new FlowLayout(0));
    JLabel bg;

    public HomeLayout(){


        // bgPanel
        bg = new JLabel(new ImageIcon("assets/HomeScreen-bg.png"));
        bgPanel.setBounds(0, 0, width, height);
        bgPanel.setOpaque(true);
        bgPanel.add(bg);

        // menu panel
        menuPanel.setBounds((width/2)-200, (height/2)-200, 400, 400);
        menuPanel.setBackground(Color.gray);
        menuPanel.setOpaque(true);

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
        JLayeredPane layeredPane = new JLayeredPane();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        layeredPane.setSize(width, height);
        layeredPane.setBackground(Color.gray);
        layeredPane.setOpaque(true);
    }

    @Override
    public void createBgPanel(String imagePath){

    }
}