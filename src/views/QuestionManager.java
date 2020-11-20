package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionManager extends StandardFormatLog {
  private JButton createButton;
  private JButton updateButton;
  private JButton deleteButton;
  private JTable questionTable;
  private final WindowManager frame;

  public QuestionManager(WindowManager windowManager){

    this.frame = windowManager;

    createTable();

  }

  private void createTable(){

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

    addComponent(panel,5,0,1,1);

    //FIM DOS BOTÕES

    questionTable = new JTable();
    questionTable.setPreferredScrollableViewportSize(new Dimension(100,200));
    questionTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane jScrollPane = new JScrollPane(questionTable);

    addComponent(jScrollPane,0,0,1,1);
  }

}
