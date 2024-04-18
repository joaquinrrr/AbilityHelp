package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.abilityhelpv1.entities.Incidents;
import pe.edu.upc.abilityhelpv1.entities.Personalities;

import java.util.List;

public interface IPersonalityRepository extends JpaRepository<Personalities, Integer> {
    public List<Personalities> findIncidentsBy(String name);
}
