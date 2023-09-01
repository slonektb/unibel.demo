package ru.unibel.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.unibel.demo.entity.Client;
import ru.unibel.demo.entity.Contact;
import ru.unibel.demo.entity.ContactType;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByClient(Client client);
    List<Contact> findByClientAndContactType(Client client, ContactType contactType);
}
