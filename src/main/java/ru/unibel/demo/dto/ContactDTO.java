package ru.unibel.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.unibel.demo.entity.Client;
import ru.unibel.demo.entity.ContactType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    private Long id;
    private Client client;
    private ContactType contactType;
    private String value;
}
