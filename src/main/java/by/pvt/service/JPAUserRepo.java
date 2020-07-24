package by.pvt.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import by.pvt.models.UserInfo;

public interface JPAUserRepo extends JpaRepository<UserInfo, Long> {

	UserInfo findByName(String name);

}
