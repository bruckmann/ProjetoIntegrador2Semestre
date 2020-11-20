package Repositories.questions;

import Entities.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepository implements IQuestionRepository {

  private static final List<Question> questionList = new ArrayList<>();

  @Override
  public List<Question> getQuestions() {
    return questionList;
  }

  @Override
  public Question getQuestionById(int id) {

    for (Question question : questionList) {
      if (question.getId() == id) {
        return question;
      }
    }
    return null;
  }

  @Override
  public void saveQuestion(Question question) {
    questionList.add(question);
  }

  @Override
  public void deleteQuestion(int id) {
    if (this.getQuestionById(id) != null) {
      Question question =  this.getQuestionById(id);
      questionList.remove(question);
    }
  }

  @Override
  public void updateQuestion(Question questionUpdate) {
    this.deleteQuestion(questionUpdate.getId());
    this.saveQuestion(questionUpdate);
  }

}
