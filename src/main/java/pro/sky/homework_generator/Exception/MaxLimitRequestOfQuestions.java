package pro.sky.homework_generator.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MaxLimitRequestOfQuestions extends RuntimeException {

}
