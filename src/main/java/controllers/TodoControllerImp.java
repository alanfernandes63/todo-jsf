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

}
