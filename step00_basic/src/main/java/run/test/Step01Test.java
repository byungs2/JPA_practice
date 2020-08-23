package run.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import step01.entity.Member;

@Slf4j
public class Step01Test {
	
	//@Test
	public void memberCrud() {
		log.info("member table에 crud 적용하기 ------------------\n");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step00_basic");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin(); 
		
		//insert 문장 생성 -> db에 insert 실행 (commit 메소드 호출 시에 실제 db 적용)
		Member member = new Member("id1", "신동엽", 10); 
		em.persist(member); //insert 기능의 메소드
//
		member.setAge(40); //update 문장이 생성되기 전에 스냅샷의 데이터와 비교하여 다를 경우 sql문장 생성
//
		Member oneFindMember = em.find(Member.class, "id1");
		System.out.println(oneFindMember.getUserName());
//
		
		//JPQL --> persist와 소통하는 구조
		//Entity와 속성을 대소문자 구분한다 
		//별칭을 필수로 사용해야한다
		//db로부터 검색
		List<Member> allMember = em.createQuery("select m from Member m", Member.class).getResultList();
		System.out.println("회원 수 : " + allMember.size());
//
//		for (Member m : allMember) {
//			System.out.println(m);
//		}
//
		em.remove(oneFindMember);
//		
		tx.commit();
//		
//		
//		System.out.println("-- 삭제 후 검색 해 보기 --");
//		oneFindMember = em.find(Member.class, "id1");
//		System.out.println(oneFindMember);
	}

}
