package ru.unibel.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.unibel.demo.components.Mapper;
import ru.unibel.demo.dto.AddClientDTO;
import ru.unibel.demo.dto.ClientDTO;
import ru.unibel.demo.dto.ClientIdDTO;
import ru.unibel.demo.entity.Client;
import ru.unibel.demo.exeptions.CustomException;
import ru.unibel.demo.repository.ClientRepository;
import ru.unibel.demo.repository.ContactRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;
    private final Mapper mapper;

    public void addNewClient(AddClientDTO addClientDTO) {
        Client client = new Client();
        client.setName(addClientDTO.getName());
        System.out.println("Client name = " + addClientDTO.getName());
        clientRepository.save(client);
    }

    public List<ClientDTO> getAllClient () {
        return clientRepository.findAll().stream()
                .map(client -> mapper.convet(client, ClientDTO.class))
                .collect(Collectors.toList());
    }

    public ClientDTO getOneClient(ClientIdDTO clientIdDTO) {
        Optional<Client> client = clientRepository.findById(clientIdDTO.getId());
        ClientDTO clientDTO = new ClientDTO();
        if (client.isPresent()) {
            clientDTO = mapper.convet(client.get(), ClientDTO.class);
//            clientDTO.setContacts(contactRepository.findByClient(client.get()).stream().collect(Collectors.toSet()));
            return clientDTO;
        } else {
            throw new CustomException("Клиента с таким идентификатором не обнаружено!");
        }
    }
}
