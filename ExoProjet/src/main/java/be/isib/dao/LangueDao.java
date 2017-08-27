package be.isib.dao;

import be.isib.entity.Langue;
import be.isib.entity.User;

public interface LangueDao extends EntityDao<Langue> {

    Langue findByLangueLibelle(String libelle);

}
