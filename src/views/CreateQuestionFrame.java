package views;

import javax.swing.*;
import java.awt.*;

public class CreateQuestionFrame extends StandartFormatLog{

    public CreateQuestionFrame(){


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
        ButtonGroup mathType = new ButtonGroup();
        JRadioButton somaRadio = new JRadioButton("SOMA");
        mathType.add(somaRadio);
        JRadioButton subtracaoRadio = new JRadioButton("SUBTRAÇÃO");
        mathType.add(subtracaoRadio);
        JRadioButton ambosRadio = new JRadioButton("AMBOS");
        mathType.add(ambosRadio);
        panel.add(somaRadio);
        panel.add(subtracaoRadio);
        panel.add(ambosRadio);
        addComponet(panel,2,1,1,1);

        label = new JLabel("PERGUNTA: ");
        addComponet(label,3,0,1,1);
        JTextArea question = new JTextArea(5,30);
        scrollPane = new JScrollPane(question);
        addComponet(scrollPane,3,1,1,5);

        label = new JLabel("RESPOSTAS");
        addComponet(label,9,0,1,1);
        panel = new JPanel();
        ButtonGroup alternatives = new ButtonGroup();
        JRadioButton alternativeOne = new JRadioButton("resposta 1");
        alternatives.add(alternativeOne);
        JRadioButton alternativeTwo = new JRadioButton("resposta 2");
        alternatives.add(alternativeTwo);
        JRadioButton alternativeThree = new JRadioButton("resposta 3");
        alternatives.add(alternativeThree);
        panel.add(alternativeOne);
        panel.add(alternativeTwo);
        panel.add(alternativeThree);
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
