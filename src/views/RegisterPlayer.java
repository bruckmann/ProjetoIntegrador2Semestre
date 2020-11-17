package views;

import javax.swing.*;
import java.awt.*;


public class RegisterPlayer extends StandartFormatLog {



    public RegisterPlayer(){
        super("Janela Cadastro Player");
        init();
    }

    private void init(){
        JLabel label;
        JPanel panel;

        label = new JLabel("OLÁ INSIRA SEUS DADOS: ");
        addComponet(label, 0, 0,5,2);

        label = new JLabel("NOME: ");
        addComponet(label,2,0,1,1);
        JTextField name = new JTextField(20);
        addComponet(name,2,1,3,1);

        label = new JLabel("SENHA: ");
        addComponet(label, 3,0,1,1);
        JPasswordField password = new JPasswordField();
        addComponet(password, 3,1,3,1);

        label = new JLabel("IDADE: ");
        addComponet(label, 4,0,1,1);
        JTextField yearsOld = new NumberMask(3);
        addComponet(yearsOld,4,1,3,1);

        label = new JLabel("EMAIL: ");
        addComponet(label, 5,0,1,1);
        JTextField textField3 = new JTextField(20);
        addComponet(textField3,5,1,3,1);

        label = new JLabel("SERIE: ");
        addComponet(label, 6,0,1,1);
        JTextField grade = new NumberMask(1);
        addComponet(grade,6,1,3,1);

        label = new JLabel("TDAH: ");
        addComponet(label, 7,0,1,1);
        panel = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton jRadioButton = new JRadioButton("SIM");
        buttonGroup.add(jRadioButton);
        JRadioButton jRadioButton2 = new JRadioButton("NÃO");
        buttonGroup.add(jRadioButton2);
        panel.add(jRadioButton);
        panel.add(jRadioButton2);
        addComponet(panel,7,1,1,1);



        JButton button = new JButton("CRIAR CONTA");
        button.setForeground(Color.BLUE);
        addComponet(button, 10,1,1,1);
    }


}

