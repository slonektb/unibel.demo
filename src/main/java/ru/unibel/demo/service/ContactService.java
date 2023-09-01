package ru.unibel.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.unibel.demo.components.Mapper;
import ru.unibel.demo.dto.AddNewContactDTO;
import ru.unibel.demo.dto.ClientIdAndContactTypeDTO;
import ru.unibel.demo.dto.ClientIdDTO;
import ru.unibel.demo.dto.ContactDTO;
import ru.unibel.demo.entity.Client;
import ru.unibel.demo.entity.Contact;
import ru.unibel.demo.exeptions.CustomException;
import ru.unibel.demo.repository.ClientRepository;
import ru.unibel.demo.repository.ContactRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final ClientRepository clientRepository;
    private final Mapper mapper;

    public void addNewContact(AddNewContactDTO addNewContactDTO) {
        Contact contact = new Contact();
        Optional<Client> client = clientRepository.findById(addNewContactDTO.getClientId());
        if (client.isPresent()) {
            contact.setClient(client.get());
            contact.setContactType(addNewContactDTO.getContactType());
            contact.setValue(addNewContactDTO.getValue());
            contactRepository.save(contact);
        } else {
            throw new CustomException("Клиента с таким идентификатором не обнаружено!");
        }
    }

    public List<ContactDTO> getAllContactByClient(ClientIdDTO clientIdDTO) {
        Optional<Client> client = clientRepository.findById(clientIdDTO.getId());
        if (client.isPresent()) {
            return contactRepository.findByClient(client.get()).stream()
                    .map(contact -> mapper.convet(contact, ContactDTO.class))
                    .collect(Collectors.toList());
        } else {
            throw new CustomException("Клиента с таким идентификатором не обнаружено!");
        }
    }

    public List<ContactDTO> getAllContactByClientAndType(ClientIdAndContactTypeDTO clientIdAndContactTypeDTO) {
        Optional<Client> client = clientRepository.findById(clientIdAndContactTypeDTO.getId());
        if (client.isPresent()) {
            return contactRepository.findByClientAndContactType(client.get(), clientIdAndContactTypeDTO.getContactType()).stream()
                    .map(contact -> mapper.convet(contact, ContactDTO.class))
                    .collect(Collectors.toList());
        } else {
            throw new CustomException("Клиента с таким идентификатором не обнаружено!");
        }
    }

}
