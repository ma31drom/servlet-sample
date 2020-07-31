package by.pvt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import by.pvt.models.Skill;
import by.pvt.models.UserInfo;

public class UserRepository implements IUserRepository {

	private EntityManager entityManager;
	private SkillsRepository skillRepo;

	public UserRepository(EntityManager entityManager, SkillsRepository skillRepo) {
		this.entityManager = entityManager;
		this.skillRepo = skillRepo;
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
		// object.setId(id);
		entityManager.remove(object);
		return true;
	}

	@org.springframework.transaction.annotation.Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public UserInfo createUser(UserInfo readValue) {
		enrichWithDBObjects(readValue);

		entityManager.persist(readValue);
		entityManager.flush();

		return readValue;
	}

	private void enrichWithDBObjects(UserInfo readValue) {
		Set<Skill> source = readValue.getSkills();
		Set<Skill> result = new HashSet<Skill>();
		if (!CollectionUtils.isEmpty(source)) {
			Set<Skill> skillsByName = skillRepo
					.getSkillsByName(source.stream().map(Skill::getName).collect(Collectors.toSet()));

			Map<String, Skill> skillsGroupedByName = skillsByName.stream()
					.collect(Collectors.toMap(Skill::getName, Function.identity()));

			for (Skill skill : source) {
				if (skillsGroupedByName.containsKey(skill.getName())) {
					result.add(skillsGroupedByName.get(skill.getName()));
				} else {
					result.add(skill);
				}
			}
			readValue.setSkills(result);
		}
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	public UserInfo updateUser(UserInfo user) {
		UserInfo find = entityManager.find(UserInfo.class, user.getId());
		find.setName(user.getName());
		find.setSalary(user.getSalary());
		entityManager.flush();
		return find;
	}

	@Override
	public List<UserInfo> getByNamePaternAndSalaryMoreThen(String namePattern, Double salaryLimit) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserInfo> q = cb.createQuery(UserInfo.class);
		Root<UserInfo> from = q.from(UserInfo.class);

		CriteriaQuery<UserInfo> query = q.select(from)
				.where(cb.and(cb.like(from.get("name"), namePattern), cb.greaterThan(from.get("salary"), salaryLimit)));

		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public List<UserInfo> getByStringIn2Fields(String filter) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserInfo> q = cb.createQuery(UserInfo.class);
		Root<UserInfo> from = q.from(UserInfo.class);

		String[] split = filter.split(" ");

		CriteriaQuery<UserInfo> query = q.select(from)
				.where(cb.and(from.get("name").in(split), from.get("lname").in(split)));
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public String mediumSalary() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> q = cb.createQuery(Tuple.class);

		Root<UserInfo> from = q.from(UserInfo.class);

		CriteriaQuery<Tuple> query = q
				.multiselect(from.get("name").alias("name"), cb.avg(from.get("salary")).alias("midSal"))
				.groupBy(from.get("name"));

		// @Query("select name, avg(salary) from Employee group by name")

		List<Tuple> resultList = entityManager.createQuery(query).getResultList();

		return resultList.stream().map(tuple -> tuple.get("name").toString() + ":" + tuple.get("midSal").toString())
				.collect(Collectors.joining(","));
	}

	@Override
	public UserInfo getUserByPhoneNumber(String phone) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserInfo> q = cb.createQuery(UserInfo.class);

		q.where(cb.equal(q.from(UserInfo.class).join("phones", JoinType.INNER).get("number"), phone));

		return entityManager.createQuery(q).getSingleResult();
	}

}
