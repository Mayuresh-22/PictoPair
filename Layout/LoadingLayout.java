package Layout;

import javax.swing.*;
import java.awt.*;

public class LoadingLayout {
    JPanel LoadingPanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), logoPanel = new JPanel(new BorderLayout());
    JLabel bg;
    
    public LoadingLayout(){
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT);

        bg = new JLabel(new ImageIcon("assets/LoadingScreen-bg.png"));
        bgPanel.setBounds(0, 0, 1920, 1080);
        bgPanel.add(bg, BorderLayout.CENTER);


        LoadingPanel.add(layeredPane);
    }

    public JPanel getLoadingPanel() {
        return LoadingPanel;
    }

    public JLabel getBg() {
        return bg;
    }
}
