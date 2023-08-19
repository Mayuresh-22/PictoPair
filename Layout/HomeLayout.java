package layout;

import javax.swing.*;
import java.awt.*;
import interfaces.*;

public class HomeLayout implements ScreenStructure {
    JPanel HomePanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), menuPanel = new JPanel(new FlowLayout(0));
    JLabel bg;
    JLayeredPane layeredPane = new JLayeredPane();

    public HomeLayout(){


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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        layeredPane.setSize(width, height);
        layeredPane.setBackground(Color.gray);
        layeredPane.setOpaque(true);
    }

    @Override
    public void createBgPanel(String imagePath){
        // bgPanel
        bg = new JLabel(new ImageIcon(imagePath));
        bgPanel.setBounds(0, 0, width, height);
        bgPanel.setOpaque(true);
        bgPanel.add(bg);
    }
}