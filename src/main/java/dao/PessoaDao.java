package dao;

import model.Pessoa;

public class PessoaDao extends GeneriDaoHibernate<Pessoa, Long> {

	public PessoaDao() {
		super(Pessoa.class);
	}

}
