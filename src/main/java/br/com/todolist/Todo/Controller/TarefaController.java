package br.com.todolist.Todo.Controller;

import br.com.todolist.Todo.Entity.Tarefa;
import br.com.todolist.Todo.Service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    List<Tarefa> create(@RequestBody Tarefa tarefa){
        return tarefaService.create(tarefa);
    }

    @GetMapping
    List<Tarefa> read(){
        return tarefaService.read();
    }

    @PutMapping
    List<Tarefa> update(@RequestBody Tarefa tarefa){
        return tarefaService.update(tarefa);
    }

    @DeleteMapping("{id}")
    List<Tarefa> delete(@PathVariable Long id){
        return tarefaService.delete(id);
    }

}
