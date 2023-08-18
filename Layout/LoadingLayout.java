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

        LoadingLayoutPane.add(LoadingBgPanel, 1);

        LoadingBgPanel.setVisible(true);
    }

    public JLayeredPane getLoadingPanel() {
        return LoadingLayoutPane;
    }

    public JLabel getBg() {
        return bg;
    }
}
