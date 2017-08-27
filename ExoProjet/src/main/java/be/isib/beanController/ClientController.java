/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isib.beanController;

import be.isib.beanPackage.Client;
import be.isib.beanService.ClientService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Gagui
 */
public class ClientController {
    @Autowired
    private ClientService clientService;

    @RequestMapping("/")
    public String listClient(Map<String, Object> map) {

        map.put("client", new Client());
        //map.put("clientList", clientService.listClient());

        return "client";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("client") Client client, BindingResult result) {

        //clientService.addClient(client);

        return "redirect:/client/";
    }

    @RequestMapping("/delete/{clientId}")
    public String deleteClient(@PathVariable("clientId") Integer clientId) {

        //clientService.removeClient(clientId);

        return "redirect:/client/";
    }

}
