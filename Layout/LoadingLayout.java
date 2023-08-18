package Layout;

import javax.swing.*;
import java.awt.*;

public class LoadingLayout {
    JPanel LoadingBgPanel, LoadingLogoPanel = new JPanel(new BorderLayout());
    JLayeredPane LoadingLayoutPane;
    JLabel bg, logo;
    
    public LoadingLayout(){
        LoadingLayoutPane = new JLayeredPane();
        // create a background pane
        bg = new JLabel(new ImageIcon("assets/LoadingScreen-bg.png"));
        LoadingBgPanel.add(bg, BorderLayout.CENTER);
        logo = new JLabel(new ImageIcon("assets/logo.jpeg"));
        LoadingLogoPanel.add(logo, BorderLayout.CENTER);
        LoadingBgPanel.setVisible(true);
    }

    public JPanel getLoadingPanel() {
        return LoadingBgPanel;
    }

    public JLabel getBg() {
        return bg;
    }
}
