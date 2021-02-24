package manegedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import controllers.PessoaControllerImp;
import controllers.TodoControllerImp;
import interfaces.IPessoaController;
import interfaces.ITodoBean;
import model.Pessoa;
import model.Todo;

@ManagedBean
@RequestScoped
public class TodoBean implements ITodoBean {

	private TodoControllerImp iTodoController;

	private IPessoaController ipessoaController;

	private Todo todo = new Todo();

	private List<Pessoa> pessoas;

	private List<Todo> todos = new ArrayList<Todo>();

	private Todo todoFiltro = new Todo();

	public TodoBean() {
		this.iTodoController = new TodoControllerImp();
		this.ipessoaController = new PessoaControllerImp();
		this.pessoas = ipessoaController.listar();
		todoFiltro.setConcluida(null);
		this.todos = iTodoController.listarTodosAFazer();
	}

	public void salvar() {

		try {
			this.iTodoController.salvar(this.todo);
			this.todo = new Todo();
			this.todos = iTodoController.listarTodosAFazer();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("salvo com sucesso!"));
		} catch (RuntimeException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
		}
	}

	public void editar() {

	}

	public void deletar(Todo todo) {
		this.iTodoController.deletar(todo);
		todos = this.iTodoController.listarTodosAFazer();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("deletado com sucesso!"));
	}

	public void listar() {
		// this.todos = iTodoController.listarTodosAFazer();
	}

	public void concluir(Todo todo) {
		todo.setConcluida(true);
		iTodoController.salvar(todo);
	}

	public void filtrar() {
		this.todos = iTodoController.filtrar(this.todoFiltro);
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

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public Todo getTodoFiltro() {
		return todoFiltro;
	}

	public void setTodoFiltro(Todo todoFiltro) {
		this.todoFiltro = todoFiltro;
	}

}
