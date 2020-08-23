package run.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import step01.entity.Member;

public class Step01Test {
	private static final Logger LOGGER = Logger.getLogger("JPA");

	@Test
	public void memberCrud() {
		LOGGER.log(Level.INFO, "member table에 crud 적용하기 ------------------\n");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracleDB");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		
//		Member member = new Member("id1", "신동엽", 10); 
//		em.persist(member);
//
//		member.setAge(40);
//
//		Member oneFindMember = em.find(Member.class, "id1");
//		System.out.println(oneFindMember);
//
//		List<Member> allMember = em.createQuery("select m from Member m", Member.class).getResultList();
//		System.out.println("회원 수 : " + allMember.size());
//
//		for (Member m : allMember) {
//			System.out.println(m);
//		}
//
//		em.remove(oneFindMember);
//		
//		tx.commit();
//		
//		
//		System.out.println("-- 삭제 후 검색 해 보기 --");
//		oneFindMember = em.find(Member.class, "id1");
//		System.out.println(oneFindMember);
		
	}

}
