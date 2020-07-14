package by.pvt.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

/**
 * 
 * @author User
 *
 */

@Entity
@Table(name = "userinfo")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserInfo {

	public UserInfo() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "U_NAME")
	private String name;

	@Access(AccessType.PROPERTY)
	@Column(name = "SALARY", insertable = true, updatable = false)
	private Double salary;

	@Formula(value = "concat(coalesce(POSITION, ''), coalesce(DEPARTMENT, ''))")
	private String employeeInfo;

	@Embedded
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(String employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return 1000 * salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
