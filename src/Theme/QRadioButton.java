package Theme;

import java.awt.Color;

import javax.swing.JRadioButton;

public class QRadioButton extends JRadioButton{
	
	Color mainColor = ColorTheme.getSecondaryColor();
	
	public QRadioButton(String text) {
		this.setText(text);
		this.setForeground(mainColor);
	}
}
