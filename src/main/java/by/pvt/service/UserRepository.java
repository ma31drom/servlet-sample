package by.pvt.service;

import java.util.List;
import java.util.function.Function;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import by.pvt.models.UserInfo;

public class UserRepository implements IUserRepository {

	static private UserRepository instance = new UserRepository();
	static private SessionFactory sessionFactory = HibernateSessionFactoryInitializer.getSessionFactory();

	private UserRepository() {

	}

	public static UserRepository getInstance() {
		return instance;
	}

	public List<UserInfo> getAllUsers() {
		return doInTransaction((session) -> {
			CriteriaQuery<UserInfo> query = session.getCriteriaBuilder().createQuery(UserInfo.class);
			query.from(UserInfo.class);
			return session.createQuery(query).getResultList();
		});
	}

	public UserInfo getUserById(Long id) {
		return doInTransaction((session) -> {
			return session.find(UserInfo.class, id);
		});
	}

	public boolean deleteUserById(Long id) {
		return doInTransaction((session) -> {
			UserInfo object = new UserInfo();
			object.setId(id);
			session.delete(object);
			return true;
		});
	}

	public UserInfo createUser(UserInfo readValue) {
		return doInTransaction((session) -> {
			session.save(readValue);
			return readValue;
		});
	}

	<R> R doInTransaction(Function<Session, R> operation) {
		try (Session currentSession = sessionFactory.getCurrentSession()) {
			Transaction transaction = currentSession.beginTransaction();
			R apply = operation.apply(currentSession);
			transaction.commit();
			return apply;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
