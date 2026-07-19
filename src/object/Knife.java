package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Knife extends SuperObject {
	public static final String IMGPATH = "/res/objects/knife.png";
	public Knife(int id, int worldX, int worldY) {
		super(id, "Knife", worldX, worldY);
		try {
			image = ImageIO.read(getClass().getResourceAsStream(IMGPATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}