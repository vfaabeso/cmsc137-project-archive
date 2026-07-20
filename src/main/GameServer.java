package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {

    private ServerSocket ss;
    private int numPlayers;
    private int maxPlayers;

    //TODO: add other sockets and runnables for other players 
    private Socket socket1, socket2;    
    private ReadFromClient readP1, readP2;
    private WriteToClient writeP1, writeP2;

    public GameServer() {
        System.out.println("----Game Server----");
        numPlayers = 0;
        maxPlayers = 4;

        try {
            ss = new ServerSocket(12345, 0, InetAddress.getByName("0.0.0.0"));
        } catch (IOException e) {
            System.out.println("IOException from Game Server Constructor");
        }
    }

    // server waiting for connections
    public void acceptConnections() {
        try {
            System.out.println("Waitng for Connections...");

            while (numPlayers < maxPlayers) {
                Socket s = ss.accept();     //server to begin accepting connections
                DataInputStream in = new DataInputStream(s.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());

                numPlayers++;
                out.writeInt(numPlayers);   //first thing the server do: send number of players
                System.out.println("Player #" + numPlayers + " has connected");

                ReadFromClient rfc = new ReadFromClient(numPlayers, in);
                WriteToClient wtc = new WriteToClient(numPlayers, out);

                // assign correct objects to the fields     //TODO: add other players
                if (numPlayers == 1){
                    socket1 = s;
                    readP1 = rfc;
                    writeP1 = wtc;
                } else if (numPlayers == 2){
                    socket2 = s;
                    readP2 = rfc;
                    writeP2 = wtc;
                }
            }
            
            System.out.println("We now have " + maxPlayers + " players");
        } catch (IOException e) {
            System.out.println("IOException in accepting connections");
        }
    }

    private class ReadFromClient implements Runnable {
        private int playerId;
        private DataInputStream dataIn;

        public ReadFromClient(int pid, DataInputStream in){
            playerId = pid;
            dataIn = in;
            System.out.println("Read from player " + playerId);
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'run'");
        }
    }

    private class WriteToClient implements Runnable {
        private int playerId;
        private DataOutputStream dataOut;

        public WriteToClient(int pid, DataOutputStream out){
            playerId = pid;
            dataOut = out;
            System.out.println("Write to player " + playerId);
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'run'");
        }
    }

    public static void main(String[] args) {
        GameServer gs = new GameServer();
        gs.acceptConnections();
    }

}
