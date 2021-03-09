package serverChat.clientSide;

import serverChat.clientSide.clientSide1.Window;
import serverChat.clientSide.clientSide2.Window2;
import serverChat.clientSide.clientSide3.Window3;

import javax.swing.*;

public class ClientWindowsApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Window();
            new Window2();
            new Window3();
        });
    }
}
