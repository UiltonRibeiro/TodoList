package br.com.todolist.Todo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String nome;

    String descricao;
    @Column(nullable = false)
    boolean realizada;

    @Column(nullable = false)
    int prioridade;

    public Tarefa(String nome, String descricao, boolean realizada, int prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.realizada = realizada;
        this.prioridade = prioridade;
    }
}
