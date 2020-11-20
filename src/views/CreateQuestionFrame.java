package views;

import Util.ViewHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

public class CreateQuestionFrame extends StandartFormatLog{
    private WindowManager frame;
    private ViewHelper helper = new ViewHelper();

    private  JRadioButton somaRadio;
    private  JRadioButton subtracaoRadio;
    private  JRadioButton ambosRadio;
    private  JTextArea question;
    private  JRadioButton alternativeOne;
    private  JRadioButton alternativeTwo;
    private  JRadioButton alternativeThree;
    private  JTextField answerOne;
    private  JTextField answerTwo;
    private  JTextField answerThree;
    private ButtonGroup mathType;
    private ButtonGroup alternatives;

    public CreateQuestionFrame(WindowManager windowManager){
        this.frame = windowManager;
         addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                mathType.clearSelection();
                alternatives.clearSelection();
                answerOne.setText("");
                answerTwo.setText("");
                answerThree.setText("");
                question.setText("");

            }
        });

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
        mathType = new ButtonGroup();
        somaRadio = new JRadioButton("SOMA");
        somaRadio.setName("tipo");
        mathType.add(somaRadio);
        subtracaoRadio = new JRadioButton("SUBTRAÇÃO");
        mathType.add(subtracaoRadio);
        ambosRadio = new JRadioButton("AMBOS");
        mathType.add(ambosRadio);
        panel.add(somaRadio);
        panel.add(subtracaoRadio);
        panel.add(ambosRadio);
        addComponet(panel,2,1,1,1);

        label = new JLabel("PERGUNTA: ");
        addComponet(label,3,0,1,1);
        question = new JTextArea(5,30);
        question.setName("pergunta");
        scrollPane = new JScrollPane(question);
        addComponet(scrollPane,3,1,1,5);

        label = new JLabel("ALTERNATIVAS");
        addComponet(label,9,0,1,1);
        panel = new JPanel();
        alternatives = new ButtonGroup();
        alternativeOne = new JRadioButton("alternativa 1");
        alternativeOne.setName("alternativas");
        alternatives.add(alternativeOne);
        alternativeTwo = new JRadioButton("alternativa 2");
        alternatives.add(alternativeTwo);
        alternativeThree = new JRadioButton("alternativa 3");
        alternatives.add(alternativeThree);
        panel.add(alternativeOne);
        panel.add(alternativeTwo);
        panel.add(alternativeThree);
        addComponet(panel,9,1,1,1);

        JPanel panel2 = new JPanel();
        answerOne = new NumberMask(10,8);
        answerOne.setName("alternativa 1");
        answerTwo = new NumberMask(10,8);
        answerTwo.setName("alternativa 2");
        answerThree = new NumberMask(10,8);
        answerThree.setName("alternativa 3");
        panel2.add(answerOne);
        panel2.add(answerTwo);
        panel2.add(answerThree);
        addComponet(panel2,10,1,5,1);


        JButton button = new JButton("CADASTRAR");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<JTextField> emptyFields;
                boolean isButtonSelected;
                boolean isButtonTypeSelected;
                List<JTextField> aJTextList = new ArrayList<JTextField>();
                aJTextList.add(answerOne);
                aJTextList.add(answerTwo);
                aJTextList.add(answerThree);

                emptyFields = helper.validateFields(aJTextList);
                isButtonSelected = (alternativeOne.isSelected()) || (alternativeTwo.isSelected() ||
                        (alternativeThree.isSelected()));

                isButtonTypeSelected = (somaRadio.isSelected()) || (subtracaoRadio.isSelected() ||
                        (ambosRadio.isSelected()));
                
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
