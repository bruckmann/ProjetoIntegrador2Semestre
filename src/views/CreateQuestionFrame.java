package views;

import javax.swing.*;
import java.awt.*;

public class CreateQuestionFrame extends StandartFormatLog{

    public CreateQuestionFrame(){

        super("Janela criação de perguntas");

        init();
    }

    private void init(){
        JLabel label;
        JPanel panel;
        JScrollPane scrollPane;

        label = new JLabel("OLÁ CRIE AQUI SUAS PERGUNTAS: ");
        addComponet(label, 0, 0,5,2);

        label = new JLabel("TIPO: ");
        addComponet(label,2,0,1,1);
        panel = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton jRadioButton = new JRadioButton("SOMA");
        buttonGroup.add(jRadioButton);
        JRadioButton jRadioButton2 = new JRadioButton("SUBTRAÇÃO");
        buttonGroup.add(jRadioButton2);
        JRadioButton jRadioButton3 = new JRadioButton("AMBOS");
        buttonGroup.add(jRadioButton3);
        panel.add(jRadioButton);
        panel.add(jRadioButton2);
        panel.add(jRadioButton3);
        addComponet(panel,2,1,1,1);

        label = new JLabel("PERGUNTA: ");
        addComponet(label,3,0,1,1);
        JTextArea textArea = new JTextArea(5,30);
        scrollPane = new JScrollPane(textArea);
        addComponet(scrollPane,3,1,1,5);

        label = new JLabel("RESPOSTAS");
        addComponet(label,9,0,1,1);
        panel = new JPanel();
        ButtonGroup buttonGroup1 = new ButtonGroup();
        JRadioButton jRadioButton4 = new JRadioButton("resposta 1");
        buttonGroup1.add(jRadioButton4);
        JRadioButton jRadioButton5 = new JRadioButton("resposta 2");
        buttonGroup1.add(jRadioButton5);
        JRadioButton jRadioButton6 = new JRadioButton("resposta 3");
        buttonGroup1.add(jRadioButton6);
        panel.add(jRadioButton4);
        panel.add(jRadioButton5);
        panel.add(jRadioButton6);
        addComponet(panel,9,1,1,1);

        JPanel panel2 = new JPanel();
        JTextField textField = new NumberMask(10,8);
        JTextField textField2 = new NumberMask(10,8);
        JTextField textField3 = new NumberMask(10,8);
        panel2.add(textField);
        panel2.add(textField2);
        panel2.add(textField3);
        addComponet(panel2,10,1,5,1);


        JButton button = new JButton("CADASTRAR");
        button.setForeground(Color.BLUE);
        addComponet(button,13,1,1,1);


    }
}
