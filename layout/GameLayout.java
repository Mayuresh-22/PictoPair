package layout;

import external.*;
import javax.swing.*;
import java.awt.*;
import interfaces.*;

public class GameLayout implements ScreenStructure {
    JPanel GamePanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), cardsPanel = new JPanel(), scorePanel = new JPanel();
    JLabel bg;
    JLayeredPane layeredPane = new JLayeredPane();

    public GameLayout(){
        createLayeredPane();

        createBgPanel("assets/images/GameLayout-bg.png");

        // menu panel
        createCardsPanel();

        // Adding to layeredPane
        layeredPane.add(cardsPanel, BorderLayout.CENTER);
        layeredPane.add(bgPanel);

        // Adding to HomePanel
        GamePanel.add(layeredPane);
        GamePanel.setOpaque(true);
    }

    public JPanel getHomePanel() {
        return GamePanel;
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

    public void createCardsPanel(){
        cardsPanel.setBounds(100, 100, (ScreenStructure.WIDTH/2), (ScreenStructure.HEIGHT/2));
        cardsPanel.setBackground(new Color(131,0,255,255));
        cardsPanel.setOpaque(true);
        cardsPanel.setBorder(new TextBubbleBorder(new Color(131,0,255,255), 10, 70, 0));
    }
}