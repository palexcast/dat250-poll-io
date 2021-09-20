package no.hvl.dat250.jpa.daos;

import no.hvl.dat250.jpa.models.entities.PollEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class PollDao {
    private final EntityManager em;

    public PollDao(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    public PollEntity create(PollEntity poll) {
        em.getTransaction().begin();
        em.persist(poll);
        em.getTransaction().commit();
        em.close();
        return poll;
    }

    public PollEntity update(PollEntity poll) {
        PollEntity toUpdate = em.find(PollEntity.class, poll.getId());
        em.getTransaction().begin();
        toUpdate.setName(poll.getName());
        toUpdate.setDescription(poll.getDescription());
        toUpdate.setStartDate(poll.getStartDate());
        toUpdate.setEndDate(poll.getEndDate());
        toUpdate.setPublicPoll(poll.isPublicPoll());
        toUpdate.setOptions(poll.getOptions());
        em.getTransaction().commit();
        em.close();
        return toUpdate;
    }

    public PollEntity getById(String id) {
        return em.find(PollEntity.class, id);
    }

    public PollEntity getByPublicId(String publicId) {
        Query query = em.createQuery("SELECT c FROM Polls c where c.publicId = :publicId");
        query.setParameter("publicId", publicId);
        return (PollEntity) query.getSingleResult();
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
