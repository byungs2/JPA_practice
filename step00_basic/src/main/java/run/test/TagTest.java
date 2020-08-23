package run.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import step01.entity.Post;
import step01.entity.PostTag;
import step01.entity.Tag;

public class TagTest {

	@Test
	public void tagCRUD() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step00_basic");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		//insert
		try {
			tx.begin();
			Post p1 = Post.builder().postId(1L).writerName("LEE").build();
			Post p2 = Post.builder().postId(2L).writerName("MIU").build();
			Post p3 = Post.builder().postId(3L).writerName("NAM").build();
			Tag t1 = Tag.builder().tagId(1L).tagName("#DOG").build();
			Tag t2 = Tag.builder().tagId(2L).tagName("#CAT").build();
			Tag t3 = Tag.builder().tagId(3L).tagName("#FISH").build();
			PostTag pt1 = PostTag.builder().postId(p1).tagId(t1).build();
			PostTag pt2 = PostTag.builder().postId(p1).tagId(t2).build();
			PostTag pt3 = PostTag.builder().postId(p1).tagId(t3).build();
			PostTag pt4 = PostTag.builder().postId(p2).tagId(t1).build();
			PostTag pt5 = PostTag.builder().postId(p3).tagId(t1).build();
			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			em.persist(t1);
			em.persist(t2);
			em.persist(t3);
			em.persist(pt1);
			em.persist(pt2);
			em.persist(pt3);
			em.persist(pt4);
			em.persist(pt5);
			tx.commit();
			PostTag pt6 = (PostTag) em.createNamedQuery("PostTag.findByTagName").setParameter("tagname", "#FISH").getSingleResult();
			System.out.println(pt6.getPostId().getWriterName());
		} catch (Exception e) {
		}finally {
			em.close();
		}
	

		
		//tag 이름으로 Post 검색
	}
}
