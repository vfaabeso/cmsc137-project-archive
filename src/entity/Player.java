package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.GameStage;
import main.KeyHandler;
import main.Splash;
import object.SuperObject;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyH;
	GameStage gs;

	// handle the inventory properly
	SuperObject inventory;
	// check if the player is currently hidden
	public boolean isHidden = false;
	//public boolean isChatting = false;

	public final int screenX, screenY;

	Map <Integer, String> characterPics = new HashMap<Integer, String>();
	

	public Player(GamePanel gp, KeyHandler keyH, int id) {
		this.gp = gp;
		this.keyH = keyH;

		setDefaultValues(19, 5);

		// set the paths of the character's images in a dictionary
		characterPics.put(1, "/res/player/firstchar.png");		
		characterPics.put(2, "/res/player/secondchar.png");
		characterPics.put(3, "/res/player/thirdchar.png");		//TODO: set other characters
		characterPics.put(4, "/res/player/fourthchar.png");

		//getPlayerImage("/res/player/firstchar.png");
		getPlayerImage(characterPics.get(id));

		screenX = Splash.SCREEN_WIDTH/3 - imgWidth/2;
		screenY = Splash.SCREEN_HEIGHT/2 - imgHeight/2;

		solidArea = new Rectangle(imgWidth/4, imgHeight/2, imgWidth/2, imgHeight/2);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
	}

	public void setDefaultValues(int worldX, int worldY) {
		this.worldX = Splash.TILE_SIZE * worldX;
		this.worldY = Splash.TILE_SIZE * worldY;
	}

	public void getPlayerImage(String path) {
		try {
			charimg = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {

		if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed || keyH.chatPressed) {

			if 		(keyH.upPressed) 	direction = 'u';
			else if (keyH.downPressed) 	direction = 'd';
			else if (keyH.leftPressed) 	direction = 'l';
			else if (keyH.rightPressed) direction = 'r';

			// CHECK TILE COLLISION
			collisionOn = false;
			gp.cChecker.checkTile(this);

			int objIndex = gp.cChecker.checkObject(this, true);
			objInteract(objIndex);
			// check also the collision with the dummies
			int dummyIndex = gp.cChecker.checkDummy(this, true);
			collideWithDummy(dummyIndex);
			// IF COLLISION IS FALSE, PLAYER CAN MOVE
			if (!collisionOn) {
				switch (direction) {
				case 'u': worldY -= speed; break;
				case 'd': worldY += speed; break;
				case 'l': worldX -= speed; break;
				case 'r': worldX += speed; break;
				}
			}

			spriteCounter++;
			if (spriteCounter>8) {
				spriteNum=(spriteNum+1)%3;
				spriteCounter=0;
			}
		} else {
			spriteNum=1;
		}

		// dropping objects
		if (keyH.dropPressed) {
			dropObject();
		}

		// hiding
		if (keyH.hidePressed) {
			unhide();
		}
	}

	void objInteract(int index) {
		if (index!=-1) {
			SuperObject object = gp.obj[index];
			// also would depend if the item is obtainable or not
			if (object.obtainable) {
				if (inventory == null) {
					gp.obj[index] = null;
					inventory = object;
					gp.ui.showMessage(inventory.name + " acquired!");
				}
				else {
					gp.ui.showMessage("Drop your inventory to obtain it");
				}
			} else { // if not obtainable like doors
				switch(object.name) {
					case "Door":
						if (inventory != null){
							if (inventory.name.equals("Key")) {
								gp.obj[index] = null;
								gp.ui.showMessage("Door unlocked!");
								inventory = null;
							} else {
								gp.ui.showMessage("You need a key!");
							}
						} else {
							gp.ui.showMessage("You need a key!");
						}
						
						break;
					case "EscapeDoor":
						if (inventory != null) {
							if (inventory.name.equals("Key")){
								setDefaultValues(21, 22); //teleporting the player in a room where all escapee are
								gp.ui.showMessage("Escape Door unlocked!");
								inventory = null;
							} else {
								gp.ui.showMessage("You need a key to escape!");
							}
						} else {
							gp.ui.showMessage("You need a key to escape!");
						}
						break;
					case "Drawer":
						if (!isHidden) hide(object.worldX+object.renderWidth/4, object.worldY+object.renderHeight/4);
						break;
				}
			}
		}
	}

	void dropObject() {
		// set the position of the inventory
		if (inventory != null) {
			gp.ui.showMessage("You dropped your "+inventory.name);
			gp.obj[inventory.id] = inventory;
			// set depending on player position
			int positionX = (this.worldX+imgWidth/2)/Splash.TILE_SIZE;
			int positionY = (this.worldY+imgHeight/2)/Splash.TILE_SIZE;
			gp.obj[inventory.id].setPosition(positionX, positionY);
			inventory = null;
		}

	}

	public void collideWithDummy(int index) {
		if (index!=-1) {
			if (inventory != null && inventory.name.equals("Knife")) {
				gp.dummylist[index] = null;
				gp.ui.showMessage("You killed a player!");
			}
		}
	}

	void hide(int worldX, int worldY) {
		if (!isHidden) {
		isHidden = true;
		this.worldX = worldX;
		this.worldY = worldY;
		}
	}

	void unhide() {
		if (isHidden) {
		isHidden = false;
		this.worldY += Splash.TILE_SIZE;
		}
	}

	public void draw(Graphics2D g2) {
		if (!isHidden) {
			int idx = spriteNum;
			switch (direction) {
			case 'u': idx+=9; 	break;
			case 'd': idx+=0; 	break;
			case 'l': idx+=3;	break;
			case 'r': idx+=6;	break;
			}

			g2.drawImage(charimg, screenX, screenY, screenX+(imgWidth), screenY+(imgHeight),
					idx*imgWidth, 0, (idx+1)*imgWidth, imgHeight, null);
		}
	}

}
