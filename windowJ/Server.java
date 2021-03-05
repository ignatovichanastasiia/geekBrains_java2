package windowJ;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket socket = null;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            //поток на сервер
            @Override
            public void run() {
                try (ServerSocket serverSocket = new ServerSocket(8080)) {
                    System.out.println("Сервер запущен...");
                    socket = serverSocket.accept();
                    System.out.println("Клиент подключился");
                    //вход и выход
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    while (true) {
                        String clientMessage = dis.readUTF();
                        System.out.println(clientMessage);
                        if (clientMessage.equalsIgnoreCase("/q")) {
                            dos.writeUTF(clientMessage);
                            break;
                        }
                        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
                        //чтение с консоли
                        dos.writeUTF("Server: " + buffer.readLine());
                        //вывод ридера
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}