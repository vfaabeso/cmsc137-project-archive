package main;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.Player;

public class GameStage extends JFrame implements Runnable {
	
	GamePanel gameScreen = new GamePanel();
	ChatPanel chatScreen = new ChatPanel();

	String role, name;

	Thread gameThread;
	final int FPS = 60;

	private Socket socket;
	private int playerId;

	private ReadFromServer rfs;
	private WriteToServer wts;

	KeyHandler keyH = new KeyHandler(gameScreen);

	public Player player, player2;

	GameStage(String role, String name){
		this.role = role;
		this.name = name;

		this.setTitle("Tagu-taguan");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Splash.SCREEN_WIDTH,Splash.SCREEN_HEIGHT);

		this.setLayout(null);
		this.setResizable(false);

		this.getContentPane().setBackground(Splash.BACKGROUND);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		this.add(gameScreen);
		this.add(chatScreen);

		// initially disable the game chat
		setPanelEnabled(chatScreen, false);
		chatScreen.messageArea.setEnabled(false);

		// enable or disable a panel through a mouse click on the game screen
		gameScreen.addMouseListener(new MouseAdapter () {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Game Screen");

				if (gameScreen.isEnabled()){
					setPanelEnabled(chatScreen, true);
					setPanelEnabled(gameScreen, false);
					chatScreen.messageArea.setEnabled(true);
				} else {
					setPanelEnabled(chatScreen, false);
					setPanelEnabled(gameScreen, true);
					chatScreen.messageArea.setEnabled(false);
					gameScreen.update();
				}
			}
		});

		// setup the actual game
		this.connectToServer();	// connect to the server
		gameScreen.setupGame();

		try {
			this.startGameThread();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// function to enable or disable the panel and its components
	static void setPanelEnabled(JPanel panel, Boolean isEnabled) {
		panel.setEnabled(isEnabled);
		Component[] components = panel.getComponents();

		for(int i = 0; i < components.length; i++) {
			if(components[i].getClass().getName() == "javax.swing.JPanel") {
				setPanelEnabled((JPanel) components[i], isEnabled);
			}
			components[i].setEnabled(isEnabled);
		}
	}

	// function to connect to the server
	void connectToServer() {
		playerId = 1;
		try {
			socket = new Socket("localhost", 12345);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());

			// accept the number of players
			playerId = in.readInt();
			System.out.println("You are Player #" + playerId);

			if (playerId != 4) {
				System.out.println("Waiting for other players to connect");
			}

			//gameScreen.player = new Player(gameScreen, keyH, playerId);	// include playerId to change the character image
			gameScreen.instantiatePlayer(playerId);

			rfs = new ReadFromServer(in);
			wts = new WriteToServer(out);
		} catch (Exception e) {
			System.out.println("Error in connecting to server. Starting in offline mode.");
			gameScreen.instantiatePlayer(playerId);
		}
	}

	// function to start the game thread
	void startGameThread() throws IOException {
		gameThread = new Thread(this);
		gameThread.start();
	}

	private class ReadFromServer implements Runnable {
        private DataInputStream dataIn;

        public ReadFromServer(DataInputStream in){
            dataIn = in;
            System.out.println("Read from Server");
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'run'");
        }
    }

	private class WriteToServer implements Runnable {
        private DataOutputStream dataOut;

        public WriteToServer(DataOutputStream out){
            dataOut = out;
            System.out.println("Write to Server");
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'run'");
        }
    }

	@Override
	public void run() {

		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;

		while (gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if (delta >= 1) {
				// update
				gameScreen.update();

				// draw
				gameScreen.repaint();
				delta--;
			}

			if (timer >= 1000000000) timer = 0;
		}
	}
	
}
