package by.pvt.config;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import by.pvt.service.IUserRepository;
import by.pvt.service.NameChangingUserRepoDecorator;
import by.pvt.service.UserRepository;

@Configuration
public class SpringContextConfiguration {

	@Bean

	@Autowired
	public IUserRepository userRepo(EntityManager em) {
		return new UserRepository(em);
	}

	@Bean
	@ConditionalOnProperty(prefix = "app", name = "decorate", havingValue = "true", matchIfMissing = false)
	@Primary
	public IUserRepository primary(IUserRepository userRepo) {
		return new NameChangingUserRepoDecorator(userRepo);
	}
}
