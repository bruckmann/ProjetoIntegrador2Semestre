package views;

import Util.ViewHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CreateQuestionFrame extends StandartFormatLog{
    private WindowManager frame;
    private ViewHelper helper = new ViewHelper();

    public CreateQuestionFrame(WindowManager windowManager){
        this.frame = windowManager;

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
        somaRadio.setName("tipo");
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
        question.setName("pergunta");
        scrollPane = new JScrollPane(question);
        addComponet(scrollPane,3,1,1,5);

        label = new JLabel("ALTERNATIVAS");
        addComponet(label,9,0,1,1);
        panel = new JPanel();
        ButtonGroup alternatives = new ButtonGroup();
        JRadioButton alternativeOne = new JRadioButton("alternativa 1");
        alternativeOne.setName("alternativas");
        alternatives.add(alternativeOne);
        JRadioButton alternativeTwo = new JRadioButton("alternativa 2");
        alternatives.add(alternativeTwo);
        JRadioButton alternativeThree = new JRadioButton("alternativa 3");
        alternatives.add(alternativeThree);
        panel.add(alternativeOne);
        panel.add(alternativeTwo);
        panel.add(alternativeThree);
        addComponet(panel,9,1,1,1);

        JPanel panel2 = new JPanel();
        JTextField textField = new NumberMask(10,8);
        textField.setName("alternativa 1");
        JTextField textField2 = new NumberMask(10,8);
        textField2.setName("alternativa 2");
        JTextField textField3 = new NumberMask(10,8);
        textField3.setName("alternativa 3");
        panel2.add(textField);
        panel2.add(textField2);
        panel2.add(textField3);
        addComponet(panel2,10,1,5,1);


        JButton button = new JButton("CADASTRAR");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<JTextField> emptyFields;
                boolean isButtonSelected;
                boolean isButtonTypeSelected;
                List<JTextField> aJTextList = new ArrayList<JTextField>();
                aJTextList.add(textField);
                aJTextList.add(textField2);
                aJTextList.add(textField3);

                emptyFields = helper.validateFields(aJTextList);
                isButtonSelected = (alternativeOne.isSelected()) || (alternativeTwo.isSelected() ||
                        (alternativeThree.isSelected()));

                isButtonTypeSelected = (somaRadio.isSelected()) || (subtracaoRadio.isSelected() ||
                        (ambosRadio.isSelected()));


               // question.getText()
                        boolean isTextArea = question.getText().length() > 0;

                if(emptyFields.isEmpty() && isButtonSelected && isTextArea && isButtonTypeSelected) {
                    JOptionPane.showMessageDialog(CreateQuestionFrame.this,"Criação de pergunta concluida !!",
                            WindowManager.TITULO,
                            JOptionPane.INFORMATION_MESSAGE);
                    frame.ManageQuestionTable();
                } else {
                    if(!isButtonSelected) {
                        JOptionPane.showMessageDialog(CreateQuestionFrame.this,"O botão " + alternativeOne.getName() + " não está selecionado\n",
                                WindowManager.TITULO,
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(!isButtonTypeSelected) {
                        JOptionPane.showMessageDialog(CreateQuestionFrame.this,"O botão " + somaRadio.getName() + " não está selecionado\n",
                                WindowManager.TITULO,
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                    for(JTextField field : emptyFields) {
                        JOptionPane.showMessageDialog(CreateQuestionFrame.this,"O campo " + field.getName() + " não está preenchido\n",
                                WindowManager.TITULO,
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                    if(!isTextArea) {
                        JOptionPane.showMessageDialog(CreateQuestionFrame.this,"O campo " + question.getName() + " não está preenchido\n",
                                WindowManager.TITULO,
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        button.setForeground(Color.BLUE);
        addComponet(button,13,1,1,1);


    }
}
