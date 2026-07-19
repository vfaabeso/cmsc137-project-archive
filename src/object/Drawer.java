package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Drawer extends SuperObject {
	public static final String IMGPATH = "/res/objects/drawer.png";
	public Drawer(int id, int worldX, int worldY) {
		super(id, "Drawer", worldX, worldY);
		try {
			image = ImageIO.read(getClass().getResourceAsStream(IMGPATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
