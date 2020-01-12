package facades;

import entities.Dayplan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class FacadeExample {

    private static FacadeExample instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private FacadeExample() {}

    public static FacadeExample getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeExample();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getPersonCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long PersonCount = (long)em.createQuery("SELECT COUNT(p) FROM Dayplan p").getSingleResult();
            return PersonCount;
        }finally{  
            em.close();
        }
    }

    public List<Dayplan> getAllPersons() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Dayplan> tq = em.createQuery("SELECT p FROM Dayplan p", Dayplan.class);
            List<Dayplan> dayplans = tq.getResultList();
            return dayplans;
        } finally {
            em.close();
        }
    }

}
