package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Splash implements ActionListener {
	// SCREEN SETTINGS
	public static final int ORIGINAL_TILE_SIZE = 32;
	public static final int SCALE = 3;

	public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;
	public static final int MAX_SCREEN_COL = 8;
	public static final int MAX_SCREEN_ROW = 6;
	public static final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
	public static final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;

	// WORLD SETTINGS
	public static final int MAX_WORLD_COL = 40;
	public static final int MAX_WORLD_ROW = 24;
	public static final int WORLD_WIDTH = TILE_SIZE * MAX_WORLD_COL;
	public static final int WORLD_HEIGHT = TILE_SIZE * MAX_WORLD_ROW;

	public static Font primaryFont;
	public static Font secondaryFont;

	final static Color CUSTOM_YELLOW = new Color(255, 200, 87);
	final static Color CUSTOM_GREEN = new Color(189, 217, 191);
	final static Color CUSTOM_WHITE = new Color(246, 241, 241);
	final static Color CUSTOM_LIGHTBLUE = new Color(138, 166, 191);
	final static Color BACKGROUND = new Color(21, 34, 46);
	final static Color CUSTOM_DARKGREY = new Color(40, 40, 40, 200);

	JFrame frame = new JFrame("Tagu-taguan");
	JButton btn_game = new JButton("NEW GAME");
	JButton btn_inst = new JButton("GUIDE");
	JButton btn_about = new JButton("ABOUT");

	JLabel label = new JLabel();

	InputStream is;

	public Splash() {

		try {
			is = getClass().getResourceAsStream("/res/font/Broken-Console.ttf");
			primaryFont = Font.createFont(Font.TRUETYPE_FONT, is);
			is = getClass().getResourceAsStream("/res/font/VT323.ttf");
			secondaryFont = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// create buttons
		btn_game.setBounds(320,180,130,40);
		btn_game.setFont(secondaryFont.deriveFont(Font.PLAIN, 21f));
		btn_game.setFocusable(false);
		btn_game.addActionListener(this);

		btn_inst.setBounds(320,240,130,40);
		btn_inst.setFont(secondaryFont.deriveFont(Font.PLAIN, 21f));
		btn_inst.setFocusable(false);
		btn_inst.addActionListener(this);

		btn_about.setBounds(320,300,130,40);
		btn_about.setFont(secondaryFont.deriveFont(Font.PLAIN, 21f));
		btn_about.setFocusable(false);
		btn_about.addActionListener(this);

		// background image
		Image img = new ImageIcon(this.getClass().getResource("/res/screen/Splash.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, -40, Splash.SCREEN_WIDTH, Splash.SCREEN_HEIGHT);
		frame.add(label);

		// frame settings
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		frame.setLayout(null);
		frame.setFocusable(true);

		frame.getContentPane().setBackground(BACKGROUND);
		frame.setLocationRelativeTo(null);	// display window at the center of the screen
		frame.setVisible(true);

		// add the buttons to the frame
		frame.add(btn_game);
		frame.add(btn_inst);
		frame.add(btn_about);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn_game) {
			frame.dispose();
			NewGame newGame = new NewGame();

		} else if (e.getSource() == btn_inst) {
			frame.dispose();
			Instructions instructionsScreen = new Instructions();

		} else if (e.getSource() == btn_about) {
			frame.dispose();
			About aboutScreen = new About();
		}
	}

}
