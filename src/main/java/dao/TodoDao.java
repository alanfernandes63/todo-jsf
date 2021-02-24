package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.Todo;
import util.HibernateUtil;

public class TodoDao extends GeneriDaoHibernate<Todo, Long>{

	public TodoDao() {
		super(Todo.class);
	}
	
	public List<Todo> listarTodosAFazer(){
		List<Todo> todos = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.getTransaction();
		
		Criteria criteria = session.createCriteria(Todo.class);
		criteria.add(Restrictions.eq("concluida", false));
		todos = criteria.list();
		transaction.begin();
		transaction.commit();
		session.close();
		
		return todos;
	}
}
