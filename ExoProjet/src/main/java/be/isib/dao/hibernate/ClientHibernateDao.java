package be.isib.dao.hibernate;

import be.isib.dao.ClientDao;
import be.isib.entity.Client;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ClientHibernateDao extends DefaultHibernateDao<Client> implements ClientDao {

}
