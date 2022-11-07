package pro.sky.homework_generator.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.homework_generator.Exception.MaxLimitRequestOfQuestions;
import pro.sky.homework_generator.Interface.ExaminerService;
import pro.sky.homework_generator.Model.Question;
import pro.sky.homework_generator.Service.ExaminerServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
public class ExamController {

    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }


    @GetMapping("/{amount}")
    public List<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);

    }
}
