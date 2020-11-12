package views;

import javax.swing.*;
import java.awt.*;

public class RegisterPlayer extends  WindowPatternFrame{
    private GridBagLayout layout;


    public RegisterPlayer(){
        super("Janela Cadastro Player");

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

        label = new JLabel("SERIE: ");
        addComponet(label, 6,0,1,1);
        JTextField textField4 = new NumberMask(1);
        addComponet(textField4,6,1,3,1);

        label = new JLabel("TDAH: ");
        addComponet(label, 7,0,1,1);
        label = new JLabel("SIM");
        addComponet(label, 7,1,1,1);
        JCheckBox jCheckBox = new JCheckBox();
        addComponet(jCheckBox,7,2,1,1);
        label = new JLabel("NÃO");
        addComponet(label, 8,1,1,1);
        JCheckBox jCheckBox1 = new JCheckBox();
        addComponet(jCheckBox1,8,2,1,1);


        JButton button = new JButton("CRIAR CONTA");
        button.setForeground(Color.BLUE);
        addComponet(button, 9,1,1,1);
    }


}

