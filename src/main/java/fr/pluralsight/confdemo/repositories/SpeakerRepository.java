package fr.pluralsight.confdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.pluralsight.confdemo.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
