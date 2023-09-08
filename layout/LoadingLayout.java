package layout;

import javax.swing.*;
import interfaces.*;
import java.awt.*;


public class LoadingLayout implements ScreenStructure{
    JPanel LoadingPanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), logoPanel = new JPanel(new BorderLayout());
    JLabel bg, logo, credits;
    JLayeredPane layeredPane = new JLayeredPane();
    
    public LoadingLayout(){
        // LoadingPanel
        createLayeredPane();

        // bgPanel
        createBgPanel("assets/images/LoadingScreen-bg.png");

        // logoPanel
        logo = new JLabel(new ImageIcon("assets/images/logogifclear.gif"));
        logoPanel.setBounds((ScreenStructure.WIDTH/2)-200, (ScreenStructure.HEIGHT/2)-200, 400, 400);
        logoPanel.setOpaque(true);
        logoPanel.add(logo);

        // credits at the bottom of the screen
        credits = new JLabel("Made by: Mayuresh Choudhary, Devang Gentyal, Om Gaikwad");
        credits.setBounds((ScreenStructure.WIDTH/2)-100, (ScreenStructure.HEIGHT/2)+200, 200, 50);
        credits.setForeground(Color.lightGray);
        credits.setFont(new Font("Arial", Font.BOLD, 20));
        credits.setHorizontalAlignment(JLabel.CENTER);
        credits.setVerticalAlignment(JLabel.CENTER);

        // Add to LoadingPanel
        layeredPane.add(logoPanel, BorderLayout.CENTER);
        layeredPane.add(credits);
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

    @Override
    public void createLayeredPane(){
        // layered pane
        layeredPane.setSize(ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        layeredPane.setBackground(Color.gray);
        layeredPane.setOpaque(true);
    }

    @Override
    public void createBgPanel(String imagePath){
        // bgPanel
        bg = new JLabel(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(ScreenStructure.WIDTH, ScreenStructure.HEIGHT, Image.SCALE_SMOOTH)));
        bgPanel.setBounds(0, 0, ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        bgPanel.setOpaque(true);
        bgPanel.add(bg);
    }
}
