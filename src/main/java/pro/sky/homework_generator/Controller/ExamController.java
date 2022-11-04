package pro.sky.homework_generator.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.homework_generator.Exception.MaxLimitRequestOfQuestions;
import pro.sky.homework_generator.Model.Question;
import pro.sky.homework_generator.Service.ExaminerServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExaminerServiceImpl examinerService;

    @GetMapping
    public List<Question> getQuestions(int amount) {
        return examinerService.getQuestions(amount);

    }
}
