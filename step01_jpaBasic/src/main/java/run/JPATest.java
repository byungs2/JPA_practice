package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;
import step01.entity.Member;
import util.PublicCommon;

@Slf4j
public class JPATest {

	@Test
	public void insert() {
		log.info("insert --- Test Running");
		EntityManager em = PublicCommon.getEntityManger();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Member m = new Member("LeeByungHun", 28);
			Member m2 = new Member("Miu", 28);
			Member m3 = new Member("Nam", 28);
			em.persist(m);
			em.persist(m2);
			em.persist(m3);
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
}
