package pro.sky.homework_generator.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.sky.homework_generator.Interface.QuestionService;
import pro.sky.homework_generator.Model.Question;
import pro.sky.homework_generator.Service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {


    private QuestionService javaQuestionService;

    public JavaQuestionController(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @PostMapping("/add")
    public Collection<Question> addQuestion(@RequestParam String question,
                                            @RequestParam String answer) {
        return javaQuestionService.addQuestion(question, answer);
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return javaQuestionService.getAllQuestions();
    }

    @DeleteMapping("/remove")
    public Boolean deleteQuestion(@RequestParam String question,
                                  @RequestParam String answer) {
        return javaQuestionService.deleteQuestion(question, answer);
    }



}
