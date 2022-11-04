package pro.sky.homework_generator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import pro.sky.homework_generator.Interface.QuestionService;
import pro.sky.homework_generator.Model.Question;
import pro.sky.homework_generator.Service.JavaQuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {



   private final JavaQuestionService javaQuestionService;

   public JavaQuestionServiceTest() {
       this.javaQuestionService = new JavaQuestionService();
   }

    Collection<Question> questions = new HashSet<>();

    Collection<Question> q;


   @BeforeEach
   public void init() {
       questions.add(new Question("1", "2"));

       q = javaQuestionService.addQuestion("1", "2");
   }

    @Test
    public void shouldAddQuestions() {
       Assertions.assertEquals(questions, q);
    }

    @Test
    public void shouldGetQuestions() {

        Collection<Question> actual = javaQuestionService.getAllQuestions();

        Assertions.assertEquals(q, actual);


    }

    @Test
    public void shouldDeleteQuestions() {
        Boolean actual = javaQuestionService.deleteQuestion("1", "2");
        Assertions.assertTrue(actual);
    }




}
