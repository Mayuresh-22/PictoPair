package Layout;

import javax.swing.*;
import java.awt.*;

public class LoadingLayout {
    JPanel LoadingPanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), logoPanel = new JPanel(new BorderLayout());
    JLabel bg;
    
    public LoadingLayout(){
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(500, 500);
        layeredPane.setBackground(Color.gray);


        LoadingPanel.add(layeredPane);
    }

    public JPanel getLoadingPanel() {
        return LoadingPanel;
    }

    public JLabel getBg() {
        return bg;
    }
}
