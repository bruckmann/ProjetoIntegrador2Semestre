package Entities.questions;

import java.util.List;

public class Question {

  private final int questionId;
  private String type;
  private String questionStatement;
  private List<Alternative> alternativesList;

  public Question(int questionId, String questionStatement, String type, List<Alternative> alternatives) {
    this.questionStatement = questionStatement;
    this.type = type;
    this.alternativesList = alternatives;
    this.questionId = questionId;
  }

  public int getId(){
    return this.questionId;
  }

  public String getQuestionStatement() {
    return this.questionStatement;
  }

  public String getType() {
      return this.type;
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
