package constants;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Constants {
    // create a constant
    public static final String MUSIC_FILE_PATH = "assets/sounds/bgm.wav";
    public static final String SOUND_EFFECT_FILE_PATH = "assets/sounds/intro.wav";
    public static final String CARD_BACK_IMAGE_PATH = "assets/images/card-back.png";
    public static final String ENDING_SCREEN_IMAGE_PATH = "assets/images/EndingScreen-bg.png";
    public static final String HOME_SCREEN_IMAGE_PATH = "assets/images/HomeScreen-bg.png";
    public static final String LOADING_SCREEN_IMAGE_PATH = "assets/images/LoadingScreen-bg.png";
    public static int WIDTH = (int) screenSize.getWidth();
    public static int HEIGHT = (int) screenSize.getHeight();
    public static ImageIcon defaultMusicIcon = new ImageIcon(new ImageIcon("assets/images/sound-on.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
}
