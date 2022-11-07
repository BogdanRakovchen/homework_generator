package pro.sky.homework_generator.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.homework_generator.Exception.MaxLimitRequestOfQuestions;
import pro.sky.homework_generator.Interface.ExaminerService;
import pro.sky.homework_generator.Interface.QuestionService;
import pro.sky.homework_generator.Model.Question;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {


    private QuestionService questionService;
    private ExaminerService examinerService;

    public ExaminerServiceImpl(QuestionService questionService,
                               ExaminerService examinerService) {
        this.questionService = questionService;
        this.examinerService = examinerService;
    }

    @Override
    public List<Question> getQuestions(int amount) {

        Map<String, Question> questionCollection = new HashMap<>(Map.of());

        if(amount > questionService.getAllQuestions().size()) {
            throw new MaxLimitRequestOfQuestions();
        }

        for(Question q : questionService.getAllQuestions()) {
            questionCollection.put(questionService.getRandomQuestion(amount), q);
        }


        List<Question> questionList = questionCollection.values()
                .stream()
                .collect(Collectors.toList());

        return questionList;

    };


}
