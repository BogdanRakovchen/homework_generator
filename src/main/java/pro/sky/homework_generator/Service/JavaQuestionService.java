package pro.sky.homework_generator.Service;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.homework_generator.Interface.QuestionService;
import pro.sky.homework_generator.Model.Question;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService {

    public Collection<Question> getQuestions() {
        return questions;
    }

    private Collection<Question> questions = new HashSet<>(Set.of());


    @Override
    public Collection<Question> addQuestion(String question, String answer) {
        questions.add(new Question(question, answer));
        return questions;
    };

    @Override
    public Collection<Question> getAllQuestions() {
        return questions;
    };

    @Override
    public Boolean deleteQuestion(String question, String answer) {
       return questions.remove(new Question(question, answer));

    };

    @Override
    public String getRandomQuestion(int amount) {

        int number = new Random().nextInt(amount);

        String num = number + "";

        return num;
    };



}
