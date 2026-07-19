package main;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewGame implements ActionListener{

    JFrame newGameScreen = new JFrame("Tagu-taguan");

    JButton btn_back = new JButton("BACK");
	JButton btn_host = new JButton("Host a Game");
	JButton btn_join = new JButton("Join a Game");

    JTextField usernameField = new JTextField();
    JLabel label = new JLabel();

    NewGame() {

        // back button settings
        btn_back.setBounds(10,15,100,30);
		btn_back.setFocusable(false);
		btn_back.addActionListener(this);
        btn_back.setFont(Splash.secondaryFont.deriveFont(Font.PLAIN, 18f));

        Image img = new ImageIcon(this.getClass().getResource("/res/screen/Game.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, -40, Splash.SCREEN_WIDTH, Splash.SCREEN_HEIGHT);
		newGameScreen.add(label);
        
        // text field settings
        usernameField.setBounds(275, 180, 210, 40);
        usernameField.setFont(Splash.secondaryFont.deriveFont(Font.PLAIN, 25f));

        // host button settings
        btn_host.setBounds(280, 275, 200, 40);
        btn_host.setFont(Splash.secondaryFont.deriveFont(Font.PLAIN, 25f));
        btn_host.setFocusable(false);
		btn_host.addActionListener(this);

        // join button settings
        btn_join.setBounds(280,335, 200, 40);
        btn_join.setFont(Splash.secondaryFont.deriveFont(Font.PLAIN, 25f));
        btn_join.setFocusable(false);
		btn_join.addActionListener(this);

		newGameScreen.add(btn_back);
        newGameScreen.add(usernameField);
        newGameScreen.add(btn_host);
        newGameScreen.add(btn_join);

		newGameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newGameScreen.setResizable(false);
		newGameScreen.setSize(Splash.SCREEN_WIDTH,Splash.SCREEN_HEIGHT);
		newGameScreen.setLayout(null);
		newGameScreen.getContentPane().setBackground(Splash.BACKGROUND);
		newGameScreen.setLocationRelativeTo(null);
		newGameScreen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String name = usernameField.getText();

            if (e.getSource() == btn_back) {
                    System.out.println("Back");
                    newGameScreen.dispose();
                    Splash splashScreen = new Splash();
            }

            if (!name.isEmpty()){    //check if username is not empty
                
                if (e.getSource() == btn_host) {
                    //game server
                    newGameScreen.dispose();
                    System.out.println("Host game");
                    GameStage gamestage = new GameStage("host", name);

                } else if (e.getSource() == btn_join) {
                    //game client
                    newGameScreen.dispose();
                    System.out.println("Join game");
                    GameStage gamestage = new GameStage("join", name);
                }
            }

        } catch (Exception err) {
            System.out.println("Error in action perofrmed");
        }
        
    }
}
