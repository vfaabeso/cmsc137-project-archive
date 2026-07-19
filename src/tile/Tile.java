package tile;

public class Tile {
	public int xcoord, ycoord;
	public String name;
	public boolean collision=false;
	
	public Tile(int x, int y, String name, boolean collision) {
		this.xcoord = x; this.ycoord = y;
		this.name = name;
		this.collision = collision;
	}
}