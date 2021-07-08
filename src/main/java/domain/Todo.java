package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data //from lombok These annotations ensure that all getter/setters,
// an all args constructor and a no-args constructor are generated for us

public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String todoItem;
    private String completed;

    public Todo(String todoItem, String completed) {
        super();
        this.todoItem = todoItem;
        this.completed = completed;
    }
}
