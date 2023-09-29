package br.com.todolist.Todo;

import br.com.todolist.Todo.Entity.Tarefa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class  ToDoApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTarefaSuccess() {
		var tarefa = new Tarefa("Test","test",true,1);
		webTestClient.post().uri("/tarefas").bodyValue(tarefa)
				.exchange().expectStatus().isOk()
				.expectBody().jsonPath("$").isArray()
				.jsonPath("$.lenght()").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(tarefa.getNome())
				.jsonPath("$[0].descricao").isEqualTo(tarefa.getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(tarefa.isRealizada())
				.jsonPath("$[0].prioridade").isEqualTo(tarefa.getPrioridade());
	}

	@Test
	void testCreateTarefaFailure() {
	}

}
