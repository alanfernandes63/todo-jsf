package manegedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import controllers.PessoaControllerImp;
import controllers.TodoControllerImp;
import interfaces.IPessoaController;
import interfaces.ITodoBean;
import model.Pessoa;
import model.Prioridade;
import model.Todo;

@ManagedBean
@ViewScoped
public class TodoBean implements ITodoBean {

	private TodoControllerImp iTodoController;

	private IPessoaController ipessoaController;

	private Todo todo = new Todo();

	private List<Pessoa> pessoas;

	private List<Todo> todos = new ArrayList<Todo>();

	public TodoBean() {
		this.iTodoController = new TodoControllerImp();
		this.ipessoaController = new PessoaControllerImp();
		this.pessoas = ipessoaController.listar();
		this.todos = iTodoController.listarTodosAFazer();
	}

	public void salvar() {
		this.iTodoController.salvar(this.todo);
		this.todo = new Todo();

	}

	public void editar() {

	}

	public void deletar(Todo todo) {
		this.iTodoController.deletar(todo);
	}

	public void listar() {
		this.todos = iTodoController.listarTodosAFazer();
	}
	
	public void concluir(Todo todo) {
		todo.setConcluida(true);
		iTodoController.salvar(todo);
	}

	public Todo getTodo() {
		return todo;
	}

	public void setTodo(Todo todo) {
		this.todo = todo;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Prioridade[] getPrioridades() {
		return Prioridade.values();
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

}
