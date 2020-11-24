package views;

import Entities.questions.Question;
import Repositories.questions.QuestionRepository;
import Util.ModelQuestions;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionManager extends StandardFormatLog {
  private JPanel panelButtons;
  private JPanel panelQuestions;
  private JPanel panelButtonsCancel;
  private JButton createButton;
  private JButton updateButton;
  private JButton deleteButton;
  private JButton cancelButton;
  private JTable questionTable;
  private final WindowManager frame;
  private ModelQuestions modelQuestions;
  private QuestionRepository questionRepo = new QuestionRepository();

  public QuestionManager(WindowManager windowManager){

    this.frame = windowManager;

    createTable();

  }

  public void reload(){
    modelQuestions.reload(questionRepo.getQuestions());
  }

  private void createTable(){
    modelQuestions = new ModelQuestions(questionRepo.getQuestions());
    setLayout(new BorderLayout(2,2));


    panelButtons = new JPanel();
    panelButtons.setPreferredSize(new Dimension(150,40));
    JPanel panel = new JPanel();
    ButtonGroup buttonGroup = new ButtonGroup();

    createButton = new JButton("CRIAR");
    createButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.ShowCreateQuestionForm(null);
      }
    });
    panel.add(createButton);
    buttonGroup.add(createButton);

    //fim botão criar

    updateButton = new JButton("ALTERAR");
    updateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Question question =  modelQuestions.getQuestion(questionTable.getSelectedRow());
        frame.ShowCreateQuestionForm(question);
      }
    });
    panel.add(updateButton);
    buttonGroup.add(updateButton);

    // fim botão alterar

    deleteButton = new JButton("DELETAR");
    panel.add(deleteButton);
    buttonGroup.add(deleteButton);
    panelButtons.add(panel);
    add(panelButtons,BorderLayout.NORTH);

     //fim dos botões

    panelQuestions = new JPanel();
    questionTable = new JTable(modelQuestions);
    questionTable.setPreferredScrollableViewportSize(new Dimension(300,300));
    questionTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    questionTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
          if (questionTable.getSelectedRow() >= 0){
            enableButtons();
          }else{
            disableButtons();
          }
        }
      }
    });
    JScrollPane jScrollPane = new JScrollPane(questionTable);
    panelQuestions.add(jScrollPane);
    add(panelQuestions,BorderLayout.CENTER);

    // fim da tabela

    panelButtonsCancel = new JPanel();
    panelButtonsCancel.setPreferredSize(new Dimension(150,70));
    cancelButton = new JButton("CANCELAR");
    cancelButton.addActionListener(e -> frame.ReturnToLogPage());
    cancelButton.setForeground(Color.red);
    panelButtonsCancel.add(cancelButton);
    add(panelButtonsCancel,BorderLayout.SOUTH);

    disableButtons();
  }

  private void disableButtons(){
    updateButton.setEnabled(false);
    deleteButton.setEnabled(false);
  }

  private void enableButtons(){
    updateButton.setEnabled(true);
    deleteButton.setEnabled(true);
  }

}
