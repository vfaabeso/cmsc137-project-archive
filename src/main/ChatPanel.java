package main;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ChatPanel extends JPanel implements ActionListener {

    JLabel chatLabel = new JLabel("GAME CHAT", null, SwingConstants.HORIZONTAL);
	JButton btn_send = new JButton("SEND");

	JTextArea chatArea = new JTextArea();
	JTextArea messageArea = new JTextArea();

	JScrollPane scrollBar = new JScrollPane(chatArea);
	JScrollPane scrollBar2 = new JScrollPane(messageArea);
    
    ChatPanel() {
        this.setBounds(2*(Splash.SCREEN_WIDTH/3),0,(Splash.SCREEN_WIDTH/3)-20, Splash.SCREEN_HEIGHT);
		this.setBackground(Splash.BACKGROUND);
		this.setDoubleBuffered(true);
		//this.addKeyListener(keyH);
		this.setFocusable(false);
        this.setLayout(null);

        chatLabel.setBounds(0, 0, Splash.SCREEN_WIDTH/3, 40);
		chatLabel.setForeground(Splash.CUSTOM_WHITE);
		chatLabel.setFont(Splash.secondaryFont.deriveFont(Font.BOLD, 30f));
		this.add(chatLabel);

        createChatArea();
		createMessageArea();

        btn_send.setBounds(0, 490, this.getWidth(), 40);
		btn_send.setFont(Splash.secondaryFont.deriveFont(Font.PLAIN, 22f));
		btn_send.addActionListener(this);
        this.add(btn_send);
    }

    private void createChatArea() {
		chatArea.setBackground(Splash.BACKGROUND);
		chatArea.setForeground(Splash.CUSTOM_LIGHTBLUE);
		chatArea.setBounds(0,40,(Splash.SCREEN_WIDTH/3)-20, Splash.SCREEN_HEIGHT-200);
		chatArea.setFont(Splash.secondaryFont.deriveFont(Font.PLAIN, 18f));
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setMargin(new Insets(10,10,10,10));
		chatArea.setEnabled(false);

		scrollBar.setBounds(0,40,(Splash.SCREEN_WIDTH/3)-20, Splash.SCREEN_HEIGHT-200);

		this.add(scrollBar);
	}

    private void createMessageArea() {
		messageArea.setBackground(Splash.CUSTOM_LIGHTBLUE);
		messageArea.setForeground(Splash.BACKGROUND);
		messageArea.setBounds(0,417,(Splash.SCREEN_WIDTH/3)-20, Splash.SCREEN_HEIGHT/8);
		messageArea.setFont(Splash.secondaryFont.deriveFont(Font.PLAIN, 18f));
		messageArea.setLineWrap(true);
		messageArea.setWrapStyleWord(true);
		messageArea.setMargin(new Insets(10,10,10,10));

		scrollBar2.setBounds(0,417,(Splash.SCREEN_WIDTH/3)-20, Splash.SCREEN_HEIGHT/8);

		this.add(scrollBar2);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = messageArea.getText();

		if(e.getSource() == btn_send) {
			if (!str.isEmpty()){
				messageArea.setText(null);
				//chatArea.append(name + ":\n" + str + "\n\n\n");
                chatArea.append("Player" + ":\n" + str + "\n\n\n");
			}
		}
    }
}
