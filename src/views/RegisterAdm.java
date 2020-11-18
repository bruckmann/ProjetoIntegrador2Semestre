package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterAdm extends StandartFormatLog {
    private WindowManager frame;

    public RegisterAdm(WindowManager windowManager){

        this.frame = windowManager;
        init();
    }

    private void init(){
        JLabel label;

        label = new JLabel("OLÁ INSIRA SEUS DADOS: ");
        addComponet(label, 0, 0,5,2);

        label = new JLabel("NOME: ");
        addComponet(label,2,0,1,1);
        JTextField name = new JTextField(20);
        addComponet(name,2,1,3,1);

        label = new JLabel("SENHA: ");
        addComponet(label, 3,0,1,1);
        JPasswordField password = new JPasswordField(10);
        addComponet(password, 3,1,3,1);

        label = new JLabel("IDADE: ");
        addComponet(label, 4,0,1,1);
        JTextField yearsOld = new NumberMask(3);
        addComponet(yearsOld,4,1,3,1);

        label = new JLabel("EMAIL: ");
        addComponet(label, 5,0,1,1);
        JTextField email = new JTextField(20);
        addComponet(email,5,1,3,1);

        JButton button = new JButton("CRIAR CONTA");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.ReturnToLogPage();
            }
        });
        button.setForeground(Color.BLUE);
        addComponet(button, 7,1,1,1);
    }

}
