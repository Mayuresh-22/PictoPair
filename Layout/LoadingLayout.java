package Layout;

import javax.swing.*;
import java.awt.*;

public class LoadingLayout {
    JPanel LoadingBgPanel = new JPanel(new BorderLayout()), LoadingLogoPanel = new JPanel(new BorderLayout());
    JLayeredPane LoadingLayoutPane;
    JLabel bg, logo;
    
    public LoadingLayout(){
        LoadingLayoutPane = new JLayeredPane();
        // create a background panel
        bg = new JLabel(new ImageIcon("assets/LoadingScreen-bg.png"));
        LoadingBgPanel.add(bg, BorderLayout.CENTER);
        // create a logo panel
        // LoadingLogoPanel.setSize(200, 200);
        // logo = new JLabel(new ImageIcon("assets/logo.jpeg"));
        // LoadingLogoPanel.add(logo, BorderLayout.CENTER);

        LoadingLayoutPane.add(LoadingBgPanel, 1);
        // LoadingLayoutPane.add(LoadingLogoPanel, BorderLayout.CENTER);
    }

    public JLayeredPane getLoadingPanel() {
        return LoadingLayoutPane;
    }

    public JLabel getBg() {
        return bg;
    }
}
