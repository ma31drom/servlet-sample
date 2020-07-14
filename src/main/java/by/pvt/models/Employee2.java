package by.pvt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employee2")
@PrimaryKeyJoinColumn(name = "person_id")
public class Employee2 extends UserInfo {

	@Column(name = "POSITION")
	private String positionName;

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

}
