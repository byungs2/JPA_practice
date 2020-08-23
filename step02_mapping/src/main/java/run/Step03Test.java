package run;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;
import step03.entity.Member;
import step03.entity.Team;
import util.PublicCommon;

//ermaster 설치
@Slf4j
public class Step03Test {
	
	@Test
	public void insert() {
		log.info("insert --- Test Running");
		EntityManager em = PublicCommon.getEntityManger();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Team t1 = Team.builder().name("TeamA").members(new ArrayList<Member>()).build();
			em.persist(t1);
			
			//양방향 관계 형성
			Member m1 = Member.builder().age(28).name("Lee").teamId(t1).build();
			Member m2 = Member.builder().age(28).name("Miu").teamId(t1).build();
			em.persist(m1);
			em.persist(m2);
			
			t1.getMembers().add(m1);
			t1.getMembers().add(m2);
			
			tx.commit();
			//TeamA에 소속된 멤버 수 확인
			Team teaminfo = em.find(Team.class, t1.getId());
			System.out.println("멤버 수 -----" + teaminfo.getMembers());
			
			//현 영속성 context 내에 저장되어 있지 않은 데이터, 단 db에는 저장된 데이터
			//find() 메소드로 호출시에 영속성 context에 없다면 select 수행
//			teaminfo = em.find(Team.class, 1L);
//			System.out.println("멤버수 ----" + teaminfo.getMembers().size());
			System.out.println("--멤버 검색 --");
			Member m3 = em.find(Member.class, 2L);
			System.out.println(m3);
			System.out.println(m3.getTeamId());
			
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
}
