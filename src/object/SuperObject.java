package object;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import main.GamePanel;
import main.Splash;

import java.awt.Rectangle;

public class SuperObject {
	BufferedImage image;
	public String name;
	public int id; // what is its id in the obj array?
	public boolean collision = false;
	public boolean obtainable = false;
	public int worldX, worldY;
	public Rectangle solidArea = new Rectangle(0, 0);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	// for image rendering
	public int imgWidth, imgHeight;
	public int renderWidth, renderHeight;
	int frameidx=0; // for multiple frames such as doors which has two states

	// a proper constructor
	SuperObject(int id, String name, int worldX, int worldY) {
		this.id = id;
		this.name = name;
		setPosition(worldX, worldY);
	}

	public void setPosition(int worldX, int worldY) {
		this.worldX = worldX * Splash.TILE_SIZE;
		this.worldY = worldY * Splash.TILE_SIZE;
	}

	public void imagePhysicalSet(int imgWidth, int imgHeight, int renderWidth, int renderHeight) {
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
		this.renderWidth = renderWidth;
		this.renderHeight = renderHeight;
		this.solidArea.width = renderWidth;
		this.solidArea.height = renderHeight;
	}

	public void draw(Graphics2D g2, GamePanel gp) {
		int screenX = worldX - gp.player.worldX + gp.player.screenX + (Splash.TILE_SIZE-renderWidth)/2;
		int screenY = worldY - gp.player.worldY + gp.player.screenY + (Splash.TILE_SIZE-renderHeight)/2;

		if (worldX + Splash.TILE_SIZE > gp.player.worldX - gp.player.screenX &&
				worldX - Splash.TILE_SIZE < gp.player.worldX + gp.player.screenX &&
				worldY + Splash.TILE_SIZE > gp.player.worldY - gp.player.screenY &&
				worldY - Splash.TILE_SIZE < gp.player.worldY + gp.player.screenY) {
			g2.drawImage(image, screenX, screenY,
					screenX + renderWidth, screenY + renderHeight,
					frameidx*imgWidth, frameidx*imgHeight,
					(frameidx+1)*imgWidth, (frameidx+1)*imgHeight, null);
		}
	}
}
