package by.pvt.config;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import by.pvt.service.IUserRepository;
import by.pvt.service.SkillsRepository;
import by.pvt.service.UserRepository;

@Configuration
public class SpringContextConfiguration {

	@Bean
	@Autowired
	public IUserRepository userRepo(EntityManager em, SkillsRepository skillRepo) {
		return new UserRepository(em, skillRepo);
	}

}
