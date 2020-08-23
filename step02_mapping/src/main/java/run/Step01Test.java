package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;
import step01.entity.Member;
import step01.entity.Team;
import util.PublicCommon;

@Slf4j
public class Step01Test {
	
	@Test
	public void insert() {
		log.info("insert --- Test Running");
		EntityManager em = PublicCommon.getEntityManger();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		/*	Team데이터 생성(2개) : 시퀀스 자동 반영 -> Team의 Id값 활용하면서 Member 생성
		 *  
		 */
		try {
			Team t1 = new Team("TeamA");
			Team t2 = new Team("TeamB");
			Team t3 = new Team("TeamC");
			em.persist(t1);
			em.persist(t2);
			em.persist(t3);
			Member m1 = new Member("Lee", 28, t1.getId());
			em.persist(m1);
			
			// Member의 모든 정보 검색 위한 코드 : 소속된 team 정보 포함
			/* Member Entity만 검색시에 모든 정보 다 검색하길 바란다면
			 * 설계는 어떻게?
			 * 하위 코드는 Member 검색 후에 Team 검색하여 정보 활용하는 구조
			 * Member Entity의 변수에 Team 타입을 멤버로 선언하는 방법
			 */
			Member searchM  = em.find(Member.class, 4L);
			Team searchT = em.find(Team.class, searchM.getTeamId());
			System.out.println(searchM);
			System.out.println(searchT);
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
}
