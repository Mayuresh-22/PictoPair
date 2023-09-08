package interfaces;

import java.awt.Dimension;
import java.awt.Toolkit;

public interface ScreenStructure {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public void createLayeredPane();
    public void createBgPanel(String imagePath);
    
}
