package serverChat.serverSide;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {
    private final int PORT = 8081;
    private List<ClientHandler> clientsList;
    private AuthenticationService authService;

    public AuthenticationService getAuthService(){
        return this.authService;
    }
    public MyServer(){
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            this.authService = new AuthenticationServiceImpl();
            authService.start();
            clientsList = new ArrayList<>();
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(this, socket);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally {
            if(authService!=null){
                authService.stop();
            }
        }
    }

    public synchronized void sendMessageToClients(String message){
        String[] arr = message.trim().split("\\s");
        if(arr[1].equals("/w")) {
            String nameTo = arr[2];
            if (isNickBusy(nameTo)) {
                sendPrivateMessage(message, nameTo);
            } else {
                System.out.println("Here is no such user");
            }
        }else {
            for (ClientHandler c : clientsList) {
                c.sendMessage(message);
            }
        }
    }

    public synchronized void subscrible(ClientHandler c){
        clientsList.add(c);
    }

    public synchronized void unsubscrible(ClientHandler c){
        clientsList.remove(c);
    }

    public synchronized boolean isNickBusy(String nick){
        for(ClientHandler c: clientsList){
            if(c.getName().equals(nick)){
                return true;
            }
        }
        return false;
    }

    public void sendPrivateMessage(String message, String name){
        for(ClientHandler c: clientsList){
            if(c.getName().equals(name)){
                c.sendMessage(message);
            }
        }
    }
}
