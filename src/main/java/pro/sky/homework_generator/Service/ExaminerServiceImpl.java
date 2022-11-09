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

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;

    }

    @Override
    public List<Question> getQuestions(int amount) {

        List<Question> questionList1 = new ArrayList<>();
        List<Question> questionList2 = new ArrayList<>();

        questionList1.addAll(questionService.getAllQuestions());


        if(amount > questionService.getAllQuestions().size()) {
            throw new MaxLimitRequestOfQuestions();
        }


        for (Question q: questionList1) {
            questionList2 = questionList1.stream()
                            .limit(amount)
                                    .collect(Collectors.toList());

            questionList2.set(questionService.getRandomQuestion(amount), q);
        }

       return questionList2;

    };


}
