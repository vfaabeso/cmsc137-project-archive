package tile;

import main.GamePanel;
import main.Splash;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

public class TileManager {
	GamePanel gp;
	public Tile[] tile;
	BufferedImage tileset;

	public int mapTileNum[][];

	public TileManager(GamePanel gp) {
		this.gp = gp;

		tile = new Tile[20];
		mapTileNum = new int[Splash.MAX_WORLD_COL][Splash.MAX_WORLD_ROW];
		getTileImage();
		loadMap("/res/maps/basicmap.txt");
	}


	public void getTileImage() {
		try {
			tileset = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tileset.png"));
			// generate the tiles here
			tile[0] = new Tile(0, 3, "Wood Floor", false);
			tile[1] = new Tile(2, 0, "Upper Left Wall", true);
			tile[2] = new Tile(3, 0, "Upper Wall", true);
			tile[3] = new Tile(4, 0, "Upper Right Wall", true);
			tile[4] = new Tile(2, 1, "Left Wall", true);
			tile[5] = new Tile(3, 1, "Middle Wall", true);
			tile[6] = new Tile(4, 1, "Right Wall", true);
			tile[7] = new Tile(2, 2, "Lower Left Wall", true);
			tile[8] = new Tile(3, 2, "Lower Wall", true);
			tile[9] = new Tile(4, 2, "Lower Right Wall", true);
			tile[10] = new Tile(0, 1, "Closed Upper Wall", true);
			tile[11] = new Tile(0, 2, "Closed Lower Wall", true);
			tile[12] = new Tile(1, 1, "Closed Right Wall", true);
			tile[13] = new Tile(1, 2, "Closed Left Wall", true);
			tile[14] = new Tile(1, 3, " Broken Wood Floor", false);
			

		} catch (IOException e ) {
			e.printStackTrace();
		}
	}

	public void loadMap(String path) {
		try {
			InputStream is = getClass().getResourceAsStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0, row=0;
			while (col < Splash.MAX_WORLD_COL && row < Splash.MAX_WORLD_ROW) {
				String line = br.readLine();
				while (col < Splash.MAX_WORLD_COL) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);

					mapTileNum[col][row] = num;
					col++;
				}
				if (col == Splash.MAX_WORLD_COL) {
					col = 0; row++;
				}
			}
			br.close();

		} catch (Exception e) {

		}
	}

	public void draw(Graphics2D g2) {
		int worldcol=0, worldrow=0;
		while (worldcol<Splash.MAX_WORLD_COL && worldrow<Splash.MAX_WORLD_ROW) {
			int tileNum = mapTileNum[worldcol][worldrow];
			int xorig =tile[tileNum].xcoord*Splash.ORIGINAL_TILE_SIZE;
			int yorig =tile[tileNum].ycoord*Splash.ORIGINAL_TILE_SIZE;

			int worldX = worldcol * Splash.TILE_SIZE;
			int worldY = worldrow * Splash.TILE_SIZE;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;

			if (worldX + Splash.TILE_SIZE > gp.player.worldX - gp.player.screenX &&
				worldX - Splash.TILE_SIZE < gp.player.worldX + gp.player.screenX &&
				worldY + Splash.TILE_SIZE > gp.player.worldY - gp.player.screenY &&
				worldY - Splash.TILE_SIZE < gp.player.worldY + gp.player.screenY) {
				g2.drawImage(tileset, screenX, screenY,
						screenX+Splash.TILE_SIZE, screenY+Splash.TILE_SIZE,
						xorig, yorig,
						xorig+Splash.ORIGINAL_TILE_SIZE, yorig+Splash.ORIGINAL_TILE_SIZE, null);
			}

			worldcol++;

			if (worldcol == Splash.MAX_WORLD_COL) {
				worldcol=0;worldrow++;
			}

		}

	}
}
