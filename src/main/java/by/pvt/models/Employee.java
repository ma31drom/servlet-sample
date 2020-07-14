package by.pvt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "person_id")
public class Employee extends UserInfo {

	@Column(name = "DEPARTMENT")	
	private String departmentName;

	@Column(name = "POSITION")
	private String positionName;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

}
