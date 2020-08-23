//employee table crud 로직
//개별 메소드로 개발 차후에 리펙토링 해야 함

package run.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step03.entity.Department;
import step03.entity.Employee;
import util.PublicCommon;

public class RunEmployeeCRUD {
	private static RunEmployeeCRUD instance = new RunEmployeeCRUD();
	
	public static RunEmployeeCRUD getInstance() {
		return instance;
	}
	
	public void createEmployee() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Employee employee = Employee.builder().ename("Gopal").salary(40000).departmentid(em.find(Department.class, 1L)).build();
			Employee employee2 = Employee.builder().ename("Lee&Miu").salary(43000).departmentid(em.find(Department.class, 2L)).build();
			em.persist(employee);
			em.persist(employee2);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	public void updateEmployee() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Employee employee = em.find(Employee.class, 1L);
			if (employee != null) {
				// before update
				System.out.println("update 전 : " + employee);
				employee.setSalary(46000);
				employee.setDepartmentid(em.find(Department.class, 3L));
			}else {
				System.out.println("업데이트 하려는 사람의 정보를 찾지 못하였습니다");
			}
			tx.commit();
			// after update
			System.out.println("update 후 : " + employee);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	// select
	public void findElement() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Employee employee = em.find(Employee.class, 1L);
			if(employee != null) {
				System.out.println("employee ID = " + employee.getEid()+ "\n" + "employee NAME = " + employee.getEname() + "\n" + "employee SALARY = " + employee.getSalary() + "\n" + "employee DESIGNATION = " + employee.getDepartmentid());
			}else {
				System.out.println("검색 요청한 직원은 미존재합니다");
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	// delete
	public void deleteElement() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Employee employee = em.find(Employee.class, 1L);
			if (employee != null) {
				em.remove(employee);
			}else {
				System.out.println("삭제하려는 사원은 아쉽게도 이미 해고되었습니다");
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
}
