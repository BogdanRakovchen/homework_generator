package pro.sky.homework_generator.Interface;

import pro.sky.homework_generator.Model.Question;

import java.util.Collection;

public interface QuestionService {
    Collection<Question> addQuestion(String question, String answer);
    Collection<Question> getAllQuestions();
    Boolean deleteQuestion(String question, String answer);
    String getRandomQuestion(int amount);
}