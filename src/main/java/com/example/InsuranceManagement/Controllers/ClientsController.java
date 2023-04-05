package com.example.InsuranceManagement.Controllers;

import com.example.InsuranceManagement.DTOs.ClientsDTO;
import com.example.InsuranceManagement.Entities.Clients;
import com.example.InsuranceManagement.Services.ClientServices;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientsController {

    @Autowired
    ClientServices clientServices;

    @PostMapping("/clients")
    public ResponseEntity<String> addClient(@RequestBody() ClientsDTO clientsDTO) {

        try {
            String response = clientServices.addClient(clientsDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Get All the clients

    @GetMapping("/clients")
    public List<Clients> getAllClients() {

            return clientServices.getAllClients();
        }


        // Get client by .
    @GetMapping("/clients/{id}")
    public Clients getClientsById(@PathVariable(value = "id") int id){
        Clients clients = clientServices.getClientsById(id);

        return clients;
        }

        // Update By ID
        @PutMapping("/clients/{id}")
        public ResponseEntity<String> updateClientById(@PathVariable(value = "id") int id,@RequestBody() ClientsDTO clientsDTO){
          try {
              String response =  clientServices.updateClientById(id, clientsDTO);
              return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
          }catch (Exception e){
              return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
          }

        }


        // Delete By ID
        @DeleteMapping("/clients/{id}")
        public ResponseEntity<String> deleteClientById(@PathVariable(value = "id") int id)
        {
            try {
                String response = clientServices.deleteClientById(id);
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            }catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
}
