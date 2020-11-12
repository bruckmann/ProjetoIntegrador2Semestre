package views;

import javax.swing.*;
import java.awt.*;

public class RegisterAdm extends StandartFormatLog {

    public RegisterAdm(){
        super("Janela Cadastro Administrador");

        init();
    }

    private void init(){
        JLabel label;

        label = new JLabel("OLÁ INSIRA SEUS DADOS: ");
        addComponet(label, 0, 0,5,2);

        label = new JLabel("NOME: ");
        addComponet(label,2,0,1,1);
        JTextField textField = new JTextField(20);
        addComponet(textField,2,1,3,1);

        label = new JLabel("SENHA: ");
        addComponet(label, 3,0,1,1);
        JPasswordField passwordField = new JPasswordField(20);
        addComponet(passwordField, 3,1,3,1);

        label = new JLabel("IDADE: ");
        addComponet(label, 4,0,1,1);
        JTextField textField2 = new NumberMask(3);
        addComponet(textField2,4,1,3,1);

        label = new JLabel("EMAIL: ");
        addComponet(label, 5,0,1,1);
        JTextField textField3 = new JTextField(20);
        addComponet(textField3,5,1,3,1);

        JButton button = new JButton("CRIAR CONTA");
        button.setForeground(Color.BLUE);
        addComponet(button, 7,1,1,1);
    }

}
