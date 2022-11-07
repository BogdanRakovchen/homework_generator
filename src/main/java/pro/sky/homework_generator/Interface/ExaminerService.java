package pro.sky.homework_generator.Interface;


import org.springframework.stereotype.Component;
import pro.sky.homework_generator.Model.Question;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface ExaminerService {

    List<Question> getQuestions(int amount);
}
