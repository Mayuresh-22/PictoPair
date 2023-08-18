package Layout;

import javax.swing.*;
import java.awt.*;

public class LoadingLayout {
    JPanel LoadingPanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), logoPanel= new JPanel(new BorderLayout());
    JLabel bg, logo;
    JLayeredPane layeredPane;
    
    public LoadingLayout(){
        // // backgroun panel
        // bg = new JLabel(new ImageIcon("assets/LoadingScreen-bg.png"));
        // bgPanel.add(bg, BorderLayout.CENTER);
        // // logo panel
        // logoPanel.setPreferredSize(new Dimension(300, 300));
        // logo = new JLabel(new ImageIcon("assets/logo.jpeg"));
        // logoPanel.add(logo, BorderLayout.CENTER);

        // create layered pane
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 500, 500);
        layeredPane.setBackground(Color.gray);

        LoadingPanel.add(layeredPane);
        // LoadingPanel.setVisible(true);
    }

    public JPanel getLoadingPanel() {
        return LoadingPanel;
    }

    public JLabel getBg() {
        return bg;
    }
}
