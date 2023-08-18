package Layout;

import javax.swing.*;
import java.awt.*;

public class LoadingLayout {
    JPanel LoadingPanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), logoPanel = new JPanel(new BorderLayout());
    JLabel bg, logo;
    
    public LoadingLayout(){
        // LoadingPanel
        JLayeredPane layeredPane = new JLayeredPane();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        layeredPane.setSize(width, height);
        layeredPane.setBackground(Color.gray);
        layeredPane.setOpaque(true);

        // bgPanel
        bg = new JLabel(new ImageIcon("assets/LoadingScreen-bg.png"));
        bgPanel.setBounds(0, 0, width, height);
        bgPanel.setOpaque(true);
        bgPanel.add(bg);

        // logoPanel
        logo = new JLabel(new ImageIcon("assets/logogif.gif"));
        logoPanel.setBounds((width/2)-200, (height/2)-200, 400, 400);
        logoPanel.setOpaque(true);
        logoPanel.add(logo);

        // Add to LoadingPanel
        layeredPane.add(logoPanel, BorderLayout.CENTER);
        layeredPane.add(bgPanel);

        // Add to LoadingPanel
        LoadingPanel.add(layeredPane);
        LoadingPanel.setOpaque(true);
    }

    public JPanel getLoadingPanel() {
        return LoadingPanel;
    }

    public JLabel getBg() {
        return bg;
    }
}
