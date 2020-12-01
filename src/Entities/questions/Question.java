package Entities.questions;

import java.util.List;

public class Question {

  private int questionId;
  private int type;
  private int idCriador;
  private String questionStatement;
  public  List<Alternative> alternatives;

  public Question(String questionStatement, String type, int idCriador, List<Alternative> alternatives) {
    this.questionStatement = questionStatement;
    this.setType(type);
    this.idCriador = idCriador;
    this.alternatives = alternatives;
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

  public void setType(String type ) {
    if (type.toLowerCase().equals("soma")) {
      this.type = 1;
    }
    else if (type.toLowerCase().equals("subtracao")) {
      this.type = 2;
    }
  }

  public void setType(int type) {
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
    return alternatives;
  }

  public int getRightAlternative() {
    for (Alternative alternative : alternatives) {

      if(alternative.correct()) {
        return alternative.getValorAlternativa();
      }
    }
    return 1;
  }
}
