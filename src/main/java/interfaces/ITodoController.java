package interfaces;

import java.util.List;

import model.Todo;

public interface ITodoController {

	public void salvar(Todo todo);

	public void atualizar(Todo todo);

	public void deletar(Todo todo);

	public List<Todo> listar();

	public List<Todo> listarTodosAFazer();

	public List<Todo> filtrar(Todo todo);

}
