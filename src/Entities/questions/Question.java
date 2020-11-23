package Entities.questions;

import java.util.List;

public class Question {

  private final int questionId;
  private int type;
  private String questionStatement;
  private List<Alternative> alternativesList;

  public Question(int questionId, String questionStatement, String type, List<Alternative> alternatives) {
    this.questionStatement = questionStatement;
    this.setType(type);
    this.alternativesList = alternatives;
    this.questionId = questionId;
  }

  public int getId(){
    return this.questionId;
  }

  public String getQuestionStatement() {
    return this.questionStatement;
  }

  public void setType(String type) {
    if(type.toLowerCase().equals("soma")) {
      this.type = 1;
    }
    else if (type.toLowerCase().equals("subtracao")) {
      this.type = 2;
    }
    else if (type.toLowerCase().equals("ambos")) {
      this.type = 3;
    }
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
