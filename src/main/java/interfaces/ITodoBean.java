package interfaces;

import model.Todo;

public interface ITodoBean {

	public void salvar();

	public void editar();

	public void deletar(Todo todo);

	public void listar();
}
