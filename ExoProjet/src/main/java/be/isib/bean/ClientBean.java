package be.isib.bean;


import be.isib.entity.Client;
import be.isib.service.ClientService;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ClientBean {

	Logger log=Logger.getLogger(ClientBean.class.getName());

	@ManagedProperty("#{clientService}")
	private ClientService clientService;

	private List<Client> listClients;

	private Client client = new Client();

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getListClients() {
		return listClients;
	}

	public void setListClients(List<Client> listClients) {
		this.listClients = listClients;
	}

	@PostConstruct
	public void init(){
			listClients = clientService.getAllClients();

	}

	public String register() {
		try {
			if(client.getId()!=null) {
				clientService.updateClient(client);
			}else{
				clientService.createClient(client);
			}
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("The Employee "+this.client.getNom()+" Is Registered Successfully"));
		}catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Cannot register this employee "+ client.getNom()));
			log.error(e);
		}

		return "";
	}
}
