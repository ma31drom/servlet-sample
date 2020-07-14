package by.pvt.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import by.pvt.models.Employee;
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

	public UserInfo getUEmployeeById(Long id) {
		return entityManager.find(Employee.class, id);
	}
	
	public boolean deleteUserById(Long id) {
		UserInfo object = new UserInfo();
		object.setId(id);
		entityManager.remove(object);
		return true;
	}

	@org.springframework.transaction.annotation.Transactional
	public UserInfo createUser(UserInfo readValue) {
		entityManager.persist(readValue);
		return readValue;
	}

	@Override
	public UserInfo updateUser(UserInfo user) {
		UserInfo find = entityManager.find(UserInfo.class, user.getId());
		find.setName(user.getName());
		find.setSalary(user.getSalary());
		entityManager.flush();
		return find;
	}
}
