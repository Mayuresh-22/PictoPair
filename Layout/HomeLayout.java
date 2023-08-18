package Layout;

import javax.swing.*;
import java.awt.*;

public class HomeLayout {
    JPanel HomePanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout());
    JLabel bg;

    public HomeLayout(){
        JLayeredPane layeredPane = new JLayeredPane();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        layeredPane.setSize(width, height);
        layeredPane.setBackground(Color.gray);
        layeredPane.setOpaque(true);

        // bgPanel
        bg = new JLabel(new ImageIcon("assets/LoadingScreen-bg.png"));
        bgPanel.setBounds(0, 0, width, height);
        bgPanel.setOpaque(true);
        bgPanel.add(bg);


        HomePanel.add(layeredPane);
        HomePanel.setOpaque(true);
    }

    public JPanel getHomePanel() {
        return HomePanel;
    }
}