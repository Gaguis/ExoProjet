package be.isib.service;

import be.isib.dao.ClientDao;
import be.isib.dao.LangueDao;
import be.isib.entity.Client;
import be.isib.entity.Langue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class LangueService {

    @Autowired
    private LangueDao langueDao;


    public Langue findLangueFromLibelle(String libelle){
        return langueDao.findByLangueLibelle(libelle);
    }

    public List<Langue> getAllLangues(){
        List<Langue> langues=new ArrayList<Langue>();
        try {
            langues=langueDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return langues;
    }
}
