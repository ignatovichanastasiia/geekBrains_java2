package serverChat.serverSide;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private MyServer myServer;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String name;

    public ClientHandler(MyServer myServer, Socket socket) {

        try {
            this.myServer = myServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            this.name = "";

            new Thread(() -> {
                try {
                    authentication();
                    readMessage();
                } catch (IOException i) {
                    i.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();

        } catch (IOException e) {
            System.out.println("Server problem");
        }
    }

    public String getName() {
        return name;
    }

    private void authentication() {
        while (true) {
            try {
                String authStr = dis.readUTF();
                if (authStr.startsWith("/auth")) {
                    String[] arr = authStr.split("\\s");
                    String nick = myServer.getAuthService().getNickByLoginAndPassword(arr[1], arr[2]);
                    if (!nick.isEmpty()) {
                        if (!myServer.isNickBusy(nick)) {
                            sendMessage("/authok " + nick);
                            name = nick;
                            myServer.sendMessageToClients(name + " joined to chat");
                            myServer.subscrible(this);
                            return;
                        } else {
                            sendMessage(name + " is busy");
                        }
                    } else {
                        sendMessage("Wrong login/password");
                    }
                }
            } catch (IOException ignored) {
            }
        }

    }

    public void sendMessage(String message) {
        try {
            dos.writeUTF(message);
        } catch (IOException ignored) {
        }
    }

    private void readMessage() throws IOException {
        while (true) {
            String messageFromClient = dis.readUTF();
            if (messageFromClient.equals("/q")) {
//                closeConnection();
                sendMessage(messageFromClient);
                return;
            }

            myServer.sendMessageToClients(name +": " + messageFromClient);
        }
    }

    private void closeConnection() {
        myServer.unsubscrible(this);
        myServer.sendMessageToClients(name + " leave chat");
    }
}
