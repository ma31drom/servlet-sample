package by.pvt.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.pvt.models.Skill;
import by.pvt.models.UserInfo;
import by.pvt.service.IUserRepository;
import by.pvt.service.SkillsRepository;

@RestController
@RequestMapping(path = "/skills")
public class SkillsController {

	@Autowired
	private SkillsRepository repo;

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<Skill> getAllUsers(@RequestParam(required = false) Integer limit,
			@RequestParam(required = false) Integer offset) throws SQLException {
		return repo.getAllSkillsAsc(limit, offset);
	}

	@GetMapping(path = "/{id}")
	public Skill getSkillById(@PathVariable Long id) throws SQLException {
		return repo.getSkillById(id);
	}

	@GetMapping
	public List getNamesByCatogory() throws SQLException {
		return repo.getGroupedSkillNames();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Skill> saveUser(@RequestBody List<Skill> skills) throws SQLException {
		return repo.createSkills(skills);
	}

}
