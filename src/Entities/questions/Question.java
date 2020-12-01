package Entities.questions;

import java.util.List;

public class Question {

  private int questionId;
  private int type;
  private int idCriador;
  private String questionStatement;
  private List<Alternative> alternativesList;

  public Question(int questionId, String questionStatement, int type, List<Alternative> alternatives) {
    this.questionStatement = questionStatement;
    this.type = type;
    this.alternativesList = alternatives;
    this.questionId = questionId;
  }

  public Question() {}

  public int getId(){
    return this.questionId;
  }

  public String getQuestionStatement() {
    return this.questionStatement;
  }

  public int getType() {
      return this.type;
  }

  public int getIdCriador() {
    return this.idCriador;
  }

  public void setType(int type ) {
    this.type = type;
  }

  public void setId(int id) {
    this.questionId = id;
  }

  public void setQuestionStatement (String questionStatement) {
    this.questionStatement = questionStatement;
  }

  public void setCriador (int id) {
    this.idCriador = id;
  }

  public List<Alternative> getAlternativesList(){
    return this.alternativesList;
  }

  public int getRightAlternative() {
    for (Alternative alternative : alternativesList) {

      if(alternative.correct()) {
        return alternative.getValue();
      }
    }
    return 1;
  }
}
