package Layout;

import javax.swing.*;
import java.awt.*;

public class HomeLayout {
    JPanel HomePanel = new JPanel(null);

    HomeLayout(){
        JLayeredPane layeredPane = new JLayeredPane();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        layeredPane.setSize(width, height);
        layeredPane.setBackground(Color.gray);
        layeredPane.setOpaque(true);

        HomePanel.add(layeredPane);
        HomePanel.setOpaque(true);
    }

    public JPanel getHomePanel() {
        return HomePanel;
    }
}