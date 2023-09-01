package ru.unibel.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.unibel.demo.entity.ContactType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddNewContactDTO {
    private Long clientId;
    private ContactType contactType;
    private String value;
}
