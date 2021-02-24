package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.Todo;
import util.HibernateUtil;

public class TodoDao extends GeneriDaoHibernate<Todo, Long> {

	public TodoDao() {
		super(Todo.class);
	}

	@SuppressWarnings("unchecked")
	public List<Todo> listarTodosAFazer() {
		List<Todo> todos = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.getTransaction();

		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Todo.class);
		criteria.add(Restrictions.eq("concluida", false));
		todos = criteria.list();
		transaction.begin();
		transaction.commit();
		session.close();

		return todos;
	}

	@SuppressWarnings("unchecked")
	public List<Todo> filtrar(Todo todo) {
		List<Todo> todos = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.getTransaction();

		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Todo.class);
		if (todo.getId() != null) {
			criteria.add(Restrictions.eq("id", todo.getId()));
		}
		if (!todo.getTitulo().equals("")) {
			criteria.add(Restrictions.eq("titulo", todo.getTitulo()));
		}
		if (todo.getConcluida() != null) {
			criteria.add(Restrictions.eq("concluida", todo.getConcluida()));
		}
		if (todo.getResponsavel() != null) {
			criteria.add(Restrictions.eq("responsavel", todo.getResponsavel()));
		}

		todos = criteria.list();
		transaction.begin();
		transaction.commit();
		session.close();

		return todos;
	}
}
