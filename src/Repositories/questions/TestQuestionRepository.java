package Repositories.questions;

import Entities.questions.Alternative;
import Entities.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class TestQuestionRepository {

  public static void main(String[] args) {

    Alternative alternative11 = new Alternative(5, false);
    Alternative alternative21 = new Alternative(2, true);
    Alternative alternative31 = new Alternative(2, false);

    List<Alternative> listOfAlternatives1 = new ArrayList<>();

    listOfAlternatives1.add(alternative11);
    listOfAlternatives1.add(alternative21);
    listOfAlternatives1.add(alternative31);

    Alternative alternative12 = new Alternative(5, false);
    Alternative alternative22 = new Alternative(4, true);
    Alternative alternative32 = new Alternative(7, false);

    List<Alternative> listOfAlternatives2 = new ArrayList<>();

    listOfAlternatives2.add(alternative12);
    listOfAlternatives2.add(alternative22);
    listOfAlternatives2.add(alternative32);

    Question question1 = new Question(1, "Quanto é 1+1", 1, listOfAlternatives1);
    Question question2 = new Question(1, "Quanto é 2+2", 1, listOfAlternatives2);

    QuestionRepository questions = new QuestionRepository();

    questions.saveQuestion(question1);
    questions.saveQuestion(question2);

    List<Question> listOfQuestions = new ArrayList<>();
    listOfQuestions = questions.getQuestions();

    for (Question question : listOfQuestions) {
      System.out.println(question.getQuestionStatement());
      System.out.println();
      System.out.println(question.getRightAlternative());
    }

  }

}
