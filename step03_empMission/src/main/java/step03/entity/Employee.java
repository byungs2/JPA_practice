package step03.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.sun.istack.Nullable;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employee {
	@Id
	@SequenceGenerator(name = "Employee_id_seq", sequenceName = "Employee_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Employee_id_seq")
	private long eid;
	
	private String ename;
	private int salary;
	
	
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department departmentid;
	
	@Builder
	public Employee(String ename, int salary, Department departmentid) {
		this.ename = ename;
		this.salary = salary;
		this.departmentid = departmentid;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", departmentid=" + departmentid.getDid()
				+ "]";
	}

}