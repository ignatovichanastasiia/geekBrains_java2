package windowJ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Window extends JFrame {
    private final static String IP_ADDRESS = "localhost"; //127.0.0.1
    private final static int SERVER_PORT = 8189;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    public JTextArea jTextArea;
    public JTextField jTextField;
//    private String clientMessage;
//    private String messageToServer;


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Window();
        });
    }

    private Window() {
        connection();
        prepareWindow();

    }

    private void connection() {
        try {
            //сокет, вход, выход
            socket = new Socket(IP_ADDRESS, SERVER_PORT);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                while (true) {
                    try {
                        String serverMessage = dis.readUTF();
                        if (serverMessage.equals("/q")) {
                            closeConnection();
                            break;
                        }
                        jTextArea.append("Server: " + serverMessage + "\n");
                    } catch (IOException ignored) {
                    }
                }
            }).start();
        } catch (IOException ignored) {
        }
    }

    private void prepareWindow() {
        //окно
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Чат");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(300, 100, 400, 500);
        jFrame.setResizable(false);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    dos.writeUTF("/q");
                    closeConnection();
                } catch (IOException z) {
                    z.printStackTrace();
                }
            }
        });

        //текстовое поле
        jTextArea = new JTextArea("Текст арея\n");
        jTextArea.setBackground(Color.lightGray);
        jTextArea.setLineWrap(true);
        jTextArea.setLayout(null);
        jFrame.add(jTextArea, BorderLayout.CENTER);

        //панель
        JPanel panel = new JPanel();
        jTextField = new JTextField();
        panel.setLayout(new GridLayout(1, 2));
        jTextField.setSize(20, 20);
        jTextField.setBackground(Color.white);
        panel.add(jTextField, BorderLayout.PAGE_START);
        jTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessageToServer();
                }
            }
        });

        //кнопка
        JButton answerButton = new JButton("Написать");
        panel.add(answerButton, BorderLayout.CENTER);
        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessageToServer();
            }
        });
        jFrame.add(panel, BorderLayout.SOUTH);
        JScrollPane scrollBar = new JScrollPane(jTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jFrame.add(scrollBar);
        jFrame.setVisible(true);
    }


    //закрывашка
    private void closeConnection() {
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


    //отправка сообщений в чат и на сервер
    private void sendMessageToServer() {
        if (!jTextField.getText().trim().isEmpty()) {
            try {
                String messageToServer = jTextField.getText();
                dos.writeUTF(messageToServer);
                jTextArea.append("User: " + messageToServer + "\n");
                jTextField.setText("");
            } catch (IOException ignored) {
            }
        }
    }

}

