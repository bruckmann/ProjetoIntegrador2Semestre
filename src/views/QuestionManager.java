package views;

import Entities.questions.Question;
import Repositories.questions.QuestionRepository;
import Util.ModelQuestions;

import javax.swing.*;
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
  private QuestionRepository questRepo = new QuestionRepository();

  private final String title = WindowManager.TITULO;
  private final int infoMessage = JOptionPane.INFORMATION_MESSAGE;
  private final QuestionManager thisFrame = QuestionManager.this;


  public QuestionManager(WindowManager windowManager){

    this.frame = windowManager;

    createButtonCrud();
    createTable();
    createButtonCancel();
    setBackground(Color.decode("#5CDB95"));
  }

  public void reload(){
    modelQuestions.reload(questRepo.getQuestions());
  }

  private void createButtonCrud() {
    modelQuestions = new ModelQuestions(questRepo.getQuestions());
    setLayout(new BorderLayout(2, 2));


    panelButtons = new JPanel();
    panelButtons.setBackground(Color.decode("#8EE4AF"));
    panelButtons.setBackground(Color.decode("#8EE4AF"));
    panelButtons.setPreferredSize(new Dimension(150, 40));
    ButtonGroup buttonGroup = new ButtonGroup();

    createButton = new JButton("CRIAR");
    createButton.setForeground(Color.decode("#EEDDFF"));
    createButton.setBackground(Color.decode("#379683"));

    createButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.ShowCreateQuestionForm(null);
      }
    });
    panelButtons.add(createButton);
    buttonGroup.add(createButton);

    //fim botão criar

    updateButton = new JButton("ALTERAR");
    updateButton.setForeground(Color.decode("#EEDDFF"));
    updateButton.setBackground(Color.decode("#379683"));

    updateButton.addActionListener(e -> {
      Question question = modelQuestions.getQuestion(questionTable.getSelectedRow());
      frame.ShowCreateQuestionForm(question);
    });
    panelButtons.add(updateButton);
    buttonGroup.add(updateButton);

    // fim botão alterar

    deleteButton = new JButton("DELETAR");
    deleteButton.setForeground(Color.decode("#EEDDFF"));
    deleteButton.setBackground(Color.decode("#379683"));


    deleteButton.addActionListener(e -> {
      Question question = modelQuestions.getQuestion(questionTable.getSelectedRow());
      if (question != null) {
        int answerDialog = JOptionPane.showConfirmDialog(thisFrame, "Você deseja deletar esta pergunta ?",
                title, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (answerDialog == JOptionPane.YES_NO_OPTION){
          if(!questRepo.deleteQuestion(question.getId())) {
            JOptionPane.showMessageDialog(thisFrame, "Houve um erro para deletar essa pergunta, tente novamente!", title, infoMessage);
            return;
          }
          JOptionPane.showMessageDialog(thisFrame, "Pergunta deletada com sucesso!", title, infoMessage);
        }
        reload();
      }
    });
    panelButtons.add(deleteButton);
    buttonGroup.add(deleteButton);
    add(panelButtons, BorderLayout.NORTH);

  } //fim dos botões

   private void createTable() {
     panelQuestions = new JPanel();
     panelQuestions.setBackground(Color.decode("#5CDB95"));
     questionTable = new JTable(modelQuestions);
     questionTable.setPreferredScrollableViewportSize(new Dimension(500, 600));
     questionTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
     questionTable.getSelectionModel().addListSelectionListener(e -> {
       if (!e.getValueIsAdjusting()) {
         if (questionTable.getSelectedRow() >= 0) {
           enableButtons();
         } else {
           disableButtons();
         }
       }
     });
     JScrollPane jScrollPane = new JScrollPane(questionTable);
     panelQuestions.add(jScrollPane);
     add(panelQuestions, BorderLayout.CENTER);

   }// fim da tabela
    private void createButtonCancel(){
    panelButtonsCancel = new JPanel();
    panelButtonsCancel.setBackground(Color.decode("#8EE4AF"));
    panelButtonsCancel.setPreferredSize(new Dimension(150,70));

    cancelButton = new JButton("CANCELAR");
    cancelButton.setForeground(Color.decode("#EEDDFF"));
    cancelButton.setBackground(Color.decode("#379683"));

    cancelButton.addActionListener(e -> frame.ReturnToLogPage());
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
