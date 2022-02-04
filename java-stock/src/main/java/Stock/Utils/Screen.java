package Stock.Utils;

import java.awt.*;

public class Screen {
    public static Toolkit toolkit = Toolkit.getDefaultToolkit();
    public static Dimension dimension = toolkit.getScreenSize();

    public static int height = dimension.height / 2;
    public static int width = dimension.width / 2;

    private static String cashParser(double value) {
        return ("$" + String.format("%.2f", value));
    }
}
