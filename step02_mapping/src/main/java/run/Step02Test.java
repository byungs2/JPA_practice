package run;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;
import step02.entity.Member;
import step02.entity.Team;
import util.PublicCommon;

@Slf4j
public class Step02Test {
	
	@Test
	public void insert() {
		ArrayList<Member> m = new ArrayList<>();
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
			Member m1 = Member.builder().age(28).name("Lee").teamId(t1).build();
			Member m2 = Member.builder().age(28).name("Miu").teamId(t1).build();
			Member m3 = Member.builder().age(28).name("Miu").teamId(t2).build();
			em.persist(m1);
			em.persist(m2);
			em.persist(m3);
			m = (ArrayList<Member>) em.createQuery("select m from Member m where TEAM_ID = 1", Member.class).getResultList();
			System.out.println(m);
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
}
