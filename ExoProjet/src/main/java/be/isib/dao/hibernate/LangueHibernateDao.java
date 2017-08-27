package be.isib.dao.hibernate;

import be.isib.dao.LangueDao;
import be.isib.dao.UserDao;
import be.isib.entity.Langue;
import be.isib.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

@Component
@Transactional
public class LangueHibernateDao extends DefaultHibernateDao<Langue> implements LangueDao {
    @Override
    public Langue findByLangueLibelle(String libelle) {
        Query query=getEntityManager().createQuery("Select l from Langue l where l.langue=:libelle");
        query.setParameter("libelle",libelle);
        return (Langue)query.getSingleResult();
    }
}
