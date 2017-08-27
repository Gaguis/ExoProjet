package be.isib.service.impl;

import be.isib.dao.ClientDao;
import be.isib.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class EmployeeServiceImpl  {

	@Autowired
	private ClientDao clientDao;

	@Transactional
	public void updateEmployee(Client client) throws Exception{
		clientDao.merge(client);
	}

	public void createEmployee(Client client) throws Exception{
		clientDao.persist(client);
	}


	public void deleteEmployee(List<Client> clients) throws Exception{

	}

	public List<Client> getAllEmployees() throws Exception{
		return null;
	}
}
