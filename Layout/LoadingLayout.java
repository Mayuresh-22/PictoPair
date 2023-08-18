package Layout;

import javax.swing.*;
import java.awt.*;

public class LoadingLayout {
    JPanel LoadingPanel = new JPanel(new BorderLayout()), bgPanel = new JPanel(new BorderLayout()), logoPanel= new JPanel(new BorderLayout());
    JLabel bg;
    
    public LoadingLayout(){
        bg = new JLabel(new ImageIcon("assets/LoadingScreen-bg.png"));
        bgPanel.add(bg, BorderLayout.CENTER);
        logo = new JLabel(new ImageIcon("assets/logo.jpeg"))
    }

    public JPanel getLoadingPanel() {
        return LoadingPanel;
    }

    public JLabel getBg() {
        return bg;
    }
}
