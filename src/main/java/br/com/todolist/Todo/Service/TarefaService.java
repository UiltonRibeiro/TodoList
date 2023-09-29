package br.com.todolist.Todo.Service;

import br.com.todolist.Todo.Entity.Tarefa;
import br.com.todolist.Todo.Repository.TarefaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> create(Tarefa tarefa){
        tarefaRepository.save(tarefa);
        return read();
    }

    public List<Tarefa> read(){
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending()
        );
        return tarefaRepository.findAll(sort);
    }

    public List<Tarefa> update(Tarefa tarefa){
        tarefaRepository.save(tarefa);
        return read();
    }

    public List<Tarefa> delete(Long id){
        tarefaRepository.deleteById(id);
        return read();
    }

}
