package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Key extends SuperObject {
	public static final String IMGPATH = "/res/objects/key.png";
	public Key(int id, int worldX, int worldY) {
		super(id, "Key", worldX, worldY);
		try {
			image = ImageIO.read(getClass().getResourceAsStream(IMGPATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
