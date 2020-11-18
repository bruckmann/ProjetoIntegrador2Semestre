package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogWindow extends StandartFormatLog {
    private WindowManager frame;
    public LogWindow (WindowManager windowManager){

        this.frame = windowManager;

        init();
    }

    private void init(){


        JLabel label;
        JSeparator separator;
        JTextField textField;
        JPasswordField passwordField;
        JButton button;

        label = new JLabel("OLÁ FAÇA SEU LOGIN");
        label.setForeground(Color.BLACK);
        addComponet(label, 0, 0,5,2);

        label = new JLabel("NOME: ");
        addComponet(label,2,0,1,1);
        textField = new JTextField(20);
        addComponet(textField, 2,1,3,1);

        label = new JLabel("SENHA: ");
        addComponet(label, 3,0,1,1);
        passwordField = new JPasswordField(20);
        addComponet(passwordField, 3,1,3,1);


        label = new JLabel("CRIAR CONTA: ");
        addComponet(label, 5,0,1,1);

        button = new JButton("ADMINISTRADOR");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showLogAdm();
            }
        });
        button.setForeground(Color.BLUE);
        addComponet(button, 5,1,1,1);

        JButton button2 = new JButton("JOGADOR");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showLogPlayer();
            }
        });
        button2.setForeground(Color.RED);
        addComponet(button2, 5,2,1,1);


        label = new JLabel(" ");
        addComponet(label, 6,0,1,1);

        JButton buttonLog = new JButton("LOGAR");
        /*buttonLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


        }); */

        buttonLog.setForeground(Color.MAGENTA);
        addComponet(buttonLog,7,1,1,1);
    }

}
