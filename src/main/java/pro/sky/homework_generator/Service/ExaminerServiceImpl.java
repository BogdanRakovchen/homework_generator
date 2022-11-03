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

    @Autowired
    private JavaQuestionService questionService;

    Map<String, Question> questionCollection = new HashMap<>(Map.of());
    @Override
    public List<Question> getQuestions(int amount) {

        for(Question q : questionService.getAllQuestions()) {
            questionCollection.put(questionService.getRandomQuestion(amount), q);
        }

        if(amount > questionService.getAllQuestions().size()) {
            throw new MaxLimitRequestOfQuestions();
        }

        List<Question> questionList = questionCollection.values()
                .stream()
                .collect(Collectors.toList());

        return questionList;

    };


}
