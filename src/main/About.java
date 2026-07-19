package main;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About implements ActionListener {

	JFrame aboutScreen = new JFrame("Tagu-taguan");
	JButton btn_back = new JButton("BACK");
	JLabel label = new JLabel();

	About() {

		// back button settings
        btn_back.setBounds(10,15,100,30);
		btn_back.setFocusable(false);
		btn_back.addActionListener(this);
        btn_back.setFont(Splash.secondaryFont.deriveFont(Font.PLAIN, 18f));
		aboutScreen.add(btn_back);

		aboutScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aboutScreen.setSize(Splash.SCREEN_WIDTH,Splash.SCREEN_HEIGHT);
		aboutScreen.setLayout(null);
		aboutScreen.setResizable(false);
		aboutScreen.setLocationRelativeTo(null);
		aboutScreen.getContentPane().setBackground(Splash.BACKGROUND);
		
		Image img = new ImageIcon(this.getClass().getResource("/res/screen/About.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(-10, 0, Splash.SCREEN_WIDTH, Splash.SCREEN_HEIGHT-50);
		aboutScreen.add(label);

		aboutScreen.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn_back) {
			aboutScreen.dispose();
			Splash splashScreen = new Splash();
		}

	}
}
