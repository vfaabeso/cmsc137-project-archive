package main;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Instructions implements ActionListener {

	JFrame instScreen = new JFrame("Tagu-taguan");
	JButton btn_back = new JButton("BACK");
	JLabel label = new JLabel();

	Instructions() {
		
		// back button settings
        btn_back.setBounds(10,15,100,30);
		btn_back.setFocusable(false);
		btn_back.addActionListener(this);
        btn_back.setFont(Splash.secondaryFont.deriveFont(Font.PLAIN, 18f));
		instScreen.add(btn_back);

		instScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		instScreen.setSize(Splash.SCREEN_WIDTH,Splash.SCREEN_HEIGHT);
		instScreen.setLayout(null);
		instScreen.setResizable(false);
		instScreen.setLocationRelativeTo(null);
		instScreen.getContentPane().setBackground(Splash.BACKGROUND);

		Image img = new ImageIcon(this.getClass().getResource("/res/screen/Guide.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 10, Splash.SCREEN_WIDTH-50, Splash.SCREEN_HEIGHT-70);
		instScreen.add(label);

		instScreen.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn_back) {
			instScreen.dispose();
			Splash splashScreen = new Splash();
		}
	}

}
