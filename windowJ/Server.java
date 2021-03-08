package windowJ;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket socket;
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            //вход и выход
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    try {
                        String consMessage = buffer.readLine();
                        if (consMessage.equals("/q")) {
                            closeConnection(dis, dos, socket);
                            break;
                        }
                        dos.writeUTF(consMessage);
                        consMessage = "";

                    } catch (IOException ignored) {
                    }
                }
            }).start();

            while (true) {
                try {
                    String clientMessage = dis.readUTF();
                    System.out.println(clientMessage);
                    if (clientMessage.equals("/q")) {
                        dos.writeUTF(clientMessage);
                        closeConnection(dis, dos, socket);
                        break;
                    }
                } catch (IOException ignored) {
                }
            }
        } catch (IOException ignored) {
        }
    }


    //закрывашка
    private static void closeConnection(DataInputStream dis, DataOutputStream dos, Socket socket) {
        try {
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}