package dao;

import java.util.List;

public interface GenericDaoInterface<T> {

	public void salvarAtualizar(T t);

	public void deletar(T t);

	public List<T> listar();

}
