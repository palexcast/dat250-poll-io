package no.hvl.dat250.jpa.daos;

import no.hvl.dat250.jpa.models.entities.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserDao {
    private final EntityManager em;

    public UserDao(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    public UserEntity create(UserEntity user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        return user;
    }

    public UserEntity update(UserEntity user) {
        UserEntity toUpdate = em.find(UserEntity.class, user.getId());
        em.getTransaction().begin();
        toUpdate.setName(user.getName());
        toUpdate.setPolls(user.getPolls());
        em.getTransaction().commit();
        em.close();
        return toUpdate;
    }

    public UserEntity getById(String id) {
        return em.find(UserEntity.class, id);
    }

    /**
     * Call when done with DAO
     */
    public void destroy() {
        if (this.em.isOpen()) {
            this.em.close();
        }
    }
}
