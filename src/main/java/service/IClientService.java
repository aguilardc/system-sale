package service;

import dto.ClientDTO;
import entity.Client;

import java.util.List;


public interface IClientService {
    ClientDTO create(Client client);

    List<ClientDTO> read();

    ClientDTO readById(Long id);

    ClientDTO update(Client client);

    Boolean delete(Long id);
}
