package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.Splash;

public class Dummy extends Entity {

	GamePanel gp;

	public Rectangle solidArea = new Rectangle(0, 0);
	public int solidAreaDefaultX = 0, solidAreaDefaultY = 0;

	public Dummy(GamePanel gp) {
		this.gp = gp;

		setDefaultValues();
		getPlayerImage();

		solidArea = new Rectangle(imgWidth / 4, imgHeight / 2, imgWidth / 2, imgHeight / 2);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
	}

	public void setDefaultValues() {
		worldX = Splash.TILE_SIZE * 11;
		worldY = Splash.TILE_SIZE * 9;

	}

	public void getPlayerImage() {
		try {
			charimg = ImageIO.read(getClass().getResourceAsStream("/res/player/secondchar.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {

	}

	public void draw(Graphics2D g2, GamePanel gp) {
		int screenX = worldX - gp.player.worldX + gp.player.screenX + imgWidth / 4;
		int screenY = worldY - gp.player.worldY + gp.player.screenY + imgHeight / 4;

		if (worldX + Splash.TILE_SIZE > gp.player.worldX - gp.player.screenX &&
				worldX - Splash.TILE_SIZE < gp.player.worldX + gp.player.screenX &&
				worldY + Splash.TILE_SIZE > gp.player.worldY - gp.player.screenY &&
				worldY - Splash.TILE_SIZE < gp.player.worldY + gp.player.screenY) {
			g2.drawImage(charimg, screenX, screenY,
					screenX + (imgWidth), screenY + (imgHeight),
					imgWidth, 0,
					imgWidth * 2, imgHeight, null);
		}
	}

}
