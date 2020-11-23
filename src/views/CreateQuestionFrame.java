package views;

import Entities.questions.Alternative;
import Entities.questions.Question;
import Repositories.questions.QuestionRepository;
import Util.ViewHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CreateQuestionFrame extends StandardFormatLog {
  private final WindowManager frame;

  private QuestionRepository questRepo = new QuestionRepository();

  private JRadioButton somaRadio;
  private JRadioButton subtracaoRadio;
  private JRadioButton ambosRadio;
  private JRadioButton alternativeOne;
  private JRadioButton alternativeTwo;
  private JRadioButton alternativeThree;
  private JTextArea question;
  private JTextField answerOne;
  private JTextField answerTwo;
  private JTextField answerThree;
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
    AtomicInteger questId = new AtomicInteger(1);
    JLabel label;
    JPanel panel;
    JScrollPane scrollPane;

    label = new JLabel("OLÁ CRIE AQUI SUAS PERGUNTAS: ");
    addComponent(label, 0, 0,5,2);

    label = new JLabel("TIPO: ");
    addComponent(label,2,0,1,1);
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
    addComponent(panel,2,1,1,1);

    label = new JLabel("PERGUNTA: ");
    addComponent(label,3,0,1,1);
    question = new JTextArea(5,30);
    question.setName("pergunta");
    scrollPane = new JScrollPane(question);
    addComponent(scrollPane,3,1,1,5);

    label = new JLabel("ALTERNATIVAS");
    addComponent(label,9,0,1,1);
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
    addComponent(panel,9,1,1,1);

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
    addComponent(panel2,10,1,5,1);

    JButton button = new JButton("CADASTRAR");
    button.addActionListener(e -> {
      List<JTextField> emptyFields;
      boolean isButtonSelected;
      boolean isButtonTypeSelected;
      List<JTextField> aJTextList = new ArrayList<JTextField>();
      aJTextList.add(answerOne);
      aJTextList.add(answerTwo);
      aJTextList.add(answerThree);

      emptyFields = ViewHelper.validateFields(aJTextList);
      isButtonSelected = (alternativeOne.isSelected()) || (alternativeTwo.isSelected() ||
              (alternativeThree.isSelected()));

      isButtonTypeSelected = (somaRadio.isSelected()) || (subtracaoRadio.isSelected() ||
              (ambosRadio.isSelected()));

      boolean isTextArea = question.getText().length() > 0;

      if(emptyFields.isEmpty() && isButtonSelected && isTextArea && isButtonTypeSelected) {
        String type = "";
        List<Alternative> lAltList = new ArrayList<>();
        lAltList.add(new Alternative(Integer.parseInt(answerOne.getText()), alternativeOne.isSelected()));
        lAltList.add(new Alternative(Integer.parseInt(answerTwo.getText()), alternativeTwo.isSelected()));
        lAltList.add(new Alternative(Integer.parseInt(answerThree.getText()), alternativeThree.isSelected()));

        if(somaRadio.isSelected()) {
          type = "soma";
        } else if (subtracaoRadio.isSelected()) {
          type = "subtracao";
        } else {
          type = "ambos";
        }

        Question quest = new Question(questId.getAndIncrement(), question.getText(), type, lAltList);

        questRepo.saveQuestion(quest);

        JOptionPane.showMessageDialog(CreateQuestionFrame.this,
                "Criação de pergunta concluída !!",
                WindowManager.TITULO,
                JOptionPane.INFORMATION_MESSAGE);

        for(Question q : questRepo.getQuestions()) {
          System.out.println("Questão id: " + q.getId() + q.getQuestionStatement());
        }

        frame.ManageQuestionTable();
      } else {
        if(!isButtonSelected) {
          JOptionPane.showMessageDialog(CreateQuestionFrame.this,
                  "O botão " + alternativeOne.getName() + " não está selecionado\n",
                  WindowManager.TITULO,
                  JOptionPane.INFORMATION_MESSAGE);
        }

        if(!isButtonTypeSelected) {
          JOptionPane.showMessageDialog(CreateQuestionFrame.this,
                  "O botão " + somaRadio.getName() + " não está selecionado\n",
                  WindowManager.TITULO,
                  JOptionPane.INFORMATION_MESSAGE);
        }

        for(JTextField field : emptyFields) {
          JOptionPane.showMessageDialog(CreateQuestionFrame.this,
                  "O campo " + field.getName() + " não está preenchido\n",
                  WindowManager.TITULO,
                  JOptionPane.INFORMATION_MESSAGE);
        }

        if(!isTextArea) {
          JOptionPane.showMessageDialog(CreateQuestionFrame.this,
                  "O campo " + question.getName() + " não está preenchido\n",
                  WindowManager.TITULO,
                  JOptionPane.INFORMATION_MESSAGE);
        }
      }
    });

    button.setForeground(Color.BLUE);
    addComponent(button,13,1,1,1);

    JButton buttonCancel = new JButton("Cancelar");
    buttonCancel.addActionListener(e -> frame.ManageQuestionTable());
    buttonCancel.setForeground(Color.red);
    addComponent(buttonCancel,13,2,1,1);
  }
}
