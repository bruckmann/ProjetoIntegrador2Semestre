package Repositories.questions;

import Entities.questions.Question;

import java.util.List;

public interface IQuestionRepository {

  List<Question> getQuestions();
  boolean saveQuestion(Question question);
  boolean deleteQuestion(int id);
  boolean updateQuestion(Question question);

}
