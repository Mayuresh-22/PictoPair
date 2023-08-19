package interfaces;

import java.awt.Dimension;
import java.awt.Toolkit;

public interface ScreenStructure {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();
    public void createLayeredPane();
    public void createBgPanel(String imagePath);
    public static 
}
