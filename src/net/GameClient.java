package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import main.GamePanel;

public class GameClient extends Thread {
    private InetAddress ipAddress;
    private DatagramSocket socket;
    private GamePanel gamePanel;
    
    public GameClient(GamePanel gp, String ipAddress) {
        try {
            this.gamePanel = gp;
            this.ipAddress = InetAddress.getByName(ipAddress);
            this.socket = new DatagramSocket(6001, this.ipAddress);
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length, this.ipAddress, 6001);//new DatagramPacket(data, data.length); DatagramPacket()
            try {
                socket.receive(packet);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String message = new String(packet.getData());
            System.out.println("Server > " + message);
        }
    }

    public void sendData(byte[] data) {
        DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, 6001);
        try {
            socket.send(packet);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
