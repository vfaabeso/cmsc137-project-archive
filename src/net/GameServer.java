package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import main.GamePanel;

public class GameServer extends Thread {
    private DatagramSocket socket;
    private GamePanel gamePanel;
    private InetAddress ipAddress;
    
    public GameServer(GamePanel gp) {
        try {
            this.gamePanel = gp;
            this.ipAddress = InetAddress.getByName("0.0.0.0");
            this.socket = new DatagramSocket(6001,this.ipAddress );
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
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String message = new String(packet.getData());
            System.out.println("Client ["+ packet.getAddress().getHostAddress()+":"+packet.getPort()+"> " + message);
            if (message.trim().equalsIgnoreCase("ping")) {
                System.out.println("Returning pong");
                sendData("pong".getBytes(), packet.getAddress(), packet.getPort());
            }   
            
        }
    }

    public void sendData(byte[] data, InetAddress ipAddress, int port) {
        DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
        try {
            this.socket.send(packet);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
