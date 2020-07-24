package by.pvt.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "skills")
@Data
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "skill_name")
	private String name;

	@Column(name = "category")
	private String category;

	@ManyToMany(mappedBy = "skills", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<UserInfo> users;
}
