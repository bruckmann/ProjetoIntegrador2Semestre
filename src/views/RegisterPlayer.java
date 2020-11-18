package views;

import Entities.User;
import Util.ViewHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;


public class RegisterPlayer extends StandartFormatLog {
    private WindowManager frame;
    private ViewHelper helper = new ViewHelper();

    public RegisterPlayer(WindowManager windowManager){

        this.frame = windowManager;

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
        name.setName("nome");
        addComponet(name,2,1,3,1);

        label = new JLabel("SENHA: ");
        addComponet(label, 3,0,1,1);
        JPasswordField password = new JPasswordField();
        password.setName("Senha");
        addComponet(password, 3,1,3,1);

        label = new JLabel("IDADE: ");
        addComponet(label, 4,0,1,1);
        JTextField yearsOld = new NumberMask(3);
        yearsOld.setName("Idade");
        addComponet(yearsOld,4,1,3,1);

        label = new JLabel("SERIE: ");
        addComponet(label, 6,0,1,1);
        JTextField grade = new NumberMask(1);
        grade.setName("Série");
        addComponet(grade,6,1,3,1);

        label = new JLabel("TDAH: ");
        addComponet(label, 7,0,1,1);
        panel = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton jRadioButton = new JRadioButton("SIM");
        jRadioButton.setName("Tdah");
        buttonGroup.add(jRadioButton);
        JRadioButton jRadioButton2 = new JRadioButton("NÃO");
        buttonGroup.add(jRadioButton2);
        panel.add(jRadioButton);
        panel.add(jRadioButton2);
        addComponet(panel,7,1,1,1);

        JButton button = new JButton("CRIAR CONTA");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<JTextField> emptyFields;
                boolean isButtonSelected;
                List<JTextField> aJTextList = new ArrayList<JTextField>();
                aJTextList.add(name);
                aJTextList.add(yearsOld);
                aJTextList.add(grade);

                emptyFields = helper.validateFields(aJTextList);
                boolean isPssValid = password.getPassword().length > 0;
                isButtonSelected = (jRadioButton.isSelected()) || (jRadioButton2.isSelected());

                if(emptyFields.isEmpty() && isButtonSelected && isPssValid) {
                    frame.ReturnToLogPage();
                } else {
                    for(JTextField field : emptyFields) {
                        System.out.println("O campo " + field.getName() + " não está preenchido\n");
                    }
                    if(!isButtonSelected) {
                        System.out.println("O botão " + jRadioButton.getName() + " não está selecionado\n");
                    }
                    if(!isPssValid) {
                        System.out.println("O campo " + password.getName() + " não está preenchido\n");

                    }
                    System.out.println("-----------------------");
                }
            }
        });
        button.setForeground(Color.BLUE);
        addComponet(button, 10,1,1,1);
    }
}

