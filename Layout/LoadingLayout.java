package Layout;

import javax.swing.*;
import java.awt.*;

public class LoadingLayout {
    JPanel LoadingPanel, LoadingLogoPanel = new JPanel(new BorderLayout());
    JLayeredPane LoadingLayoutPane;
    JLabel bg, logo;
    
    public LoadingLayout(){
        bg = new JLabel(new ImageIcon("assets/LoadingScreen-bg.png"));
        logo = new JLabel(new ImageIcon("assets/logo.jpeg"));
        LoadingPanel.add(bg, BorderLayout.CENTER);
        LoadingPanel.add(LoadingLogo)
        LoadingPanel.setVisible(true);
    }

    public JPanel getLoadingPanel() {
        return LoadingPanel;
    }

    public JLabel getBg() {
        return bg;
    }
}
