package main;

import entity.Entity;

public class CollisionChecker {
	GamePanel gp;
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}

	public void checkTile(Entity entity) {
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entityLeftWorldX + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entityTopWorldY + entity.solidArea.height;

		int entityLeftCol = entityLeftWorldX/Splash.TILE_SIZE;
		int entityRightCol = entityRightWorldX/Splash.TILE_SIZE;
		int entityTopRow = entityTopWorldY/Splash.TILE_SIZE;
		int entityBottomRow = entityBottomWorldY/Splash.TILE_SIZE;

		int tileNum1, tileNum2;

		switch (entity.direction) {
		case 'u':
			entityTopRow = (entityTopWorldY - entity.speed)/Splash.TILE_SIZE;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
				entity.collisionOn = true;
			}
			break;
		case 'd':
			entityBottomRow = (entityBottomWorldY + entity.speed)/Splash.TILE_SIZE;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
				entity.collisionOn = true;
			}
			break;
		case 'l':
			entityLeftCol = (entityLeftWorldX - entity.speed)/Splash.TILE_SIZE;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
				entity.collisionOn = true;
			}
			break;
		case 'r':
			entityRightCol = (entityRightWorldX + entity.speed)/Splash.TILE_SIZE;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
				entity.collisionOn = true;
			}
			break;
		}
	}

	public int checkObject(Entity entity, boolean player) {
		int index = -1;
		for (int i=0; i<gp.obj.length; i++) {
			if (gp.obj[i] != null) {
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;

				gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

				switch (entity.direction) {
				case 'u':
					entity.solidArea.y -= entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (gp.obj[i].collision) entity.collisionOn = true;
						if (player) index = i;
					}
					break;
				case 'd':
					entity.solidArea.y += entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (gp.obj[i].collision) entity.collisionOn = true;
						if (player) index = i;
					}
					break;
				case 'l':
					entity.solidArea.x -= entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (gp.obj[i].collision) entity.collisionOn = true;
						if (player) index = i;
					}
					break;
				case 'r':
					entity.solidArea.x += entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (gp.obj[i].collision) entity.collisionOn = true;
						if (player) index = i;
					}
					break;
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
				gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
			}
		}
		return index;
	}

	// could be multiple dummies
	public int checkDummy(Entity entity, boolean player) {
		int index = -1;
		for (int i=0; i<gp.dummylist.length; i++) {
			if (gp.dummylist[i] != null) {
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;

				gp.dummylist[i].solidArea.x = gp.dummylist[i].worldX + gp.dummylist[i].solidArea.x;
				gp.dummylist[i].solidArea.y = gp.dummylist[i].worldY + gp.dummylist[i].solidArea.y;

				switch (entity.direction) {
				case 'u':
					entity.solidArea.y -= entity.speed;
					if (entity.solidArea.intersects(gp.dummylist[i].solidArea)) {
						if (gp.dummylist[i].collisionOn) entity.collisionOn = true;
						if (player) index = i;
					}
					break;
				case 'd':
					entity.solidArea.y += entity.speed;
					if (entity.solidArea.intersects(gp.dummylist[i].solidArea)) {
						if (gp.dummylist[i].collisionOn) entity.collisionOn = true;
						if (player) index = i;
					}
					break;
				case 'l':
					entity.solidArea.x -= entity.speed;
					if (entity.solidArea.intersects(gp.dummylist[i].solidArea)) {
						if (gp.dummylist[i].collisionOn) entity.collisionOn = true;
						if (player) index = i;
					}
					break;
				case 'r':
					entity.solidArea.x += entity.speed;
					if (entity.solidArea.intersects(gp.dummylist[i].solidArea)) {
						if (gp.dummylist[i].collisionOn) entity.collisionOn = true;
						if (player) index = i;
					}
					break;
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gp.dummylist[i].solidArea.x = gp.dummylist[i].solidAreaDefaultX;
				gp.dummylist[i].solidArea.y = gp.dummylist[i].solidAreaDefaultY;
			}
		}
		return index;
	}
}
