package Layout;

import javax.swing.*;
import java.awt.*;

public class LoadingLayout {
    JPanel LoadingPanel = new JPanel(null);
    JLabel bg;
    
    public LoadingLayout(){
        bg = new JLabel(new ImageIcon("assets/LoadingScreen-bg.png"));
        LoadingPanel.add(bg, BorderLayout.CENTER);
    }

    public JPanel getLoadingPanel() {
        return LoadingPanel;
    }

    public JLabel getBg() {
        return bg;
    }
}
