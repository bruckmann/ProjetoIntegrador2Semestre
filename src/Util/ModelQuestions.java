package Util;

import Entities.questions.Question;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModelQuestions extends AbstractTableModel {
  private List<Question> questions = new ArrayList<>();
  private String[] columns = new String[] {"id" , "type", "question"};

  public ModelQuestions(List<Question> lQuestions){
    this.questions = lQuestions;
  }

  @Override
  public int getRowCount() {
    return questions.size();
  }

  @Override
  public int getColumnCount() {
    return columns.length;
  }

  @Override
  public String getColumnName(int column) {
    String columnName = null;

    if (column >= 0 && column < columns.length){
      columnName = columns[column];
    }

    return columnName;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    String value = null;
    if(rowIndex >= 0 && rowIndex <= questions.size()) {
      Question question = questions.get(rowIndex);

      switch (columnIndex){
        case 0:
          value = String.valueOf(question.getId());
          break;
        case 1:
          value = question.getType();
          break;
        case 2:
          value = question.getQuestionStatement();
          break;
        default: System.err.printf("[ERROR] indice errado %d/n", columnIndex);
        break;
      }
    }
    return value;
  }

  public void reload(List<Question> questions){
    this.questions = questions;
    fireTableDataChanged();
  }

  public Question getQuestion(int rowIndex){
    Question question = null;

    if (rowIndex >= 0 && rowIndex < questions.size()){
      question = questions.get(rowIndex);
    }
    return question;
  }

}
