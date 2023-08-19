package layout;

import external.*;
import javax.swing.*;
import java.awt.*;
import interfaces.*;
import javax.swing.border.AbstractBorder;

// RoundBorders
class RoundedBorder extends AbstractBorder {
    private int radius;

    public RoundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color borderColor = Color.GRAY; // Customize the border color here

        g2.setColor(borderColor);
        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);

        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius, radius, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = radius;
        return insets;
    }
}

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

    public JPanel getGamePanel() {
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
        cardsPanel.setBounds((int)(ScreenStructure.WIDTH*0.03),(int)(ScreenStructure.HEIGHT*0.03), (int)(ScreenStructure.WIDTH*0.7), (int)(ScreenStructure.HEIGHT*0.9));
        cardsPanel.setOpaque(true);
        cardsPanel.setBorder(new TextBubbleBorder(new Color(200, 200, 200), 10, 70, 0));
    }
}