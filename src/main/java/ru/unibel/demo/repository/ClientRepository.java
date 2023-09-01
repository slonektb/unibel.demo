package ru.unibel.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.unibel.demo.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
