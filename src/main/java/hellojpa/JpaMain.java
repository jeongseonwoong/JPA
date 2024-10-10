package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        //code
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            //영속
            Member member= entityManager.find(Member.class, 1L);
            member.setName("GalBae");

        } catch (Exception e){
            transaction.rollback();
        } finally{
            entityManager.close();
        }


        entityManager.close();
        entityManagerFactory.close();
    }
}
