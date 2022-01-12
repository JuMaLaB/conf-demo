package fr.pluralsight.confdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.pluralsight.confdemo.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
