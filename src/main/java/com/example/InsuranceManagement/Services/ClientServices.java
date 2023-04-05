package com.example.InsuranceManagement.Services;

import com.example.InsuranceManagement.Convertors.ClientDTOEntity;
import com.example.InsuranceManagement.DTOs.ClientsDTO;
import com.example.InsuranceManagement.Entities.Clients;
import com.example.InsuranceManagement.Repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServices {

    @Autowired
    ClientsRepository clientsRepository;


    public String addClient(ClientsDTO clientsDTO) throws Exception{

        // Here call convert function through the class bcz it's methode is static
        Clients clients = ClientDTOEntity.clientDTOToEntity(clientsDTO);

        clientsRepository.save(clients);

        return "Client Added Successfully";
    }

    // return All the clients
    //GET /api/clients: Fetch all clients.
    public List<Clients> getAllClients(){
        return clientsRepository.getAllClients();
    }

    //Get the clients by the ID;

    public Clients getClientsById(int id){

        Clients clients = clientsRepository.findById(id).get();

        return clients;
    }


    // Update the Client by Its ID

    public String updateClientById(int id, ClientsDTO clientsDTO) throws Exception{
        Clients clients =  getClientsById(id); // Here we get the Client object

        // Now set its Attributes
        clients.setName(clientsDTO.getName());
        clients.setAddress(clientsDTO.getAddress());
        clients.setEmail(clientsDTO.getEmail());
        clients.setPhoneNo(clientsDTO.getPhoneNo());
        clients.setDateOfBirth(clientsDTO.getDateOfBirth());

        // After Set the Attribute we need to save
        clientsRepository.save(clients);

        return "Client Update SuccessFully";
    }


    // Delete the Clients by its ID

    public String deleteClientById(int id) throws Exception{

        clientsRepository.deleteById(id);

        return "Client Delete SuccessFully";
    }

}
