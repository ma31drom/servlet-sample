package by.pvt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import by.pvt.models.Skill;

@Repository
public class SkillsRepository {

	private EntityManager entityManager;

	public SkillsRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Set<Skill> getSkillsByName(Set<String> names) {
		CriteriaQuery<Skill> query = entityManager.getCriteriaBuilder().createQuery(Skill.class);
		query.from(Skill.class);
		return entityManager.createQuery(query).getResultList().stream().collect(Collectors.toSet());
	}

	@Transactional
	public List<Skill> getAllSkillsAsc(Integer limit, Integer offset) {
		Query createQuery = entityManager.createQuery("from Skill S order by S.name ASC");
		if (offset != null) {
			createQuery.setFirstResult(offset);
		}
		if (limit != null) {
			createQuery.setMaxResults(limit);
		}
		return createQuery.getResultList();
	}

	public Skill getSkillById(Long id) {

		Query createQuery = entityManager.createQuery("from Skill S where S.id = :id");
		createQuery.setParameter("id", id);

		List resultList = createQuery.getResultList();
		if (!CollectionUtils.isEmpty(resultList)) {
			return (Skill) resultList.iterator().next();
		}
		return null;
	}

	public List getGroupedSkillNames() {
		Query createQuery = entityManager
				.createQuery("select count(name) as count, category as cat from Skill group by category");
		return createQuery.getResultList();
	}

	@Transactional
	public List<Skill> createSkills(List<Skill> skills) {
		skills.forEach(entityManager::persist);
		return skills;
	}

}
