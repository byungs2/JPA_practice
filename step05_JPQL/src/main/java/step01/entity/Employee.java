/* 사번으로 사원의 모든 정보 검색하는 정적 sql문장
 * select e from Employee e where e.empno = :empno
 * 이름으로 사원의 모든 정보 검색하는 정적 sql문장
 * select e from Employee e where e.ename = :ename
 * 
 * @NamedQuery
 * - sql문장에 이름 부여
 * - 가변적인 데이터 표현은 :변수명 으로 표현
 * - 가변적인 데이터 값 표현은 자바 코드로 처리 : setParameter()
 */

package step01.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;

@Data
@Entity
@NamedQuery(query = "select e from Employee e where e.empno = :empno ", name = "Employee.findByEmpno")
@NamedQuery(query = "select e from Employee e where e.ename = :ename ", name = "Employee.findByEname")
@NamedQuery(query = "select e.sal from Employee e where e.ename = :ename and e.empno = :empno", name = "Employee.findByEmpnoEname")
public class Employee {
	@Id
	private int empno;
	
	private String ename;
	private double sal;
	private int deptno;
}
