package Repositories.questions;

import Entities.questions.Alternative;
import Entities.questions.Question;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepository implements IQuestionRepository {


  @Override
  public List<Question> getQuestions() {
    List<Question> questions = new ArrayList<>();
    final String query = "SELECT * FROM pergunta ORDER BY id_pergunta";
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try {
      connection = ConnectionFactory.getConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        Question question = new Question();
        question.setId(resultSet.getInt("id_pergunta"));
        question.setQuestionStatement(resultSet.getString("enunciado_pergunta"));
        question.setCriador(resultSet.getInt("id_criador"));
        question.setType(resultSet.getInt("id_tipo"));
        questions.add(question);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (statement != null) {
          statement.close();
        }

        if(resultSet != null) {
          resultSet.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return questions;
  }


  @Override
  public boolean saveQuestion(Question question) {
    final String questionQuery = "INSERT INTO pergunta (enunciado_pergunta, id_criador, id_tipo) VALUES (?, ?, ?)";
    final String alternativeQuery = "INSERT INTO alternativa (valor_alternativa, correta, id_pergunta) VALUES (?, ?, ?)";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      connection = ConnectionFactory.getConnection();
      statement = connection.prepareStatement(questionQuery, Statement.RETURN_GENERATED_KEYS);
      statement.setString(1, question.getQuestionStatement());
      statement.setInt(2, question.getIdCriador());
      statement.setInt(3, question.getType());
      statement.execute();

      resultSet = statement.getGeneratedKeys();
      while(resultSet.next()) {
        question.setId(resultSet.getInt(1));
      }
      statement.close();

      statement = connection.prepareStatement(alternativeQuery);
      for ( Alternative alternative : question.getAlternativesList()) {
        statement.setInt(1, alternative.getValorAlternativa());
        statement.setBoolean(2, alternative.correct());
        statement.setInt(3, question.getId());
        statement.addBatch();
      }
      statement.executeBatch();

    }catch (Exception e) {
      e.printStackTrace();
      return false;
    } finally {
      try{
        if (statement != null) {
          statement.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return true;
  }

  @Override
  public boolean deleteQuestion(int id) {
    final String query = "DELETE FROM pergunta WHERE id_pergunta = ?";
    Connection connection = null;
    PreparedStatement statement = null;
    try {
      connection = ConnectionFactory.getConnection();
      statement = connection.prepareStatement(query);
      statement.setInt(1, id);
    }catch (Exception e) {
      e.printStackTrace();
      return false;
    } finally {
      try{
        if (statement != null) {
          statement.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean updateQuestion(Question question) {
    final String query = "UPDATE pergunta SET enunciado_pergunta = ?, id_criador = ?, id_tipo = ?   WHERE id_pergunta = ?";
    Connection connection = null;
    PreparedStatement statement = null;
    try {
      connection = ConnectionFactory.getConnection();
      statement = connection.prepareStatement(query);
      statement.setString(1, question.getQuestionStatement());
      statement.setInt(2, question.getIdCriador());
      statement.setInt(3, question.getType());
      statement.setInt(4, question.getId());
      statement.execute();
    }catch (Exception e) {
      e.printStackTrace();
      return false;
    } finally {
      try{
        if (statement != null) {
          statement.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }
    return true;
  }

}
