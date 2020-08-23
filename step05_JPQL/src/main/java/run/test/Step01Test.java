package run.test;

import java.util.List;

import javax.persistence.EntityManager;

import step01.entity.Employee;
import util.PublicCommon;

public class Step01Test {

	public static void main(String[] args) {
		EntityManager em = PublicCommon.getEntityManger();
		try {
			//step01
//			List<String> l = em.createQuery("select UPPER(e.ename) from Employee e").getResultList();
//			l.stream().forEach(x-> System.out.println("직원명 : "+ x));
//			Double sal = (Double)em.createQuery("select max(e.sal) from Employee e").getSingleResult();
//			System.out.println("최고 급여 : " +sal);
//			
//			//? 급여가 800~3000 사이 직원의 모든 정보 검색
//			List<Employee> l = em.createQuery("select e from Employee e where e.sal between 800 and 3000").getResultList();
//			l.stream().forEach(x -> System.out.println(x));
//			//? like 연산자 사용하여 M으로 시작하는 이름을 보유한  모든 직원의 이름만 검색
//			List<String> l2 = em.createQuery("select e.ename from Employee e where e.ename like 'M%'").getResultList();
//			l2.stream().forEach(x -> System.out.println(x));
//			//? 사원명 오름차순 정렬
//			List<Employee> l3 = em.createQuery("select e from Employee e order by e.ename asc").getResultList();
//			l3.stream().forEach(x -> System.out.println(x));
			
			//step02 NameQuery 학습
			Employee e = (Employee)em.createNamedQuery("Employee.findByEmpno").setParameter("empno", 7369).getSingleResult();
			System.out.println(e);
			// 사원명과 사번으로 해당 사원의 급여 검색
			Double sal = (Double)em.createNamedQuery("Employee.findByEmpnoEname").setParameter("empno", 7369).setParameter("ename", "SMITH").getSingleResult();
			System.out.println("급여 : " + sal);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
}
