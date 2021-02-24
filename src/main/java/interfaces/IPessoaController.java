package interfaces;

import java.util.List;

import model.Pessoa;

public interface IPessoaController {

	public Pessoa buscarPorId(Long id);

	public void salvarAtualizar(Pessoa pessoa);

	public void deletar(Pessoa pessoa);

	public List<Pessoa> listar();

}
