package Layout;

import javax.swing.*;
import java.awt.*;

public class LoadingLayout {
    JPanel LoadingPanel = new JPanel(null);
    JLabel bg;
    
    public LoadingLayout(){
        bg = new JLabel();
        bg.setBounds(0, 0, 100, 100);
    }

    public JPanel getLoadingPanel() {
        return LoadingPanel;
    }

    public JLabel getBg() {
        return bg;
    }
}
