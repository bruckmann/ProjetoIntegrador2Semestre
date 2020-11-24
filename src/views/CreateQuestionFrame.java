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
  private AtomicInteger questId = new AtomicInteger(1);
  private QuestionRepository questRepo = new QuestionRepository();

  private JRadioButton somaRadio;
  private JRadioButton subtracaoRadio;
  private JRadioButton alternativeOne;
  private JRadioButton alternativeTwo;
  private JRadioButton alternativeThree;
  private JTextArea question;
  private JTextField answerOne;
  private JTextField answerTwo;
  private JTextField answerThree;
  private ButtonGroup mathType;
  private ButtonGroup alternatives;

  private final String title = WindowManager.TITULO;
  private final int infoMessage = JOptionPane.INFORMATION_MESSAGE;
  private final CreateQuestionFrame thisFrame = CreateQuestionFrame.this;

  public Question questionFilled;

  public CreateQuestionFrame(WindowManager windowManager){
    this.frame = windowManager;

    addComponentListener(new ComponentAdapter() {
      @Override
      public void componentShown(ComponentEvent e) {
        if (questionFilled == null) {
          mathType.clearSelection();
          alternatives.clearSelection();
          answerOne.setText("");
          answerTwo.setText("");
          answerThree.setText("");
          question.setText("");
        }
        if (questionFilled != null){

          String ty = questionFilled.getType();
          switch (ty){
            case "soma" -> somaRadio.setSelected(true);
            case "subtracao" -> subtracaoRadio.setSelected(true);
          }

          int crrInd = 0;

          List<Alternative> lAlt = questionFilled.getAlternativesList();

          answerOne.setText(String.valueOf(lAlt.get(0).getValue()));
          answerTwo.setText(String.valueOf(lAlt.get(1).getValue()));
          answerThree.setText(String.valueOf(lAlt.get(2).getValue()));
          for (Alternative alt : lAlt ){
            if(alt.correct()){
               crrInd = lAlt.indexOf(alt);
            }
          }
          List<JRadioButton> alt = new ArrayList<>();
          alt.add(alternativeOne);
          alt.add(alternativeTwo);
          alt.add(alternativeThree);
          alt.get(crrInd).setSelected(true);
          question.setText(questionFilled.getQuestionStatement());
        }
      }
    });

    setComponent();
  }

  private void setComponent() {
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

    panel.add(somaRadio);
    panel.add(subtracaoRadio);
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

    JButton insButton = new JButton("SALVAR");
    insButton.addActionListener(e -> {
      upsertQuestion();
    });
    insButton.setForeground(Color.BLUE);
    addComponent(insButton,13,1,1,1);

    JButton buttonCancel = new JButton("Cancelar");
    buttonCancel.addActionListener(e -> frame.ManageQuestionTable());
    buttonCancel.setForeground(Color.red);
    addComponent(buttonCancel,14,1,1,1);
  }

  private void upsertQuestion() {
    List<JTextField> emptyFields;
    List<JTextField> aJTextList = new ArrayList<>();

    aJTextList.add(answerOne);
    aJTextList.add(answerTwo);
    aJTextList.add(answerThree);

    emptyFields = ViewHelper.validateFields(aJTextList);

    boolean isButtonSelected = (alternativeOne.isSelected()) || (alternativeTwo.isSelected() ||
            (alternativeThree.isSelected()));

    boolean isButtonTypeSelected = (somaRadio.isSelected()) || (subtracaoRadio.isSelected());

    boolean isTextArea = question.getText().length() > 0;

    if(emptyFields.isEmpty() && isButtonSelected && isTextArea && isButtonTypeSelected) {
      String type = "";
      List<Alternative> lAltList = new ArrayList<>();

      lAltList.add(new Alternative(Integer.parseInt(answerOne.getText()), alternativeOne.isSelected()));
      lAltList.add(new Alternative(Integer.parseInt(answerTwo.getText()), alternativeTwo.isSelected()));
      lAltList.add(new Alternative(Integer.parseInt(answerThree.getText()), alternativeThree.isSelected()));

      if(somaRadio.isSelected()) {
        type = "soma";
      } else {
        type = "subtracao";
      }

      if (questionFilled == null) {
        this.createQuestion(question.getText(), type, lAltList);
      } else {
        this.updateQuestion(questionFilled.getId(), question.getText(), type, lAltList);
      }

      frame.ManageQuestionTable();
    } else {
      if(!isButtonSelected) {
        String message = "O botão " + alternativeOne.getName() + " não está selecionado\n";
        JOptionPane.showMessageDialog(thisFrame, message, title, infoMessage);
      }
      if(!isButtonTypeSelected) {
        String message = "O botão " + somaRadio.getName() + " não está selecionado\n";
        JOptionPane.showMessageDialog(thisFrame, message, title, infoMessage);
      }
      if(!isTextArea) {
        String message = "O campo " + question.getName() + " não está preenchido\n";
        JOptionPane.showMessageDialog(thisFrame, message, title, infoMessage);
      }
      for(JTextField field : emptyFields) {
        String message = "O campo " + field.getName() + " não está preenchido\n";
        JOptionPane.showMessageDialog(thisFrame, message, title, infoMessage);
      }
    }
  }

  private void createQuestion(String question,String type, List<Alternative> lAltList) {
    int id = this.questId.getAndIncrement();
    Question quest = new Question(id, question, type, lAltList);

    questRepo.saveQuestion(quest);

    JOptionPane.showMessageDialog(thisFrame, "Criação de pergunta concluída !!", title, infoMessage);
  }

  private void updateQuestion(int questId, String question,String type, List<Alternative> lAltList) {
    Question questUpdate = new Question(questId, question, type, lAltList);

    questRepo.updateQuestion(questUpdate);

    JOptionPane.showMessageDialog(thisFrame, "Atualização de pergunta concluída !!", title, infoMessage);
  }

  public void setQuestion(Question lQuestionFilled) {
    this.questionFilled = lQuestionFilled;
  }
}
