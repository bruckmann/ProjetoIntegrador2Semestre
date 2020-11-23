package views;

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

  public QuestionManager(WindowManager windowManager){

    this.frame = windowManager;

    createTable();

  }

  private void createTable(){
    setLayout(new BorderLayout(2,2));


    panelButtons = new JPanel();
    panelButtons.setPreferredSize(new Dimension(150,40));
    JPanel panel = new JPanel();
    ButtonGroup buttonGroup = new ButtonGroup();

    createButton = new JButton("CRIAR");
    createButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.ShowCreateQuestionForm();
      }
    });
    panel.add(createButton);
    buttonGroup.add(createButton);

    updateButton = new JButton("ALTERAR");
    panel.add(updateButton);
    buttonGroup.add(updateButton);

    deleteButton = new JButton("DELETAR");
    panel.add(deleteButton);
    buttonGroup.add(deleteButton);
    panelButtons.add(panel);
    add(panelButtons,BorderLayout.NORTH);

     //fim dos botões

    panelQuestions = new JPanel();
    questionTable = new JTable();
    questionTable.setPreferredScrollableViewportSize(new Dimension(300,300));
    questionTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
  }

}
