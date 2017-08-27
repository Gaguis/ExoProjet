package be.isib.dao.hibernate;

import be.isib.dao.UserDao;
import be.isib.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

@Component
@Transactional
public class UserHibernateDao extends DefaultHibernateDao<User> implements UserDao{
    @Override
    public User findByUsername(String username) throws Exception {
        Query query=getEntityManager().createQuery("Select u from User u where username = :username");
        query.setParameter("username",username);
        return (User)query.getSingleResult();
    }
}
