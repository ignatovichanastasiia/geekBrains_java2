package windowJ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Шаблон чата");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(300, 100, 400, 500);
        jFrame.setResizable(false);

        JTextArea jTextArea = new JTextArea("Текст арея\n");
        jTextArea.setBackground(Color.lightGray);
        jTextArea.setLineWrap(true);
        jTextArea.setLayout(null);
        jFrame.add(jTextArea, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JTextField jTextField = new JTextField();
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
                if(e.getKeyCode() == KeyEvent.VK_ENTER ) {
                    jTextArea.append("Ник: " + jTextField.getText() + "\n");
                    jTextField.setText("");
                }
            }
        });
        JButton answertButton = new JButton("Написать");
        panel.add(answertButton, BorderLayout.CENTER);
        answertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                jTextArea.append("Ник: " + jTextField.getText() + "\n");
                jTextField.setText("");
            }

        });
        jFrame.add(panel, BorderLayout.SOUTH);
        JScrollPane scrollBar = new JScrollPane(jTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jFrame.add(scrollBar);
        jFrame.setVisible(true);
    }
}

