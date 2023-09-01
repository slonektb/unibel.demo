package ru.unibel.demo.controller.api.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.unibel.demo.dto.AddClientDTO;
import ru.unibel.demo.dto.ClientDTO;
import ru.unibel.demo.dto.ClientIdDTO;
import ru.unibel.demo.service.ClientService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class ClientController {
    private final ClientService clientService;

    @PostMapping(value = "/addNewClient")
    public void addNewClient(@RequestBody AddClientDTO addClientDTO) {
        System.out.println("Client DTO = " + addClientDTO);
        clientService.addNewClient(addClientDTO);
    }

    @GetMapping(value = "/getAllClient")
    public List<ClientDTO> getAllClient() {
        return clientService.getAllClient();
    }

    @GetMapping(value = "/getOneClient")
    public ClientDTO getClient(@RequestBody ClientIdDTO clientIdDTO) {
        return clientService.getOneClient(clientIdDTO);
    }

}
