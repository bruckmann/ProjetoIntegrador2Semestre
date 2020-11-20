package Repositories.questions;

import Entities.questions.Question;

import java.util.List;

public interface IQuestionRepository {

  List<Question> getQuestions();
  Question getQuestionById(int id);
  void saveQuestion(Question question);
  void deleteQuestion(int id);
  void updateQuestion(Question questionUpdate);

}
