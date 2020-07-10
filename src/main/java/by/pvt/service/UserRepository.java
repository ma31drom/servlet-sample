package by.pvt.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import by.pvt.models.UserInfo;

public class UserRepository implements IUserRepository {

	private EntityManager entityManager;

	public UserRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<UserInfo> getAllUsers() {
		CriteriaQuery<UserInfo> query = entityManager.getCriteriaBuilder().createQuery(UserInfo.class);
		query.from(UserInfo.class);
		return entityManager.createQuery(query).getResultList();
	}

	public UserInfo getUserById(Long id) {
		return entityManager.find(UserInfo.class, id);
	}

	public boolean deleteUserById(Long id) {
		UserInfo object = new UserInfo();
		object.setId(id);
		entityManager.remove(object);
		return true;
	}

	public UserInfo createUser(UserInfo readValue) {
		entityManager.persist(readValue);
		return readValue;
	}
}
