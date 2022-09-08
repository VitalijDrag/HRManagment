package lt.CodeAcademy.model;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@DynamicUpdate
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String name;

	@Column
	private String idNumber;

	@Column
	private String address;

	@Column
	private String phone;

	@Column
	private String email;

	@Column
	private String birth;

	@Column
	private String contractStart;

	@Column
	private String contractEnd;

	@Column
	private String occupation;

	@Column
	private String password;

	@Column
	private Boolean isAdmin;

	@Column
	private String salary;

	@Column
	private String obs;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", insertable = false, updatable = false)
	private Set<Vacation> vacations;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", insertable = false, updatable = false)
	private Set<Absence> absences;

	public String getSalary() {
		try {
			return String.format("%,.2f", Double.valueOf(this.salary));
		} catch (Exception e) {
			return this.salary;
		}
	}

}
