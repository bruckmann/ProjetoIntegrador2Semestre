package Repositories.questions;

import Entities.questions.Question;

import java.util.List;

public interface IQuestionRepository {

    public List<Question> getQuestions();
    public Question getQuestionById(int id);
    public void saveQuestion(Question question);
    public void deleteQuestion(int id);
    public void updateQuestion(Question questionUpdate, int id);

}
