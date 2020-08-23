package run.test;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import step03.entity.Department;
import util.PublicCommon;

public class RunDepartmentCRUD {
	private static RunDepartmentCRUD instance = new RunDepartmentCRUD();
	
	public static RunDepartmentCRUD getInstance() {
		return instance;
	}
	
	public void createDepartment() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Department department1 = Department.builder().dname("Technical Manager").build();
			Department department2 = Department.builder().dname("Constructing Manager").build();
			Department department3 = Department.builder().dname("Mechanical Product Manager").build();

			em.persist(department1);
			em.persist(department2);
			em.persist(department3);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	public void updateDepartment() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Department department = em.find(Department.class, 3L);
			if (department != null) {
				// before update
				System.out.println("update 전 : " + department);
				department.setDname("Program Debugging Manager");
			}else {
				System.out.println("업데이트 하려는 부서의 정보를 찾지 못하였습니다");
			}
			tx.commit();
			// after update
			System.out.println("update 후 : " + department);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	// select
	public void findElement() {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			Department department = em.find(Department.class, 3L);
			
			if(department != null) {
				System.out.println("Department name = " + department.getDname() + "\n" + "Employees = " + department.getEmployee());
			}else {
				System.out.println("검색 요청한 부서는 미존재합니다");
			}
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
			Department department = em.find(Department.class, 1L);
			if (department != null) {
				em.remove(department);
			}else {
				System.out.println("삭제하려는 부서는 아쉽게도 이미 해체되었습니다");
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
}
