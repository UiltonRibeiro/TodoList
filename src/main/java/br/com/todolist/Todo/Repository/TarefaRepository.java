package br.com.todolist.Todo.Repository;

import br.com.todolist.Todo.Entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
