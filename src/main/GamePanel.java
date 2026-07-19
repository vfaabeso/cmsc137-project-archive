package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.Socket;

import javax.swing.JPanel;

import entity.Dummy;
import entity.DummySetter;
import entity.Player;
import environment.EnvironmentManager;
import object.SuperObject;
import tile.TileManager;


@SuppressWarnings("serial")
	public class GamePanel extends JPanel {

	public UI ui = new UI(this);

	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	Thread gameThread;

	EnvironmentManager eManager = new EnvironmentManager(this);

	public CollisionChecker cChecker = new CollisionChecker(this);
	AssetSetter aSetter = new AssetSetter(this);
	DummySetter dSetter = new DummySetter(this);

	//public Player player = new Player(this, keyH);
	public Player player, player2;

	public SuperObject[] obj = new SuperObject[50];
	public Dummy[] dummylist = new Dummy[30];

	GamePanel() {
		this.setBounds(0,0,2*(Splash.SCREEN_WIDTH/3),Splash.SCREEN_HEIGHT);
		this.setBackground(Color.red);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	void instantiatePlayer(int playerId) {
		player = new Player(this, keyH, playerId);	// include playerId to change the character image
	}

	private void ensurePlayerExists() {
		if (player == null) {
			instantiatePlayer(1);
		}
	}

	void setupGame() {
		aSetter.setObject();
		dSetter.setDummies();
		eManager.setup();
	}

	void update() {
		ensurePlayerExists();
		player.update();
		//dummy.update();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		ensurePlayerExists();

		if (player.isHidden) ui.showMessage("Press E to unhide");
		else {
			tileM.draw(g2);

			for (int i = 0; i < obj.length; i++) {
				if (obj[i] != null) {
					obj[i].draw(g2, this);
				}
			}
			for (int i = 0; i < dummylist.length; i++) {
				if (dummylist[i] != null) {
					dummylist[i].draw(g2, this);
				}
			}
			player.draw(g2);

		}
		eManager.draw(g2);

		ui.draw(g2);

		g2.dispose();
	}
}
