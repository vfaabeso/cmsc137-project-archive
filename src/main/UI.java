package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;

public class UI {
	private GamePanel gp;
	private Graphics2D g2;

	private boolean messageOn = false;
	private String message = "";

	private int messageTimer = 0;

	UI(GamePanel gp) {
		this.gp = gp;
	}

	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}

	void draw(Graphics2D g2) {
		this.g2 = g2;
		drawGameScreen();
	}

	void drawGameScreen() {
		setFont(Splash.secondaryFont, 30f);
		g2.setColor(Splash.CUSTOM_YELLOW);

		// show the message
		if (messageOn) {

			g2.drawString(message, 30, 50);
			messageTimer++;
			if (messageTimer > 180) {
				// message disappears after 3 seconds
				messageTimer = 0;
				messageOn = false;
			}
		}
	}

	// method to display text at the center of x-axis
	int getXCenter(String text) {
		int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = Splash.SCREEN_WIDTH / 2 - length / 2;
		return x;
	}

	// method to set the font of the text
	void setFont(Font font, float size) {
		g2.setFont(font);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, size));
	}
}
