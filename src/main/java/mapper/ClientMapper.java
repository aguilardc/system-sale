package mapper;

import dto.ClientDTO;
import entity.Client;
import org.aspectj.apache.bcel.generic.InstructionConstants;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public ClientDTO toDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }

    public List<ClientDTO> toDTOList(List<Client> clientList) {
        return clientList.stream().map(s -> toDTO(s)).collect(Collectors.toList());
    }

    public Client toEntity(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO,client);

        return client;
    }
}
