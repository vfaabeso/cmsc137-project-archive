package entity;

import main.GamePanel;
import main.Splash;

public class DummySetter {
    GamePanel gp;

	public DummySetter(GamePanel gp) {
		this.gp = gp;
	}

	public void setDummies() {
        Dummy dummy = new Dummy(gp);

		dummy.worldX = 11 * Splash.TILE_SIZE;
		dummy.worldY = 9 * Splash.TILE_SIZE;
		dummy.solidArea.width = dummy.imgWidth;
		dummy.solidArea.height = dummy.imgHeight;
		dummy.collisionOn = true;
        gp.dummylist[0] = dummy;
	}
}
