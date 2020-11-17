package views;

import javax.swing.*;
import java.awt.*;

public class RegisterAdm extends StandartFormatLog {

    public RegisterAdm(){


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
        button.setForeground(Color.BLUE);
        addComponet(button, 7,1,1,1);
    }

}
