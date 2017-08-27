package be.isib.service;

import be.isib.dao.ClientDao;
import be.isib.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    @Transactional
    public void updateClient(Client client) throws Exception{
        clientDao.merge(client);
    }

    public void createClient(Client client) throws Exception{
        clientDao.persist(client);
    }


    public void deleteClient(Client client) throws Exception{
        clientDao.remove(client.getId());

    }

    public List<Client> getAllClients(){
        List<Client> clients=new ArrayList<Client>();
        try {
            clients=clientDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return clients;
    }
}
