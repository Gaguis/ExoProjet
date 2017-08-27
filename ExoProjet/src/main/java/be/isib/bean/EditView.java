package be.isib.bean;

import be.isib.entity.Client;
import be.isib.entity.Langue;
import be.isib.service.ClientService;
import be.isib.service.LangueService;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name="dtEditView")
@SessionScoped
public class EditView implements Serializable {

    private List<Client> selectedClients=new ArrayList<Client>();

    private List<Client> listClients;

    private List<Langue> langues;

    private Client newClient=new Client();

    private Client selectedClient;

    @ManagedProperty("#{clientService}")
    private ClientService clientService;

    @ManagedProperty("#{langueService}")
    private LangueService langueService;


    @PostConstruct
    public void init() {
        listClients = clientService.getAllClients();
        langues=langueService.getAllLangues();
    }

    public Client getNewClient() {
        return newClient;
    }

    public void setNewClient(Client newClient) {
        this.newClient = newClient;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }

    public List<Client> getSelectedClients() {
        return selectedClients;
    }

    public void setSelectedClients(List<Client> selectedClients) {
        this.selectedClients = selectedClients;
    }

    public List<Client> getListClients() {
        return listClients;
    }

    public void setListClients(List<Client> listClients) {
        this.listClients = listClients;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public List<Langue> getLangues() {
        return langues;
    }

    public void setLangues(List<Langue> langues) {
        this.langues = langues;
    }

    public LangueService getLangueService() {
        return langueService;
    }

    public void setLangueService(LangueService langueService) {
        this.langueService = langueService;
    }

    public void onRowEdit(RowEditEvent event) {
        try {
            clientService.updateClient((Client) event.getObject());
            FacesMessage msg = new FacesMessage("Client Edited", ""+((Client) event.getObject()).getId());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }catch (Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage("Cannot save Client into db", ""+((Client) event.getObject()).getId());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }


    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ""+((Client) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void onRowSelect(RowEditEvent event) {
        selectedClients.add((Client) event.getObject());
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void deleteAction() {
        try{
            for (Client selectedClient : selectedClients) {
                    clientService.deleteClient(selectedClient);
            }
            listClients=clientService.getAllClients();
            //RequestContext.getCurrentInstance().update("clientForm");
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Clients deleted","");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cannot delete clients","");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Client Selected", ""+((Client) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Client Unselected", ""+((Client) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onSubmit(){
        try {
            clientService.createClient(newClient);
            listClients=clientService.getAllClients();
            FacesMessage msg = new FacesMessage("Client was Add", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg = new FacesMessage("Client not Added", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
}
