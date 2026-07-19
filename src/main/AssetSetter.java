package main;

import object.Door;
import object.Drawer;
import object.Key;
import object.Knife;
import object.EscapeDoor;

public class AssetSetter {
	GamePanel gp;

	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}

	public void setObject() {

		gp.obj[0] = new EscapeDoor(0, 21, 21);
		gp.obj[0].imagePhysicalSet(32, 32, Splash.TILE_SIZE, Splash.TILE_SIZE);

		gp.obj[1] = new Door(1, 5, 7);
		gp.obj[1].imagePhysicalSet(32, 32, Splash.TILE_SIZE, Splash.TILE_SIZE);

		gp.obj[2] = new Door(2, 12, 7);
		gp.obj[2].imagePhysicalSet(32, 32, Splash.TILE_SIZE, Splash.TILE_SIZE);

		gp.obj[3] = new Door(3, 22, 10);
		gp.obj[3].imagePhysicalSet(32, 32, Splash.TILE_SIZE, Splash.TILE_SIZE);

		gp.obj[4] = new Door(4, 33, 11);
		gp.obj[4].imagePhysicalSet(32, 32, Splash.TILE_SIZE, Splash.TILE_SIZE);

		gp.obj[5] = new Door(5, 29, 16);
		gp.obj[5].imagePhysicalSet(32, 32, Splash.TILE_SIZE, Splash.TILE_SIZE);

		gp.obj[6] = new Door(6, 24, 17);
		gp.obj[6].imagePhysicalSet(32, 32, Splash.TILE_SIZE, Splash.TILE_SIZE);

		gp.obj[7] = new Door(7, 23, 18);
		gp.obj[7].imagePhysicalSet(32, 32, Splash.TILE_SIZE, Splash.TILE_SIZE);

		gp.obj[8] = new Door(8, 22, 6);
		gp.obj[8].imagePhysicalSet(32, 32, Splash.TILE_SIZE, Splash.TILE_SIZE);

		gp.obj[9] = new Door(9, 19, 15);
		gp.obj[9].imagePhysicalSet(32, 32, Splash.TILE_SIZE, Splash.TILE_SIZE);

		gp.obj[10] = new Door(10, 11, 17);
		gp.obj[10].imagePhysicalSet(32, 32, Splash.TILE_SIZE, Splash.TILE_SIZE);

		gp.obj[11] = new Key(11, 6, 17);
		gp.obj[11].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[11].obtainable = true;

		gp.obj[12] = new Key(12, 19, 20);
		gp.obj[12].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[12].obtainable = true;

		gp.obj[13] = new Key(13, 5, 3);
		gp.obj[13].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[13].obtainable = true;

		gp.obj[14] = new Key(14, 17, 3);
		gp.obj[14].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[14].obtainable = true;

		gp.obj[15] = new Key(15, 19, 20);
		gp.obj[15].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[15].obtainable = true;

		gp.obj[16] = new Key(16, 21, 12);
		gp.obj[16].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[16].obtainable = true;

		gp.obj[17] = new Key(17, 12, 8);
		gp.obj[17].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[17].obtainable = true;

		gp.obj[18] = new Key(18, 34, 4);
		gp.obj[18].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[18].obtainable = true;

		gp.obj[19] = new Key(19, 14, 12);
		gp.obj[19].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[19].obtainable = true;

		gp.obj[20] = new Key(20, 17, 14);
		gp.obj[20].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[20].obtainable = true;

		gp.obj[21] = new Key(21, 6, 17);
		gp.obj[21].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[21].obtainable = true;

		gp.obj[22] = new Drawer(22, 21, 3);
		gp.obj[22].imagePhysicalSet(72, 96, Splash.TILE_SIZE+10, Splash.TILE_SIZE+40);

		gp.obj[23] = new Drawer(23, 32, 4);
		gp.obj[23].imagePhysicalSet(72, 96, Splash.TILE_SIZE+10, Splash.TILE_SIZE+40);

		gp.obj[24] = new Drawer(24, 27, 10);
		gp.obj[24].imagePhysicalSet(72, 96, Splash.TILE_SIZE+10, Splash.TILE_SIZE+40);

		gp.obj[25] = new Drawer(25, 27, 18);
		gp.obj[25].imagePhysicalSet(72, 96, Splash.TILE_SIZE+10, Splash.TILE_SIZE+40);

		gp.obj[26] = new Drawer(26, 14, 12);
		gp.obj[26].imagePhysicalSet(72, 96, Splash.TILE_SIZE+10, Splash.TILE_SIZE+40);

		gp.obj[27] = new Drawer(27, 8, 10);
		gp.obj[27].imagePhysicalSet(72, 96, Splash.TILE_SIZE+10, Splash.TILE_SIZE+40);

		gp.obj[28] = new Drawer(28, 4, 17);
		gp.obj[28].imagePhysicalSet(72, 96, Splash.TILE_SIZE+10, Splash.TILE_SIZE+40);

		gp.obj[29] = new Knife(29, 12, 15);
		gp.obj[29].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[29].obtainable = true;

		gp.obj[30] = new Knife(30, 22, 8);
		gp.obj[30].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[30].obtainable = true;

		gp.obj[31] = new Knife(31, 16, 14);
		gp.obj[31].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[31].obtainable = true;

		gp.obj[32] = new Knife(32, 9, 16);
		gp.obj[32].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[32].obtainable = true;

		gp.obj[33] = new Knife(33, 35, 19);
		gp.obj[33].imagePhysicalSet(32, 32, Splash.TILE_SIZE/2, Splash.TILE_SIZE/2);
		gp.obj[33].obtainable = true;
	}

	// this is to set the objects manually

}
