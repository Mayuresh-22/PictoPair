package Layout;

import javax.swing.*;
import java.awt.*;

public class LoadingLayout {
    JPanel LoadingPanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), logoPanel = new JPanel(new BorderLayout());
    JLabel bg;
    
    public LoadingLayout(){
        bg = new JLabel();
        bg.setBounds(100, 100, 100, 100);
        bg.setOpaque(true);
        bg.setBackground(Color.red);
        LoadingPanel.add(bg);
    }

    public JPanel getLoadingPanel() {
        return LoadingPanel;
    }

    public JLabel getBg() {
        return bg;
    }
}
