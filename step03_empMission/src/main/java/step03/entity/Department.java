package step03.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@ToString
@Entity
public class Department {
	@Id
	@SequenceGenerator(name = "Department_id_seq", sequenceName = "Department_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Department_id_seq")
	long did;
	
	String dname;
	
	//왜 employee 리스트 요소가 삭제 안될까
	//외래키가 존재하는 쪽이 관계를 주도한다. 즉 외래키를 가져간 Employee 테이블을 통해서만 변경 가능
	@Nullable
	@OneToMany(mappedBy = "departmentid")
	private List<Employee> employee;
	
	@Builder
	public Department(String dname, List<Employee> employee) {
		this.dname = dname;
		this.employee = employee;
	}
	
}
