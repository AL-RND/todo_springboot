package todo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import todo.domain.Todo;
import todo.repository.TodoRepository;

@Controller
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/todos")
    public String todos(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "todos";
    }

    @PostMapping("/todoNew") //To create a new_todo, this is a Post request
    public String add(@RequestParam String todoItem, @RequestParam String status, Model model) {
        Todo todo = new Todo();
        todo.setTodoItem(todoItem);
        todo.setCompleted(status);
        todoRepository.save(todo);
        model.addAttribute("todos", todoRepository.findAll());
        return "redirect:/todos";
    }

    @PostMapping("/todoDelete/{id}") //This endpoint deletes a specific_todo it's also an HTTP POST request mapping
    public String delete(@PathVariable long id, Model model) {
        todoRepository.deleteById(id);
        model.addAttribute("todos", todoRepository.findAll());
        return "redirect:/todos";
    }

    @PostMapping("/todoUpdate/{id}") //endpoint toggles a specific_todo_status
    public String update(@PathVariable long id, Model model) {
        Todo todo = todoRepository.findById(id).get();
        if("Yes".equals(todo.getCompleted())) {
            todo.setCompleted("No");
        }
        else {
            todo.setCompleted("Yes");
        }
        todoRepository.save(todo);
        model.addAttribute("todos", todoRepository.findAll());
        return "redirect:/todos";
    }
}

//Mapping for the HTML data
