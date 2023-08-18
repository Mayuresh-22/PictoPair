package Layout;

import javax.swing.*;
import java.awt.*;

public class LoadingLayout {
    JPanel LoadingPanel = new JPanel(new BorderLayout()), bgPanel = new JPanel(new BorderLayout()), logoPanel= new JPanel(new BorderLayout());
    JLabel bg, logo;
    JLayeredPane layeredPane;
    
    public LoadingLayout(){
        // backgroun panel
        bg = new JLabel(new ImageIcon("assets/LoadingScreen-bg.png"));
        bgPanel.add(bg, BorderLayout.CENTER);
        // logo panel
        logoPanel.setPreferredSize(new Dimension(300, 300));
        logo = new JLabel(new ImageIcon("assets/logo.jpeg"));
        logoPanel.add(logo, BorderLayout.CENTER);

        // create layered pane
        layeredPane = new JLayeredPane();
        layeredPane.add(bgPanel, 1);
        LoadingPanel.add(layeredPane, BorderLayout.CENTER);
        LoadingPanel.setVisible(true);
    }

    public JPanel getLoadingPanel() {
        return LoadingPanel;
    }

    public JLabel getBg() {
        return bg;
    }
}
