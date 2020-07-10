package by.pvt.service;

import java.util.List;
import java.util.stream.Collectors;

import by.pvt.models.UserInfo;

public class NameChangingUserRepoDecorator implements IUserRepository {

	private IUserRepository realRepo;

	public NameChangingUserRepoDecorator(IUserRepository realRepo) {
		super();
		this.realRepo = realRepo;
	}

	@Override
	public List<UserInfo> getAllUsers() {
		return realRepo.getAllUsers().stream().map(ui -> {
			ui.setName(ui.getName() + "_MODIFIED");
			return ui;
		}).collect(Collectors.toList());
	}

	@Override
	public UserInfo getUserById(Long id) {

		return realRepo.getUserById(id);
	}

	@Override
	public boolean deleteUserById(Long id) {
		return realRepo.deleteUserById(id);
	}

	@Override
	public UserInfo createUser(UserInfo readValue) {
		return realRepo.createUser(readValue);
	}

}
