package com.systemsale.systemsale.service.client;


import com.systemsale.systemsale.dto.ClientDTO;
import com.systemsale.systemsale.entity.Client;
import com.systemsale.systemsale.mapper.ClientMapper;
import com.systemsale.systemsale.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class ClientServiceImpl implements  IClientService{

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    public ClientDTO create(Client client){
        Client client1 = clientRepository.save(client);
        return clientMapper.toDTO(client1);
    }
    public List<ClientDTO> read() {
        var client = clientRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return clientMapper.toDTOList(client);
    }


    public ClientDTO readById(Long id) {
        Client client = clientRepository.findById(id).get();
        if (ObjectUtils.isEmpty(client)) return  null;
        return clientMapper.toDTO(client);
    }

    public ClientDTO update(Client client) {
        Client client1 = clientRepository.save(client);
        return clientMapper.toDTO(client1);
    }
    public  Boolean delete(Long id) {
        try {
            clientRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}