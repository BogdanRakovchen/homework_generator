package pro.sky.homework_generator;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class HomeworkGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkGeneratorApplication.class, args);
    }

}
