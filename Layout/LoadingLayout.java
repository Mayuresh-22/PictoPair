package Layout;

import javax.swing.*;
import java.awt.*;

public class LoadingLayout {
    JPanel LoadingBgPanel, LoadingLogoPanel = new JPanel(new BorderLayout());
    JLayeredPane LoadingLayoutPane;
    JLabel bg, logo;
    
    public LoadingLayout(){
        LoadingLayoutPane = new JLayeredPane();
        bg = new JLabel(new ImageIcon("assets/LoadingScreen-bg.png"));
        logo = new JLabel(new ImageIcon("assets/logo.jpeg"));
        LoadingBgPanel.add(bg, BorderLayout.CENTER);
        LoadingBgPanel.add(LoadingLogoPanel)
        LoadingBgPanel.setVisible(true);
    }

    public JPanel getLoadingPanel() {
        return LoadingBgPanel;
    }

    public JLabel getBg() {
        return bg;
    }
}
