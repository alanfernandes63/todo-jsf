package controllers;

import java.util.List;

import dao.TodoDao;
import interfaces.ITodoController;
import model.Todo;

public class TodoControllerImp implements ITodoController {

	private TodoDao dao;

	public TodoControllerImp() {
		super();
		dao = new TodoDao();
	}

	public void salvar(Todo todo) {
		validar(todo);
		dao.salvarAtualizar(todo);

	}

	public void atualizar(Todo todo) {
		dao.salvarAtualizar(todo);
	}

	public void deletar(Todo todo) {
		dao.deletar(todo);
	}

	public List<Todo> listar() {
		return dao.listar();
	}

	public List<Todo> listarTodosAFazer() {
		return dao.listarTodosAFazer();
	}

	public List<Todo> filtrar(Todo todo) {
		return dao.filtrar(todo);
	}

	private void validar(Todo todo) {
		if (todo.getTitulo() == null) {
			throw new RuntimeException("o título não pode ser nulo");
		}
		if (todo.getTitulo().trim().equals("")) {
			throw new RuntimeException("o titulo não pode estar em branco");
		}
		if (todo.getDescricao() == null) {
			throw new RuntimeException("a descição não pode ser nulo");
		}
		if (todo.getDescricao().trim().equals("")) {
			throw new RuntimeException("a descrição não pode estar em branco");
		}
		if (todo.getDeadline() == null) {
			throw new RuntimeException("a deadline não pode ser nulo");
		}
		if (todo.getPrioridade() == null) {
			throw new RuntimeException("a deadline não pode ser nulo");
		}
		if (todo.getResponsavel() == null) {
			throw new RuntimeException("o responsável não pode ser nulo");
		}
	}

}
