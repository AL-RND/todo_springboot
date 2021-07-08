import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collection;

import domain.Todo;
import todoRepository.TodoRepository;

@SpringBootApplication
public class TodoSpringbootAppApplication implements CommandLineRunner{

    public final TodoRepository todoRepository;

    public TodoSpringbootAppApplication(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(TodoSpringbootAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Collection<Todo> todos = Arrays.asList(new Todo("Learn Spring", "Yes"),
                                                new Todo("Learn Driving", "No"),
                                                new Todo("Go for a Walk", "No"),
                                                new Todo("Cook Dinner", "Yes"));
        todos.forEach(todoRepository::save);

    }
}
