package com.example.InsuranceManagement.Convertors;

import com.example.InsuranceManagement.DTOs.ClientsDTO;
import com.example.InsuranceManagement.Entities.Clients;

public class ClientDTOEntity {

    public static Clients clientDTOToEntity(ClientsDTO clientsDTO){

        Clients clients =  Clients.builder()
                .address(clientsDTO.getAddress())
                .phoneNo(clientsDTO.getPhoneNo())
                .name(clientsDTO.getName())
                .email(clientsDTO.getEmail())
                .dateOfBirth(clientsDTO.getDateOfBirth())
                .build();

        return clients;
    }
}
