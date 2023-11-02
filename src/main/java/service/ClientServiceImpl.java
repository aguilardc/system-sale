package service;


import dto.ClientDTO;
import entity.Client;
import mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import repository.IClientRepository;

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
        var client = clientRepository.findAll();
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
