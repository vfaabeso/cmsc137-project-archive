package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Door extends SuperObject {
	public static final String IMGPATH = "/res/objects/door.png";
	public Door(int id, int worldX, int worldY) {
		super(id, "Door", worldX, worldY);
		try {
			image = ImageIO.read(getClass().getResourceAsStream(IMGPATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
