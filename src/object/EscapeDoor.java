package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class EscapeDoor extends SuperObject {
	public static final String IMGPATH = "/res/objects/escapedoor.png";
	public EscapeDoor(int id, int worldX, int worldY) {
		super(id, "EscapeDoor", worldX, worldY);
		try {
			image = ImageIO.read(getClass().getResourceAsStream(IMGPATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
