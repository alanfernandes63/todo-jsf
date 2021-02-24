package dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class GeneriDaoHibernate<T, ID extends Serializable> implements GenericDaoInterface<T> {

	private Class<T> className;

	public GeneriDaoHibernate(Class<T> className) {
		super();
		this.className = className;
	}

	public void salvarAtualizar(T t) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.getTransaction();

		transaction.begin();
		session.saveOrUpdate(t);
		transaction.commit();
		session.close();
	}

	public void deletar(T t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.getTransaction();

		transaction.begin();
		session.delete(t);
		transaction.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<T> listar() {
		List<T> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		list = session.createQuery("select o from " + className.getSimpleName() + " o").getResultList();
		transaction.commit();
		session.close();
		return list;
	}

	public T buscarPorId(Long id) {
		T t = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		t = session.find(className, id);
		transaction.commit();
		session.close();

		return t;
	}

}
