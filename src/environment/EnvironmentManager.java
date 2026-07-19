package environment;

import java.awt.Graphics2D;

import main.GamePanel;

public class EnvironmentManager {

	GamePanel gp;
	Flashlight flashlight;

	public EnvironmentManager(GamePanel gp) {
		this.gp = gp;
	}

	public void setup() {
		flashlight = new Flashlight(gp, 450);	// 450 - circle size
	}

	public void draw(Graphics2D g2) {
		try {
			flashlight.draw(g2);
		} catch(NullPointerException e) {
			System.out.println("NullPointerException Caught");
		}

	}
}