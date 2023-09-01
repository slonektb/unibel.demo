package ru.unibel.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.unibel.demo.entity.ContactType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientIdAndContactTypeDTO {
    private Long id;
    private ContactType contactType;
}
