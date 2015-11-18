package Theme;

import java.awt.Color;

public class ColorTheme {
	static Color primary = new Color(0, 204, 204);
	static Color secondary = new Color(0, 153, 153);
	
	public ColorTheme() {}
	
	public static Color getPrimaryColor() {
		return primary;
	}
	
	public static Color getSecondaryColor() {
		return secondary;
	}
}
