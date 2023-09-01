package ru.unibel.demo.controller.api.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.unibel.demo.dto.AddNewContactDTO;
import ru.unibel.demo.dto.ClientIdAndContactTypeDTO;
import ru.unibel.demo.dto.ClientIdDTO;
import ru.unibel.demo.dto.ContactDTO;
import ru.unibel.demo.service.ContactService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class ContactController {
    private final ContactService contactService;

    @PostMapping(value = "/addNewContact")
    public void addContact(@RequestBody AddNewContactDTO addNewContactDTO) {
        contactService.addNewContact(addNewContactDTO);
    }

    @GetMapping(value = "/getContactByClient")
    public List<ContactDTO> getContactByClient(@RequestBody ClientIdDTO clientIdDTO){
        return contactService.getAllContactByClient(clientIdDTO);
    }

    @GetMapping(value = "/getContactByClientAndType")
    public List<ContactDTO> getContactByClientAndType(@RequestBody ClientIdAndContactTypeDTO clientIdAndContactTypeDTO) {
        return contactService.getAllContactByClientAndType(clientIdAndContactTypeDTO);
    }
}
