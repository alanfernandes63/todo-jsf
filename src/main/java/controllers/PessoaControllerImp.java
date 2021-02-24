package controllers;

import java.util.List;

import dao.PessoaDao;
import interfaces.IPessoaController;
import model.Pessoa;

public class PessoaControllerImp implements IPessoaController{
	
	private PessoaDao dao;

	public PessoaControllerImp() {
		super();
		
		dao = new PessoaDao();
	}

	public void salvarAtualizar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

	public void deletar(Pessoa pessoa) {
		
	}

	public List<Pessoa> listar() {
		return dao.listar();
	}

	public Pessoa buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

}
