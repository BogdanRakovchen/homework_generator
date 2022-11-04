package pro.sky.homework_generator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homework_generator.Model.Question;
import pro.sky.homework_generator.Service.ExaminerServiceImpl;
import pro.sky.homework_generator.Service.JavaQuestionService;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    List<Question> questionList = new ArrayList<>(List.of());

    @BeforeEach
    public void init() {
        questionList.add(new Question("1", "2"));

        when(javaQuestionService.getAllQuestions()).thenReturn(List.of(new Question("1", "2")));
        when(javaQuestionService.getRandomQuestion(1)).thenReturn("1");
    }

    @Test
    public void shouldGetQuestionRandomOrder() {
        List<Question> questions = examinerService.getQuestions(1);
        Assertions.assertEquals(questionList, questions);

    }

}
